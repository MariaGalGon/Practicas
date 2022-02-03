import 'package:flutter/material.dart';
import 'package:nrp_app/colores.dart';
import 'package:nrp_app/data/moor_database.dart';
import 'package:nrp_app/data/operaciones_db.dart';
import 'package:nrp_app/service_locator.dart';
import 'package:nrp_app/widgets/botones.dart';
import 'package:nrp_app/widgets/campo_texto.dart';
import 'package:nrp_app/widgets/mensaje_widget.dart';

class EditarRequisitoVista extends StatefulWidget {
  @override
  _EditarRequisitoVistaState createState() => _EditarRequisitoVistaState();
}

class _EditarRequisitoVistaState extends State<EditarRequisitoVista> {
  TextEditingController nombre = TextEditingController();
  TextEditingController descripcion = TextEditingController();
  TextEditingController esfuerzo = TextEditingController();
  TextEditingController porcentaje = TextEditingController();
  TextEditingController valoracion = TextEditingController();
  bool esNuevo = true;
  List<ClienteData> clientes = [];
  List<ValoracionData> valoraciones = [];
  Map<ClienteData, ValoracionData> mapaClienteValoracion =
      Map<ClienteData, ValoracionData>();
  late RequisitoData requisito;

  @override
  void dispose() {
    nombre.dispose();
    descripcion.dispose();
    esfuerzo.dispose();
    porcentaje.dispose();
    valoracion.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    requisito = ModalRoute.of(context)!.settings.arguments as RequisitoData;
    mapaClienteValoracion.clear();
    if (requisito.nombre != "") {
      nombre.text = requisito.nombre;
      descripcion.text = requisito.descripcion;
      esfuerzo.text = "${requisito.esfuerzo}";
      porcentaje.text = "${requisito.porcentaje}";
      esNuevo = false;
    }

    return GestureDetector(
      onTap: () => FocusScope.of(context).unfocus(),
      child: Scaffold(
        appBar: AppBar(
          title: Text("Editar requisito"),
          centerTitle: true,
          backgroundColor: Colores.primario,
        ),
        body: SingleChildScrollView(
          child: Column(
            children: [
              CampoTexto(nombre, "Nombre", Colors.grey.shade200, 50),
              CampoTexto(descripcion, "Descripción", Colors.grey.shade200, 250),
              CampoTexto(esfuerzo, "Esfuerzo", Colors.grey.shade200, 50),
              CampoTexto(porcentaje, "Porcentaje", Colors.grey.shade200, 50),
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
                        Text("Clientes",
                            style: TextStyle(
                                fontWeight: FontWeight.bold, fontSize: 20)),
                        SizedBox(
                          height: 10,
                        ),
                        SizedBox(
                            height: 200,
                            child: FutureBuilder(
                                future: cargarClientesValoraciones(),
                                builder: (context, snapshot) {
                                  if (snapshot.connectionState ==
                                      ConnectionState.done) {
                                    return Container(
                                        child: Scrollbar(
                                      child: ListView.builder(
                                          itemCount: clientes.length,
                                          itemBuilder: (BuildContext context,
                                              int indice) {
                                            return Container(
                                              height: 50,
                                              width: 100,
                                              child: ListTile(
                                                  /* onTap: () => editarValoracion(
                                                      clientes[indice]), */
                                                  title: Text(
                                                      clientes[indice].nombre,
                                                      style: TextStyle()),
                                                  subtitle: Text(
                                                      "${clientes[indice].puesto}, Valoración: ${mapaClienteValoracion[clientes[indice]]!.valoracion}",
                                                      style: TextStyle())),
                                            );
                                          }),
                                    ));
                                  } else {
                                    return Center(
                                        child: CircularProgressIndicator());
                                  }
                                }))
                      ],
                    ),
                  ),
                ),
              ),
              Row(
                children: [
                  Boton(guardarRequisito, "GUARDAR", Colors.blue, Colors.white,
                      50, 40),
                  SizedBox(height: 10),
                  Boton(borrarRequisito, "BORRAR", Colors.red, Colors.white, 50,
                      40)
                ],
              )
            ],
          ),
        ),
      ),
    );
  }

  void guardarRequisito() async {
    if (!comprobarCampo(1, 10, esfuerzo.text)) {
      Mensaje m = Mensaje(
          Icons.warning_outlined, "El esfuerzo debe ser un valor entre 1 y 10");
      ScaffoldMessenger.of(context).showSnackBar(m.mostrarMensaje());
      return;
    }

    if (!comprobarCampo(0, 100, porcentaje.text)) {
      Mensaje m = Mensaje(Icons.warning_outlined,
          "El porcentaje debe ser un valor entre 0 y 100");
      ScaffoldMessenger.of(context).showSnackBar(m.mostrarMensaje());
      return;
    }

    RequisitoData requisitoModificado = RequisitoData(
        idVersion: requisito.idVersion,
        idProyecto: requisito.idProyecto,
        idRequisito: requisito.idRequisito,
        nombre: nombre.text,
        descripcion: descripcion.text,
        porcentaje: int.parse(porcentaje.text),
        esfuerzo: int.parse(esfuerzo.text));

    RequisitoData nuevoRequisito = requisitoModificado;
    if (esNuevo) {
      await locator<AppDatabase>().insertRequisito(requisitoModificado);
      List<RequisitoData> tempRequisitos =
          await locator<AppDatabase>().getRequisitos();
      nuevoRequisito = tempRequisitos[tempRequisitos.length - 1];
    } else {
      await locator<AppDatabase>().updateRequisito(requisitoModificado);
    }

    clientes.forEach((cliente) async {
      if (mapaClienteValoracion[cliente]!.idValoracion == null) {
        await locator<AppDatabase>().insertValoracion(ValoracionData(
            idValoracion: null,
            idRequisito: nuevoRequisito.idRequisito,
            idCliente: mapaClienteValoracion[cliente]!.idCliente,
            valoracion: mapaClienteValoracion[cliente]!.valoracion));
      } else {
        await locator<AppDatabase>()
            .updateValoracion(mapaClienteValoracion[cliente]!);
      }
    });

    Navigator.pop(context);
  }

  bool comprobarCampo(int min, int max, String valor) {
    int? v = int.tryParse(valor);

    if (v == null) {
      return false;
    }

    if (v >= min && v <= max) {
      return true;
    }

    return false;
  }

  void borrarRequisito() async {
    if (!esNuevo) {
      OperacionesDB operacionesDB = OperacionesDB();

      operacionesDB.borrarRequisito(requisito);
      Navigator.pop(context);
    }
  }

  Future<dynamic> cargarClientesValoraciones() async {
    List<ClienteData> tempClientes = await locator<AppDatabase>().getClientes();
    List<ValoracionData> tempValoraciones =
        await locator<AppDatabase>().getValoraciones();
    clientes.clear();
    valoraciones.clear();

    for (ClienteData x in tempClientes) {
      if (x.idProyecto == requisito.idProyecto) {
        clientes.add(x);
        mapaClienteValoracion[x] = ValoracionData(
            valoracion: 1,
            idCliente: x.idCliente,
            idRequisito: requisito.idRequisito);
      }
    }

    for (ValoracionData x in tempValoraciones) {
      if (x.idRequisito != null) {
        if (x.idRequisito == requisito.idRequisito) {
          valoraciones.add(x);
        }
      }
    }

    clientes.forEach((cliente) {
      valoraciones.forEach((val) {
        if (val.idCliente == cliente.idCliente) {
          mapaClienteValoracion[cliente] = val;
        }
      });
    });
  }

  void editarValoracion(ClienteData cliente) {
    FocusScope.of(context).unfocus();
    valoracion.text = "${mapaClienteValoracion[cliente]!.valoracion}";
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
                    "${cliente.nombre}",
                    style: TextStyle(fontWeight: FontWeight.bold),
                  ),
                  children: [
                    CampoTexto(
                        valoracion, "Valoración", Colors.grey.shade200, 50),
                    Row(
                      children: [
                        Spacer(),
                        Boton(() {
                          Navigator.pop(context);
                        }, "CANCELAR", Colors.grey, Colors.white, 50, 40),
                        SizedBox(height: 10),
                        Boton(() {
                          if (!comprobarCampo(1, 5, valoracion.text)) {
                            Mensaje m = Mensaje(Icons.warning_outlined,
                                "La valoracion debe ser un valor entre 1 y 5");
                            ScaffoldMessenger.of(context)
                                .showSnackBar(m.mostrarMensaje());
                            return;
                          } else {
                            mapaClienteValoracion[cliente] = ValoracionData(
                                idValoracion:
                                    mapaClienteValoracion[cliente] == null
                                        ? null
                                        : mapaClienteValoracion[cliente]!
                                            .idValoracion,
                                valoracion: int.parse(valoracion.text),
                                idCliente: cliente.idCliente,
                                idRequisito: requisito.idRequisito);
                            Navigator.pop(context);
                          }
                        }, "GUARDAR", Colors.blue, Colors.white, 50, 40)
                      ],
                    )
                  ],
                );
              }),
            ),
          );
        });
  }
}
