import 'package:flutter/material.dart';
import 'package:nrp_app/colores.dart';
import 'package:nrp_app/data/moor_database.dart';
import 'package:nrp_app/screens/perfil_vista.dart';
import 'package:nrp_app/screens/proyectos_vista.dart';

class InicioVista extends StatelessWidget {
  late UsuarioData usuario;

  @override
  Widget build(BuildContext context) {
    final UsuarioData usuario =
        ModalRoute.of(context)!.settings.arguments as UsuarioData;

    return DefaultTabController(
      length: 2,
      child: Scaffold(
        backgroundColor: Colores.gris,
        appBar: AppBar(
          backgroundColor: Colores.primario,
          title: Text("Inicio",
              style: TextStyle(color: Colors.white, fontSize: 20)),
          centerTitle: true,
          bottom: TabBar(
            indicatorColor: Colores.claro,
            tabs: [
              Tab(
                text: "PROYECTOS",
              ),
              Tab(
                text: "PERFIL",
              )
            ],
          ),
        ),
        body: TabBarView(
          children: [ProyectosVista(usuario), PerfilVista(usuario)],
        ),
      ),
    );
  }
}
