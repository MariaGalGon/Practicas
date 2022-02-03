import 'package:flutter/material.dart';
import 'package:nrp_app/colores.dart';
import 'package:nrp_app/data/moor_database.dart';
import 'package:nrp_app/service_locator.dart';
import 'package:nrp_app/widgets/botones.dart';
import 'package:nrp_app/widgets/campo_texto.dart';
import 'package:nrp_app/widgets/campo_texto_contrasenia.dart';
import 'package:nrp_app/widgets/mensaje_widget.dart';

class RegistroVista extends StatefulWidget {
  @override
  _RegistroVistaState createState() => _RegistroVistaState();
}

class _RegistroVistaState extends State<RegistroVista> {
  TextEditingController nombre = TextEditingController();
  TextEditingController correo = TextEditingController();
  TextEditingController contrasenia = TextEditingController();
  TextEditingController confirmar = TextEditingController();
  final clave = GlobalKey<FormState>();
  bool? esDesarrollador = false;

  @override
  void dispose() {
    nombre.dispose();
    correo.dispose();
    contrasenia.dispose();
    confirmar.dispose();
    super.dispose();
  }

  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () => FocusScope.of(context).unfocus(),
      child: Scaffold(
        appBar: AppBar(backgroundColor: Colores.claro, elevation: 0),
        backgroundColor: Colores.claro,
        body: Center(
          child: SingleChildScrollView(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text(
                  "Registrarse",
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
                          CampoTexto(nombre, "Nombre", Colors.white, 50),
                          SizedBox(height: 10),
                          CampoTexto(correo, "Correo", Colors.white, 50),
                          SizedBox(height: 10),
                          CampoTextoContrasenia(
                              contrasenia, "Contraseña", Colors.white),
                          SizedBox(height: 10),
                          CampoTextoContrasenia(
                              confirmar, "Confirmar Contraseña", Colors.white)
                        ],
                      )),
                ),
                SizedBox(
                  width: 350,
                  child: CheckboxListTile(
                      title: Text("Desarrollador",
                          style: TextStyle(
                              fontWeight: FontWeight.bold,
                              fontSize: 20,
                              color: Colors.white)),
                      controlAffinity: ListTileControlAffinity.trailing,
                      checkColor: Colors.black,
                      activeColor: Colors.white,
                      value: esDesarrollador,
                      onChanged: (valor) => setState(() {
                            esDesarrollador = valor;
                          })),
                ),
                Boton(registrar, "REGISTRARSE", Colors.white, Colors.black, 50,
                    40),
              ],
            ),
          ),
        ),
      ),
    );
  }

  void registrar() async {
    bool existeUsuario = false;
    if (clave.currentState!.validate()) {
      clave.currentState!.save();
      if (contrasenia.text == confirmar.text) {
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

        if (!existeUsuario) {
          await locator<AppDatabase>().insertUsuario(UsuarioData(
              idUsuario: null,
              nombre: nombre.text,
              correo: correo.text,
              contrasenia: contrasenia.text,
              esDesarrollador: esDesarrollador!));

          Navigator.pop(context);
          Mensaje m = Mensaje(Icons.done_outlined, "Su cuenta se ha creado");
          ScaffoldMessenger.of(context).showSnackBar(m.mostrarMensaje());
        }
      } else {
        Mensaje m = Mensaje(
            Icons.warning_outlined, "Las contraseñas deben ser iguales");
        ScaffoldMessenger.of(context).showSnackBar(m.mostrarMensaje());
      }
    }
  }
}
