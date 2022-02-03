import 'package:nrp_app/data/moor_database.dart';
import 'package:nrp_app/service_locator.dart';

class OperacionesDB {
  void borrarRequisito(RequisitoData requisito) async {
    List<ValoracionData> tempValoraciones =
        await locator<AppDatabase>().getValoraciones();

    tempValoraciones.forEach((val) async {
      if (val.idRequisito == requisito.idRequisito) {
        await locator<AppDatabase>().deleteValoracion(val);
      }
    });

    await locator<AppDatabase>().deleteRequisito(requisito);
  }

  void borrarCliente(ClienteData cliente) async {
    List<ValoracionData> tempValoraciones =
        await locator<AppDatabase>().getValoraciones();

    tempValoraciones.forEach((val) async {
      if (val.idCliente == cliente.idCliente) {
        await locator<AppDatabase>().deleteValoracion(val);
      }
    });

    await locator<AppDatabase>().deleteCliente(cliente);
  }

  void borrarProyecto(ProyectoData proyecto) async {
    List<RequisitoData> tempRequisitos =
        await locator<AppDatabase>().getRequisitos();
    tempRequisitos.forEach((req) async {
      if (req.idProyecto == proyecto.idProyecto) {
        borrarRequisito(req);
      }
    });

    List<ClienteData> tempClientes = await locator<AppDatabase>().getClientes();
    tempClientes.forEach((cliente) async {
      if (cliente.idProyecto == proyecto.idProyecto) {
        borrarCliente(cliente);
      }
    });

    List<VersionData> tempVersiones =
        await locator<AppDatabase>().getVersiones();
    tempVersiones.forEach((ver) async {
      if (ver.idProyecto == proyecto.idProyecto) {
        await locator<AppDatabase>().deleteVersion(ver);
      }
    });

    await locator<AppDatabase>().deleteProyecto(proyecto);
  }

  void eliminarCuenta(UsuarioData usuario) async {
    List<ProyectoData> tempProyectos =
        await locator<AppDatabase>().getProyectos();
    tempProyectos.forEach((proyecto) async {
      if (usuario.idUsuario == proyecto.idUsuario) {
        borrarProyecto(proyecto);
      }
    });

    await locator<AppDatabase>().deleteUsuario(usuario);
  }
}
