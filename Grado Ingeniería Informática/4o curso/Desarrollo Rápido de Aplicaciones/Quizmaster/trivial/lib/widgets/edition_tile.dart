import 'package:flutter/material.dart';
import 'package:trivial/models/editions_data.dart';

class EditionTile extends StatelessWidget {
  final EditionsData _edition;

  EditionTile(this._edition);

  @override
  Widget build(BuildContext context) {
    return ListTile(
      title: Text(_edition.name),
      subtitle: (_edition.year != null) ? Text(_edition.year!) : null,
    );
  }
}
