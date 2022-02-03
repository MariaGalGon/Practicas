//
//  ConfiguracionView.swift
//  proyectoLPS
//
//  Created by Aula11 on 25/11/21.
//

import SwiftUI

struct ConfiguracionView: View {
    @EnvironmentObject var vm: ViewModel
    @Binding var autentificacion: Bool
    @Binding var usuario: UsuarioEntity
    
    @AppStorage("modoOscuro") private var modoOscuro = false
    init(usuario: Binding<UsuarioEntity>, autentificacion: Binding<Bool>){
        _usuario = usuario
        _autentificacion = autentificacion
        UITableView.appearance().backgroundColor = .clear
    }
    
    var body: some View {
        NavigationView {
            VStack(alignment: .leading){
                
                
                Text("Usuario")
                    .font(.headline)
                    .fontWeight(.bold)
                    .foregroundColor(.primary)
                    .textCase(nil)
                
                NavigationLink(destination: DatosPersonalesView(usuario: $usuario)){
                    HStack{
                        Text("Datos personales")
                            .foregroundColor(.primary)
                        Spacer()
                        Image(systemName: "chevron.right")
                            .foregroundColor(.primary)
                    }
                    
                }.padding()
                    .frame(maxWidth: .infinity)
                    .background(
                        RoundedRectangle(cornerRadius: 10).fill(Color(UIColor.systemGray6))
                    )
                
                Text("Aplicación")
                    .font(.headline)
                    .fontWeight(.bold)
                    .foregroundColor(.primary)
                    .textCase(nil)
                Toggle(isOn: $modoOscuro){
                    Text("Modo oscuro")
                }.padding()
                    .frame(height: 50)
                    .background(
                        RoundedRectangle(cornerRadius: 10).fill(Color(UIColor.systemGray6))
                    )
                
                
                
                Spacer()
                Button(){
                    autentificacion = false
                }label:{
                    BotonPersonalizado(texto: "Cerrar Sesión", color: .red)
                }
                .padding()
                .padding(.bottom, 50)
            }.padding()
                .navigationTitle("Ajustes")
        }
    }
}


/*
 struct ConfiguracionView_Previews: PreviewProvider {
 static var previews: some View {
 ConfiguracionView()
 }
 }
 */
