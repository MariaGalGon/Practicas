import 'package:flutter/material.dart';
import 'package:nrp_app/colores.dart';
import 'package:nrp_app/data/moor_database.dart';
import 'package:nrp_app/screens/requisitos_cliente_vista.dart';
import 'package:nrp_app/screens/resumen_cliente_vista.dart';
import 'package:nrp_app/service_locator.dart';

class ProyectoClienteVista extends StatefulWidget {
  ProyectoClienteVista();

  @override
  State<ProyectoClienteVista> createState() => _ProyectoClienteVistaState();
}

class _ProyectoClienteVistaState extends State<ProyectoClienteVista> {
  ProyectoData proyecto = ProyectoData(nombre: "", descripcion: "");
  late UsuarioData usuario;
  ClienteData cliente = ClienteData(nombre: "", puesto: "", importancia: 0);
  bool primeraVez = true;

  @override
  Widget build(BuildContext context) {
    if (primeraVez) {
      Argumentos a = ModalRoute.of(context)!.settings.arguments as Argumentos;
      proyecto = a.proyecto;
      usuario = a.usuario;
      primeraVez = false;
    }

    return FutureBuilder(
        future: buscarCliente(),
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.done) {
            return DefaultTabController(
              length: 2,
              child: Scaffold(
                backgroundColor: Colores.gris,
                appBar: AppBar(
                  backgroundColor: Colores.primario,
                  title: Text(proyecto.nombre,
                      style: TextStyle(color: Colors.white, fontSize: 20)),
                  centerTitle: true,
                  bottom: TabBar(
                    indicatorColor: Colores.claro,
                    tabs: [
                      Tab(
                        text: "RESUMEN",
                      ),
                      Tab(
                        text: "REQUISITOS",
                      )
                    ],
                  ),
                ),
                body: TabBarView(children: [
                  ResumenClienteVista(proyecto),
                  RequisitosClienteVista(proyecto, cliente)
                ]),
              ),
            );
          } else {
            return Center(child: CircularProgressIndicator());
          }
        });
  }

  Future<dynamic> buscarCliente() async {
    List<ClienteData> tempClientes = await locator<AppDatabase>().getClientes();

    for (ClienteData x in tempClientes) {
      if (x.idUsuario == usuario.idUsuario) {
        cliente = x;
      }
    }
  }
}

class Argumentos {
  ProyectoData proyecto;
  UsuarioData usuario;

  Argumentos(this.proyecto, this.usuario);
}
