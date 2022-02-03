import 'package:flutter/material.dart';
import 'package:nrp_app/data/moor_database.dart';
import 'package:nrp_app/service_locator.dart';
import 'package:nrp_app/widgets/botones.dart';
import 'package:nrp_app/widgets/campo_texto.dart';
import 'package:nrp_app/widgets/mensaje_widget.dart';

class FilaRequisitoCliente extends StatefulWidget {
  final RequisitoData requisito;
  final ClienteData cliente;

  FilaRequisitoCliente(this.requisito, this.cliente);

  @override
  State<FilaRequisitoCliente> createState() => _FilaRequisitoClienteState();
}

class _FilaRequisitoClienteState extends State<FilaRequisitoCliente> {
  TextEditingController valoracionCampo = TextEditingController();
  ValoracionData valoracion = ValoracionData(valoracion: 0);

  @override
  void dispose() {
    valoracionCampo.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
        onTap: () {
          abrirPopUp();
        },
        child: ListTile(
            title: Text(widget.requisito.nombre, style: TextStyle()),
            subtitle: Text(widget.requisito.descripcion, style: TextStyle()),
            trailing: Icon(Icons.add_circle_outline_outlined)));
  }

  void abrirPopUp() async {
    await cargarClientesValoraciones();

    valoracionCampo.text = "${valoracion.valoracion}";
    showDialog(
        context: context,
        builder: (BuildContext context) {
          return GestureDetector(
            onTap: () => FocusScope.of(context).unfocus(),
            child: Scaffold(
              backgroundColor: Colors.transparent,
              body: Builder(builder: (context) {
                return SimpleDialog(
                  shape: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(5),
                      borderSide: BorderSide(color: Colors.white)),
                  title: Text(
                    "${widget.requisito.nombre}",
                    style: TextStyle(fontWeight: FontWeight.bold),
                  ),
                  children: [
                    CampoTexto(valoracionCampo, "Valoración",
                        Colors.grey.shade200, 50),
                    Row(
                      children: [
                        Spacer(),
                        Boton(() {
                          Navigator.pop(context);
                        }, "CANCELAR", Colors.grey, Colors.white, 50, 40),
                        SizedBox(height: 10),
                        Boton(() async {
                          if (!comprobarCampo(1, 5, valoracionCampo.text)) {
                            Mensaje m = Mensaje(Icons.warning_outlined,
                                "La valoracion debe ser un valor entre 1 y 5");
                            ScaffoldMessenger.of(context)
                                .showSnackBar(m.mostrarMensaje());
                            return;
                          } else {
                            valoracion = ValoracionData(
                                idValoracion: valoracion.idValoracion,
                                valoracion: int.parse(valoracionCampo.text),
                                idCliente: widget.cliente.idCliente,
                                idRequisito: widget.requisito.idRequisito);
                            await locator<AppDatabase>()
                                .updateValoracion(valoracion);
                            Navigator.pop(context);
                          }
                        }, "GUARDAR", Colors.blue, Colors.white, 50, 40)
                      ],
                    )
                  ],
                );
              }),
            ),
          );
        });
  }

  Future<dynamic> cargarClientesValoraciones() async {
    List<ValoracionData> tempValoraciones =
        await locator<AppDatabase>().getValoraciones();

    for (ValoracionData x in tempValoraciones) {
      print(
          "Cliente: ${widget.cliente.idCliente} vs ${x.idCliente} Requisito: ${widget.requisito.idRequisito} vs ${x.idRequisito}");
      if (x.idRequisito == widget.requisito.idRequisito &&
          x.idCliente == widget.cliente.idCliente) {
        valoracion = x;
      }
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
}
