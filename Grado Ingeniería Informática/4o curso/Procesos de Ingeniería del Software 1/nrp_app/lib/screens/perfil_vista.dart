import 'package:flutter/material.dart';
import 'package:nrp_app/data/moor_database.dart';
import 'package:nrp_app/data/operaciones_db.dart';
import 'package:nrp_app/service_locator.dart';
import 'package:nrp_app/widgets/botones.dart';
import 'package:nrp_app/widgets/campo_texto.dart';
import 'package:nrp_app/widgets/campo_texto_contrasenia.dart';
import 'package:nrp_app/widgets/mensaje_widget.dart';

class PerfilVista extends StatefulWidget {
  UsuarioData usuario;

  PerfilVista(this.usuario);

  @override
  _PerfilVistaState createState() => _PerfilVistaState();
}

class _PerfilVistaState extends State<PerfilVista> {
  TextEditingController usuario = TextEditingController();
  TextEditingController correo = TextEditingController();
  TextEditingController contraseniaActual = TextEditingController();
  final clave = GlobalKey<FormState>();

  @override
  void dispose() {
    usuario.dispose();
    correo.dispose();
    contraseniaActual.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    usuario.text = widget.usuario.nombre;
    correo.text = widget.usuario.correo;
    contraseniaActual.text = widget.usuario.contrasenia;

    return GestureDetector(
      onTap: () => FocusScope.of(context).unfocus(),
      child: Padding(
        padding: const EdgeInsets.all(10.0),
        child: SingleChildScrollView(
          child: Column(
            children: [
              Form(
                  key: clave,
                  child: Column(children: [
                    CampoTexto(usuario, "Nombre", Colors.white, 50),
                    CampoTexto(correo, "Correo", Colors.white, 50),
                    SizedBox(height: 20),
                    CampoTextoContrasenia(
                        contraseniaActual, "Contraseña Actual", Colors.white),
                  ])),
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Boton(guardar, "GUARDAR", Colors.blue.shade600, Colors.white,
                      50, 40),
                  Row(
                    children: [
                      Boton(cerrarSesion, "CERRAR SESIÓN", Colors.orange,
                          Colors.white, 50, 40),
                      Boton(eliminarCuenta, "ELIMINAR CUENTA",
                          Colors.red.shade400, Colors.white, 50, 40),
                    ],
                  )
                ],
              )
            ],
          ),
        ),
      ),
    );
  }

  void guardar() async {
    bool existeUsuario = false;
    if (clave.currentState!.validate()) {
      if (correo.text == widget.usuario.correo) {
        existeUsuario = false;
      } else {
        List<UsuarioData> usuarios = await locator<AppDatabase>().getUsuarios();
        for (final x in usuarios) {
          if (x.correo == correo.text) {
            existeUsuario = true;
            Mensaje m = Mensaje(Icons.warning_outlined,
                "El correo introducido ya está registrado");
            ScaffoldMessenger.of(context).showSnackBar(m.mostrarMensaje());
            break;
          }
        }
      }

      if (!existeUsuario) {
        clave.currentState!.save();
        UsuarioData nuevo = UsuarioData(
            idUsuario: widget.usuario.idUsuario,
            nombre: usuario.text,
            correo: correo.text,
            contrasenia: contraseniaActual.text,
            esDesarrollador: true);
        await locator<AppDatabase>().updateUsuario(nuevo);
        Mensaje m = Mensaje(Icons.save_outlined, "Se han guardado los cambios");
        ScaffoldMessenger.of(context).showSnackBar(m.mostrarMensaje());
      }
    }
  }

  void cerrarSesion() {
    Navigator.pop(context);
    Navigator.pushNamed(context, '/');
  }

  void eliminarCuenta() async {
    OperacionesDB operacionesDB = OperacionesDB();

    operacionesDB.eliminarCuenta(widget.usuario);
    Navigator.pop(context);
    Navigator.pushNamed(context, '/');
  }
}
