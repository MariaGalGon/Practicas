import "package:flutter/material.dart";

import 'package:nrp_app/colores.dart';
import 'package:nrp_app/data/moor_database.dart';
import 'package:nrp_app/service_locator.dart';
import 'package:nrp_app/widgets/botones.dart';
import 'package:nrp_app/widgets/mensaje_widget.dart';

class Previsualizacion extends StatefulWidget {
  @override
  _PrevisualizacionState createState() => _PrevisualizacionState();
}

class _PrevisualizacionState extends State<Previsualizacion> {
  late ElementosPrevisualizacion elementos;
  late double satisfaccionTotal;
  late int esfuerzoDisponible;
  double productividadVersion = 0;
  late List<RequisitoData> requisitosAbajo = [];

  @override
  Widget build(BuildContext context) {
    elementos =
        ModalRoute.of(context)!.settings.arguments as ElementosPrevisualizacion;
    satisfaccionTotal = 0.0;
    esfuerzoDisponible = elementos.limite;
    elementos.solucion.forEach((requisito) {
      satisfaccionTotal += requisito.satisfaccion!;
      esfuerzoDisponible -= requisito.esfuerzo;
    });

    requisitosAbajo.clear();
    elementos.requisitos.forEach((requisito) {
      requisitosAbajo.add(requisito);
      elementos.solucion.forEach((s) {
        if (s.idRequisito == requisito.idRequisito) {
          requisitosAbajo.remove(requisito);
        }
      });

      if (requisito.idVersion != null) {
        requisitosAbajo.remove(requisito);
      }
    });

    productividadVersion =
        satisfaccionTotal / (elementos.limite - esfuerzoDisponible);

    elementos.solucion.sort((a, b) => b.satisfaccion!.compareTo(a.satisfaccion!));
    requisitosAbajo.sort((a, b) => b.satisfaccion!.compareTo(a.satisfaccion!));

    return Scaffold(
        backgroundColor: Colores.gris,
        appBar: AppBar(
          backgroundColor: Colores.primario,
          title: Text("Previsualización de la versión",
              style: TextStyle(color: Colors.white, fontSize: 20)),
          centerTitle: true,
        ),
        body: SingleChildScrollView(
          child: Column(children: [
            SizedBox(
              width: double.infinity,
              child: Card(
                elevation: 5,
                margin: EdgeInsets.fromLTRB(50, 10, 50, 20),
                shape: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(5),
                    borderSide: BorderSide(color: Colors.white)),
                child: Padding(
                  padding: const EdgeInsets.all(20.0),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      ListTile(
                        title: Text("Requisitos de esta versión",
                            style: TextStyle(
                                fontWeight: FontWeight.bold, fontSize: 20)),
                        subtitle: Text(
                            "Satisfacción Total: ${satisfaccionTotal.toStringAsFixed(0)}, Productividad Total: ${productividadVersion.toStringAsFixed(2)},  Esfuerzo: ${elementos.limite - esfuerzoDisponible} / ${elementos.limite}"),
                      ),
                      SizedBox(
                        height: 10,
                      ),
                      SizedBox(
                          height: 190,
                          child: Container(
                              child: Scrollbar(
                            child: ListView.builder(
                                itemCount: elementos.solucion.length,
                                itemBuilder:
                                    (BuildContext context, int indice) {
                                      // elementos.solucion.sort((a, b) => b.satisfaccion!.compareTo(a.satisfaccion!));
                                  return Container(
                                    height: 50,
                                    width: 100,
                                    child: ListTile(
                                      title: Text(
                                          elementos.solucion[indice].nombre),
                                      subtitle: Text(
                                          "Satisfacción: ${elementos.solucion[indice].satisfaccion!.toStringAsFixed(0)}, Esfuerzo: ${elementos.solucion[indice].esfuerzo}, Productividad: ${elementos.solucion[indice].productividad!.toStringAsFixed(2)}"),
                                      trailing: IconButton(
                                          icon: Icon(Icons.arrow_downward),
                                          onPressed: () {
                                            bajarRequisito(
                                                elementos.solucion[indice]);
                                          }),
                                    ),
                                  );
                                }),
                          )))
                    ],
                  ),
                ),
              ),
            ),
            SizedBox(
              width: double.infinity,
              child: Card(
                elevation: 5,
                margin: EdgeInsets.fromLTRB(50, 10, 50, 20),
                shape: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(5),
                    borderSide: BorderSide(color: Colors.white)),
                child: Padding(
                  padding: const EdgeInsets.all(20.0),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      ListTile(
                        title: Text("Requisitos sin versión",
                            style: TextStyle(
                                fontWeight: FontWeight.bold, fontSize: 20)),
                      ),
                      SizedBox(
                        height: 10,
                      ),
                      SizedBox(
                          height: 190,
                          child: Container(
                              child: Scrollbar(
                            child: ListView.builder(
                                itemCount: requisitosAbajo.length,
                                itemBuilder:
                                    (BuildContext context, int indice) {
                                  print(
                                      "Req: ${requisitosAbajo[indice].nombre} Sat: ${requisitosAbajo[indice].satisfaccion}");
                                  return Container(
                                    height: 50,
                                    width: 100,
                                    child: ListTile(
                                      title:
                                          Text(requisitosAbajo[indice].nombre),
                                      subtitle: Text(
                                          "Satisfacción: ${requisitosAbajo[indice].satisfaccion!.toStringAsFixed(0)}, Esfuerzo: ${requisitosAbajo[indice].esfuerzo}, Productividad: ${requisitosAbajo[indice].productividad!.toStringAsFixed(2)}"),
                                      trailing: IconButton(
                                          icon: Icon(Icons.arrow_upward),
                                          onPressed: () {
                                            subirRequisito(
                                                requisitosAbajo[indice]);
                                          }),
                                    ),
                                  );
                                }),
                          )))
                    ],
                  ),
                ),
              ),
            ),
            Row(
              children: [
                Boton(() async {
                  List<VersionData> tempVersiones =
                      await locator<AppDatabase>().getVersiones();

                  int contVersiones = 0;
                  tempVersiones.forEach((ver) {
                    if (ver.idProyecto == elementos.solucion[0].idProyecto) {
                      contVersiones++;
                    }
                  });

                  await locator<AppDatabase>().insertVersion(VersionData(
                      idProyecto: elementos.solucion[0].idProyecto,
                      nombre: "Versión ${contVersiones + 1}",
                      esfuerzo: (elementos.limite - esfuerzoDisponible),
                      satisfaccionTotal: satisfaccionTotal,
                      productividad: productividadVersion));

                  tempVersiones = await locator<AppDatabase>().getVersiones();
                  VersionData nuevaVersion =
                      tempVersiones[tempVersiones.length - 1];

                  elementos.solucion.forEach((requisito) async {
                    await locator<AppDatabase>().updateRequisito(RequisitoData(
                        idRequisito: requisito.idRequisito,
                        idProyecto: requisito.idProyecto,
                        idVersion: nuevaVersion.idVersion,
                        nombre: requisito.nombre,
                        descripcion: requisito.descripcion,
                        porcentaje: requisito.porcentaje,
                        esfuerzo: requisito.esfuerzo,
                        productividad: requisito.productividad,
                        satisfaccion: requisito.satisfaccion));
                  });

                  Navigator.pop(context);
                }, "GENERAR", Colors.blue, Colors.white, 50, 40),
                Boton(() {
                  Navigator.pop(context);
                }, "CANCELAR", Colors.grey, Colors.white, 50, 40)
              ],
            )
          ]),
        ));
  }

  void bajarRequisito(RequisitoData requisito) {
    elementos.solucion.remove(requisito);
    requisitosAbajo.add(requisito);
    setState(() {});
  }

  void subirRequisito(RequisitoData requisito) {
    int esfuerzoNuevo = esfuerzoDisponible - requisito.esfuerzo;

    if (esfuerzoNuevo < 0) {
      Mensaje m = Mensaje(Icons.warning_outlined,
          "Superado límite de esfuerzo, quite requisitos de la versión");
      ScaffoldMessenger.of(context).showSnackBar(m.mostrarMensaje());
    } else {
      requisitosAbajo.remove(requisito);
      elementos.solucion.add(requisito);
      setState(() {});
    }
  }
}

class ElementosPrevisualizacion {
  int limite;
  List<RequisitoData> requisitos = [];
  List<RequisitoData> solucion = [];

  ElementosPrevisualizacion(this.limite, this.requisitos, this.solucion);
}
