import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class CampoTexto extends StatefulWidget {
  int limite;
  String label;
  TextEditingController _controlador;
  Color colorFondo;

  CampoTexto(this._controlador, this.label, this.colorFondo, this.limite);

  @override
  _CampoTextoState createState() => _CampoTextoState();
}

class _CampoTextoState extends State<CampoTexto> {
  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.fromLTRB(15, 8, 15, 8),
      child: TextFormField(
        inputFormatters: [
          LengthLimitingTextInputFormatter(widget.limite),
        ],
        controller: widget._controlador,
        decoration: InputDecoration(
          fillColor: widget.colorFondo,
          filled: true,
          isDense: true,
          labelText: widget.label,
          enabledBorder: OutlineInputBorder(
              borderRadius: BorderRadius.circular(10),
              borderSide: BorderSide(width: 0, color: Colors.white)),
          contentPadding: EdgeInsets.fromLTRB(30, 20, 30, 20),
          errorBorder: OutlineInputBorder(
              borderRadius: BorderRadius.circular(10),
              borderSide: BorderSide(width: 0, color: Colors.red)),
        ),
        validator: (valor) {
          if (valor!.isEmpty) {
            return "Campo vacio";
          }
        },
      ),
    );
  }
}
