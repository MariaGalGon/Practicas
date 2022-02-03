import 'package:flutter/material.dart';

class Boton extends StatelessWidget {
  final VoidCallback _funcionPulsar;
  final String _texto;
  final Color _colorFondo;
  final Color _colorLetra;
  final double _ancho;
  final double _alto;

  const Boton(this._funcionPulsar, this._texto, this._colorFondo,
      this._colorLetra, this._ancho, this._alto);

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(10.0),
      child: ElevatedButton(
          style: ElevatedButton.styleFrom(
              primary: _colorFondo,
              onPrimary: _colorLetra,
              minimumSize: Size(_ancho, _alto),
              shape:
                  RoundedRectangleBorder(borderRadius: BorderRadius.circular(7))),
          child: Text(
            _texto,
            style: TextStyle(fontSize: 17),
          ),
          onPressed: _funcionPulsar),
    );
  }
}
