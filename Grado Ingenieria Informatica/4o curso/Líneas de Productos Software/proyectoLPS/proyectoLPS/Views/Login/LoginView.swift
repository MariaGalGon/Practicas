//
//  LoginView.swift
//  proyectoLPS
//
//  Created by Aula11 on 25/11/21.
//

import SwiftUI

struct LoginView: View {
    @Binding var autentificacion: Bool
    @Binding var usuario: UsuarioEntity
    @EnvironmentObject var vm: ViewModel
    
    @State var correo: String = ""
    @State var contrasenia: String = ""
    var body: some View {
        VStack(spacing: 20){
            
            Spacer()
            
            Image("LogoBlanco")
                .resizable()
                .aspectRatio(contentMode: .fill)
                .frame(width: 150, height: 150, alignment:.center)
                .clipShape(Circle())
                .padding(.bottom, 40)
                .padding(.top, 30)
                .shadow(color: Color.gray, radius:3, x: 1, y: 4)
            
            
            TextFieldPersonalizado(placeholder: "Correo electrónico", texto: $correo)
                .autocapitalization(.none)
            SecureFieldPersonalizado(placeholder: "Contraseña", texto: $contrasenia)
                .autocapitalization(.none)
            
          
            
            
            Button(
                action: {
                  
                    if(vm.usuarios.isEmpty){
                        vm.addUsuario(nombre: "Admin", correo: "admin@ual.es", contrasenia: "123456", esAdmin: true)

                    }
                    vm.usuarios.forEach { u in
                        if(u.correo == correo && u.contrasenia == contrasenia){
                            usuario = u
                            autentificacion = true
                        }
                    }
                }){
                    
                    BotonPersonalizado(texto: "Iniciar Sesión", color: .accentColor)
                }
                .padding(.top, 20)
            Spacer()
            
        }.padding()
        
    }
}

/*
 struct LoginView_Previews: PreviewProvider {
 static var previews: some View {
 LoginView()
 }
 }
 */
