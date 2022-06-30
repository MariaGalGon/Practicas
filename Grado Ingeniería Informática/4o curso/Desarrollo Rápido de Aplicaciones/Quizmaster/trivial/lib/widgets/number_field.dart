import 'package:flutter/material.dart';
import 'package:trivial/colors_app.dart';

class NumberField extends StatefulWidget {
  final TextEditingController _controller;
  final String _label;

  NumberField(this._controller, this._label);

  @override
  State<NumberField> createState() => _NumberFieldState();
}

class _NumberFieldState extends State<NumberField> {
  FocusNode isFocus = FocusNode();

  @override
  void dispose() {
    isFocus.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.symmetric(vertical: 10),
      child: TextFormField(
        controller: widget._controller,
        focusNode: isFocus,
        onTap: _requestFocus,
        decoration: InputDecoration(
          labelText: widget._label,
          labelStyle: TextStyle(
              color: isFocus.hasFocus ? ColorsApp.orangeButton : Colors.grey),
          border: OutlineInputBorder(borderRadius: BorderRadius.circular(10)),
          focusedBorder: OutlineInputBorder(
              borderRadius: BorderRadius.circular(10),
              borderSide: BorderSide(width: 1, color: ColorsApp.orangeButton)),
          enabledBorder: OutlineInputBorder(
              borderRadius: BorderRadius.circular(10),
              borderSide: BorderSide(width: 1, color: Colors.grey)),
          contentPadding: EdgeInsets.fromLTRB(30, 20, 30, 20),
          errorBorder: OutlineInputBorder(
              borderRadius: BorderRadius.circular(10),
              borderSide: BorderSide(width: 0, color: Colors.red)),
        ),
        validator: (value) {
          if (value!.isEmpty) {
            return "Empty field";
          } else if (int.tryParse(value) == null) {
            return "Value must be a number";
          } else if (int.parse(value) <= 0 || int.parse(value) > 50) {
            return "Value must be between 1 and 50";
          }
        },
      ),
    );
  }

  void _requestFocus() {
    setState(() {
      FocusScope.of(context).requestFocus(isFocus);
    });
  }
}
