//
//  UserMainView.swift
//  proyectoLPS
//
//  Created by Aula11 on 25/11/21.
//

import SwiftUI

struct UserMainView: View {
    @Binding var autentificacion: Bool
    @Binding var usuario: UsuarioEntity
    @State var seleccion: Int = 0
    @StateObject var vm: ViewModel
    
    @State var index = 0
    var body: some View {
        VStack(spacing: 0){
            
            
            ZStack{
                if self.index == 0{
                    HistoricoView(usuarioInicial: $usuario, usuarioSeleccionado: usuario, vm: vm)
                        .environmentObject(vm)
                        .transition(.slide)
                }else if(self.index == 1){
                    ConfiguracionView(usuario: $usuario, autentificacion: $autentificacion)
                        .transition(.slide)
                }
                
                VStack{
                    Spacer()
                    CircleTabUsuario(index: $index)
                }
            }
        /*
        TabView(selection: $seleccion){
            HistoricoView(usuarioInicial: $usuario, usuarioSeleccionado: usuario, vm: vm)
                .environmentObject(vm)
                .tabItem{
                    Image(systemName: "folder")
                    Text("Histórico")
                }.tag(0)
            ConfiguracionView(usuario: $usuario, autentificacion: $autentificacion)
                .tabItem{
                    Image(systemName: "gearshape.fill")
                    Text("Configuración")
                    
                }.tag(1)
        }*/
        }.ignoresSafeArea(.keyboard, edges: .bottom)
}

/*
struct UserMainView_Previews: PreviewProvider {
    static var previews: some View {
        UserMainView()
    }
}*/


struct CircleTabUsuario: View{
    @Binding var index: Int
    @Environment(\.colorScheme) var colorScheme
    var body: some View{
        HStack{
          
            Button {
                self.index = 0
            } label: {
                
                VStack{
                    if self.index != 0{
                        Image(systemName: "folder")
                            .resizable()
                            .frame(width: 27, height: 25)
                            .foregroundColor(Color.primary.opacity(0.7))
                    }else{
                        Image(systemName: "folder")
                            .resizable()
                            .frame(width: 27, height: 25)
                            .foregroundColor(.white)
                            .padding()
                            .background(Color.accentColor)
                            .clipShape(Circle())
                            .offset(y: -20)
                            .padding(.bottom, -20)
                        
                        Text("Histórico")
                            .font(.caption)
                            .foregroundColor(Color.primary.opacity(0.7))
                    }
                }
            }.padding(.leading, 80)
                .scaleEffect(1)
            Spacer(minLength: 70)
            
            
            Button {
                self.index = 1
            } label: {
                VStack{
                    if self.index != 1{
                        Image(systemName: "gearshape.fill")
                            .resizable()
                            .frame(width: 27, height: 25)
                            .foregroundColor(Color.primary.opacity(0.7))
                    }else{
                        Image(systemName: "gearshape.fill")
                            .resizable()
                            .frame(width: 27, height: 25)
                            .foregroundColor(.white)
                            .padding()
                            .background(Color.accentColor)
                            .clipShape(Circle())
                            .offset(y: -20)
                            .padding(.bottom, -20)
                        
                        Text("Ajustes")
                            .font(.caption)
                            .foregroundColor(Color.primary.opacity(0.7))
                    }
                }
                
               
            }.padding(.trailing, 80)
            .scaleEffect(1)
        }.padding(.vertical, -5)
            .padding(.horizontal, 25)
            .background(.ultraThinMaterial)
            .edgesIgnoringSafeArea(.bottom)
            .animation(.spring( blendDuration: 10))
    }
}
}
