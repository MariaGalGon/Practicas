//
//  VistaUsuarios.swift
//  proyectoLPS
//
//  Created by Aula11 on 25/11/21.
//

import SwiftUI

struct VistaUsuarios: View {
    @EnvironmentObject var vm: ViewModel
    @Binding var usuarioInicial: UsuarioEntity
    var usuarios: [UsuarioEntity] = []
    @State var query: String = ""
    @State var nombre: String = ""
    @State var correo: String = ""
    @State var pass: String = ""
    @State var pass2: String = ""
    var letras = [UsuariosLetra(letra: "A", usuarios: []),
                  UsuariosLetra(letra: "B", usuarios: []),
                  UsuariosLetra(letra: "C", usuarios: []),
                  UsuariosLetra(letra: "D", usuarios: []),
                  UsuariosLetra(letra: "E", usuarios: []),
                  UsuariosLetra(letra: "F", usuarios: []),
                  UsuariosLetra(letra: "G", usuarios: []),
                  UsuariosLetra(letra: "H", usuarios: []),
                  UsuariosLetra(letra: "I", usuarios: []),
                  UsuariosLetra(letra: "J", usuarios: []),
                  UsuariosLetra(letra: "K", usuarios: []),
                  UsuariosLetra(letra: "L", usuarios: []),
                  UsuariosLetra(letra: "M", usuarios: []),
                  UsuariosLetra(letra: "N", usuarios: []),
                  UsuariosLetra(letra: "Ñ", usuarios: []),
                  UsuariosLetra(letra: "O", usuarios: []),
                  UsuariosLetra(letra: "P", usuarios: []),
                  UsuariosLetra(letra: "Q", usuarios: []),
                  UsuariosLetra(letra: "R", usuarios: []),
                  UsuariosLetra(letra: "S", usuarios: []),
                  UsuariosLetra(letra: "T", usuarios: []),
                  UsuariosLetra(letra: "U", usuarios: []),
                  UsuariosLetra(letra: "V", usuarios: []),
                  UsuariosLetra(letra: "W", usuarios: []),
                  UsuariosLetra(letra: "X", usuarios: []),
                  UsuariosLetra(letra: "Y", usuarios: []),
                  UsuariosLetra(letra: "Z", usuarios: [])]
    
    init(_ vm: ViewModel, usuarioInicial: Binding<UsuarioEntity>){
        _usuarioInicial = usuarioInicial
        for i in 0...letras.count-1 {
            for usuario in vm.usuarios {
                if (String(usuario.nombre?.folding(options: [.diacriticInsensitive, .caseInsensitive], locale: .current).first ?? " ").uppercased() == letras[i].letra) {
                    if (!usuario.esAdministrador) {
                        letras[i].usuarios.append(usuario)
                    }
                }
            }
        }
    }
    
    var body: some View {
        NavigationView{
            VStack{
                    HStack(){
                        Text("Usuarios")
                            .font(.largeTitle)
                            .fontWeight(.bold)
                        Spacer()
                        NavigationLink(destination: VistaAddUsuario()){
                            Image(systemName: "plus.circle")
                                .resizable()
                                .frame(width: 30, height: 30)
                                .shadow(color: .gray, radius: 14, x: -5, y: -5)
                        }
                    }.padding([.leading, .trailing])
                BusquedaView(text: $query)
                
                
                    
                
                if(vm.usuarios.count == 1){
                    Spacer()
                    Image("ListaVacia")
                        .resizable()
                        .scaledToFit()
                        .frame(width: 300, height: 320)
                        .padding(.top, 60)
                    Spacer()
                }else{
                    List {
                        if (query.isEmpty) {
                            ForEach(letras, id: \.self) { letra in
                                if !letra.usuarios.isEmpty {
                                    Section(header:
                                        HStack{
                                            Text("\(letra.letra)").padding(10)
                                            Spacer()
                                    }.listRowInsets(EdgeInsets(top:0,leading:0,bottom:0,trailing:0))
                                    .background(Color(UIColor.systemGray6))

                                        ) {
                                        ForEach (letra.usuarios, id: \.self) { usuario in
                                            NavigationLink {
                                                HistoricoView(usuarioInicial: $usuarioInicial, usuarioSeleccionado: usuario, vm: vm)
                                            } label: {
                                                Text("\(usuario.nombre!)")
                                            }.swipeActions() {
                                                Button {
                                                    vm.deleteUsuario(usuario: usuario)
                                                } label: {
                                                  Label("Eliminar", systemImage: "minus.circle.fill")
                                                }
                                                .tint(.red)
                                              }

                                            
                                        }
                                    }
                                }
                            }
                        } else {
                            Section(){
                                ForEach(vm.usuarios, id:\.self){ usuario in
                                    if (usuario.nombre!.contains(query) && !usuario.esAdministrador){
                                        NavigationLink {
                                            HistoricoView(usuarioInicial: $usuarioInicial, usuarioSeleccionado: usuario, vm: vm)
                                        } label: {
                                            Text("\(usuario.nombre!)")
                                        }
                                        .swipeActions() {
                                            Button {
                                                vm.deleteUsuario(usuario: usuario)
                                            } label: {
                                              Label("Eliminar", systemImage: "minus.circle.fill")
                                            }
                                            .tint(.red)
                                          }
                                    }
                                }
                            }
                        }
                    }.listStyle(GroupedListStyle())
                }
                
                Spacer(minLength: 40)
            }.navigationBarTitleDisplayMode(.inline)
            
        }
    }
    
    
}

struct BusquedaView: View{
    @Binding var text:String
    var body: some View{
    
            TextFieldBuscar(placeholder: "Buscar...", text: $text)
                   
    }
}


struct TextFieldBuscar: View{
    var placeholder: String
    @Binding var text: String
    @AppStorage("modoOscuro") private var modoOscuro = false
    var body: some View {
        HStack{
            Image(systemName: "magnifyingglass").resizable().frame(width: 20, height: 20)
                .foregroundColor(modoOscuro ? Color.white.opacity(0.5) : Color.black)
        TextField(placeholder, text: $text)
            .padding()
            .background(Color(UIColor.systemGray6))
            .cornerRadius(10.0)
            
            Button(){
                text = ""
            }label:{
                Image(systemName: "x.circle")
                    .opacity(text.isEmpty ? 0.0 : 1.0)
                    .padding(.trailing, 10)
            }
        }
            .padding(.leading, 10)
            
            .background(RoundedRectangle(cornerRadius: 10).fill( Color(UIColor.systemGray6)))
            .padding()
    }
}

