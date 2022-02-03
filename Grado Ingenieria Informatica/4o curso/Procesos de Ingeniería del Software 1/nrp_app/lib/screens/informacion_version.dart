import 'package:flutter/material.dart';
import 'package:nrp_app/colores.dart';
import 'package:nrp_app/data/moor_database.dart';
import 'package:nrp_app/service_locator.dart';

class InformacionVersion extends StatelessWidget {
  late VersionData version;
  List<RequisitoData> requisitos = [];
  List<AtributosCliente> clientes = [];
  List<ValoracionData> valoraciones = [];

  @override
  Widget build(BuildContext context) {
    version = ModalRoute.of(context)!.settings.arguments as VersionData;

    return FutureBuilder(
        future: cargarDatos(),
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.done) {
            return Scaffold(
              appBar: AppBar(
                backgroundColor: Colores.primario,
                title: Text("${version.nombre}"),
                centerTitle: true,
              ),
              body: SingleChildScrollView(
                child: Column(
                  children: [
                    SizedBox(
                      width: double.infinity,
                      child: Card(
                        elevation: 5,
                        margin: EdgeInsets.fromLTRB(50, 10, 50, 20),
                        shape: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(5),
                            borderSide: BorderSide(color: Colors.white)),
                        child: Padding(
                          padding: const EdgeInsets.fromLTRB(20, 0, 20, 20),
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              ListTile(
                                title: Text("Información General",
                                    style: TextStyle(
                                        fontWeight: FontWeight.bold,
                                        fontSize: 20)),
                              ),
                              SizedBox(
                                  child: Container(
                                      child: Padding(
                                padding: EdgeInsets.fromLTRB(20, 0, 0, 0),
                                child: Column(
                                  crossAxisAlignment: CrossAxisAlignment.start,
                                  children: [
                                    Text(
                                        "Satisfacción total: ${version.satisfaccionTotal!.toStringAsFixed(0)}"),
                                    SizedBox(
                                      height: 7,
                                    ),
                                    Text("Esfuerzo total: ${version.esfuerzo}"),
                                    SizedBox(
                                      height: 7,
                                    ),
                                    Text(
                                        "Productividad: ${version.productividad!.toStringAsFixed(2)}")
                                  ],
                                ),
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
                                title: Text("Requisitos de la versión",
                                    style: TextStyle(
                                        fontWeight: FontWeight.bold,
                                        fontSize: 20)),
                              ),
                              SizedBox(
                                  height: 190,
                                  child: Container(
                                      child: Scrollbar(
                                    child: ListView.builder(
                                        itemCount: requisitos.length,
                                        itemBuilder:
                                            (BuildContext context, int indice) {
                                          return Container(
                                            height: 50,
                                            width: 100,
                                            child: ListTile(
                                              title: Text(
                                                  requisitos[indice].nombre),
                                              subtitle: Text(
                                                  "Satisfacción: ${requisitos[indice].satisfaccion!.toStringAsFixed(0)}, Esfuerzo: ${requisitos[indice].esfuerzo}, Productividad: ${requisitos[indice].productividad!.toStringAsFixed(2)}"),
                                              trailing: IconButton(
                                                  icon:
                                                      Icon(Icons.info_outlined),
                                                  onPressed: () {
                                                    contribucionCliente(
                                                        requisitos[indice],
                                                        context);
                                                  }),
                                            ),
                                          );
                                        }),
                                  ))),
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
                                title: Text("Métricas de los clientes",
                                    style: TextStyle(
                                        fontWeight: FontWeight.bold,
                                        fontSize: 20)),
                              ),
                              SizedBox(
                                  height: 190,
                                  child: Container(
                                      child: Scrollbar(
                                    child: ListView.builder(
                                        itemCount: clientes.length,
                                        itemBuilder:
                                            (BuildContext context, int indice) {
                                          return Container(
                                            height: 50,
                                            width: 100,
                                            child: ListTile(
                                              title: Text(clientes[indice]
                                                  .cliente
                                                  .nombre),
                                              subtitle: Text(
                                                  "Contribución: ${clientes[indice].contribucion.toStringAsFixed(2)}, Cobertura: ${clientes[indice].cobertura.toStringAsFixed(2)}"),
                                            ),
                                          );
                                        }),
                                  ))),
                            ],
                          ),
                        ),
                      ),
                    )
                  ],
                ),
              ),
            );
          } else {
            return Center(child: CircularProgressIndicator());
          }
        });
  }

  Future<dynamic> cargarDatos() async {
    List<RequisitoData> tempRequisitos =
        await locator<AppDatabase>().getRequisitos();
    List<ClienteData> tempClientes = await locator<AppDatabase>().getClientes();
    valoraciones = await locator<AppDatabase>().getValoraciones();

    requisitos.clear();
    clientes.clear();

    tempRequisitos.forEach((requisito) {
      if (requisito.idVersion == version.idVersion) {
        requisitos.add(requisito);
      }
    });

    tempClientes.forEach((cliente) {
      if (requisitos[0].idProyecto == cliente.idProyecto) {
        clientes.add(AtributosCliente(
            cliente, valoraciones, requisitos, version.satisfaccionTotal!));
      }
    });
  }

  void contribucionCliente(RequisitoData requisito, BuildContext context) {
    valoraciones.forEach((v) {
      if (requisito.idRequisito == v.idRequisito) {
        clientes.forEach((c) {
          if (c.cliente.idCliente == v.idCliente) {
            c.valoracion = v.valoracion;
          }
        });
      }
    });
    showDialog(
        barrierDismissible: true,
        context: context,
        builder: (BuildContext context) {
          return Builder(builder: (context) {
            return SimpleDialog(
              shape: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(5),
                  borderSide: BorderSide(color: Colors.white)),
              title: Text(
                "Métricas de calidad para ${requisito.nombre}",
                style: TextStyle(fontWeight: FontWeight.bold),
              ),
              children: [
                Padding(
                  padding: const EdgeInsets.only(left: 25),
                  child: Text(
                      "Satisfacción: ${requisito.satisfaccion!.toStringAsFixed(0)}, Esfuerzo: ${requisito.esfuerzo}, Productividad: ${requisito.productividad!.toStringAsFixed(2)}"),
                ),
                Padding(
                  padding: const EdgeInsets.only(left: 15),
                  child: Container(
                      height: 190,
                      width: 500,
                      child: Scrollbar(
                        child: ListView.builder(
                            itemCount: clientes.length,
                            itemBuilder: (BuildContext context, int indice) {
                              return Container(
                                height: 50,
                                child: ListTile(
                                  title: Text(clientes[indice].cliente.nombre),
                                  subtitle: Text(
                                      "Contribución: ${((clientes[indice].cliente.importancia * clientes[indice].valoracion) / requisito.satisfaccion!).toStringAsFixed(2)}"),
                                ),
                              );
                            }),
                      )),
                )
              ],
            );
          });
        });
  }
}

class AtributosCliente {
  late ClienteData cliente;
  int valoracion = 0;
  double contribucion = 0.0;
  double cobertura = 0.0;

  AtributosCliente(ClienteData cliente, List<ValoracionData> valoraciones,
      List<RequisitoData> requisitos, double satisfaccionVersion) {
    this.cliente = cliente;
    contribucion =
        calculoContribucion(valoraciones, requisitos, satisfaccionVersion);
    cobertura = calculoCobertura(valoraciones, requisitos);
  }

  double calculoContribucion(List<ValoracionData> valoraciones,
      List<RequisitoData> requisitos, double satisfaccionVersion) {
    double contribucion = 0.0;
    List<ValoracionData> tempValoraciones = [];
    double sum = 0.0;

    valoraciones.forEach((v) {
      if (v.idCliente == cliente.idCliente) {
        requisitos.forEach((r) {
          if (r.idRequisito == v.idRequisito) {
            tempValoraciones.add(v);
          }
        });
      }
    });

    tempValoraciones.forEach((v) {
      sum += cliente.importancia * v.valoracion;
    });
    contribucion = sum / satisfaccionVersion;

    return contribucion;
  }

  double calculoCobertura(
      List<ValoracionData> valoraciones, List<RequisitoData> requisitos) {
    double cobertura = 0.0;
    List<ValoracionData> tempValoracionesVersion = [];
    List<ValoracionData> tempValoracionesCliente = [];
    double sum1 = 0.0;
    double sum2 = 0.0;

    valoraciones.forEach((v) {
      if (v.idCliente == cliente.idCliente) {
        requisitos.forEach((r) {
          if (r.idRequisito == v.idRequisito) {
            tempValoracionesVersion.add(v);
          }
        });
      }
    });

    tempValoracionesVersion.forEach((v) {
      sum1 += v.valoracion;
    });
    valoraciones.forEach((v) {
      if (v.idCliente == cliente.idCliente) {
        tempValoracionesCliente.add(v);
      }
    });
    tempValoracionesCliente.forEach((v) {
      sum2 += v.valoracion;
    });
    cobertura = sum1 / sum2;

    return cobertura;
  }
}
