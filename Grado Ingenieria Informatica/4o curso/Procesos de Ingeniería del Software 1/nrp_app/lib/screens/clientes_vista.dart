import 'package:flutter/material.dart';
import 'package:nrp_app/data/moor_database.dart';
import 'package:nrp_app/service_locator.dart';
import 'package:nrp_app/widgets/fila_cliente.dart';
import 'package:nrp_app/widgets/mensaje_widget.dart';

import '../colores.dart';

class ClientesVista extends StatelessWidget {
  ProyectoData proyecto;
  List<ClienteData> clientes = [];
  bool resultado = false;
  ClientesVista(this.proyecto);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Container(
            margin: EdgeInsets.fromLTRB(50, 50, 50, 200),
            decoration: BoxDecoration(color: Colors.white, boxShadow: [
              BoxShadow(
                  color: Colors.grey.shade300,
                  blurRadius: 20.0,
                  offset: Offset(10.0, 10.0))
            ]),
            child: StreamBuilder(
                stream: locator<AppDatabase>().watchClientes(),
                builder: (context, AsyncSnapshot<List<ClienteData>> snapshot) {
                  clientes = snapshot.data ?? [];
                  return ListView.builder(
                      itemCount: clientes.length,
                      itemBuilder: (BuildContext context, int indice) {
                        if (clientes[indice].idProyecto != null) {
                          if (clientes[indice].idProyecto ==
                              proyecto.idProyecto) {
                            return FilaCliente(clientes[indice]);
                          } else {
                            return Container();
                          }
                        } else {
                          return Container();
                        }
                      });
                })),
        floatingActionButton: FloatingActionButton(
            backgroundColor: Colores.claro,
            child: Icon(Icons.person_add_alt_outlined, size: 35),
            onPressed: () async {
              try {
                resultado = await Navigator.pushNamed(context, '/editarCliente',
                    arguments: ClienteData(
                        idProyecto: proyecto.idProyecto,
                        nombre: "",
                        puesto: "",
                        correo: "",
                        importancia: 0)) as bool;
              } catch (e) {}

              if (!resultado) {
                Mensaje m = Mensaje(
                    Icons.warning_outlined, "No existen usuarios disponibles.");
                ScaffoldMessenger.of(context).showSnackBar(m.mostrarMensaje());
              }
            }));
  }
}
