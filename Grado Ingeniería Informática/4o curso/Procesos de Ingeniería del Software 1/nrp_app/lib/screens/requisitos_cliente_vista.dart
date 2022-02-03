import 'package:flutter/material.dart';
import 'package:nrp_app/data/moor_database.dart';
import 'package:nrp_app/service_locator.dart';
import 'package:nrp_app/widgets/fila_requisito_cliente.dart';

import '../colores.dart';

class RequisitosClienteVista extends StatelessWidget {
  ProyectoData proyecto;
  ClienteData cliente;
  List<RequisitoData> requisitos = [];
  RequisitosClienteVista(this.proyecto, this.cliente);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
          height: 600,
          margin: EdgeInsets.fromLTRB(50, 50, 50, 0),
          decoration: BoxDecoration(color: Colors.white, boxShadow: [
            BoxShadow(
                color: Colors.grey.shade300,
                blurRadius: 20.0,
                offset: Offset(10.0, 10.0))
          ]),
          child: StreamBuilder(
              stream: locator<AppDatabase>().watchRequisitos(),
              builder: (context, AsyncSnapshot<List<RequisitoData>> snapshot) {
                requisitos = snapshot.data ?? [];
                return ListView.builder(
                    itemCount: requisitos.length,
                    itemBuilder: (BuildContext context, int indice) {
                      if (requisitos[indice].idProyecto != null) {
                        if (requisitos[indice].idProyecto ==
                            proyecto.idProyecto) {
                          return FilaRequisitoCliente(
                              requisitos[indice], cliente);
                        } else {
                          return Container();
                        }
                      } else {
                        return Container();
                      }
                    });
              })),
    );
  }
}
