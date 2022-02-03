import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

//Campo de texto que permite cambiar la visibilidad de su contenido
class CampoTextoContrasenia extends StatefulWidget {
  final String label;
  final Color colorFondo;
  final TextEditingController controlador;

  CampoTextoContrasenia(this.controlador, this.label, this.colorFondo);

  @override
  _CampoTextoContraseniaState createState() => _CampoTextoContraseniaState();
}

class _CampoTextoContraseniaState extends State<CampoTextoContrasenia> {
  bool oculto = true;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.fromLTRB(15, 8, 15, 8),
      child: TextFormField(
          obscureText: oculto,
          controller: widget.controlador,
          decoration: InputDecoration(
              fillColor: widget.colorFondo,
              filled: true,
              isDense: true,
              labelText: widget.label,
              contentPadding: EdgeInsets.fromLTRB(30, 20, 30, 20),
              enabledBorder: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(10),
                  borderSide: BorderSide(width: 0, color: Colors.white)),
              errorBorder: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(10),
                  borderSide: BorderSide(width: 0, color: Colors.red)),
              suffixIcon: IconButton(
                  onPressed: _cambiarVisibilidad,
                  icon: oculto
                      ? Icon(Icons.visibility_off)
                      : Icon(Icons.visibility))),
          keyboardType: TextInputType.visiblePassword,
          validator: (valor) {
            if (valor!.isEmpty) {
              return "Debe rellenar este campo";
            } else if (valor.length < 6 || valor.length > 10) {
              return "La contraseña debe tener entre 6 y 10 caracteres";
            }
          }),
    );
  }

  void _cambiarVisibilidad() {
    setState(() {
      oculto = !oculto;
    });
  }
}
