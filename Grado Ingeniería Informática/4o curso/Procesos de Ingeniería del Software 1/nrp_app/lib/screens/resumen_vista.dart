import 'package:flutter/material.dart';
import 'package:nrp_app/colores.dart';
import 'package:nrp_app/data/moor_database.dart';
import 'package:nrp_app/screens/previsualizacion_vista.dart';
import 'package:nrp_app/service_locator.dart';
import 'package:nrp_app/widgets/botones.dart';
import 'package:nrp_app/widgets/campo_texto.dart';
import 'package:nrp_app/widgets/descripcion.dart';
import 'package:nrp_app/widgets/mensaje_widget.dart';
import 'package:nrp_app/widgets/version_widget.dart';
import 'dart:math';

class ResumenVista extends StatefulWidget {
  ProyectoData proyecto;

  ResumenVista(this.proyecto);

  @override
  _ResumenVistaState createState() => _ResumenVistaState();
}

class _ResumenVistaState extends State<ResumenVista> {
  TextEditingController limite = TextEditingController();
  List<VersionData> versiones = [];
  List<RequisitoData> requisitos = [];
  List<ClienteData> clientes = [];
  List<ValoracionData> valoraciones = [];

  @override
  void initState() {
    super.initState();
  }

  //
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Column(
          children: [
            Descripcion(widget.proyecto.descripcion),
            SizedBox(
              width: double.infinity,
              height: 500,
              child: Card(
                elevation: 5,
                margin: EdgeInsets.fromLTRB(50, 10, 50, 20),
                shape: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(5),
                    borderSide: BorderSide(color: Colors.white)),
                child: Column(
                  children: [
                    ListTile(
                        title: Text("Versiones",
                            style: TextStyle(
                                fontWeight: FontWeight.bold, fontSize: 20))),
                    FutureBuilder(
                        future: cargarDatos(),
                        builder: (context, snapshot) {
                          if (snapshot.connectionState == ConnectionState.done) {
                            return Expanded(
                                child: ListView.builder(
                                    itemCount: versiones.length,
                                    itemBuilder:
                                        (BuildContext context, int indice) {
                                      return VersionWidget(versiones[indice]);
                                    }));
                          } else {
                            return Center(child: CircularProgressIndicator());
                          }
                        }),
                  ],
                ),
              ),
            )
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        child: Icon(Icons.leaderboard_outlined),
        backgroundColor: Colores.claro,
        onPressed: generarVersion,
      ),
    );
  }

  void generarVersion() {
    limite.clear();
    showDialog(
        context: context,
        builder: (BuildContext context) {
          return GestureDetector(
            onTap: () => FocusScope.of(context).unfocus(),
            child: Scaffold(
              backgroundColor: Colors.transparent,
              body: Builder(builder: (context) {
                return SimpleDialog(
                  shape: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(5),
                      borderSide: BorderSide(color: Colors.white)),
                  title: Text(
                    "Límite de esfuerzo para esta versión",
                    style: TextStyle(fontWeight: FontWeight.bold),
                  ),
                  children: [
                    CampoTexto(
                        limite, "Limite de esfuerzo", Colors.grey.shade200, 50),
                    Row(
                      children: [
                        Spacer(),
                        Boton(() {
                          Navigator.pop(context);
                        }, "CANCELAR", Colors.grey, Colors.white, 50, 40),
                        SizedBox(height: 10),
                        Boton(() async {
                          if (!comprobarCampo(limite.text)) {
                            Mensaje m = Mensaje(Icons.warning_outlined,
                                "El limite debe ser un valor mayor que 1");
                            ScaffoldMessenger.of(context)
                                .showSnackBar(m.mostrarMensaje());
                            return;
                          } else if (requisitos.isEmpty) {
                            Mensaje m = Mensaje(Icons.warning_outlined,
                                "No existen requisitos disponibles");
                            ScaffoldMessenger.of(context)
                                .showSnackBar(m.mostrarMensaje());
                            return;
                          } else {
                            int valor = int.parse(limite.text);

                            bool creada = await crearVersion(valor);

                            if (creada) {
                              setState(() {});
                            } else {
                              Mensaje m = Mensaje(Icons.warning_outlined,
                                  "El limite es inferior al esfuerzo de los requisitos");
                              ScaffoldMessenger.of(context)
                                  .showSnackBar(m.mostrarMensaje());
                            }
                          }
                        }, "PREVISUALIZAR", Colors.blue, Colors.white, 50, 40)
                      ],
                    )
                  ],
                );
              }),
            ),
          );
        });
  }

  Future<bool> crearVersion(int limite) async {
    Map<RequisitoData, double> satisfacciones = Map<RequisitoData, double>();
    double tempSatisfaccion = 0.0;

    List<RequisitoData> requisitosMapa = [];
    List<double> satisfaccionesMapa = [];
    List<RequisitoData> solucion = [];

    requisitos.sort((a, b) => a.esfuerzo.compareTo(b.esfuerzo));

    //Calculo de satisfacciones
    requisitos.forEach((requisito) {
      tempSatisfaccion = 0.0;
      clientes.forEach((cliente) {
        valoraciones.forEach((valoracion) {
          if (valoracion.idRequisito == requisito.idRequisito &&
              valoracion.idCliente == cliente.idCliente) {
            tempSatisfaccion = tempSatisfaccion +
                (valoracion.valoracion * cliente.importancia);
            satisfacciones[requisito] = tempSatisfaccion;
          }
        });
      });
    });

    List<List<double>> tabla = List.generate(
        satisfacciones.length + 1, (i) => List.filled(limite + 1, 0),
        growable: false);
    requisitosMapa = satisfacciones.keys.toList();
    satisfaccionesMapa = satisfacciones.values.toList();

    requisitos.clear();
    for (int i = 0; i < requisitosMapa.length; i++) {
      RequisitoData requisitoTemp = RequisitoData(
          idVersion: requisitosMapa[i].idVersion,
          idProyecto: requisitosMapa[i].idProyecto,
          idRequisito: requisitosMapa[i].idRequisito,
          nombre: requisitosMapa[i].nombre,
          descripcion: requisitosMapa[i].descripcion,
          porcentaje: requisitosMapa[i].porcentaje,
          esfuerzo: requisitosMapa[i].esfuerzo,
          satisfaccion: satisfaccionesMapa[i],
          productividad: (satisfaccionesMapa[i] / requisitosMapa[i].esfuerzo));

      requisitos.add(requisitoTemp);
      await locator<AppDatabase>().updateRequisito(requisitoTemp);

      requisitosMapa[i] = requisitoTemp;
    }

    //Calculo de la mochila
    for (int i = 1; i < tabla.length; i++) {
      for (int j = 1; j < tabla[0].length; j++) {
        if (requisitosMapa[i - 1].esfuerzo > j) {
          tabla[i][j] = tabla[i - 1][j];
        } else {
          tabla[i][j] = max(
              tabla[i - 1][j],
              satisfaccionesMapa[i - 1] +
                  tabla[i - 1][j - requisitosMapa[i - 1].esfuerzo]);
        }
      }
    }

    int columna = tabla[0].length - 1;
    for (int i = tabla.length - 1; i > 0; i--) {
      if (tabla[i][columna] != tabla[i - 1][columna]) {
        solucion.add(requisitosMapa[i - 1]);
        columna -= requisitosMapa[i - 1].esfuerzo;
      }
    }

    if (solucion.isEmpty) {
      return false;
    }
/*
    await locator<AppDatabase>().insertVersion(VersionData(
        idProyecto: widget.proyecto.idProyecto,
        nombre: "Versión ${versiones.length + 1}",
        esfuerzo: limite));


    List<VersionData> tempVersiones =
        await locator<AppDatabase>().getVersiones();
    VersionData nuevaVersion = tempVersiones[tempVersiones.length - 1];

    print("Requisito       Satisfacción");
    print("------------------------------------");
    for (int i = 0; i < satisfaccionesMapa.length; i++) {
      print(
          "Requisito: ${requisitosMapa[i].nombre} Satisfacción: ${satisfaccionesMapa[i]}");
    }

    print("${nuevaVersion.nombre} Limite Esfuerzo: ${nuevaVersion.esfuerzo}");
    print("------------------------------------");
    for (int i = 0; i < solucion.length; i++) {
      print(
          "Requisito: ${solucion[i].nombre} Esfuerzo: ${solucion[i].esfuerzo}");
    }

    solucion.forEach((requisito) async {
      await locator<AppDatabase>().updateRequisito(RequisitoData(
          idRequisito: requisito.idRequisito,
          idProyecto: requisito.idProyecto,
          idVersion: nuevaVersion.idVersion,
          nombre: requisito.nombre,
          descripcion: requisito.descripcion,
          porcentaje: requisito.porcentaje,
          esfuerzo: requisito.esfuerzo));
    });
*/
    Navigator.pop(context);

    try {
      await Navigator.pushNamed(context, '/previsualizacion',
          arguments: ElementosPrevisualizacion(limite, requisitos, solucion));
      setState(() {});
    } catch (e) {}

    return true;
  }

  Future<dynamic> cargarDatos() async {
    List<VersionData> tempVersiones =
        await locator<AppDatabase>().getVersiones();
    List<RequisitoData> tempRequisito =
        await locator<AppDatabase>().getRequisitos();
    List<ClienteData> tempClientes = await locator<AppDatabase>().getClientes();
    List<ValoracionData> tempValoraciones =
        await locator<AppDatabase>().getValoraciones();
    versiones.clear();
    requisitos.clear();
    clientes.clear();
    valoraciones.clear();

    for (VersionData x in tempVersiones) {
      if (x.idProyecto == widget.proyecto.idProyecto) {
        versiones.add(x);
      }
    }

    for (RequisitoData x in tempRequisito) {
      if (x.idProyecto == widget.proyecto.idProyecto && x.idVersion == null) {
        requisitos.add(x);
      }
    }

    for (ClienteData x in tempClientes) {
      if (x.idProyecto == widget.proyecto.idProyecto) {
        clientes.add(x);
      }
    }

    for (ValoracionData x in tempValoraciones) {
      clientes.forEach((cliente) {
        if (cliente.idCliente == x.idCliente) {
          valoraciones.add(x);
        }
      });
    }
  }

  bool comprobarCampo(String valor) {
    int? v = int.tryParse(valor);

    if (v == null) {
      return false;
    }

    if (v >= 1) {
      return true;
    }

    return false;
  }
}
