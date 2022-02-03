import 'dart:io';

import 'package:moor/moor.dart';
import 'package:moor/ffi.dart';
import 'package:path_provider/path_provider.dart';
import 'package:path/path.dart' as p;

part 'moor_database.g.dart';

LazyDatabase openConnection() {
  return LazyDatabase(() async {
    final dbFolder = await getApplicationDocumentsDirectory();
    final file = File(p.join(dbFolder.path, 'db.sqlite'));
    return VmDatabase(file);
  });
}

class Proyecto extends Table {
  IntColumn get idProyecto => integer().autoIncrement().nullable()(); //PK
  IntColumn get idUsuario => integer()
      .nullable()
      .customConstraint('NULL REFERENCES usuario(idUsuario)')(); //FK
  TextColumn get nombre => text().withLength(min: 1, max: 50)();
  TextColumn get descripcion => text().withLength(min: 1, max: 250)();
}

class Requisito extends Table {
  IntColumn get idRequisito => integer().autoIncrement().nullable()(); //PK
  IntColumn get idProyecto => integer()
      .nullable()
      .customConstraint('NULL REFERENCES proyecto(idProyecto)')(); //FK
  IntColumn get idVersion => integer()
      .nullable()
      .customConstraint('NULL REFERENCES version(idVersion)')(); //FK
  TextColumn get nombre => text().withLength(min: 1, max: 50)();
  TextColumn get descripcion => text().withLength(min: 1, max: 250)();
  IntColumn get porcentaje => integer()();
  IntColumn get esfuerzo => integer()();
  RealColumn get productividad => real().nullable()();
  RealColumn get satisfaccion => real().nullable()();
}

class Usuario extends Table {
  IntColumn get idUsuario => integer().autoIncrement().nullable()(); //PK
  TextColumn get nombre => text().withLength(min: 1, max: 50)();
  TextColumn get correo => text().withLength(min: 1, max: 50)();
  TextColumn get contrasenia => text().withLength(min: 1, max: 50)();
  BoolColumn get esDesarrollador => boolean().withDefault(Constant(true))();
}

class Cliente extends Table {
  IntColumn get idCliente => integer().autoIncrement().nullable()(); //PK
  IntColumn get idUsuario => integer()
      .nullable()
      .customConstraint('NULL REFERENCES usuario(idUsuario)')(); //FK
  TextColumn get nombre => text().withLength(min: 1, max: 50)();
  TextColumn get correo => text().withLength(min: 1, max: 50).nullable()();
  IntColumn get idProyecto => integer()
      .nullable()
      .customConstraint('NULL REFERENCES proyecto(idProyecto)')(); //FK
  TextColumn get puesto => text().withLength(min: 1, max: 50)();
  IntColumn get importancia => integer()();
}

class Version extends Table {
  IntColumn get idVersion => integer().autoIncrement().nullable()(); //PK
  TextColumn get nombre => text().withLength(min: 1, max: 50)();
  IntColumn get esfuerzo => integer()();
  RealColumn get satisfaccionTotal => real().nullable()();
  RealColumn get productividad => real().nullable()();
  IntColumn get idProyecto => integer()
      .nullable()
      .customConstraint('NULL REFERENCES proyecto(idProyecto)')(); //FK
}

class Valoracion extends Table {
  IntColumn get idValoracion => integer().autoIncrement().nullable()(); //PK
  IntColumn get valoracion => integer().withDefault(Constant(0))();
  IntColumn get idRequisito => integer()
      .nullable()
      .customConstraint('NULL REFERENCES requisito(idRequisito)')(); //FK
  IntColumn get idCliente => integer()
      .nullable()
      .customConstraint('NULL REFERENCES cliente(idCliente)')(); //FK
}

@UseMoor(tables: [Proyecto, Requisito, Usuario, Cliente, Version, Valoracion])
class AppDatabase extends _$AppDatabase {
  AppDatabase(QueryExecutor e) : super(e);

  @override
  int get schemaVersion => 8;

  //Metodos tabla Proyecto
  Future<List<ProyectoData>> getProyectos() => select(proyecto).get();
  Stream<List<ProyectoData>> watchProyectos() => select(proyecto).watch();
  Future insertProyecto(Insertable<ProyectoData> proyectoNuevo) =>
      into(proyecto).insert(proyectoNuevo);
  Future updateProyecto(Insertable<ProyectoData> proyectoNuevo) =>
      update(proyecto).replace(proyectoNuevo);
  Future deleteProyecto(Insertable<ProyectoData> proyectoNuevo) =>
      delete(proyecto).delete(proyectoNuevo);

  //Metodos tabla Requisito
  Future<List<RequisitoData>> getRequisitos() => select(requisito).get();
  Stream<List<RequisitoData>> watchRequisitos() => select(requisito).watch();
  Future insertRequisito(Insertable<RequisitoData> requisitoNuevo) =>
      into(requisito).insert(requisitoNuevo);
  Future updateRequisito(Insertable<RequisitoData> requisitoNuevo) =>
      update(requisito).replace(requisitoNuevo);
  Future deleteRequisito(Insertable<RequisitoData> requisitoNuevo) =>
      delete(requisito).delete(requisitoNuevo);

  //Metodos tabla Usuario
  Future<List<UsuarioData>> getUsuarios() => select(usuario).get();
  Stream<List<UsuarioData>> watchUsuarios() => select(usuario).watch();
  Future insertUsuario(Insertable<UsuarioData> usuarioNuevo) =>
      into(usuario).insert(usuarioNuevo);
  Future updateUsuario(Insertable<UsuarioData> usuarioNuevo) =>
      update(usuario).replace(usuarioNuevo);
  Future deleteUsuario(Insertable<UsuarioData> usuarioNuevo) =>
      delete(usuario).delete(usuarioNuevo);

  //Metodos tabla Cliente
  Future<List<ClienteData>> getClientes() => select(cliente).get();
  Stream<List<ClienteData>> watchClientes() => select(cliente).watch();
  Future insertCliente(Insertable<ClienteData> clienteNuevo) =>
      into(cliente).insert(clienteNuevo);
  Future updateCliente(Insertable<ClienteData> clienteNuevo) =>
      update(cliente).replace(clienteNuevo);
  Future deleteCliente(Insertable<ClienteData> clienteNuevo) =>
      delete(cliente).delete(clienteNuevo);

  //Metodos tabla Version
  Future<List<VersionData>> getVersiones() => select(version).get();
  Stream<List<VersionData>> watchVersiones() => select(version).watch();
  Future insertVersion(Insertable<VersionData> versionNuevo) =>
      into(version).insert(versionNuevo);
  Future updateVersion(Insertable<VersionData> versionNuevo) =>
      update(version).replace(versionNuevo);
  Future deleteVersion(Insertable<VersionData> versionNuevo) =>
      delete(version).delete(versionNuevo);

  //Metodos tabla Valoracion
  Future<List<ValoracionData>> getValoraciones() => select(valoracion).get();
  Stream<List<ValoracionData>> watchValoraciones() =>
      select(valoracion).watch();
  Future insertValoracion(Insertable<ValoracionData> valoracionNuevo) =>
      into(valoracion).insert(valoracionNuevo);
  Future updateValoracion(Insertable<ValoracionData> valoracionNuevo) =>
      update(valoracion).replace(valoracionNuevo);
  Future deleteValoracion(Insertable<ValoracionData> valoracionNuevo) =>
      delete(valoracion).delete(valoracionNuevo);
}
