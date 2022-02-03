import 'package:flutter/material.dart';
import 'package:nrp_app/colores.dart';
import 'package:nrp_app/data/moor_database.dart';
import 'package:nrp_app/data/operaciones_db.dart';
import 'package:nrp_app/service_locator.dart';
import 'package:nrp_app/widgets/botones.dart';
import 'package:nrp_app/widgets/campo_texto.dart';
import 'package:nrp_app/widgets/mensaje_widget.dart';

class EditarClienteVista extends StatefulWidget {
  @override
  _EditarClienteVistaState createState() => _EditarClienteVistaState();
}

class _EditarClienteVistaState extends State<EditarClienteVista> {
  TextEditingController puesto = TextEditingController();
  TextEditingController importancia = TextEditingController();
  bool esNuevo = true;
  late ClienteData cliente;
  List<ElementoMenu> elementos = [];
  UsuarioData usuarioSeleccionado = UsuarioData(
      nombre: "", correo: "", contrasenia: "", esDesarrollador: false);

  @override
  void initState() {
    super.initState();
  }

  @override
  void dispose() {
    puesto.dispose();
    importancia.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    cliente = ModalRoute.of(context)!.settings.arguments as ClienteData;
    // obtenerClientes();

    return FutureBuilder(
        future: obtenerClientes(),
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.done) {
            if (cliente.nombre != "") {
              cargarUsuario(cliente.idUsuario!);
              puesto.text = cliente.puesto;
              importancia.text = "${cliente.importancia}";
              esNuevo = false;
            } else {
              if (usuarioSeleccionado.nombre == "")
                usuarioSeleccionado = elementos.first.usuario;
            }

            return ventana();
          } else {
            return Center(child: CircularProgressIndicator());
          }
        });
  }

  void guardarCliente() async {
    if (!comprobarCampo(1, 5, importancia.text)) {
      Mensaje m = Mensaje(Icons.warning_outlined,
          "La importancia debe ser un valor entre 1 y 5");
      ScaffoldMessenger.of(context).showSnackBar(m.mostrarMensaje());
      return;
    }

    ClienteData clienteModificado = ClienteData(
      idProyecto: cliente.idProyecto,
      idCliente: cliente.idCliente,
      idUsuario: usuarioSeleccionado.idUsuario,
      nombre: usuarioSeleccionado.nombre,
      importancia: int.parse(importancia.text),
      puesto: puesto.text,
      correo: usuarioSeleccionado.correo,
    );
    if (esNuevo) {
      await locator<AppDatabase>().insertCliente(clienteModificado);
    } else {
      await locator<AppDatabase>().updateCliente(clienteModificado);
    }
    Navigator.pop(context, true);
  }

  void borrarCliente() async {
    if (!esNuevo) {
      OperacionesDB operacionesDB = OperacionesDB();

      operacionesDB.borrarCliente(cliente);
      Navigator.pop(context, true);
    }
  }

  Future<void> obtenerClientes() async {
    List<UsuarioData> tempUsuarios = await locator<AppDatabase>().getUsuarios();
    List<ClienteData> tempClientes = await locator<AppDatabase>().getClientes();
    elementos.clear();

    tempUsuarios.forEach((x) {
      if (!x.esDesarrollador) {
        bool existeCliente = false;

        for (ClienteData c in tempClientes) {
          if (c.idProyecto == cliente.idProyecto &&
              c.idUsuario == x.idUsuario) {
            existeCliente = true;
            break;
          }
        }

        if (!existeCliente) {
          elementos.add(ElementoMenu(x, x.nombre));
        }
      }
    });

    if(elementos.length == 0 && cliente.nombre == ""){
      Navigator.pop(context, false);
    }
  }

  bool comprobarCampo(int min, int max, String valor) {
    int? v = int.tryParse(valor);

    if (v == null) {
      return false;
    }

    if (v >= min && v <= max) {
      return true;
    }

    return false;
  }

  void cargarUsuario(int idUsuario) async {
    List<UsuarioData> tempUsuarios = await locator<AppDatabase>().getUsuarios();
    for (UsuarioData c in tempUsuarios) {
      if (c.idUsuario == idUsuario) {
        usuarioSeleccionado = c;
      }
    }
  }

  Widget ventana() {
    return GestureDetector(
      onTap: () => FocusScope.of(context).unfocus(),
      child: Scaffold(
        appBar: AppBar(
          title: Text("Editar cliente"),
          centerTitle: true,
          backgroundColor: Colores.primario,
        ),
        body: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Container(
                padding: EdgeInsets.symmetric(horizontal: 40),
                height: 100,
                child: (cliente.nombre == "")
                    ? DropdownButtonHideUnderline(
                        child: DropdownButton(
                        value: usuarioSeleccionado,
                        items: elementos
                            .map((ElementoMenu e) => DropdownMenuItem(
                                  child: Text(e.nombre),
                                  value: e.usuario,
                                ))
                            .toList(),
                        isExpanded: true,
                        onChanged: (valorSeleccionado) {
                          setState(() {
                            this.usuarioSeleccionado =
                                valorSeleccionado as UsuarioData;
                          });
                        },
                      ))
                    : Padding(
                        padding: EdgeInsets.fromLTRB(0, 35, 0, 0),
                        child: Text(
                          cliente.nombre,
                          style: TextStyle(
                              fontSize: 25, fontWeight: FontWeight.bold),
                          textAlign: TextAlign.left,
                        ),
                      )),
            CampoTexto(puesto, "Puesto", Colors.grey.shade200, 50),
            CampoTexto(importancia, "Importancia", Colors.grey.shade200, 50),
            Spacer(),
            Row(
              children: [
                Boton(guardarCliente, "GUARDAR", Colors.blue, Colors.white, 50,
                    40),
                SizedBox(height: 10),
                Boton(borrarCliente, "BORRAR", Colors.red, Colors.white, 50, 40)
              ],
            )
          ],
        ),
      ),
    );
  }
}

class ElementoMenu {
  UsuarioData usuario;
  String nombre;

  ElementoMenu(this.usuario, this.nombre);
}
