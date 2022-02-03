import 'package:flutter/material.dart';
import 'package:nrp_app/data/moor_database.dart';
import 'package:nrp_app/widgets/descripcion.dart';

class ResumenClienteVista extends StatelessWidget {
  ProyectoData proyecto;

  ResumenClienteVista(this.proyecto);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Column(children: [Descripcion(proyecto.descripcion), Spacer()]));
  }
}
