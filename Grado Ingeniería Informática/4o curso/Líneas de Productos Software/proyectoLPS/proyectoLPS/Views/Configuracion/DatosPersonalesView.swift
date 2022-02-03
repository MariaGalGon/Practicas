//
//  DatosPersonalesView.swift
//  proyectoLPS
//
//  Created by Aula11 on 25/11/21.
//

import SwiftUI

struct DatosPersonalesView: View {
    @EnvironmentObject var vm: ViewModel
    @Binding var usuario: UsuarioEntity
    
    @State var nombre = ""
    @State var correo = ""
    @State var contrasenia = ""
    @State var confirmar = ""
    
    var body: some View {
        VStack(alignment: .leading){
                Text("Nombre y correo")
                           .font(.headline)
                           .fontWeight(.bold)
                           .foregroundColor(.primary)
                           .textCase(nil)
                           .onAppear{
                               nombre = usuario.nombre!
                               correo = usuario.correo!
                               contrasenia = ""
                               confirmar = ""
                           }
                TextFieldPersonalizado(placeholder: "Nombre y apellidos", texto: $nombre)
                TextFieldPersonalizado(placeholder:"Correo", texto: $correo)
                
                Text("Cambiar contraseña")
                                .font(.headline)
                                .fontWeight(.bold)
                                .foregroundColor(.primary)
                                .textCase(nil)
                                .padding(.top, 10)
                
                SecureFieldPersonalizado(placeholder: "Introduce la nueva contraseña", texto: $contrasenia)

                SecureFieldPersonalizado(placeholder: "Confirma la contraseña", texto: $confirmar)
                
                if(contrasenia != confirmar){
                    Text("Las contraseñas no son iguales.")
                        .foregroundColor(.red)
                }
                Spacer()
                Button(){
                    if(contrasenia == confirmar){
                        usuario.nombre = nombre
                        usuario.correo = correo
                        
                        if(contrasenia != ""){
                            usuario.contrasenia = contrasenia
                        }
                        
                        vm.guardarDatos()
                    }
                }label:{
                    BotonPersonalizado(texto: "Guardar", color: .accentColor)
                        
                }
                .padding()
                .padding(.bottom, 50)
            }
            .padding()
            .navigationTitle("Datos personales")
            
           
    }
    
}

/*
struct DatosPersonalesView_Previews: PreviewProvider {
    static var previews: some View {
        DatosPersonalesView(nombre: .constant(""), correo: .constant(""), contrasenia: .constant(""), confirmar: .constant(""))
    }
}*/
