//
//  MainView.swift
//  proyectoLPS
//
//  Created by Aula11 on 30/11/21.
//

import SwiftUI

struct MainView: View {
    @State var autentificacion = false
    @State var usuario = UsuarioEntity()
    @StateObject private var vm: ViewModel = ViewModel()
    @AppStorage("modoOscuro") private var modoOscuro = false
    var body: some View {
        if(autentificacion){
            if(usuario.esAdministrador){
                AdminMainView(autentificacion: $autentificacion, usuario: $usuario).preferredColorScheme(modoOscuro ? .dark : .light)
                    .environmentObject(vm)
            }else{
                UserMainView(autentificacion:  $autentificacion, usuario: $usuario, vm: vm).preferredColorScheme(modoOscuro ? .dark : .light)
                    .environmentObject(vm)
            }
        }else{
            LoginView(autentificacion: $autentificacion, usuario: $usuario).preferredColorScheme(modoOscuro ? .dark : .light)
                .environmentObject(vm)
        }
    }
}

struct MainView_Previews: PreviewProvider {
    static var previews: some View {
        MainView()
    }
}
