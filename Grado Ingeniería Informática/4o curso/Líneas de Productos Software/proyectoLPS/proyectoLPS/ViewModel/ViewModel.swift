//
//  ViewModel.swift
//  proyectoLPS
//
//  Created by Deyan on 24/11/21.
//

import Foundation
import CoreData
import UIKit

class ViewModel: ObservableObject{
    let gestorCoreData = CoreDataManager.instance //singleton
    
    @Published var usuarios: [UsuarioEntity] = []
    @Published var clasificacionA: [ClasificacionAEntity] = []
    
    init(){
        cargarDatos()
    }
    
    func cargarDatos(){
        usuarios.removeAll()
        clasificacionA.removeAll()
        
        let fetchUsuarios = NSFetchRequest<UsuarioEntity>(entityName: "UsuarioEntity")
        let fetchClasificaciones = NSFetchRequest<ClasificacionAEntity>(entityName: "ClasificacionAEntity")
        
        do{
            self.usuarios = try gestorCoreData.contexto.fetch(fetchUsuarios).sorted(){$0.nombre! < $1.nombre!}
            self.clasificacionA = try gestorCoreData.contexto.fetch(fetchClasificaciones).sorted(){$0.fecha! < $1.fecha!}
            
        }catch let error{
            print("Error al cargar los datos: \(error)") }
    }
    
    func guardarDatos(){
        gestorCoreData.save()
        cargarDatos()
    }
    
    func addUsuario(nombre: String, correo: String, contrasenia: String, esAdmin: Bool){
        
        let nuevoUsuario = UsuarioEntity(context: gestorCoreData.contexto)
        nuevoUsuario.nombre = nombre
        nuevoUsuario.correo = correo
        nuevoUsuario.esAdministrador = esAdmin
        nuevoUsuario.contrasenia = contrasenia
        guardarDatos()
    }
    
    func addClasificacion(usuario: UsuarioEntity, a3: Double, a5: Double, a6: Double, a9: Double, a11: Double, fecha: Date, resultado: Bool){
        
        let nuevaClasificacion = ClasificacionAEntity(context: gestorCoreData.contexto)
        nuevaClasificacion.usuarioRelacion = usuario
        nuevaClasificacion.a3 = a3
        nuevaClasificacion.a5 = a5
        nuevaClasificacion.a6 = a6
        nuevaClasificacion.a9 = a9
        nuevaClasificacion.a11 = a11
        nuevaClasificacion.fecha = fecha
        nuevaClasificacion.resultado = resultado
        guardarDatos()
    }
    
    func deleteClasificacion(clasificacion: ClasificacionAEntity){
        gestorCoreData.contexto.delete(clasificacion)
        guardarDatos()
    }
    
    func deleteUsuario(usuario: UsuarioEntity){
        gestorCoreData.contexto.delete(usuario)
        guardarDatos()
    }
    
    func updateClasificacion(){
        do{
            try gestorCoreData.contexto.save()
            guardarDatos()
        }catch{
            gestorCoreData.contexto.rollback()
        }
        
    }
}
