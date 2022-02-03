import 'package:flutter/material.dart';

class Descripcion extends StatelessWidget {
  final String _texto;

  Descripcion(this._texto);

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      width: double.infinity,
      child: Card(
        elevation: 5,
        margin: EdgeInsets.fromLTRB(50, 10, 50, 20),
        shape: OutlineInputBorder(
            borderRadius: BorderRadius.circular(5),
            borderSide: BorderSide(color: Colors.white)),
        child: Padding(
          padding: const EdgeInsets.all(20.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text("Descripción",
                  style: TextStyle(fontWeight: FontWeight.bold, fontSize: 20)),
              SizedBox(
                height: 10,
              ),
              Text(_texto)
            ],
          ),
        ),
      ),
    );
  }
}
