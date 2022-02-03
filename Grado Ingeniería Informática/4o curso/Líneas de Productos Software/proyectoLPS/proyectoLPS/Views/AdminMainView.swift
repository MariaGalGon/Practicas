//
//  AdminMainView.swift
//  proyectoLPS
//
//  Created by Aula11 on 25/11/21.
//

import SwiftUI

struct AdminMainView: View {
    @Binding var autentificacion: Bool
    @Binding var usuario: UsuarioEntity
    @State var index = 0
    @EnvironmentObject var vm: ViewModel
    
    @State var seleccion: Int = 0
    
    var body: some View {
        VStack(spacing: 0){
            
            
            ZStack{
                if self.index == 0{
                    HistoricoView(usuarioInicial: $usuario, usuarioSeleccionado: usuario, vm: vm)
                }else if(self.index == 1){
                    VistaUsuarios(vm, usuarioInicial: $usuario)
                }else if(self.index == 2){
                    EstadisticasView()
                        .environmentObject(vm)
                }else if(self.index == 3 ){
                    ConfiguracionView(usuario: $usuario, autentificacion: $autentificacion)
                       
                }
                VStack{
                    Spacer()
                    CircleTabAdmin(index: $index)
                }
                
            }
            
            /*
            TabView(selection: $seleccion){
                HistoricoView(usuarioInicial: $usuario, usuarioSeleccionado: usuario, vm: vm)
                    .tabItem{
                        Image(systemName: "folder")
                        Text("Histórico")
                    }.tag(0)
                
                VistaUsuarios(vm, usuarioInicial: $usuario)
                    .tabItem{
                        Image(systemName: "person.crop.circle")
                        Text("Usuarios")
                    }.tag(1)
                
                ConfiguracionView(usuario: $usuario, autentificacion: $autentificacion)
                    .tabItem{
                        Image(systemName: "gearshape.fill")
                        Text("Configuración")
                    }.tag(2)
            }
             */
        }.edgesIgnoringSafeArea(.top)
            .ignoresSafeArea(.keyboard, edges: .bottom)
        
       
    }
}

/*
struct AdminMainView_Previews: PreviewProvider {
    static var previews: some View {
        AdminMainView()
    }
}*/

struct CircleTabAdmin: View{
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
                            .frame(width: 60)
                            .foregroundColor(Color.primary.opacity(0.7))
                    }
                }
            }.padding(.leading, 20)
                .scaleEffect(1)
            Spacer(minLength: 70)
            
            Button {
                self.index = 1
            } label: {
                VStack{
                    if self.index != 1{
                        Image(systemName: "person.crop.circle")
                            .resizable()
                            .frame(width: 27, height: 25)
                            .foregroundColor(Color.primary.opacity(0.7))
                    }else{
                        Image(systemName: "person.crop.circle")
                            .resizable()
                            .frame(width: 27, height: 25)
                            .foregroundColor(.white)
                            .padding()
                            .background(Color.accentColor)
                            .clipShape(Circle())
                            .offset(y: -20)
                            .padding(.bottom, -20)
                        
                        Text("Usuarios")
                            .font(.caption)
                            .foregroundColor(Color.primary.opacity(0.7))
                    }
                }
            
            }
            .scaleEffect(1)
            
            Spacer(minLength: 40)
            
            Button {
                self.index = 2
            } label: {
                VStack{
                    if self.index != 2{
                        Image(systemName: "chart.bar.xaxis")
                            .resizable()
                            .frame(width: 27, height: 25)
                            .foregroundColor(Color.primary.opacity(0.7))
                    }else{
                        Image(systemName: "chart.bar.xaxis")
                            .resizable()
                            .frame(width: 27, height: 25)
                            .foregroundColor(.white)
                            .padding()
                            .background(Color.accentColor)
                            .clipShape(Circle())
                            .offset(y: -20)
                            .padding(.bottom, -20)
                        
                        Text("Gráficas")
                            .font(.caption)
                            .foregroundColor(Color.primary.opacity(0.7))
                    }
                }
                
               
            }
            
            Spacer(minLength: 40)
            
            Button {
                self.index = 3
            } label: {
                VStack{
                    if self.index != 3{
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
                
               
            }.padding(.trailing, 20)
            .scaleEffect(1)
        }.padding(.vertical, -5)
            .padding(.horizontal, 25)
            .background(.ultraThinMaterial)
            .edgesIgnoringSafeArea(.bottom)
            .animation(.spring( blendDuration: 10))
    }
}
