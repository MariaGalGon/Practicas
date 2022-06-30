import 'package:flutter/material.dart';

class CustomSnackbar {
  IconData _icon;
  String _message;

  CustomSnackbar(this._icon, this._message);

  SnackBar getSnackbar() {
    return SnackBar(
      content: ListTile(
        leading: Icon(_icon, color: Colors.white),
        title: Text(
          _message,
          style: TextStyle(fontWeight: FontWeight.bold, color: Colors.white)
        ),
      ),
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(20)),
      behavior: SnackBarBehavior.floating,
      width: 500,
      duration: Duration(seconds: 5),
    );
  }
}
