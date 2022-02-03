import 'package:flutter/material.dart';
import 'package:flutter/painting.dart';
import 'package:flutter/widgets.dart';
import 'package:nrp_app/colores.dart';
import 'package:nrp_app/data/moor_database.dart';
import 'package:nrp_app/service_locator.dart';
import 'package:nrp_app/widgets/botones.dart';
import 'package:nrp_app/widgets/campo_texto.dart';
import 'package:nrp_app/widgets/campo_texto_contrasenia.dart';
import 'package:nrp_app/widgets/mensaje_widget.dart';

class LoginVista extends StatefulWidget {
  @override
  State<LoginVista> createState() => _LoginVistaState();
}

class _LoginVistaState extends State<LoginVista> {
  TextEditingController usuario = TextEditingController();
  TextEditingController contrasenia = TextEditingController();
  final clave = GlobalKey<FormState>();

  @override
  void dispose() {
    usuario.dispose();
    contrasenia.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () => FocusScope.of(context).unfocus(),
      child: Scaffold(
        backgroundColor: Colores.claro,
        body: Center(
          child: SingleChildScrollView(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Container(
                  child: Image.asset(
                    "assets/logo/logo.png",
                  ),
                  width: 200,
                ),
                Text(
                  "Inicio de Sesión",
                  style: TextStyle(
                      color: Colors.white,
                      fontWeight: FontWeight.bold,
                      fontSize: 40),
                ),
                Padding(
                  padding: const EdgeInsets.fromLTRB(350, 20, 350, 20),
                  child: Form(
                      key: clave,
                      child: Column(
                        children: [
                          CampoTexto(usuario, "Correo", Colors.white, 50),
                          SizedBox(height: 10),
                          CampoTextoContrasenia(
                              contrasenia, "Contraseña", Colors.white)
                        ],
                      )),
                ),
                Boton(iniciarSesion, "INICIAR SESIÓN", Colors.white,
                    Colors.black, 50, 40),
                SizedBox(height: 10),
                Boton(registrar, "REGISTRARSE", Colors.white, Colors.black, 50,
                    40),
              ],
            ),
          ),
        ),
      ),
    );
  }

  void iniciarSesion() async {
    List<UsuarioData> usuarios = await locator<AppDatabase>().getUsuarios();
    bool esCorrecto = false;
    if (clave.currentState!.validate()) {
      clave.currentState!.save();
      for (final x in usuarios) {
        if (x.correo == usuario.text && x.contrasenia == contrasenia.text) {
          esCorrecto = true;
          Navigator.pop(context);
          Navigator.pushNamed(context, '/inicio', arguments: x);
          break;
        }
      }

      if (!esCorrecto) {
        Mensaje m = Mensaje(
            Icons.warning_outlined, "Los datos introducidos no son válidos");
        ScaffoldMessenger.of(context).showSnackBar(m.mostrarMensaje());
      }
    }
  }

  void registrar() {
    usuario.clear();
    contrasenia.clear();
    Navigator.pushNamed(context, '/registro');
  }
}
