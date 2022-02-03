import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';

class Mensaje {
  IconData icono;
  String mensaje;

  Mensaje(this.icono, this.mensaje);

  SnackBar mostrarMensaje() {
    return SnackBar(
        content: Row(children: [
      Icon(
        icono,
        color: Colors.white,
      ),
      SizedBox(width: 15),
      Text(mensaje, style: TextStyle(fontWeight: FontWeight.bold))
    ]));
  }
}
