import 'package:flutter/material.dart';
import 'package:nrp_app/colores.dart';
import 'package:nrp_app/data/moor_database.dart';
import 'package:nrp_app/data/operaciones_db.dart';
import 'package:nrp_app/service_locator.dart';
import 'package:nrp_app/widgets/botones.dart';
import 'package:nrp_app/widgets/campo_texto.dart';

class EditarProyectoVista extends StatefulWidget {
  @override
  _EditarProyectoVistaState createState() => _EditarProyectoVistaState();
}

class _EditarProyectoVistaState extends State<EditarProyectoVista> {
  TextEditingController nombre = TextEditingController();
  TextEditingController descripcion = TextEditingController();
  bool esNuevo = true;
  ProyectoData proyecto = ProyectoData(nombre: "", descripcion: "");

  @override
  void dispose() {
    nombre.dispose();
    descripcion.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    proyecto = ModalRoute.of(context)!.settings.arguments as ProyectoData;

    if (proyecto.nombre != "") {
      nombre.text = proyecto.nombre;
      descripcion.text = proyecto.descripcion;
      esNuevo = false;
    }

    return GestureDetector(
      onTap: () => FocusScope.of(context).unfocus(),
      child: Scaffold(
        appBar: AppBar(
          title: Text(proyecto.nombre == "" ? "Nuevo proyecto" : proyecto.nombre),
          centerTitle: true,
          backgroundColor: Colores.primario,
        ),
        body: Column(
          children: [
            CampoTexto(nombre, "Nombre", Colors.grey.shade200, 50),
            CampoTexto(descripcion, "Descripcion", Colors.grey.shade200, 250),
            Spacer(),
            Row(
              children: [
                Boton(guardarProyecto, "GUARDAR", Colors.blue, Colors.white, 50,
                    40),
                SizedBox(height: 10),
                Boton(borrarProyecto, "BORRAR", Colors.red, Colors.white, 50, 40)
              ],
            )
          ],
        ),
      ),
    );
  }

  void guardarProyecto() async {
    ProyectoData modificado = ProyectoData(
        idProyecto: esNuevo ? null : proyecto.idProyecto,
        idUsuario: proyecto.idUsuario,
        nombre: nombre.text,
        descripcion: descripcion.text);

    if (esNuevo) {
      await locator<AppDatabase>().insertProyecto(modificado);
    } else {
      await locator<AppDatabase>().updateProyecto(modificado);
    }
    Navigator.pop(context, modificado);
  }

  void borrarProyecto() async {
    if (!esNuevo) {
      OperacionesDB operacionesDB = OperacionesDB();

      operacionesDB.borrarProyecto(proyecto);
      Navigator.pop(context);
      Navigator.pop(context);
    }
  }
}
