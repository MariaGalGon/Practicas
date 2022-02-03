//
//  HistoricoView.swift
//  proyectoLPS
//
//  Created by Aula11 on 25/11/21.
//

import SwiftUI



struct HistoricoView: View {
    @EnvironmentObject var vm: ViewModel
    @Binding var usuarioInicial: UsuarioEntity
    var usuarioSeleccionado: UsuarioEntity
    @State var eliminar = false
    @State var filtroResultado = "both"
    @State var startDate = Calendar.current.date(from: DateComponents(year:1989)) ?? Date()
    @State var endDate = Calendar.current.date(from: DateComponents(year:2023)) ?? Date()
    var buenos:Double = 0
    var malos:Double = 0
    var total:Double = 0
    
    
    
    init(usuarioInicial: Binding<UsuarioEntity>, usuarioSeleccionado: UsuarioEntity, vm:ViewModel){
        _usuarioInicial = usuarioInicial
        self.usuarioSeleccionado = usuarioSeleccionado
        UITableView.appearance().separatorStyle = .singleLine
        UITableViewCell.appearance().backgroundColor = .clear
        UITableView.appearance().backgroundColor = .clear
        
        if (!self.usuarioInicial.esAdministrador){
            for clasificacion in vm.clasificacionA{
                if (clasificacion.usuarioRelacion == self.usuarioInicial) {
                    if (clasificacion.resultado) {
                        buenos += 1
                    } else {
                        malos += 1
                    }
                }
            }
            total = buenos+malos
        }else if(self.usuarioInicial.esAdministrador){
            if(!self.usuarioSeleccionado.esAdministrador){
                for clasificacion in vm.clasificacionA{
                    if (clasificacion.usuarioRelacion == self.usuarioSeleccionado) {
                        if (clasificacion.resultado) {
                            buenos += 1
                        } else {
                            malos += 1
                        }
                    }
                }
                total = buenos+malos
            }else{
                for clasificacion in vm.clasificacionA{
                    
                    if (clasificacion.resultado) {
                        buenos += 1
                    } else {
                        malos += 1
                    }
                    
                }
                total = buenos+malos
            }
        }
        
        
    }
    
    @State var mostrarFiltros: Bool = false
    @State var aniadirDatos: Bool = false
    @State var mostrarNombre: Bool = false
    @State var nombre = ""
    var body: some View {
        ScrollView{
            
            VStack{
                
                HStack(){
                        Text((usuarioInicial.esAdministrador && !usuarioSeleccionado.esAdministrador) ? nombre : "Histórico")
                            .font(.largeTitle)
                            .fontWeight(.bold)
                            .onAppear{
                                nombre = usuarioSeleccionado.nombre!
                            }
                    
                    Spacer()
                    Button {
                        aniadirDatos.toggle()
                    } label: {
                        if(!usuarioInicial.esAdministrador){
                            Image(systemName: "plus.circle")
                                .resizable()
                                .frame(width: 30, height: 30)
                        }
                    }.sheet(isPresented: $aniadirDatos) {
                        
                    } content: {
                        EditarClasificacionView(clasificacion: nil, usuario: $usuarioInicial, eliminar: $eliminar)
                        
                    }
                    
                }.padding(.top, (usuarioInicial.esAdministrador && usuarioSeleccionado.esAdministrador) ? 70 : 0)
                .padding(.top, !usuarioInicial.esAdministrador ? 30 : 0)
                
                
                if(total != 0){
                    VStack {
                        HStack(spacing:2) {
                            Spacer()
                            VStack{
                                Spacer()
                                Text("Bueno")
                                    .font(.footnote)
                                    .fontWeight(.bold)
                                Text(String(format: "%.f",(buenos/total)*100)+" %")
                                    .font(.footnote)
                                Spacer()
                            }.padding(.trailing,3)
                            Spacer()
                            Rectangle()
                                .fill(Color.green)
                                .frame(width:(buenos/total)*250, height: 30)
                                .cornerRadius(5)
                            Rectangle()
                                .fill(Color.red)
                                .frame(width:(malos/total)*250 , height: 30)
                                .cornerRadius(5)
                            Spacer()
                            VStack{
                                Spacer()
                                Text("Malo")
                                    .font(.footnote)
                                    .fontWeight(.bold)
                                Text(String(format: "%.f",(malos/total)*100)+" %")
                                    .font(.footnote)
                                Spacer()
                            }.padding(.leading,3)
                            Spacer()
                        }
                    }
                }
                
                
                
                
                
                
                if(usuarioInicial.esAdministrador && total == 0){
                    Spacer()
                    LottieView(name: "notFound", loopMode: .loop)
                        .frame(width: 280, height: 280)
                        .padding(.top, 200)
                    Spacer()
                }else if(!usuarioInicial.esAdministrador && total == 0){
                    Spacer()
                    Image("ListaVacia")
                        .resizable()
                        .scaledToFit()
                        .padding(.top, 150)
                    Spacer()
                }else{
                    
                HeaderFilterPersonalizadoView(clasification: $filtroResultado, startDate: $startDate, endDate: $endDate)
                    
                VStack(spacing: 10){
                    if(filtroResultado == "good"){
                        ForEach(vm.clasificacionA, id: \.self){clasificacion in
                            if(clasificacion.resultado && startDate <= clasificacion.fecha! && clasificacion.fecha! <= endDate){
                                if((usuarioInicial.esAdministrador && !usuarioSeleccionado.esAdministrador) && clasificacion.usuarioRelacion == usuarioSeleccionado){ //Administrador abriendo usuario
                                    HeaderPersonalizadoView(clasificacion: clasificacion, usuarioInicial: $usuarioInicial, mostrarNombre: $mostrarNombre)
                                        .listRowBackground(Color(UIColor.systemGray6))
                                        .background(RoundedRectangle(cornerRadius: 10).fill(Color(UIColor.systemGray6)))
                                        .transition(.slide)
                                }else if (usuarioInicial.esAdministrador && usuarioSeleccionado.esAdministrador){ //Administrador
                                    HeaderPersonalizadoView(clasificacion: clasificacion, usuarioInicial: $usuarioInicial, mostrarNombre: $mostrarNombre)
                                        .listRowBackground(Color(UIColor.systemGray6))
                                        .background(RoundedRectangle(cornerRadius: 10).fill(Color(UIColor.systemGray6)))
                                        .transition(.slide)
                                }else if ((!usuarioInicial.esAdministrador && !usuarioSeleccionado.esAdministrador) && clasificacion.usuarioRelacion == usuarioSeleccionado){ //Usuario
                                    HeaderPersonalizadoView(clasificacion: clasificacion, usuarioInicial: $usuarioInicial, mostrarNombre: $mostrarNombre)
                                        .listRowBackground(Color(UIColor.systemGray6))
                                        .background(RoundedRectangle(cornerRadius: 10).fill(Color(UIColor.systemGray6)))
                                        .transition(.slide)
                                }
                                
                            }
                        }
                    
                        
                    }else if(filtroResultado == "bad"){
                        ForEach(vm.clasificacionA, id: \.self){clasificacion in
                            if(!clasificacion.resultado && startDate <= clasificacion.fecha! && clasificacion.fecha! <= endDate){
                                if((usuarioInicial.esAdministrador && !usuarioSeleccionado.esAdministrador) && clasificacion.usuarioRelacion == usuarioSeleccionado){ //Administrador abriendo usuario
                                    HeaderPersonalizadoView(clasificacion: clasificacion, usuarioInicial: $usuarioInicial, mostrarNombre: $mostrarNombre)
                                        .listRowBackground(Color(UIColor.systemGray6))
                                        .background(RoundedRectangle(cornerRadius: 10).fill(Color(UIColor.systemGray6)))
                                        .transition(.slide)
                                }else if (usuarioInicial.esAdministrador && usuarioSeleccionado.esAdministrador){ //Administrador
                                    HeaderPersonalizadoView(clasificacion: clasificacion, usuarioInicial: $usuarioInicial, mostrarNombre: $mostrarNombre)
                                        .listRowBackground(Color(UIColor.systemGray6))
                                        .background(RoundedRectangle(cornerRadius: 10).fill(Color(UIColor.systemGray6)))
                                        .transition(.slide)
                                }else if ((!usuarioInicial.esAdministrador && !usuarioSeleccionado.esAdministrador) && clasificacion.usuarioRelacion == usuarioSeleccionado){ //Usuario
                                    HeaderPersonalizadoView(clasificacion: clasificacion, usuarioInicial: $usuarioInicial, mostrarNombre: $mostrarNombre)
                                        .listRowBackground(Color(UIColor.systemGray6))
                                        .background(RoundedRectangle(cornerRadius: 10).fill(Color(UIColor.systemGray6)))
                                        .transition(.slide)
                                }
                            }
                        }
                    }else{
                        ForEach(vm.clasificacionA, id: \.self){clasificacion in
                            if(startDate <= clasificacion.fecha! && clasificacion.fecha! <= endDate){
                                if((usuarioInicial.esAdministrador && !usuarioSeleccionado.esAdministrador) && clasificacion.usuarioRelacion == usuarioSeleccionado){ //Administrador abriendo usuario
                                    HeaderPersonalizadoView(clasificacion: clasificacion, usuarioInicial: $usuarioInicial, mostrarNombre: $mostrarNombre)
                                        .listRowBackground(Color(UIColor.systemGray6))
                                        .background(RoundedRectangle(cornerRadius: 10).fill(Color(UIColor.systemGray6)))
                                        .transition(.slide)
                                }else if (usuarioInicial.esAdministrador && usuarioSeleccionado.esAdministrador){ //Administrador
                                    HeaderPersonalizadoView(clasificacion: clasificacion, usuarioInicial: $usuarioInicial, mostrarNombre: $mostrarNombre)
                                        .listRowBackground(Color(UIColor.systemGray6))
                                        .background(RoundedRectangle(cornerRadius: 10).fill(Color(UIColor.systemGray6)))
                                        .transition(.slide)
                                }else if ((!usuarioInicial.esAdministrador && !usuarioSeleccionado.esAdministrador) && clasificacion.usuarioRelacion == usuarioSeleccionado){ //Usuario
                                    HeaderPersonalizadoView(clasificacion: clasificacion, usuarioInicial: $usuarioInicial, mostrarNombre: $mostrarNombre)
                                        .listRowBackground(Color(UIColor.systemGray6))
                                        .background(RoundedRectangle(cornerRadius: 10).fill(Color(UIColor.systemGray6)))
                                        .transition(.slide)
                                }
                                
                            }
                        }
                        
                    }
                }.transition(.slide)
            }
            }
            
            Spacer()
            Spacer(minLength: 70)
        }
        .navigationBarTitleDisplayMode(.inline)
        .padding([.leading, .trailing, .top])
        .onAppear{
            if(usuarioInicial.esAdministrador && usuarioSeleccionado.esAdministrador){
                mostrarNombre = true
            }
        }
        
        
    }
}

struct HeaderFilterPersonalizadoView: View{
    @State var mostrar = false
    @Binding var clasification: String
    @Binding var startDate: Date
    @Binding var endDate: Date
    var body: some View{
        VStack(){
            
            HStack{
                Text("Filtrar")
                    .font(.headline)
                    .foregroundColor(Color.blue)
                    .onTapGesture {
                        withAnimation {
                            mostrar.toggle()
                        }
                        
                        
                        
                    }
                
                Image(systemName: "chevron.down")
                    .foregroundColor(.accentColor)
                    .onTapGesture {
                        withAnimation {
                            mostrar.toggle()
                        }
                        
                        
                        
                    }
                
                Spacer()
            }
            
            
            if(mostrar){
                FilterPersonalizadoView(clasification: $clasification, startDate: $startDate, endDate: $endDate)
            }
        }.padding(.all, 5.0)
    }
}

struct FilterPersonalizadoView: View{
    
    @Binding var clasification: String
    var comienzo = Calendar.current.date(from: DateComponents(year:2000)) ?? Date()
    var fin = Date()
    @Binding var startDate: Date
    @Binding var endDate: Date
    var body: some View{
        VStack(alignment: .leading){
            Text("Fecha")
                .fontWeight(.bold)
            VStack{
                DatePicker("Desde", selection:$startDate, in:comienzo...fin,displayedComponents: [.date])
                DatePicker("Hasta", selection:$endDate, in:comienzo...fin,displayedComponents: [.date])
            }.padding(.horizontal, 50.0)
            
            Divider()
            
            Text("Clasificación")
                .fontWeight(.bold)
            
            VStack{
                Picker("Filtro", selection: $clasification) {
                    Text("Ambos").tag("both")
                    Image(systemName:"hand.thumbsup").tag("good")
                    Image(systemName: "hand.thumbsdown").tag("bad")
                }.pickerStyle(.segmented)
                
            }
        }.padding(.all, 15.0)
            .background(RoundedRectangle(cornerRadius: 10).fill(Color(UIColor.systemGray6)))
    }
}

struct HeaderPersonalizadoView: View{
    @State var clasificacion: ClasificacionAEntity
    @State var mostrar = false
    @Binding var usuarioInicial: UsuarioEntity
    @Binding var mostrarNombre: Bool
    
    
    let fechaFormato: DateFormatter = {
        let formatter = DateFormatter()
        formatter.dateFormat = "dd MMM yyyy"
        return formatter
    }()
    
    let horaFormato: DateFormatter = {
        let formatter = DateFormatter()
        formatter.dateFormat = "HH:mm:ss"
        return formatter
    }()
    
    var body: some View{
        VStack{
            
            HStack{
                VStack(alignment: .leading){
                    if(mostrarNombre){
                        Text(clasificacion.usuarioRelacion!.nombre!)
                            .fontWeight(.bold)
                    }
                    Text(fechaFormato.string(from: clasificacion.fecha!))
                        .foregroundColor(Color("ColorFecha"))
                    Text(horaFormato.string(from: clasificacion.fecha!))
                        .foregroundColor(Color.gray)
                }
                Spacer()
                VStack(alignment: .leading){
                    Text("CLASIFICADO")
                        .font(.headline)
                        .foregroundColor(Color.gray)
                    Text(clasificacion.resultado ? "BUENO" :"MALO")
                        .font(.title2)
                        .fontWeight(.bold)
                }
                
                Image(systemName: "chevron.down")
                    .foregroundColor(.accentColor)
                    .onTapGesture {
                        withAnimation {
                            mostrar.toggle()
                        }
                        
                    }
            }.padding(/*@START_MENU_TOKEN@*/.all, 15.0/*@END_MENU_TOKEN@*/)
            
            if(mostrar){
                SeccionPersonalizadaView(clasificacion: $clasificacion, usuarioInicial: $usuarioInicial)
            }
        }
        
        
        
    }
}

struct SeccionPersonalizadaView: View{
    @EnvironmentObject var vm: ViewModel
    @Binding var clasificacion: ClasificacionAEntity
    @Binding var usuarioInicial: UsuarioEntity
    @State var aniadirDatos: Bool = false
    @State var eliminar = false
    var body: some View{
        VStack(){
            HStack(spacing: 0.0){
                Text("A03")
                    .font(.title3)
                    .fontWeight(.semibold)
                Spacer()
                Text("A05")
                    .font(.title3)
                    .fontWeight(.semibold)
                Spacer()
                Text("A06")
                    .font(.title3)
                    .fontWeight(.semibold)
                Spacer()
                Text("A09")
                    .font(.title3)
                    .fontWeight(.semibold)
                Spacer()
                Text("A11")
                    .font(.title3)
                    .fontWeight(.semibold)
                
            }
            
            Divider()
            HStack{
                Text(String(format: "%.5f",clasificacion.a3))
                    .font(.footnote)
                Spacer()
                Text(String(format: "%.5f",clasificacion.a5))
                    .font(.footnote)
                Spacer()
                Text(String(format: "%.5f",clasificacion.a6))
                    .font(.footnote)
                Spacer()
                Text(String(format: "%.5f",clasificacion.a9))
                    .font(.footnote)
                Spacer()
                Text(String(format: "%.5f",clasificacion.a11))
                    .font(.footnote)
            }
            
            if(!usuarioInicial.esAdministrador){
                Button {
                    aniadirDatos.toggle()
                } label: {
                    Text("Editar")
                        .fontWeight(.bold)
                        .foregroundColor(.black)
                        .padding()
                        .frame(maxWidth: .infinity, maxHeight: 45)
                        .background(RoundedRectangle(cornerRadius: 10).fill(.white).shadow(color: Color.gray, radius:3, x: 1, y: 4))
                    
                }.sheet(isPresented: $aniadirDatos) {
                    if(eliminar){
                        vm.deleteClasificacion(clasificacion: clasificacion)
                        //eliminar = false
                    }
                } content: {
                    EditarClasificacionView(clasificacion: clasificacion, usuario: $usuarioInicial, eliminar: $eliminar)
                }
            }
            
            
        }
        .padding(.all, 15.0)
    }
}

/*
 struct HistoricoView_Previews: PreviewProvider {
 static var previews: some View {
 HistoricoView()
 }
 }*/
