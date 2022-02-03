//
//  VistaAddUsuario.swift
//  proyectoLPS
//
//  Created by Aula11 on 25/11/21.
//

import SwiftUI

struct VistaAddUsuario: View {
    @EnvironmentObject var vm: ViewModel
    @Environment(\.presentationMode) var modoPresentacion
    @State var nombre: String = ""
    @State var correo: String = ""
    @State var pass: String = ""
    @State var pass2: String = ""
    @State var alerta = false
    @State var color = Color.gray
    
    init(){
        UITableView.appearance().separatorStyle = .singleLine
        UITableViewCell.appearance().backgroundColor = .clear
        UITableView.appearance().backgroundColor = .clear

    }
    var body: some View{
            VStack(alignment: .leading){
            
                Text("Nombre y apellidos")
                    .fontWeight(.bold)
                
              
                TextField("Nombre y apellidos",text: $nombre)
                .padding()
                .background(Color(UIColor.systemGray6))
                .cornerRadius(12.0)
                
              Text("Correo electrónico")
                    .autocapitalization(.none)
                    .disableAutocorrection(true)
                 .font(Font.body.bold())
              TextField("Correo electrónico", text: $correo)
                    .autocapitalization(.none)
                    .disableAutocorrection(true)
                    .padding()
                    .background(Color(UIColor.systemGray6))
                    .cornerRadius(12.0)
              Text("Contraseña")
                 .font(Font.body.bold())
              SecureField("Contraseña", text: $pass)
                    .padding()
                    .background(Color(UIColor.systemGray6))
                    .cornerRadius(12.0)
              Text("Confirmar contraseña")
                 .font(Font.body.bold())
               SecureField("Confirmar contraseña", text: $pass2)
                    .padding()
                    .background(Color(UIColor.systemGray6))
                    .cornerRadius(12.0)
              if(pass != pass2){
                  Text("Las contraseñas deben coincidir")
                      .foregroundColor(.red)
              }
                

              Button(){
                  vm.usuarios.forEach { u in
                      if(u.correo == correo){
                          alerta = true
                      }
                  }
                  if(!alerta && nombre != "" && correo != "" && pass == pass2 && pass != "" && correo.contains("@")){
                      vm.addUsuario(nombre: nombre,correo: correo,contrasenia: pass, esAdmin: false)
                      modoPresentacion.wrappedValue.dismiss()
                  }
              }label:{
                  Text("Guardar")
                      .fontWeight(.bold)
                      .frame(width: 360, height: 50)
                      .foregroundColor(.white)
                      .background((nombre == "" || correo == "" || pass != pass2 || pass == "" || !correo.contains("@")) ? Color.gray : Color.accentColor)
                      .cornerRadius(15)
              }
              .padding(.bottom, 50)
              .disabled( nombre == "" || correo == "" || pass != pass2 || pass == "" || !correo.contains("@"))
              .padding(.top, 200 )
                    .alert(isPresented: $alerta) {
                        Alert(title: Text("Este correo ya existe"), dismissButton: .default(Text("Ok")))
                    }
                
            }.navigationTitle("Datos de usuario")
                .padding()
               
                
    }
}

struct VistaAddUsuario_Previews: PreviewProvider {
    static var previews: some View {
        VistaAddUsuario()
    }
}
