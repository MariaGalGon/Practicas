import 'package:flutter/material.dart';
import 'package:nrp_app/colores.dart';
import 'package:nrp_app/data/moor_database.dart';
import 'package:nrp_app/screens/clientes_vista.dart';
import 'package:nrp_app/screens/requisitos_vista.dart';
import 'package:nrp_app/screens/resumen_vista.dart';

class ProyectoVista extends StatefulWidget {
  ProyectoVista();

  @override
  State<ProyectoVista> createState() => _ProyectoVistaState();
}

class _ProyectoVistaState extends State<ProyectoVista> {
  ProyectoData proyecto = ProyectoData(nombre: "", descripcion: "");
  bool primeraVez = true;

  @override
  Widget build(BuildContext context) {
    if (primeraVez) {
      proyecto = ModalRoute.of(context)!.settings.arguments as ProyectoData;
      primeraVez = false;
    }

    return DefaultTabController(
      length: 3,
      child: Scaffold(
        backgroundColor: Colores.gris,
        appBar: AppBar(
          backgroundColor: Colores.primario,
          title: Text(proyecto.nombre,
              style: TextStyle(color: Colors.white, fontSize: 20)),
          centerTitle: true,
          actions: [
            IconButton(
                icon: Icon(Icons.edit),
                onPressed: () async {
                  try {
                    proyecto = await Navigator.pushNamed(
                            context, '/editarProyecto', arguments: proyecto)
                        as ProyectoData;
                    setState(() {});
                  } catch (e) {}
                },
                padding: EdgeInsets.all(8))
          ],
          bottom: TabBar(
            indicatorColor: Colores.claro,
            tabs: [
              Tab(
                text: "RESUMEN",
              ),
              Tab(
                text: "REQUISITOS",
              ),
              Tab(
                text: "CLIENTES",
              )
            ],
          ),
        ),
        body: TabBarView(children: [
          ResumenVista(proyecto),
          RequisitosVista(proyecto),
          ClientesVista(proyecto)
        ]),
      ),
    );
  }
}
