import 'package:flutter/material.dart';
import 'package:nrp_app/colores.dart';
import 'package:nrp_app/data/moor_database.dart';
import 'package:nrp_app/screens/proyecto_cliente_vista.dart';
import 'package:nrp_app/service_locator.dart';
import 'package:nrp_app/widgets/fila_proyecto.dart';

class ProyectosVista extends StatefulWidget {
  late UsuarioData usuario;

  ProyectosVista(this.usuario);

  @override
  State<ProyectosVista> createState() => _ProyectosVistaState();
}

class _ProyectosVistaState extends State<ProyectosVista> {
  List<ProyectoData> proyectos = [];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: FutureBuilder(
            future: (widget.usuario.esDesarrollador)
                ? cargarProyectosDesarrollador()
                : cargarProyectosCliente(),
            builder: (context, snapshot) {
              if (snapshot.connectionState == ConnectionState.done) {
                return Container(
                    margin: EdgeInsets.fromLTRB(50, 50, 50, 200),
                    decoration: BoxDecoration(color: Colors.white, boxShadow: [
                      BoxShadow(
                          color: Colors.grey.shade300,
                          blurRadius: 20.0,
                          offset: Offset(10.0, 10.0))
                    ]),
                    child: ListView.builder(
                        itemCount: proyectos.length,
                        itemBuilder: (BuildContext context, int indice) {
                          if (widget.usuario.esDesarrollador) {
                            return FilaProyecto(proyectos[indice], () async {
                              await Navigator.pushNamed(context, '/proyecto',
                                  arguments: proyectos[indice]);
                              setState(() {});
                            });
                          } else {
                            return FilaProyecto(proyectos[indice], () async {
                              await Navigator.pushNamed(
                                  context, '/proyectoCliente',
                                  arguments: Argumentos(proyectos[indice], widget.usuario));
                              setState(() {});
                            });
                          }
                        }));
              } else {
                return Center(child: CircularProgressIndicator());
              }
            }),
        floatingActionButton: (widget.usuario.esDesarrollador)
            ? FloatingActionButton(
                backgroundColor: Colores.claro,
                child: Icon(Icons.add, size: 35),
                onPressed: () async {
                  await Navigator.pushNamed(context, '/editarProyecto',
                      arguments: ProyectoData(
                          idUsuario: widget.usuario.idUsuario,
                          nombre: "",
                          descripcion: ""));
                  setState(() {});
                })
            : null);
  }

  Future<dynamic> cargarProyectosDesarrollador() async {
    List<ProyectoData> temp = await locator<AppDatabase>().getProyectos();
    proyectos.clear();

    for (ProyectoData x in temp) {
      if (x.idUsuario == widget.usuario.idUsuario) {
        proyectos.add(x);
      }
    }
  }

  Future<dynamic> cargarProyectosCliente() async {
    List<ProyectoData> tempProyectos =
        await locator<AppDatabase>().getProyectos();
    List<ClienteData> tempClientes = await locator<AppDatabase>().getClientes();
    proyectos.clear();

    for (ClienteData x in tempClientes) {
      if (x.idUsuario == widget.usuario.idUsuario) {
        for (ProyectoData p in tempProyectos) {
          if (x.idProyecto == p.idProyecto) {
            proyectos.add(p);
          }
        }
      }
    }
  }
}
