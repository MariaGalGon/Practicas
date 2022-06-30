import 'package:flutter/material.dart';

class SectionButton extends StatelessWidget {
  final VoidCallback _onTap;
  final IconData _icon;
  final String _text;
  final Color _backgroundColor;

  SectionButton(this._onTap, this._icon, this._text, this._backgroundColor);

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.symmetric(horizontal: 50, vertical: 10),
      child: ElevatedButton(
          style: ElevatedButton.styleFrom(
              primary: _backgroundColor,
              onPrimary: Colors.white,
              padding: EdgeInsets.symmetric(horizontal: 20, vertical: 40),
              shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10))),
          child: SizedBox(
            width: 170,
            child: Column(
              children: [
                Icon(_icon, size: 100),
                Text(
                  _text,
                  style: TextStyle(fontSize: 25),
                ),
              ],
            ),
          ),
          onPressed: _onTap),
    );
  }
}
