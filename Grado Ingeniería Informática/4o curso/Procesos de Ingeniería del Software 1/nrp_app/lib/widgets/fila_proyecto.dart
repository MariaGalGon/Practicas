import 'package:flutter/material.dart';
import 'package:nrp_app/data/moor_database.dart';

class FilaProyecto extends StatelessWidget {
  final ProyectoData proyecto;
  final VoidCallback funcion;

  FilaProyecto(this.proyecto, this.funcion);

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: funcion,
      child: ListTile(
          title: Text(proyecto.nombre, style: TextStyle()),
          subtitle: Text(proyecto.descripcion, style: TextStyle())),
    );
  }
}
