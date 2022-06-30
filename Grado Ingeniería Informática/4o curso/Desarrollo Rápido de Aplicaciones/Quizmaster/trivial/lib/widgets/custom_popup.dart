import 'package:flutter/material.dart';

//Dialogo personalizable
class CustomPopup {
  late String _title;
  late String _content;
  late BuildContext _context;
  late bool _isInfo;
  late Color _buttonsColor;
  late String _leftButtonText;
  late String? _rightButtonText;
  late VoidCallback _action;

  CustomPopup(String title, String content, BuildContext context, bool isInfo,
      Color buttonsColor, String leftButtonText,
      {String? rightButtonText, VoidCallback? action}) {
    this._title = title;
    this._content = content;
    this._context = context;
    this._isInfo = isInfo;
    this._buttonsColor = buttonsColor;
    this._leftButtonText = leftButtonText;
    this._rightButtonText = rightButtonText;
    this._action = action ?? () {};
  }

  void showPopup() {
    showDialog(
        context: _context,
        builder: (BuildContext context) {
          return AlertDialog(
            shape:
                RoundedRectangleBorder(borderRadius: BorderRadius.circular(20)),
            title: Text(_title),
            content: Text(_content),
            actions: _buttons(),
          );
        });
  }

  //Si el pop-up es informativo devuelve un boton (Volver) y sino dos (Cancelar y Borrar)
  List<Widget> _buttons() {
    if (_isInfo) {
      return [
        TextButton(
            child: Text(_leftButtonText,
                style: TextStyle(fontSize: 15, color: _buttonsColor)),
            onPressed: () {
              Navigator.pop(_context);
            })
      ];
    } else {
      return [
        TextButton(
            child: Text(_leftButtonText,
                style: TextStyle(fontSize: 15, color: _buttonsColor)),
            onPressed: () {
              Navigator.pop(_context);
            }),
        TextButton(
            child: Text(_rightButtonText!,
                style: TextStyle(
                    fontSize: 15,
                    color: (_rightButtonText! == "Delete")
                        ? Colors.red
                        : _buttonsColor)),
            onPressed: _action)
      ];
    }
  }
}
