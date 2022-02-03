import 'package:flutter/material.dart';
import 'package:nrp_app/data/moor_database.dart';

class FilaCliente extends StatelessWidget {
  final ClienteData cliente;

  FilaCliente(this.cliente);

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.pushNamed(context, '/editarCliente', arguments: cliente);
      },
      child: ListTile(
          title: Text(cliente.nombre, style: TextStyle()),
          subtitle: Text(cliente.puesto, style: TextStyle())),
    );
  }
}
