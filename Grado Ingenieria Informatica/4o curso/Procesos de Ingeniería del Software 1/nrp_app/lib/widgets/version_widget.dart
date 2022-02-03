import 'package:flutter/material.dart';
import 'package:nrp_app/data/moor_database.dart';
import 'package:nrp_app/service_locator.dart';

class VersionWidget extends StatelessWidget {
  VersionData version;

  VersionWidget(this.version);

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: (){
        Navigator.pushNamed(context, '/informacionVersion', arguments: version);
      },
      child: ListTile(
          title: Text(version.nombre),),
    );
  }
}
