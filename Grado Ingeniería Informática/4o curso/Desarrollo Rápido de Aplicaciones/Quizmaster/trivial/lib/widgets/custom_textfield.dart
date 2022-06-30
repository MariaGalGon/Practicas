import 'package:flutter/material.dart';
import 'package:trivial/colors_app.dart';

class CustomTextField extends StatefulWidget {
  final TextEditingController _controller;
  final String _label;
  final double _widthPadding;

  CustomTextField(this._controller, this._label, this._widthPadding);

  @override
  State<CustomTextField> createState() => _CustomTextFieldState();
}

class _CustomTextFieldState extends State<CustomTextField> {
  FocusNode isFocus = FocusNode();

  @override
  void dispose() {
    isFocus.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding:
          EdgeInsets.symmetric(vertical: 10, horizontal: widget._widthPadding),
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
        // autovalidateMode: AutovalidateMode.onUserInteraction,
        validator: (value) {
          if (value!.isEmpty) {
            return "Empty field";
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
