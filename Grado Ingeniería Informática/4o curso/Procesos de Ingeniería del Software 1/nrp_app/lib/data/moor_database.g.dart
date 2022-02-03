// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'moor_database.dart';

// **************************************************************************
// MoorGenerator
// **************************************************************************

// ignore_for_file: unnecessary_brace_in_string_interps, unnecessary_this
class ProyectoData extends DataClass implements Insertable<ProyectoData> {
  final int? idProyecto;
  final int? idUsuario;
  final String nombre;
  final String descripcion;
  ProyectoData(
      {this.idProyecto,
      this.idUsuario,
      required this.nombre,
      required this.descripcion});
  factory ProyectoData.fromData(Map<String, dynamic> data, GeneratedDatabase db,
      {String? prefix}) {
    final effectivePrefix = prefix ?? '';
    return ProyectoData(
      idProyecto: const IntType()
          .mapFromDatabaseResponse(data['${effectivePrefix}id_proyecto']),
      idUsuario: const IntType()
          .mapFromDatabaseResponse(data['${effectivePrefix}id_usuario']),
      nombre: const StringType()
          .mapFromDatabaseResponse(data['${effectivePrefix}nombre'])!,
      descripcion: const StringType()
          .mapFromDatabaseResponse(data['${effectivePrefix}descripcion'])!,
    );
  }
  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    if (!nullToAbsent || idProyecto != null) {
      map['id_proyecto'] = Variable<int?>(idProyecto);
    }
    if (!nullToAbsent || idUsuario != null) {
      map['id_usuario'] = Variable<int?>(idUsuario);
    }
    map['nombre'] = Variable<String>(nombre);
    map['descripcion'] = Variable<String>(descripcion);
    return map;
  }

  ProyectoCompanion toCompanion(bool nullToAbsent) {
    return ProyectoCompanion(
      idProyecto: idProyecto == null && nullToAbsent
          ? const Value.absent()
          : Value(idProyecto),
      idUsuario: idUsuario == null && nullToAbsent
          ? const Value.absent()
          : Value(idUsuario),
      nombre: Value(nombre),
      descripcion: Value(descripcion),
    );
  }

  factory ProyectoData.fromJson(Map<String, dynamic> json,
      {ValueSerializer? serializer}) {
    serializer ??= moorRuntimeOptions.defaultSerializer;
    return ProyectoData(
      idProyecto: serializer.fromJson<int?>(json['idProyecto']),
      idUsuario: serializer.fromJson<int?>(json['idUsuario']),
      nombre: serializer.fromJson<String>(json['nombre']),
      descripcion: serializer.fromJson<String>(json['descripcion']),
    );
  }
  @override
  Map<String, dynamic> toJson({ValueSerializer? serializer}) {
    serializer ??= moorRuntimeOptions.defaultSerializer;
    return <String, dynamic>{
      'idProyecto': serializer.toJson<int?>(idProyecto),
      'idUsuario': serializer.toJson<int?>(idUsuario),
      'nombre': serializer.toJson<String>(nombre),
      'descripcion': serializer.toJson<String>(descripcion),
    };
  }

  ProyectoData copyWith(
          {int? idProyecto,
          int? idUsuario,
          String? nombre,
          String? descripcion}) =>
      ProyectoData(
        idProyecto: idProyecto ?? this.idProyecto,
        idUsuario: idUsuario ?? this.idUsuario,
        nombre: nombre ?? this.nombre,
        descripcion: descripcion ?? this.descripcion,
      );
  @override
  String toString() {
    return (StringBuffer('ProyectoData(')
          ..write('idProyecto: $idProyecto, ')
          ..write('idUsuario: $idUsuario, ')
          ..write('nombre: $nombre, ')
          ..write('descripcion: $descripcion')
          ..write(')'))
        .toString();
  }

  @override
  int get hashCode => Object.hash(idProyecto, idUsuario, nombre, descripcion);
  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      (other is ProyectoData &&
          other.idProyecto == this.idProyecto &&
          other.idUsuario == this.idUsuario &&
          other.nombre == this.nombre &&
          other.descripcion == this.descripcion);
}

class ProyectoCompanion extends UpdateCompanion<ProyectoData> {
  final Value<int?> idProyecto;
  final Value<int?> idUsuario;
  final Value<String> nombre;
  final Value<String> descripcion;
  const ProyectoCompanion({
    this.idProyecto = const Value.absent(),
    this.idUsuario = const Value.absent(),
    this.nombre = const Value.absent(),
    this.descripcion = const Value.absent(),
  });
  ProyectoCompanion.insert({
    this.idProyecto = const Value.absent(),
    this.idUsuario = const Value.absent(),
    required String nombre,
    required String descripcion,
  })  : nombre = Value(nombre),
        descripcion = Value(descripcion);
  static Insertable<ProyectoData> custom({
    Expression<int?>? idProyecto,
    Expression<int?>? idUsuario,
    Expression<String>? nombre,
    Expression<String>? descripcion,
  }) {
    return RawValuesInsertable({
      if (idProyecto != null) 'id_proyecto': idProyecto,
      if (idUsuario != null) 'id_usuario': idUsuario,
      if (nombre != null) 'nombre': nombre,
      if (descripcion != null) 'descripcion': descripcion,
    });
  }

  ProyectoCompanion copyWith(
      {Value<int?>? idProyecto,
      Value<int?>? idUsuario,
      Value<String>? nombre,
      Value<String>? descripcion}) {
    return ProyectoCompanion(
      idProyecto: idProyecto ?? this.idProyecto,
      idUsuario: idUsuario ?? this.idUsuario,
      nombre: nombre ?? this.nombre,
      descripcion: descripcion ?? this.descripcion,
    );
  }

  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    if (idProyecto.present) {
      map['id_proyecto'] = Variable<int?>(idProyecto.value);
    }
    if (idUsuario.present) {
      map['id_usuario'] = Variable<int?>(idUsuario.value);
    }
    if (nombre.present) {
      map['nombre'] = Variable<String>(nombre.value);
    }
    if (descripcion.present) {
      map['descripcion'] = Variable<String>(descripcion.value);
    }
    return map;
  }

  @override
  String toString() {
    return (StringBuffer('ProyectoCompanion(')
          ..write('idProyecto: $idProyecto, ')
          ..write('idUsuario: $idUsuario, ')
          ..write('nombre: $nombre, ')
          ..write('descripcion: $descripcion')
          ..write(')'))
        .toString();
  }
}

class $ProyectoTable extends Proyecto
    with TableInfo<$ProyectoTable, ProyectoData> {
  final GeneratedDatabase _db;
  final String? _alias;
  $ProyectoTable(this._db, [this._alias]);
  final VerificationMeta _idProyectoMeta = const VerificationMeta('idProyecto');
  late final GeneratedColumn<int?> idProyecto = GeneratedColumn<int?>(
      'id_proyecto', aliasedName, true,
      typeName: 'INTEGER',
      requiredDuringInsert: false,
      defaultConstraints: 'PRIMARY KEY AUTOINCREMENT');
  final VerificationMeta _idUsuarioMeta = const VerificationMeta('idUsuario');
  late final GeneratedColumn<int?> idUsuario = GeneratedColumn<int?>(
      'id_usuario', aliasedName, true,
      typeName: 'INTEGER',
      requiredDuringInsert: false,
      $customConstraints: 'NULL REFERENCES usuario(idUsuario)');
  final VerificationMeta _nombreMeta = const VerificationMeta('nombre');
  late final GeneratedColumn<String?> nombre = GeneratedColumn<String?>(
      'nombre', aliasedName, false,
      additionalChecks:
          GeneratedColumn.checkTextLength(minTextLength: 1, maxTextLength: 50),
      typeName: 'TEXT',
      requiredDuringInsert: true);
  final VerificationMeta _descripcionMeta =
      const VerificationMeta('descripcion');
  late final GeneratedColumn<String?> descripcion = GeneratedColumn<String?>(
      'descripcion', aliasedName, false,
      additionalChecks:
          GeneratedColumn.checkTextLength(minTextLength: 1, maxTextLength: 250),
      typeName: 'TEXT',
      requiredDuringInsert: true);
  @override
  List<GeneratedColumn> get $columns =>
      [idProyecto, idUsuario, nombre, descripcion];
  @override
  String get aliasedName => _alias ?? 'proyecto';
  @override
  String get actualTableName => 'proyecto';
  @override
  VerificationContext validateIntegrity(Insertable<ProyectoData> instance,
      {bool isInserting = false}) {
    final context = VerificationContext();
    final data = instance.toColumns(true);
    if (data.containsKey('id_proyecto')) {
      context.handle(
          _idProyectoMeta,
          idProyecto.isAcceptableOrUnknown(
              data['id_proyecto']!, _idProyectoMeta));
    }
    if (data.containsKey('id_usuario')) {
      context.handle(_idUsuarioMeta,
          idUsuario.isAcceptableOrUnknown(data['id_usuario']!, _idUsuarioMeta));
    }
    if (data.containsKey('nombre')) {
      context.handle(_nombreMeta,
          nombre.isAcceptableOrUnknown(data['nombre']!, _nombreMeta));
    } else if (isInserting) {
      context.missing(_nombreMeta);
    }
    if (data.containsKey('descripcion')) {
      context.handle(
          _descripcionMeta,
          descripcion.isAcceptableOrUnknown(
              data['descripcion']!, _descripcionMeta));
    } else if (isInserting) {
      context.missing(_descripcionMeta);
    }
    return context;
  }

  @override
  Set<GeneratedColumn> get $primaryKey => {idProyecto};
  @override
  ProyectoData map(Map<String, dynamic> data, {String? tablePrefix}) {
    return ProyectoData.fromData(data, _db,
        prefix: tablePrefix != null ? '$tablePrefix.' : null);
  }

  @override
  $ProyectoTable createAlias(String alias) {
    return $ProyectoTable(_db, alias);
  }
}

class RequisitoData extends DataClass implements Insertable<RequisitoData> {
  final int? idRequisito;
  final int? idProyecto;
  final int? idVersion;
  final String nombre;
  final String descripcion;
  final int porcentaje;
  final int esfuerzo;
  final double? productividad;
  final double? satisfaccion;
  RequisitoData(
      {this.idRequisito,
      this.idProyecto,
      this.idVersion,
      required this.nombre,
      required this.descripcion,
      required this.porcentaje,
      required this.esfuerzo,
      this.productividad,
      this.satisfaccion});
  factory RequisitoData.fromData(
      Map<String, dynamic> data, GeneratedDatabase db,
      {String? prefix}) {
    final effectivePrefix = prefix ?? '';
    return RequisitoData(
      idRequisito: const IntType()
          .mapFromDatabaseResponse(data['${effectivePrefix}id_requisito']),
      idProyecto: const IntType()
          .mapFromDatabaseResponse(data['${effectivePrefix}id_proyecto']),
      idVersion: const IntType()
          .mapFromDatabaseResponse(data['${effectivePrefix}id_version']),
      nombre: const StringType()
          .mapFromDatabaseResponse(data['${effectivePrefix}nombre'])!,
      descripcion: const StringType()
          .mapFromDatabaseResponse(data['${effectivePrefix}descripcion'])!,
      porcentaje: const IntType()
          .mapFromDatabaseResponse(data['${effectivePrefix}porcentaje'])!,
      esfuerzo: const IntType()
          .mapFromDatabaseResponse(data['${effectivePrefix}esfuerzo'])!,
      productividad: const RealType()
          .mapFromDatabaseResponse(data['${effectivePrefix}productividad']),
      satisfaccion: const RealType()
          .mapFromDatabaseResponse(data['${effectivePrefix}satisfaccion']),
    );
  }
  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    if (!nullToAbsent || idRequisito != null) {
      map['id_requisito'] = Variable<int?>(idRequisito);
    }
    if (!nullToAbsent || idProyecto != null) {
      map['id_proyecto'] = Variable<int?>(idProyecto);
    }
    if (!nullToAbsent || idVersion != null) {
      map['id_version'] = Variable<int?>(idVersion);
    }
    map['nombre'] = Variable<String>(nombre);
    map['descripcion'] = Variable<String>(descripcion);
    map['porcentaje'] = Variable<int>(porcentaje);
    map['esfuerzo'] = Variable<int>(esfuerzo);
    if (!nullToAbsent || productividad != null) {
      map['productividad'] = Variable<double?>(productividad);
    }
    if (!nullToAbsent || satisfaccion != null) {
      map['satisfaccion'] = Variable<double?>(satisfaccion);
    }
    return map;
  }

  RequisitoCompanion toCompanion(bool nullToAbsent) {
    return RequisitoCompanion(
      idRequisito: idRequisito == null && nullToAbsent
          ? const Value.absent()
          : Value(idRequisito),
      idProyecto: idProyecto == null && nullToAbsent
          ? const Value.absent()
          : Value(idProyecto),
      idVersion: idVersion == null && nullToAbsent
          ? const Value.absent()
          : Value(idVersion),
      nombre: Value(nombre),
      descripcion: Value(descripcion),
      porcentaje: Value(porcentaje),
      esfuerzo: Value(esfuerzo),
      productividad: productividad == null && nullToAbsent
          ? const Value.absent()
          : Value(productividad),
      satisfaccion: satisfaccion == null && nullToAbsent
          ? const Value.absent()
          : Value(satisfaccion),
    );
  }

  factory RequisitoData.fromJson(Map<String, dynamic> json,
      {ValueSerializer? serializer}) {
    serializer ??= moorRuntimeOptions.defaultSerializer;
    return RequisitoData(
      idRequisito: serializer.fromJson<int?>(json['idRequisito']),
      idProyecto: serializer.fromJson<int?>(json['idProyecto']),
      idVersion: serializer.fromJson<int?>(json['idVersion']),
      nombre: serializer.fromJson<String>(json['nombre']),
      descripcion: serializer.fromJson<String>(json['descripcion']),
      porcentaje: serializer.fromJson<int>(json['porcentaje']),
      esfuerzo: serializer.fromJson<int>(json['esfuerzo']),
      productividad: serializer.fromJson<double?>(json['productividad']),
      satisfaccion: serializer.fromJson<double?>(json['satisfaccion']),
    );
  }
  @override
  Map<String, dynamic> toJson({ValueSerializer? serializer}) {
    serializer ??= moorRuntimeOptions.defaultSerializer;
    return <String, dynamic>{
      'idRequisito': serializer.toJson<int?>(idRequisito),
      'idProyecto': serializer.toJson<int?>(idProyecto),
      'idVersion': serializer.toJson<int?>(idVersion),
      'nombre': serializer.toJson<String>(nombre),
      'descripcion': serializer.toJson<String>(descripcion),
      'porcentaje': serializer.toJson<int>(porcentaje),
      'esfuerzo': serializer.toJson<int>(esfuerzo),
      'productividad': serializer.toJson<double?>(productividad),
      'satisfaccion': serializer.toJson<double?>(satisfaccion),
    };
  }

  RequisitoData copyWith(
          {int? idRequisito,
          int? idProyecto,
          int? idVersion,
          String? nombre,
          String? descripcion,
          int? porcentaje,
          int? esfuerzo,
          double? productividad,
          double? satisfaccion}) =>
      RequisitoData(
        idRequisito: idRequisito ?? this.idRequisito,
        idProyecto: idProyecto ?? this.idProyecto,
        idVersion: idVersion ?? this.idVersion,
        nombre: nombre ?? this.nombre,
        descripcion: descripcion ?? this.descripcion,
        porcentaje: porcentaje ?? this.porcentaje,
        esfuerzo: esfuerzo ?? this.esfuerzo,
        productividad: productividad ?? this.productividad,
        satisfaccion: satisfaccion ?? this.satisfaccion,
      );
  @override
  String toString() {
    return (StringBuffer('RequisitoData(')
          ..write('idRequisito: $idRequisito, ')
          ..write('idProyecto: $idProyecto, ')
          ..write('idVersion: $idVersion, ')
          ..write('nombre: $nombre, ')
          ..write('descripcion: $descripcion, ')
          ..write('porcentaje: $porcentaje, ')
          ..write('esfuerzo: $esfuerzo, ')
          ..write('productividad: $productividad, ')
          ..write('satisfaccion: $satisfaccion')
          ..write(')'))
        .toString();
  }

  @override
  int get hashCode => Object.hash(idRequisito, idProyecto, idVersion, nombre,
      descripcion, porcentaje, esfuerzo, productividad, satisfaccion);
  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      (other is RequisitoData &&
          other.idRequisito == this.idRequisito &&
          other.idProyecto == this.idProyecto &&
          other.idVersion == this.idVersion &&
          other.nombre == this.nombre &&
          other.descripcion == this.descripcion &&
          other.porcentaje == this.porcentaje &&
          other.esfuerzo == this.esfuerzo &&
          other.productividad == this.productividad &&
          other.satisfaccion == this.satisfaccion);
}

class RequisitoCompanion extends UpdateCompanion<RequisitoData> {
  final Value<int?> idRequisito;
  final Value<int?> idProyecto;
  final Value<int?> idVersion;
  final Value<String> nombre;
  final Value<String> descripcion;
  final Value<int> porcentaje;
  final Value<int> esfuerzo;
  final Value<double?> productividad;
  final Value<double?> satisfaccion;
  const RequisitoCompanion({
    this.idRequisito = const Value.absent(),
    this.idProyecto = const Value.absent(),
    this.idVersion = const Value.absent(),
    this.nombre = const Value.absent(),
    this.descripcion = const Value.absent(),
    this.porcentaje = const Value.absent(),
    this.esfuerzo = const Value.absent(),
    this.productividad = const Value.absent(),
    this.satisfaccion = const Value.absent(),
  });
  RequisitoCompanion.insert({
    this.idRequisito = const Value.absent(),
    this.idProyecto = const Value.absent(),
    this.idVersion = const Value.absent(),
    required String nombre,
    required String descripcion,
    required int porcentaje,
    required int esfuerzo,
    this.productividad = const Value.absent(),
    this.satisfaccion = const Value.absent(),
  })  : nombre = Value(nombre),
        descripcion = Value(descripcion),
        porcentaje = Value(porcentaje),
        esfuerzo = Value(esfuerzo);
  static Insertable<RequisitoData> custom({
    Expression<int?>? idRequisito,
    Expression<int?>? idProyecto,
    Expression<int?>? idVersion,
    Expression<String>? nombre,
    Expression<String>? descripcion,
    Expression<int>? porcentaje,
    Expression<int>? esfuerzo,
    Expression<double?>? productividad,
    Expression<double?>? satisfaccion,
  }) {
    return RawValuesInsertable({
      if (idRequisito != null) 'id_requisito': idRequisito,
      if (idProyecto != null) 'id_proyecto': idProyecto,
      if (idVersion != null) 'id_version': idVersion,
      if (nombre != null) 'nombre': nombre,
      if (descripcion != null) 'descripcion': descripcion,
      if (porcentaje != null) 'porcentaje': porcentaje,
      if (esfuerzo != null) 'esfuerzo': esfuerzo,
      if (productividad != null) 'productividad': productividad,
      if (satisfaccion != null) 'satisfaccion': satisfaccion,
    });
  }

  RequisitoCompanion copyWith(
      {Value<int?>? idRequisito,
      Value<int?>? idProyecto,
      Value<int?>? idVersion,
      Value<String>? nombre,
      Value<String>? descripcion,
      Value<int>? porcentaje,
      Value<int>? esfuerzo,
      Value<double?>? productividad,
      Value<double?>? satisfaccion}) {
    return RequisitoCompanion(
      idRequisito: idRequisito ?? this.idRequisito,
      idProyecto: idProyecto ?? this.idProyecto,
      idVersion: idVersion ?? this.idVersion,
      nombre: nombre ?? this.nombre,
      descripcion: descripcion ?? this.descripcion,
      porcentaje: porcentaje ?? this.porcentaje,
      esfuerzo: esfuerzo ?? this.esfuerzo,
      productividad: productividad ?? this.productividad,
      satisfaccion: satisfaccion ?? this.satisfaccion,
    );
  }

  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    if (idRequisito.present) {
      map['id_requisito'] = Variable<int?>(idRequisito.value);
    }
    if (idProyecto.present) {
      map['id_proyecto'] = Variable<int?>(idProyecto.value);
    }
    if (idVersion.present) {
      map['id_version'] = Variable<int?>(idVersion.value);
    }
    if (nombre.present) {
      map['nombre'] = Variable<String>(nombre.value);
    }
    if (descripcion.present) {
      map['descripcion'] = Variable<String>(descripcion.value);
    }
    if (porcentaje.present) {
      map['porcentaje'] = Variable<int>(porcentaje.value);
    }
    if (esfuerzo.present) {
      map['esfuerzo'] = Variable<int>(esfuerzo.value);
    }
    if (productividad.present) {
      map['productividad'] = Variable<double?>(productividad.value);
    }
    if (satisfaccion.present) {
      map['satisfaccion'] = Variable<double?>(satisfaccion.value);
    }
    return map;
  }

  @override
  String toString() {
    return (StringBuffer('RequisitoCompanion(')
          ..write('idRequisito: $idRequisito, ')
          ..write('idProyecto: $idProyecto, ')
          ..write('idVersion: $idVersion, ')
          ..write('nombre: $nombre, ')
          ..write('descripcion: $descripcion, ')
          ..write('porcentaje: $porcentaje, ')
          ..write('esfuerzo: $esfuerzo, ')
          ..write('productividad: $productividad, ')
          ..write('satisfaccion: $satisfaccion')
          ..write(')'))
        .toString();
  }
}

class $RequisitoTable extends Requisito
    with TableInfo<$RequisitoTable, RequisitoData> {
  final GeneratedDatabase _db;
  final String? _alias;
  $RequisitoTable(this._db, [this._alias]);
  final VerificationMeta _idRequisitoMeta =
      const VerificationMeta('idRequisito');
  late final GeneratedColumn<int?> idRequisito = GeneratedColumn<int?>(
      'id_requisito', aliasedName, true,
      typeName: 'INTEGER',
      requiredDuringInsert: false,
      defaultConstraints: 'PRIMARY KEY AUTOINCREMENT');
  final VerificationMeta _idProyectoMeta = const VerificationMeta('idProyecto');
  late final GeneratedColumn<int?> idProyecto = GeneratedColumn<int?>(
      'id_proyecto', aliasedName, true,
      typeName: 'INTEGER',
      requiredDuringInsert: false,
      $customConstraints: 'NULL REFERENCES proyecto(idProyecto)');
  final VerificationMeta _idVersionMeta = const VerificationMeta('idVersion');
  late final GeneratedColumn<int?> idVersion = GeneratedColumn<int?>(
      'id_version', aliasedName, true,
      typeName: 'INTEGER',
      requiredDuringInsert: false,
      $customConstraints: 'NULL REFERENCES version(idVersion)');
  final VerificationMeta _nombreMeta = const VerificationMeta('nombre');
  late final GeneratedColumn<String?> nombre = GeneratedColumn<String?>(
      'nombre', aliasedName, false,
      additionalChecks:
          GeneratedColumn.checkTextLength(minTextLength: 1, maxTextLength: 50),
      typeName: 'TEXT',
      requiredDuringInsert: true);
  final VerificationMeta _descripcionMeta =
      const VerificationMeta('descripcion');
  late final GeneratedColumn<String?> descripcion = GeneratedColumn<String?>(
      'descripcion', aliasedName, false,
      additionalChecks:
          GeneratedColumn.checkTextLength(minTextLength: 1, maxTextLength: 250),
      typeName: 'TEXT',
      requiredDuringInsert: true);
  final VerificationMeta _porcentajeMeta = const VerificationMeta('porcentaje');
  late final GeneratedColumn<int?> porcentaje = GeneratedColumn<int?>(
      'porcentaje', aliasedName, false,
      typeName: 'INTEGER', requiredDuringInsert: true);
  final VerificationMeta _esfuerzoMeta = const VerificationMeta('esfuerzo');
  late final GeneratedColumn<int?> esfuerzo = GeneratedColumn<int?>(
      'esfuerzo', aliasedName, false,
      typeName: 'INTEGER', requiredDuringInsert: true);
  final VerificationMeta _productividadMeta =
      const VerificationMeta('productividad');
  late final GeneratedColumn<double?> productividad = GeneratedColumn<double?>(
      'productividad', aliasedName, true,
      typeName: 'REAL', requiredDuringInsert: false);
  final VerificationMeta _satisfaccionMeta =
      const VerificationMeta('satisfaccion');
  late final GeneratedColumn<double?> satisfaccion = GeneratedColumn<double?>(
      'satisfaccion', aliasedName, true,
      typeName: 'REAL', requiredDuringInsert: false);
  @override
  List<GeneratedColumn> get $columns => [
        idRequisito,
        idProyecto,
        idVersion,
        nombre,
        descripcion,
        porcentaje,
        esfuerzo,
        productividad,
        satisfaccion
      ];
  @override
  String get aliasedName => _alias ?? 'requisito';
  @override
  String get actualTableName => 'requisito';
  @override
  VerificationContext validateIntegrity(Insertable<RequisitoData> instance,
      {bool isInserting = false}) {
    final context = VerificationContext();
    final data = instance.toColumns(true);
    if (data.containsKey('id_requisito')) {
      context.handle(
          _idRequisitoMeta,
          idRequisito.isAcceptableOrUnknown(
              data['id_requisito']!, _idRequisitoMeta));
    }
    if (data.containsKey('id_proyecto')) {
      context.handle(
          _idProyectoMeta,
          idProyecto.isAcceptableOrUnknown(
              data['id_proyecto']!, _idProyectoMeta));
    }
    if (data.containsKey('id_version')) {
      context.handle(_idVersionMeta,
          idVersion.isAcceptableOrUnknown(data['id_version']!, _idVersionMeta));
    }
    if (data.containsKey('nombre')) {
      context.handle(_nombreMeta,
          nombre.isAcceptableOrUnknown(data['nombre']!, _nombreMeta));
    } else if (isInserting) {
      context.missing(_nombreMeta);
    }
    if (data.containsKey('descripcion')) {
      context.handle(
          _descripcionMeta,
          descripcion.isAcceptableOrUnknown(
              data['descripcion']!, _descripcionMeta));
    } else if (isInserting) {
      context.missing(_descripcionMeta);
    }
    if (data.containsKey('porcentaje')) {
      context.handle(
          _porcentajeMeta,
          porcentaje.isAcceptableOrUnknown(
              data['porcentaje']!, _porcentajeMeta));
    } else if (isInserting) {
      context.missing(_porcentajeMeta);
    }
    if (data.containsKey('esfuerzo')) {
      context.handle(_esfuerzoMeta,
          esfuerzo.isAcceptableOrUnknown(data['esfuerzo']!, _esfuerzoMeta));
    } else if (isInserting) {
      context.missing(_esfuerzoMeta);
    }
    if (data.containsKey('productividad')) {
      context.handle(
          _productividadMeta,
          productividad.isAcceptableOrUnknown(
              data['productividad']!, _productividadMeta));
    }
    if (data.containsKey('satisfaccion')) {
      context.handle(
          _satisfaccionMeta,
          satisfaccion.isAcceptableOrUnknown(
              data['satisfaccion']!, _satisfaccionMeta));
    }
    return context;
  }

  @override
  Set<GeneratedColumn> get $primaryKey => {idRequisito};
  @override
  RequisitoData map(Map<String, dynamic> data, {String? tablePrefix}) {
    return RequisitoData.fromData(data, _db,
        prefix: tablePrefix != null ? '$tablePrefix.' : null);
  }

  @override
  $RequisitoTable createAlias(String alias) {
    return $RequisitoTable(_db, alias);
  }
}

class UsuarioData extends DataClass implements Insertable<UsuarioData> {
  final int? idUsuario;
  final String nombre;
  final String correo;
  final String contrasenia;
  final bool esDesarrollador;
  UsuarioData(
      {this.idUsuario,
      required this.nombre,
      required this.correo,
      required this.contrasenia,
      required this.esDesarrollador});
  factory UsuarioData.fromData(Map<String, dynamic> data, GeneratedDatabase db,
      {String? prefix}) {
    final effectivePrefix = prefix ?? '';
    return UsuarioData(
      idUsuario: const IntType()
          .mapFromDatabaseResponse(data['${effectivePrefix}id_usuario']),
      nombre: const StringType()
          .mapFromDatabaseResponse(data['${effectivePrefix}nombre'])!,
      correo: const StringType()
          .mapFromDatabaseResponse(data['${effectivePrefix}correo'])!,
      contrasenia: const StringType()
          .mapFromDatabaseResponse(data['${effectivePrefix}contrasenia'])!,
      esDesarrollador: const BoolType()
          .mapFromDatabaseResponse(data['${effectivePrefix}es_desarrollador'])!,
    );
  }
  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    if (!nullToAbsent || idUsuario != null) {
      map['id_usuario'] = Variable<int?>(idUsuario);
    }
    map['nombre'] = Variable<String>(nombre);
    map['correo'] = Variable<String>(correo);
    map['contrasenia'] = Variable<String>(contrasenia);
    map['es_desarrollador'] = Variable<bool>(esDesarrollador);
    return map;
  }

  UsuarioCompanion toCompanion(bool nullToAbsent) {
    return UsuarioCompanion(
      idUsuario: idUsuario == null && nullToAbsent
          ? const Value.absent()
          : Value(idUsuario),
      nombre: Value(nombre),
      correo: Value(correo),
      contrasenia: Value(contrasenia),
      esDesarrollador: Value(esDesarrollador),
    );
  }

  factory UsuarioData.fromJson(Map<String, dynamic> json,
      {ValueSerializer? serializer}) {
    serializer ??= moorRuntimeOptions.defaultSerializer;
    return UsuarioData(
      idUsuario: serializer.fromJson<int?>(json['idUsuario']),
      nombre: serializer.fromJson<String>(json['nombre']),
      correo: serializer.fromJson<String>(json['correo']),
      contrasenia: serializer.fromJson<String>(json['contrasenia']),
      esDesarrollador: serializer.fromJson<bool>(json['esDesarrollador']),
    );
  }
  @override
  Map<String, dynamic> toJson({ValueSerializer? serializer}) {
    serializer ??= moorRuntimeOptions.defaultSerializer;
    return <String, dynamic>{
      'idUsuario': serializer.toJson<int?>(idUsuario),
      'nombre': serializer.toJson<String>(nombre),
      'correo': serializer.toJson<String>(correo),
      'contrasenia': serializer.toJson<String>(contrasenia),
      'esDesarrollador': serializer.toJson<bool>(esDesarrollador),
    };
  }

  UsuarioData copyWith(
          {int? idUsuario,
          String? nombre,
          String? correo,
          String? contrasenia,
          bool? esDesarrollador}) =>
      UsuarioData(
        idUsuario: idUsuario ?? this.idUsuario,
        nombre: nombre ?? this.nombre,
        correo: correo ?? this.correo,
        contrasenia: contrasenia ?? this.contrasenia,
        esDesarrollador: esDesarrollador ?? this.esDesarrollador,
      );
  @override
  String toString() {
    return (StringBuffer('UsuarioData(')
          ..write('idUsuario: $idUsuario, ')
          ..write('nombre: $nombre, ')
          ..write('correo: $correo, ')
          ..write('contrasenia: $contrasenia, ')
          ..write('esDesarrollador: $esDesarrollador')
          ..write(')'))
        .toString();
  }

  @override
  int get hashCode =>
      Object.hash(idUsuario, nombre, correo, contrasenia, esDesarrollador);
  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      (other is UsuarioData &&
          other.idUsuario == this.idUsuario &&
          other.nombre == this.nombre &&
          other.correo == this.correo &&
          other.contrasenia == this.contrasenia &&
          other.esDesarrollador == this.esDesarrollador);
}

class UsuarioCompanion extends UpdateCompanion<UsuarioData> {
  final Value<int?> idUsuario;
  final Value<String> nombre;
  final Value<String> correo;
  final Value<String> contrasenia;
  final Value<bool> esDesarrollador;
  const UsuarioCompanion({
    this.idUsuario = const Value.absent(),
    this.nombre = const Value.absent(),
    this.correo = const Value.absent(),
    this.contrasenia = const Value.absent(),
    this.esDesarrollador = const Value.absent(),
  });
  UsuarioCompanion.insert({
    this.idUsuario = const Value.absent(),
    required String nombre,
    required String correo,
    required String contrasenia,
    this.esDesarrollador = const Value.absent(),
  })  : nombre = Value(nombre),
        correo = Value(correo),
        contrasenia = Value(contrasenia);
  static Insertable<UsuarioData> custom({
    Expression<int?>? idUsuario,
    Expression<String>? nombre,
    Expression<String>? correo,
    Expression<String>? contrasenia,
    Expression<bool>? esDesarrollador,
  }) {
    return RawValuesInsertable({
      if (idUsuario != null) 'id_usuario': idUsuario,
      if (nombre != null) 'nombre': nombre,
      if (correo != null) 'correo': correo,
      if (contrasenia != null) 'contrasenia': contrasenia,
      if (esDesarrollador != null) 'es_desarrollador': esDesarrollador,
    });
  }

  UsuarioCompanion copyWith(
      {Value<int?>? idUsuario,
      Value<String>? nombre,
      Value<String>? correo,
      Value<String>? contrasenia,
      Value<bool>? esDesarrollador}) {
    return UsuarioCompanion(
      idUsuario: idUsuario ?? this.idUsuario,
      nombre: nombre ?? this.nombre,
      correo: correo ?? this.correo,
      contrasenia: contrasenia ?? this.contrasenia,
      esDesarrollador: esDesarrollador ?? this.esDesarrollador,
    );
  }

  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    if (idUsuario.present) {
      map['id_usuario'] = Variable<int?>(idUsuario.value);
    }
    if (nombre.present) {
      map['nombre'] = Variable<String>(nombre.value);
    }
    if (correo.present) {
      map['correo'] = Variable<String>(correo.value);
    }
    if (contrasenia.present) {
      map['contrasenia'] = Variable<String>(contrasenia.value);
    }
    if (esDesarrollador.present) {
      map['es_desarrollador'] = Variable<bool>(esDesarrollador.value);
    }
    return map;
  }

  @override
  String toString() {
    return (StringBuffer('UsuarioCompanion(')
          ..write('idUsuario: $idUsuario, ')
          ..write('nombre: $nombre, ')
          ..write('correo: $correo, ')
          ..write('contrasenia: $contrasenia, ')
          ..write('esDesarrollador: $esDesarrollador')
          ..write(')'))
        .toString();
  }
}

class $UsuarioTable extends Usuario with TableInfo<$UsuarioTable, UsuarioData> {
  final GeneratedDatabase _db;
  final String? _alias;
  $UsuarioTable(this._db, [this._alias]);
  final VerificationMeta _idUsuarioMeta = const VerificationMeta('idUsuario');
  late final GeneratedColumn<int?> idUsuario = GeneratedColumn<int?>(
      'id_usuario', aliasedName, true,
      typeName: 'INTEGER',
      requiredDuringInsert: false,
      defaultConstraints: 'PRIMARY KEY AUTOINCREMENT');
  final VerificationMeta _nombreMeta = const VerificationMeta('nombre');
  late final GeneratedColumn<String?> nombre = GeneratedColumn<String?>(
      'nombre', aliasedName, false,
      additionalChecks:
          GeneratedColumn.checkTextLength(minTextLength: 1, maxTextLength: 50),
      typeName: 'TEXT',
      requiredDuringInsert: true);
  final VerificationMeta _correoMeta = const VerificationMeta('correo');
  late final GeneratedColumn<String?> correo = GeneratedColumn<String?>(
      'correo', aliasedName, false,
      additionalChecks:
          GeneratedColumn.checkTextLength(minTextLength: 1, maxTextLength: 50),
      typeName: 'TEXT',
      requiredDuringInsert: true);
  final VerificationMeta _contraseniaMeta =
      const VerificationMeta('contrasenia');
  late final GeneratedColumn<String?> contrasenia = GeneratedColumn<String?>(
      'contrasenia', aliasedName, false,
      additionalChecks:
          GeneratedColumn.checkTextLength(minTextLength: 1, maxTextLength: 50),
      typeName: 'TEXT',
      requiredDuringInsert: true);
  final VerificationMeta _esDesarrolladorMeta =
      const VerificationMeta('esDesarrollador');
  late final GeneratedColumn<bool?> esDesarrollador = GeneratedColumn<bool?>(
      'es_desarrollador', aliasedName, false,
      typeName: 'INTEGER',
      requiredDuringInsert: false,
      defaultConstraints: 'CHECK (es_desarrollador IN (0, 1))',
      defaultValue: Constant(true));
  @override
  List<GeneratedColumn> get $columns =>
      [idUsuario, nombre, correo, contrasenia, esDesarrollador];
  @override
  String get aliasedName => _alias ?? 'usuario';
  @override
  String get actualTableName => 'usuario';
  @override
  VerificationContext validateIntegrity(Insertable<UsuarioData> instance,
      {bool isInserting = false}) {
    final context = VerificationContext();
    final data = instance.toColumns(true);
    if (data.containsKey('id_usuario')) {
      context.handle(_idUsuarioMeta,
          idUsuario.isAcceptableOrUnknown(data['id_usuario']!, _idUsuarioMeta));
    }
    if (data.containsKey('nombre')) {
      context.handle(_nombreMeta,
          nombre.isAcceptableOrUnknown(data['nombre']!, _nombreMeta));
    } else if (isInserting) {
      context.missing(_nombreMeta);
    }
    if (data.containsKey('correo')) {
      context.handle(_correoMeta,
          correo.isAcceptableOrUnknown(data['correo']!, _correoMeta));
    } else if (isInserting) {
      context.missing(_correoMeta);
    }
    if (data.containsKey('contrasenia')) {
      context.handle(
          _contraseniaMeta,
          contrasenia.isAcceptableOrUnknown(
              data['contrasenia']!, _contraseniaMeta));
    } else if (isInserting) {
      context.missing(_contraseniaMeta);
    }
    if (data.containsKey('es_desarrollador')) {
      context.handle(
          _esDesarrolladorMeta,
          esDesarrollador.isAcceptableOrUnknown(
              data['es_desarrollador']!, _esDesarrolladorMeta));
    }
    return context;
  }

  @override
  Set<GeneratedColumn> get $primaryKey => {idUsuario};
  @override
  UsuarioData map(Map<String, dynamic> data, {String? tablePrefix}) {
    return UsuarioData.fromData(data, _db,
        prefix: tablePrefix != null ? '$tablePrefix.' : null);
  }

  @override
  $UsuarioTable createAlias(String alias) {
    return $UsuarioTable(_db, alias);
  }
}

class ClienteData extends DataClass implements Insertable<ClienteData> {
  final int? idCliente;
  final int? idUsuario;
  final String nombre;
  final String? correo;
  final int? idProyecto;
  final String puesto;
  final int importancia;
  ClienteData(
      {this.idCliente,
      this.idUsuario,
      required this.nombre,
      this.correo,
      this.idProyecto,
      required this.puesto,
      required this.importancia});
  factory ClienteData.fromData(Map<String, dynamic> data, GeneratedDatabase db,
      {String? prefix}) {
    final effectivePrefix = prefix ?? '';
    return ClienteData(
      idCliente: const IntType()
          .mapFromDatabaseResponse(data['${effectivePrefix}id_cliente']),
      idUsuario: const IntType()
          .mapFromDatabaseResponse(data['${effectivePrefix}id_usuario']),
      nombre: const StringType()
          .mapFromDatabaseResponse(data['${effectivePrefix}nombre'])!,
      correo: const StringType()
          .mapFromDatabaseResponse(data['${effectivePrefix}correo']),
      idProyecto: const IntType()
          .mapFromDatabaseResponse(data['${effectivePrefix}id_proyecto']),
      puesto: const StringType()
          .mapFromDatabaseResponse(data['${effectivePrefix}puesto'])!,
      importancia: const IntType()
          .mapFromDatabaseResponse(data['${effectivePrefix}importancia'])!,
    );
  }
  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    if (!nullToAbsent || idCliente != null) {
      map['id_cliente'] = Variable<int?>(idCliente);
    }
    if (!nullToAbsent || idUsuario != null) {
      map['id_usuario'] = Variable<int?>(idUsuario);
    }
    map['nombre'] = Variable<String>(nombre);
    if (!nullToAbsent || correo != null) {
      map['correo'] = Variable<String?>(correo);
    }
    if (!nullToAbsent || idProyecto != null) {
      map['id_proyecto'] = Variable<int?>(idProyecto);
    }
    map['puesto'] = Variable<String>(puesto);
    map['importancia'] = Variable<int>(importancia);
    return map;
  }

  ClienteCompanion toCompanion(bool nullToAbsent) {
    return ClienteCompanion(
      idCliente: idCliente == null && nullToAbsent
          ? const Value.absent()
          : Value(idCliente),
      idUsuario: idUsuario == null && nullToAbsent
          ? const Value.absent()
          : Value(idUsuario),
      nombre: Value(nombre),
      correo:
          correo == null && nullToAbsent ? const Value.absent() : Value(correo),
      idProyecto: idProyecto == null && nullToAbsent
          ? const Value.absent()
          : Value(idProyecto),
      puesto: Value(puesto),
      importancia: Value(importancia),
    );
  }

  factory ClienteData.fromJson(Map<String, dynamic> json,
      {ValueSerializer? serializer}) {
    serializer ??= moorRuntimeOptions.defaultSerializer;
    return ClienteData(
      idCliente: serializer.fromJson<int?>(json['idCliente']),
      idUsuario: serializer.fromJson<int?>(json['idUsuario']),
      nombre: serializer.fromJson<String>(json['nombre']),
      correo: serializer.fromJson<String?>(json['correo']),
      idProyecto: serializer.fromJson<int?>(json['idProyecto']),
      puesto: serializer.fromJson<String>(json['puesto']),
      importancia: serializer.fromJson<int>(json['importancia']),
    );
  }
  @override
  Map<String, dynamic> toJson({ValueSerializer? serializer}) {
    serializer ??= moorRuntimeOptions.defaultSerializer;
    return <String, dynamic>{
      'idCliente': serializer.toJson<int?>(idCliente),
      'idUsuario': serializer.toJson<int?>(idUsuario),
      'nombre': serializer.toJson<String>(nombre),
      'correo': serializer.toJson<String?>(correo),
      'idProyecto': serializer.toJson<int?>(idProyecto),
      'puesto': serializer.toJson<String>(puesto),
      'importancia': serializer.toJson<int>(importancia),
    };
  }

  ClienteData copyWith(
          {int? idCliente,
          int? idUsuario,
          String? nombre,
          String? correo,
          int? idProyecto,
          String? puesto,
          int? importancia}) =>
      ClienteData(
        idCliente: idCliente ?? this.idCliente,
        idUsuario: idUsuario ?? this.idUsuario,
        nombre: nombre ?? this.nombre,
        correo: correo ?? this.correo,
        idProyecto: idProyecto ?? this.idProyecto,
        puesto: puesto ?? this.puesto,
        importancia: importancia ?? this.importancia,
      );
  @override
  String toString() {
    return (StringBuffer('ClienteData(')
          ..write('idCliente: $idCliente, ')
          ..write('idUsuario: $idUsuario, ')
          ..write('nombre: $nombre, ')
          ..write('correo: $correo, ')
          ..write('idProyecto: $idProyecto, ')
          ..write('puesto: $puesto, ')
          ..write('importancia: $importancia')
          ..write(')'))
        .toString();
  }

  @override
  int get hashCode => Object.hash(
      idCliente, idUsuario, nombre, correo, idProyecto, puesto, importancia);
  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      (other is ClienteData &&
          other.idCliente == this.idCliente &&
          other.idUsuario == this.idUsuario &&
          other.nombre == this.nombre &&
          other.correo == this.correo &&
          other.idProyecto == this.idProyecto &&
          other.puesto == this.puesto &&
          other.importancia == this.importancia);
}

class ClienteCompanion extends UpdateCompanion<ClienteData> {
  final Value<int?> idCliente;
  final Value<int?> idUsuario;
  final Value<String> nombre;
  final Value<String?> correo;
  final Value<int?> idProyecto;
  final Value<String> puesto;
  final Value<int> importancia;
  const ClienteCompanion({
    this.idCliente = const Value.absent(),
    this.idUsuario = const Value.absent(),
    this.nombre = const Value.absent(),
    this.correo = const Value.absent(),
    this.idProyecto = const Value.absent(),
    this.puesto = const Value.absent(),
    this.importancia = const Value.absent(),
  });
  ClienteCompanion.insert({
    this.idCliente = const Value.absent(),
    this.idUsuario = const Value.absent(),
    required String nombre,
    this.correo = const Value.absent(),
    this.idProyecto = const Value.absent(),
    required String puesto,
    required int importancia,
  })  : nombre = Value(nombre),
        puesto = Value(puesto),
        importancia = Value(importancia);
  static Insertable<ClienteData> custom({
    Expression<int?>? idCliente,
    Expression<int?>? idUsuario,
    Expression<String>? nombre,
    Expression<String?>? correo,
    Expression<int?>? idProyecto,
    Expression<String>? puesto,
    Expression<int>? importancia,
  }) {
    return RawValuesInsertable({
      if (idCliente != null) 'id_cliente': idCliente,
      if (idUsuario != null) 'id_usuario': idUsuario,
      if (nombre != null) 'nombre': nombre,
      if (correo != null) 'correo': correo,
      if (idProyecto != null) 'id_proyecto': idProyecto,
      if (puesto != null) 'puesto': puesto,
      if (importancia != null) 'importancia': importancia,
    });
  }

  ClienteCompanion copyWith(
      {Value<int?>? idCliente,
      Value<int?>? idUsuario,
      Value<String>? nombre,
      Value<String?>? correo,
      Value<int?>? idProyecto,
      Value<String>? puesto,
      Value<int>? importancia}) {
    return ClienteCompanion(
      idCliente: idCliente ?? this.idCliente,
      idUsuario: idUsuario ?? this.idUsuario,
      nombre: nombre ?? this.nombre,
      correo: correo ?? this.correo,
      idProyecto: idProyecto ?? this.idProyecto,
      puesto: puesto ?? this.puesto,
      importancia: importancia ?? this.importancia,
    );
  }

  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    if (idCliente.present) {
      map['id_cliente'] = Variable<int?>(idCliente.value);
    }
    if (idUsuario.present) {
      map['id_usuario'] = Variable<int?>(idUsuario.value);
    }
    if (nombre.present) {
      map['nombre'] = Variable<String>(nombre.value);
    }
    if (correo.present) {
      map['correo'] = Variable<String?>(correo.value);
    }
    if (idProyecto.present) {
      map['id_proyecto'] = Variable<int?>(idProyecto.value);
    }
    if (puesto.present) {
      map['puesto'] = Variable<String>(puesto.value);
    }
    if (importancia.present) {
      map['importancia'] = Variable<int>(importancia.value);
    }
    return map;
  }

  @override
  String toString() {
    return (StringBuffer('ClienteCompanion(')
          ..write('idCliente: $idCliente, ')
          ..write('idUsuario: $idUsuario, ')
          ..write('nombre: $nombre, ')
          ..write('correo: $correo, ')
          ..write('idProyecto: $idProyecto, ')
          ..write('puesto: $puesto, ')
          ..write('importancia: $importancia')
          ..write(')'))
        .toString();
  }
}

class $ClienteTable extends Cliente with TableInfo<$ClienteTable, ClienteData> {
  final GeneratedDatabase _db;
  final String? _alias;
  $ClienteTable(this._db, [this._alias]);
  final VerificationMeta _idClienteMeta = const VerificationMeta('idCliente');
  late final GeneratedColumn<int?> idCliente = GeneratedColumn<int?>(
      'id_cliente', aliasedName, true,
      typeName: 'INTEGER',
      requiredDuringInsert: false,
      defaultConstraints: 'PRIMARY KEY AUTOINCREMENT');
  final VerificationMeta _idUsuarioMeta = const VerificationMeta('idUsuario');
  late final GeneratedColumn<int?> idUsuario = GeneratedColumn<int?>(
      'id_usuario', aliasedName, true,
      typeName: 'INTEGER',
      requiredDuringInsert: false,
      $customConstraints: 'NULL REFERENCES usuario(idUsuario)');
  final VerificationMeta _nombreMeta = const VerificationMeta('nombre');
  late final GeneratedColumn<String?> nombre = GeneratedColumn<String?>(
      'nombre', aliasedName, false,
      additionalChecks:
          GeneratedColumn.checkTextLength(minTextLength: 1, maxTextLength: 50),
      typeName: 'TEXT',
      requiredDuringInsert: true);
  final VerificationMeta _correoMeta = const VerificationMeta('correo');
  late final GeneratedColumn<String?> correo = GeneratedColumn<String?>(
      'correo', aliasedName, true,
      additionalChecks:
          GeneratedColumn.checkTextLength(minTextLength: 1, maxTextLength: 50),
      typeName: 'TEXT',
      requiredDuringInsert: false);
  final VerificationMeta _idProyectoMeta = const VerificationMeta('idProyecto');
  late final GeneratedColumn<int?> idProyecto = GeneratedColumn<int?>(
      'id_proyecto', aliasedName, true,
      typeName: 'INTEGER',
      requiredDuringInsert: false,
      $customConstraints: 'NULL REFERENCES proyecto(idProyecto)');
  final VerificationMeta _puestoMeta = const VerificationMeta('puesto');
  late final GeneratedColumn<String?> puesto = GeneratedColumn<String?>(
      'puesto', aliasedName, false,
      additionalChecks:
          GeneratedColumn.checkTextLength(minTextLength: 1, maxTextLength: 50),
      typeName: 'TEXT',
      requiredDuringInsert: true);
  final VerificationMeta _importanciaMeta =
      const VerificationMeta('importancia');
  late final GeneratedColumn<int?> importancia = GeneratedColumn<int?>(
      'importancia', aliasedName, false,
      typeName: 'INTEGER', requiredDuringInsert: true);
  @override
  List<GeneratedColumn> get $columns =>
      [idCliente, idUsuario, nombre, correo, idProyecto, puesto, importancia];
  @override
  String get aliasedName => _alias ?? 'cliente';
  @override
  String get actualTableName => 'cliente';
  @override
  VerificationContext validateIntegrity(Insertable<ClienteData> instance,
      {bool isInserting = false}) {
    final context = VerificationContext();
    final data = instance.toColumns(true);
    if (data.containsKey('id_cliente')) {
      context.handle(_idClienteMeta,
          idCliente.isAcceptableOrUnknown(data['id_cliente']!, _idClienteMeta));
    }
    if (data.containsKey('id_usuario')) {
      context.handle(_idUsuarioMeta,
          idUsuario.isAcceptableOrUnknown(data['id_usuario']!, _idUsuarioMeta));
    }
    if (data.containsKey('nombre')) {
      context.handle(_nombreMeta,
          nombre.isAcceptableOrUnknown(data['nombre']!, _nombreMeta));
    } else if (isInserting) {
      context.missing(_nombreMeta);
    }
    if (data.containsKey('correo')) {
      context.handle(_correoMeta,
          correo.isAcceptableOrUnknown(data['correo']!, _correoMeta));
    }
    if (data.containsKey('id_proyecto')) {
      context.handle(
          _idProyectoMeta,
          idProyecto.isAcceptableOrUnknown(
              data['id_proyecto']!, _idProyectoMeta));
    }
    if (data.containsKey('puesto')) {
      context.handle(_puestoMeta,
          puesto.isAcceptableOrUnknown(data['puesto']!, _puestoMeta));
    } else if (isInserting) {
      context.missing(_puestoMeta);
    }
    if (data.containsKey('importancia')) {
      context.handle(
          _importanciaMeta,
          importancia.isAcceptableOrUnknown(
              data['importancia']!, _importanciaMeta));
    } else if (isInserting) {
      context.missing(_importanciaMeta);
    }
    return context;
  }

  @override
  Set<GeneratedColumn> get $primaryKey => {idCliente};
  @override
  ClienteData map(Map<String, dynamic> data, {String? tablePrefix}) {
    return ClienteData.fromData(data, _db,
        prefix: tablePrefix != null ? '$tablePrefix.' : null);
  }

  @override
  $ClienteTable createAlias(String alias) {
    return $ClienteTable(_db, alias);
  }
}

class VersionData extends DataClass implements Insertable<VersionData> {
  final int? idVersion;
  final String nombre;
  final int esfuerzo;
  final double? satisfaccionTotal;
  final double? productividad;
  final int? idProyecto;
  VersionData(
      {this.idVersion,
      required this.nombre,
      required this.esfuerzo,
      this.satisfaccionTotal,
      this.productividad,
      this.idProyecto});
  factory VersionData.fromData(Map<String, dynamic> data, GeneratedDatabase db,
      {String? prefix}) {
    final effectivePrefix = prefix ?? '';
    return VersionData(
      idVersion: const IntType()
          .mapFromDatabaseResponse(data['${effectivePrefix}id_version']),
      nombre: const StringType()
          .mapFromDatabaseResponse(data['${effectivePrefix}nombre'])!,
      esfuerzo: const IntType()
          .mapFromDatabaseResponse(data['${effectivePrefix}esfuerzo'])!,
      satisfaccionTotal: const RealType().mapFromDatabaseResponse(
          data['${effectivePrefix}satisfaccion_total']),
      productividad: const RealType()
          .mapFromDatabaseResponse(data['${effectivePrefix}productividad']),
      idProyecto: const IntType()
          .mapFromDatabaseResponse(data['${effectivePrefix}id_proyecto']),
    );
  }
  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    if (!nullToAbsent || idVersion != null) {
      map['id_version'] = Variable<int?>(idVersion);
    }
    map['nombre'] = Variable<String>(nombre);
    map['esfuerzo'] = Variable<int>(esfuerzo);
    if (!nullToAbsent || satisfaccionTotal != null) {
      map['satisfaccion_total'] = Variable<double?>(satisfaccionTotal);
    }
    if (!nullToAbsent || productividad != null) {
      map['productividad'] = Variable<double?>(productividad);
    }
    if (!nullToAbsent || idProyecto != null) {
      map['id_proyecto'] = Variable<int?>(idProyecto);
    }
    return map;
  }

  VersionCompanion toCompanion(bool nullToAbsent) {
    return VersionCompanion(
      idVersion: idVersion == null && nullToAbsent
          ? const Value.absent()
          : Value(idVersion),
      nombre: Value(nombre),
      esfuerzo: Value(esfuerzo),
      satisfaccionTotal: satisfaccionTotal == null && nullToAbsent
          ? const Value.absent()
          : Value(satisfaccionTotal),
      productividad: productividad == null && nullToAbsent
          ? const Value.absent()
          : Value(productividad),
      idProyecto: idProyecto == null && nullToAbsent
          ? const Value.absent()
          : Value(idProyecto),
    );
  }

  factory VersionData.fromJson(Map<String, dynamic> json,
      {ValueSerializer? serializer}) {
    serializer ??= moorRuntimeOptions.defaultSerializer;
    return VersionData(
      idVersion: serializer.fromJson<int?>(json['idVersion']),
      nombre: serializer.fromJson<String>(json['nombre']),
      esfuerzo: serializer.fromJson<int>(json['esfuerzo']),
      satisfaccionTotal:
          serializer.fromJson<double?>(json['satisfaccionTotal']),
      productividad: serializer.fromJson<double?>(json['productividad']),
      idProyecto: serializer.fromJson<int?>(json['idProyecto']),
    );
  }
  @override
  Map<String, dynamic> toJson({ValueSerializer? serializer}) {
    serializer ??= moorRuntimeOptions.defaultSerializer;
    return <String, dynamic>{
      'idVersion': serializer.toJson<int?>(idVersion),
      'nombre': serializer.toJson<String>(nombre),
      'esfuerzo': serializer.toJson<int>(esfuerzo),
      'satisfaccionTotal': serializer.toJson<double?>(satisfaccionTotal),
      'productividad': serializer.toJson<double?>(productividad),
      'idProyecto': serializer.toJson<int?>(idProyecto),
    };
  }

  VersionData copyWith(
          {int? idVersion,
          String? nombre,
          int? esfuerzo,
          double? satisfaccionTotal,
          double? productividad,
          int? idProyecto}) =>
      VersionData(
        idVersion: idVersion ?? this.idVersion,
        nombre: nombre ?? this.nombre,
        esfuerzo: esfuerzo ?? this.esfuerzo,
        satisfaccionTotal: satisfaccionTotal ?? this.satisfaccionTotal,
        productividad: productividad ?? this.productividad,
        idProyecto: idProyecto ?? this.idProyecto,
      );
  @override
  String toString() {
    return (StringBuffer('VersionData(')
          ..write('idVersion: $idVersion, ')
          ..write('nombre: $nombre, ')
          ..write('esfuerzo: $esfuerzo, ')
          ..write('satisfaccionTotal: $satisfaccionTotal, ')
          ..write('productividad: $productividad, ')
          ..write('idProyecto: $idProyecto')
          ..write(')'))
        .toString();
  }

  @override
  int get hashCode => Object.hash(idVersion, nombre, esfuerzo,
      satisfaccionTotal, productividad, idProyecto);
  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      (other is VersionData &&
          other.idVersion == this.idVersion &&
          other.nombre == this.nombre &&
          other.esfuerzo == this.esfuerzo &&
          other.satisfaccionTotal == this.satisfaccionTotal &&
          other.productividad == this.productividad &&
          other.idProyecto == this.idProyecto);
}

class VersionCompanion extends UpdateCompanion<VersionData> {
  final Value<int?> idVersion;
  final Value<String> nombre;
  final Value<int> esfuerzo;
  final Value<double?> satisfaccionTotal;
  final Value<double?> productividad;
  final Value<int?> idProyecto;
  const VersionCompanion({
    this.idVersion = const Value.absent(),
    this.nombre = const Value.absent(),
    this.esfuerzo = const Value.absent(),
    this.satisfaccionTotal = const Value.absent(),
    this.productividad = const Value.absent(),
    this.idProyecto = const Value.absent(),
  });
  VersionCompanion.insert({
    this.idVersion = const Value.absent(),
    required String nombre,
    required int esfuerzo,
    this.satisfaccionTotal = const Value.absent(),
    this.productividad = const Value.absent(),
    this.idProyecto = const Value.absent(),
  })  : nombre = Value(nombre),
        esfuerzo = Value(esfuerzo);
  static Insertable<VersionData> custom({
    Expression<int?>? idVersion,
    Expression<String>? nombre,
    Expression<int>? esfuerzo,
    Expression<double?>? satisfaccionTotal,
    Expression<double?>? productividad,
    Expression<int?>? idProyecto,
  }) {
    return RawValuesInsertable({
      if (idVersion != null) 'id_version': idVersion,
      if (nombre != null) 'nombre': nombre,
      if (esfuerzo != null) 'esfuerzo': esfuerzo,
      if (satisfaccionTotal != null) 'satisfaccion_total': satisfaccionTotal,
      if (productividad != null) 'productividad': productividad,
      if (idProyecto != null) 'id_proyecto': idProyecto,
    });
  }

  VersionCompanion copyWith(
      {Value<int?>? idVersion,
      Value<String>? nombre,
      Value<int>? esfuerzo,
      Value<double?>? satisfaccionTotal,
      Value<double?>? productividad,
      Value<int?>? idProyecto}) {
    return VersionCompanion(
      idVersion: idVersion ?? this.idVersion,
      nombre: nombre ?? this.nombre,
      esfuerzo: esfuerzo ?? this.esfuerzo,
      satisfaccionTotal: satisfaccionTotal ?? this.satisfaccionTotal,
      productividad: productividad ?? this.productividad,
      idProyecto: idProyecto ?? this.idProyecto,
    );
  }

  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    if (idVersion.present) {
      map['id_version'] = Variable<int?>(idVersion.value);
    }
    if (nombre.present) {
      map['nombre'] = Variable<String>(nombre.value);
    }
    if (esfuerzo.present) {
      map['esfuerzo'] = Variable<int>(esfuerzo.value);
    }
    if (satisfaccionTotal.present) {
      map['satisfaccion_total'] = Variable<double?>(satisfaccionTotal.value);
    }
    if (productividad.present) {
      map['productividad'] = Variable<double?>(productividad.value);
    }
    if (idProyecto.present) {
      map['id_proyecto'] = Variable<int?>(idProyecto.value);
    }
    return map;
  }

  @override
  String toString() {
    return (StringBuffer('VersionCompanion(')
          ..write('idVersion: $idVersion, ')
          ..write('nombre: $nombre, ')
          ..write('esfuerzo: $esfuerzo, ')
          ..write('satisfaccionTotal: $satisfaccionTotal, ')
          ..write('productividad: $productividad, ')
          ..write('idProyecto: $idProyecto')
          ..write(')'))
        .toString();
  }
}

class $VersionTable extends Version with TableInfo<$VersionTable, VersionData> {
  final GeneratedDatabase _db;
  final String? _alias;
  $VersionTable(this._db, [this._alias]);
  final VerificationMeta _idVersionMeta = const VerificationMeta('idVersion');
  late final GeneratedColumn<int?> idVersion = GeneratedColumn<int?>(
      'id_version', aliasedName, true,
      typeName: 'INTEGER',
      requiredDuringInsert: false,
      defaultConstraints: 'PRIMARY KEY AUTOINCREMENT');
  final VerificationMeta _nombreMeta = const VerificationMeta('nombre');
  late final GeneratedColumn<String?> nombre = GeneratedColumn<String?>(
      'nombre', aliasedName, false,
      additionalChecks:
          GeneratedColumn.checkTextLength(minTextLength: 1, maxTextLength: 50),
      typeName: 'TEXT',
      requiredDuringInsert: true);
  final VerificationMeta _esfuerzoMeta = const VerificationMeta('esfuerzo');
  late final GeneratedColumn<int?> esfuerzo = GeneratedColumn<int?>(
      'esfuerzo', aliasedName, false,
      typeName: 'INTEGER', requiredDuringInsert: true);
  final VerificationMeta _satisfaccionTotalMeta =
      const VerificationMeta('satisfaccionTotal');
  late final GeneratedColumn<double?> satisfaccionTotal =
      GeneratedColumn<double?>('satisfaccion_total', aliasedName, true,
          typeName: 'REAL', requiredDuringInsert: false);
  final VerificationMeta _productividadMeta =
      const VerificationMeta('productividad');
  late final GeneratedColumn<double?> productividad = GeneratedColumn<double?>(
      'productividad', aliasedName, true,
      typeName: 'REAL', requiredDuringInsert: false);
  final VerificationMeta _idProyectoMeta = const VerificationMeta('idProyecto');
  late final GeneratedColumn<int?> idProyecto = GeneratedColumn<int?>(
      'id_proyecto', aliasedName, true,
      typeName: 'INTEGER',
      requiredDuringInsert: false,
      $customConstraints: 'NULL REFERENCES proyecto(idProyecto)');
  @override
  List<GeneratedColumn> get $columns => [
        idVersion,
        nombre,
        esfuerzo,
        satisfaccionTotal,
        productividad,
        idProyecto
      ];
  @override
  String get aliasedName => _alias ?? 'version';
  @override
  String get actualTableName => 'version';
  @override
  VerificationContext validateIntegrity(Insertable<VersionData> instance,
      {bool isInserting = false}) {
    final context = VerificationContext();
    final data = instance.toColumns(true);
    if (data.containsKey('id_version')) {
      context.handle(_idVersionMeta,
          idVersion.isAcceptableOrUnknown(data['id_version']!, _idVersionMeta));
    }
    if (data.containsKey('nombre')) {
      context.handle(_nombreMeta,
          nombre.isAcceptableOrUnknown(data['nombre']!, _nombreMeta));
    } else if (isInserting) {
      context.missing(_nombreMeta);
    }
    if (data.containsKey('esfuerzo')) {
      context.handle(_esfuerzoMeta,
          esfuerzo.isAcceptableOrUnknown(data['esfuerzo']!, _esfuerzoMeta));
    } else if (isInserting) {
      context.missing(_esfuerzoMeta);
    }
    if (data.containsKey('satisfaccion_total')) {
      context.handle(
          _satisfaccionTotalMeta,
          satisfaccionTotal.isAcceptableOrUnknown(
              data['satisfaccion_total']!, _satisfaccionTotalMeta));
    }
    if (data.containsKey('productividad')) {
      context.handle(
          _productividadMeta,
          productividad.isAcceptableOrUnknown(
              data['productividad']!, _productividadMeta));
    }
    if (data.containsKey('id_proyecto')) {
      context.handle(
          _idProyectoMeta,
          idProyecto.isAcceptableOrUnknown(
              data['id_proyecto']!, _idProyectoMeta));
    }
    return context;
  }

  @override
  Set<GeneratedColumn> get $primaryKey => {idVersion};
  @override
  VersionData map(Map<String, dynamic> data, {String? tablePrefix}) {
    return VersionData.fromData(data, _db,
        prefix: tablePrefix != null ? '$tablePrefix.' : null);
  }

  @override
  $VersionTable createAlias(String alias) {
    return $VersionTable(_db, alias);
  }
}

class ValoracionData extends DataClass implements Insertable<ValoracionData> {
  final int? idValoracion;
  final int valoracion;
  final int? idRequisito;
  final int? idCliente;
  ValoracionData(
      {this.idValoracion,
      required this.valoracion,
      this.idRequisito,
      this.idCliente});
  factory ValoracionData.fromData(
      Map<String, dynamic> data, GeneratedDatabase db,
      {String? prefix}) {
    final effectivePrefix = prefix ?? '';
    return ValoracionData(
      idValoracion: const IntType()
          .mapFromDatabaseResponse(data['${effectivePrefix}id_valoracion']),
      valoracion: const IntType()
          .mapFromDatabaseResponse(data['${effectivePrefix}valoracion'])!,
      idRequisito: const IntType()
          .mapFromDatabaseResponse(data['${effectivePrefix}id_requisito']),
      idCliente: const IntType()
          .mapFromDatabaseResponse(data['${effectivePrefix}id_cliente']),
    );
  }
  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    if (!nullToAbsent || idValoracion != null) {
      map['id_valoracion'] = Variable<int?>(idValoracion);
    }
    map['valoracion'] = Variable<int>(valoracion);
    if (!nullToAbsent || idRequisito != null) {
      map['id_requisito'] = Variable<int?>(idRequisito);
    }
    if (!nullToAbsent || idCliente != null) {
      map['id_cliente'] = Variable<int?>(idCliente);
    }
    return map;
  }

  ValoracionCompanion toCompanion(bool nullToAbsent) {
    return ValoracionCompanion(
      idValoracion: idValoracion == null && nullToAbsent
          ? const Value.absent()
          : Value(idValoracion),
      valoracion: Value(valoracion),
      idRequisito: idRequisito == null && nullToAbsent
          ? const Value.absent()
          : Value(idRequisito),
      idCliente: idCliente == null && nullToAbsent
          ? const Value.absent()
          : Value(idCliente),
    );
  }

  factory ValoracionData.fromJson(Map<String, dynamic> json,
      {ValueSerializer? serializer}) {
    serializer ??= moorRuntimeOptions.defaultSerializer;
    return ValoracionData(
      idValoracion: serializer.fromJson<int?>(json['idValoracion']),
      valoracion: serializer.fromJson<int>(json['valoracion']),
      idRequisito: serializer.fromJson<int?>(json['idRequisito']),
      idCliente: serializer.fromJson<int?>(json['idCliente']),
    );
  }
  @override
  Map<String, dynamic> toJson({ValueSerializer? serializer}) {
    serializer ??= moorRuntimeOptions.defaultSerializer;
    return <String, dynamic>{
      'idValoracion': serializer.toJson<int?>(idValoracion),
      'valoracion': serializer.toJson<int>(valoracion),
      'idRequisito': serializer.toJson<int?>(idRequisito),
      'idCliente': serializer.toJson<int?>(idCliente),
    };
  }

  ValoracionData copyWith(
          {int? idValoracion,
          int? valoracion,
          int? idRequisito,
          int? idCliente}) =>
      ValoracionData(
        idValoracion: idValoracion ?? this.idValoracion,
        valoracion: valoracion ?? this.valoracion,
        idRequisito: idRequisito ?? this.idRequisito,
        idCliente: idCliente ?? this.idCliente,
      );
  @override
  String toString() {
    return (StringBuffer('ValoracionData(')
          ..write('idValoracion: $idValoracion, ')
          ..write('valoracion: $valoracion, ')
          ..write('idRequisito: $idRequisito, ')
          ..write('idCliente: $idCliente')
          ..write(')'))
        .toString();
  }

  @override
  int get hashCode =>
      Object.hash(idValoracion, valoracion, idRequisito, idCliente);
  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      (other is ValoracionData &&
          other.idValoracion == this.idValoracion &&
          other.valoracion == this.valoracion &&
          other.idRequisito == this.idRequisito &&
          other.idCliente == this.idCliente);
}

class ValoracionCompanion extends UpdateCompanion<ValoracionData> {
  final Value<int?> idValoracion;
  final Value<int> valoracion;
  final Value<int?> idRequisito;
  final Value<int?> idCliente;
  const ValoracionCompanion({
    this.idValoracion = const Value.absent(),
    this.valoracion = const Value.absent(),
    this.idRequisito = const Value.absent(),
    this.idCliente = const Value.absent(),
  });
  ValoracionCompanion.insert({
    this.idValoracion = const Value.absent(),
    this.valoracion = const Value.absent(),
    this.idRequisito = const Value.absent(),
    this.idCliente = const Value.absent(),
  });
  static Insertable<ValoracionData> custom({
    Expression<int?>? idValoracion,
    Expression<int>? valoracion,
    Expression<int?>? idRequisito,
    Expression<int?>? idCliente,
  }) {
    return RawValuesInsertable({
      if (idValoracion != null) 'id_valoracion': idValoracion,
      if (valoracion != null) 'valoracion': valoracion,
      if (idRequisito != null) 'id_requisito': idRequisito,
      if (idCliente != null) 'id_cliente': idCliente,
    });
  }

  ValoracionCompanion copyWith(
      {Value<int?>? idValoracion,
      Value<int>? valoracion,
      Value<int?>? idRequisito,
      Value<int?>? idCliente}) {
    return ValoracionCompanion(
      idValoracion: idValoracion ?? this.idValoracion,
      valoracion: valoracion ?? this.valoracion,
      idRequisito: idRequisito ?? this.idRequisito,
      idCliente: idCliente ?? this.idCliente,
    );
  }

  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    if (idValoracion.present) {
      map['id_valoracion'] = Variable<int?>(idValoracion.value);
    }
    if (valoracion.present) {
      map['valoracion'] = Variable<int>(valoracion.value);
    }
    if (idRequisito.present) {
      map['id_requisito'] = Variable<int?>(idRequisito.value);
    }
    if (idCliente.present) {
      map['id_cliente'] = Variable<int?>(idCliente.value);
    }
    return map;
  }

  @override
  String toString() {
    return (StringBuffer('ValoracionCompanion(')
          ..write('idValoracion: $idValoracion, ')
          ..write('valoracion: $valoracion, ')
          ..write('idRequisito: $idRequisito, ')
          ..write('idCliente: $idCliente')
          ..write(')'))
        .toString();
  }
}

class $ValoracionTable extends Valoracion
    with TableInfo<$ValoracionTable, ValoracionData> {
  final GeneratedDatabase _db;
  final String? _alias;
  $ValoracionTable(this._db, [this._alias]);
  final VerificationMeta _idValoracionMeta =
      const VerificationMeta('idValoracion');
  late final GeneratedColumn<int?> idValoracion = GeneratedColumn<int?>(
      'id_valoracion', aliasedName, true,
      typeName: 'INTEGER',
      requiredDuringInsert: false,
      defaultConstraints: 'PRIMARY KEY AUTOINCREMENT');
  final VerificationMeta _valoracionMeta = const VerificationMeta('valoracion');
  late final GeneratedColumn<int?> valoracion = GeneratedColumn<int?>(
      'valoracion', aliasedName, false,
      typeName: 'INTEGER',
      requiredDuringInsert: false,
      defaultValue: Constant(0));
  final VerificationMeta _idRequisitoMeta =
      const VerificationMeta('idRequisito');
  late final GeneratedColumn<int?> idRequisito = GeneratedColumn<int?>(
      'id_requisito', aliasedName, true,
      typeName: 'INTEGER',
      requiredDuringInsert: false,
      $customConstraints: 'NULL REFERENCES requisito(idRequisito)');
  final VerificationMeta _idClienteMeta = const VerificationMeta('idCliente');
  late final GeneratedColumn<int?> idCliente = GeneratedColumn<int?>(
      'id_cliente', aliasedName, true,
      typeName: 'INTEGER',
      requiredDuringInsert: false,
      $customConstraints: 'NULL REFERENCES cliente(idCliente)');
  @override
  List<GeneratedColumn> get $columns =>
      [idValoracion, valoracion, idRequisito, idCliente];
  @override
  String get aliasedName => _alias ?? 'valoracion';
  @override
  String get actualTableName => 'valoracion';
  @override
  VerificationContext validateIntegrity(Insertable<ValoracionData> instance,
      {bool isInserting = false}) {
    final context = VerificationContext();
    final data = instance.toColumns(true);
    if (data.containsKey('id_valoracion')) {
      context.handle(
          _idValoracionMeta,
          idValoracion.isAcceptableOrUnknown(
              data['id_valoracion']!, _idValoracionMeta));
    }
    if (data.containsKey('valoracion')) {
      context.handle(
          _valoracionMeta,
          valoracion.isAcceptableOrUnknown(
              data['valoracion']!, _valoracionMeta));
    }
    if (data.containsKey('id_requisito')) {
      context.handle(
          _idRequisitoMeta,
          idRequisito.isAcceptableOrUnknown(
              data['id_requisito']!, _idRequisitoMeta));
    }
    if (data.containsKey('id_cliente')) {
      context.handle(_idClienteMeta,
          idCliente.isAcceptableOrUnknown(data['id_cliente']!, _idClienteMeta));
    }
    return context;
  }

  @override
  Set<GeneratedColumn> get $primaryKey => {idValoracion};
  @override
  ValoracionData map(Map<String, dynamic> data, {String? tablePrefix}) {
    return ValoracionData.fromData(data, _db,
        prefix: tablePrefix != null ? '$tablePrefix.' : null);
  }

  @override
  $ValoracionTable createAlias(String alias) {
    return $ValoracionTable(_db, alias);
  }
}

abstract class _$AppDatabase extends GeneratedDatabase {
  _$AppDatabase(QueryExecutor e) : super(SqlTypeSystem.defaultInstance, e);
  late final $ProyectoTable proyecto = $ProyectoTable(this);
  late final $RequisitoTable requisito = $RequisitoTable(this);
  late final $UsuarioTable usuario = $UsuarioTable(this);
  late final $ClienteTable cliente = $ClienteTable(this);
  late final $VersionTable version = $VersionTable(this);
  late final $ValoracionTable valoracion = $ValoracionTable(this);
  @override
  Iterable<TableInfo> get allTables => allSchemaEntities.whereType<TableInfo>();
  @override
  List<DatabaseSchemaEntity> get allSchemaEntities =>
      [proyecto, requisito, usuario, cliente, version, valoracion];
}
