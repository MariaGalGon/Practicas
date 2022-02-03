import 'package:flutter/material.dart';
import 'package:nrp_app/data/moor_database.dart';

class FilaRequisito extends StatelessWidget {
  ProyectoData proyecto;
  final RequisitoData requisito;

  FilaRequisito(this.proyecto, this.requisito);

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.pushNamed(context, '/editarRequisito', arguments: requisito);
      },
      child: ListTile(
          title: Text(requisito.nombre, style: TextStyle()),
          subtitle: Text(requisito.descripcion, style: TextStyle())),
    );
  }
}
