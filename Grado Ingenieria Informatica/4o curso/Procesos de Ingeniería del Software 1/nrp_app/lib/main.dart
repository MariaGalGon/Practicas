import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:nrp_app/screens/editar_cliente_vista.dart';
import 'package:nrp_app/screens/editar_proyecto_vista.dart';
import 'package:nrp_app/screens/editar_requisito_vista.dart';
import 'package:nrp_app/screens/informacion_version.dart';
import 'package:nrp_app/screens/inicio_vista.dart';
import 'package:nrp_app/screens/login_vista.dart';
import 'package:nrp_app/screens/previsualizacion_vista.dart';
import 'package:nrp_app/screens/proyecto_cliente_vista.dart';
import 'package:nrp_app/screens/proyecto_vista.dart';
import 'package:nrp_app/screens/registro_vista.dart';
import 'package:nrp_app/service_locator.dart';

Future<void> main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await SystemChrome.setPreferredOrientations([
    DeviceOrientation.landscapeLeft,
    DeviceOrientation.landscapeRight,
  ]);
  // Register the database service before the app starts
  await setupLocator();

  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: 'NRP',
        debugShowCheckedModeBanner: false,
        initialRoute: '/',
        routes: {
          '/': (context) => LoginVista(),
          '/registro': (context) => RegistroVista(),
          '/inicio': (context) => InicioVista(),
          '/proyecto': (context) => ProyectoVista(),
          '/editarRequisito': (context) => EditarRequisitoVista(),
          '/editarCliente': (context) => EditarClienteVista(),
          '/editarProyecto': (context) => EditarProyectoVista(),
          '/proyectoCliente': (context) => ProyectoClienteVista(),
          '/previsualizacion': (context) => Previsualizacion(),
          '/informacionVersion': (context) => InformacionVersion()
        });
  }
}
