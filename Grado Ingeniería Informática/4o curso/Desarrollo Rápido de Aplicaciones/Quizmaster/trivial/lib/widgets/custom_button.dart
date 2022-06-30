import 'package:flutter/material.dart';

class CustomButton extends StatelessWidget {
  final VoidCallback _onTap;
  final String _text;
  final Color _backgroundColor;

  CustomButton(this._onTap, this._text, this._backgroundColor);

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.symmetric(vertical: 15, horizontal: 20),
      child: ElevatedButton(
          style: ElevatedButton.styleFrom(
              primary: _backgroundColor,
              onPrimary: Colors.white,
              padding: EdgeInsets.all(20),
              shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10))),
          child: Text(
            _text,
            style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
            textAlign: TextAlign.center,
          ),
          onPressed: _onTap),
    );
  }
}
