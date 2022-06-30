import 'package:flutter/material.dart';
import 'package:trivial/colors_app.dart';

class PasswordField extends StatefulWidget {
  final TextEditingController _controller;
  final String _label;
  final bool _isMandatory;
  final double _widthPadding;

  PasswordField(
      this._controller, this._label, this._isMandatory, this._widthPadding);

  @override
  State<PasswordField> createState() => _PasswordFieldState();
}

class _PasswordFieldState extends State<PasswordField> {
  bool hidden = true;
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
          obscureText: hidden,
          controller: widget._controller,
          focusNode: isFocus,
          onTap: _requestFocus,
          decoration: InputDecoration(
              labelText: widget._label,
              labelStyle: TextStyle(
                  color:
                      isFocus.hasFocus ? ColorsApp.orangeButton : Colors.grey),
              contentPadding: EdgeInsets.fromLTRB(30, 20, 30, 20),
              border:
                  OutlineInputBorder(borderRadius: BorderRadius.circular(10)),
              focusedBorder: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(10),
                  borderSide:
                      BorderSide(width: 1, color: ColorsApp.orangeButton)),
              enabledBorder: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(10),
                  borderSide: BorderSide(width: 1, color: Colors.grey)),
              errorBorder: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(10),
                  borderSide: BorderSide(width: 0, color: Colors.red)),
              suffixIcon: IconButton(
                  onPressed: _changeVisibility,
                  icon: hidden
                      ? Icon(Icons.visibility_off,
                          color: isFocus.hasFocus
                              ? ColorsApp.orangeButton
                              : Colors.grey)
                      : Icon(Icons.visibility,
                          color: isFocus.hasFocus
                              ? ColorsApp.orangeButton
                              : Colors.grey))),
          // autovalidateMode: AutovalidateMode.onUserInteraction,
          validator: (value) {
            if (value!.isEmpty && widget._isMandatory) {
              return "Empty field";
            } else if (value.isNotEmpty &&
                (value.length < 6 || value.length > 10)) {
              return "Password must have between 6 and 10 characters";
            }
          }),
    );
  }

  void _changeVisibility() {
    setState(() {
      hidden = !hidden;
    });
  }

  void _requestFocus() {
    setState(() {
      FocusScope.of(context).requestFocus(isFocus);
    });
  }
}
