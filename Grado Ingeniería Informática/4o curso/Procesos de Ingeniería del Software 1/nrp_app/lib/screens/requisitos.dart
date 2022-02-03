import 'package:flutter/material.dart';
import 'package:nrp_app/data/moor_database.dart';
import 'package:nrp_app/widgets/fila_requisito.dart';

import '../colores.dart';

class Requisitos extends StatelessWidget {
  ProyectoData proyecto;
  List<RequisitoData> requisitos = [];

  Requisitos(this.proyecto, this.requisitos);

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
            child: ListView.builder(
                itemCount: requisitos.length,
                itemBuilder: (BuildContext context, int indice) {
                  return FilaRequisito(proyecto, requisitos[indice]);
                })),
        floatingActionButton: FloatingActionButton(
            backgroundColor: Colores.claro,
            child: Icon(Icons.post_add_outlined, size: 35),
            onPressed: () {
              Navigator.pushNamed(context, '/editarRequisito',
                  arguments: RequisitoData(
                      idProyecto: proyecto.idProyecto,
                      nombre: "",
                      descripcion: "",
                      porcentaje: -1,
                      esfuerzo: -1));
            }));
  }
}
