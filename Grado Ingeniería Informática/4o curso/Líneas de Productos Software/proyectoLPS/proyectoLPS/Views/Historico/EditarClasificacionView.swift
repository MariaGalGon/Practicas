//
//  EditarClasificacionView.swift
//  proyectoLPS
//
//  Created by Aula11 on 25/11/21.
//

import SwiftUI


struct EditarClasificacionView: View {
    @State var ondas = [Onda(idOnda: 0, nombre: "Onda 1", valor: 0.0),
                        Onda(idOnda: 1, nombre: "Onda 2", valor: 0.0),
                        Onda(idOnda: 2, nombre: "Onda 3", valor: 0.0),
                        Onda(idOnda: 3, nombre: "Onda 4", valor: 0.0),
                        Onda(idOnda: 4, nombre: "Onda 5", valor: 0.0),]
    
    @State var ondaSeleccionada = 0
    var clasificacion: ClasificacionAEntity?
    @Binding var usuario: UsuarioEntity
    @EnvironmentObject var vm: ViewModel
    @Environment(\.presentationMode) var modoPresentacion
    @State var resultado = "good"
    @Binding var eliminar: Bool
    @State var fecha: Date = Date()
    var start = Calendar.current.date(from: DateComponents(year:1989)) ?? Date()
    var fin = Date()

    
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
    
    var body: some View {
        VStack{
            
            if(clasificacion == nil){
            HStack{
                Text("Añadir Medida")
                    .font(.title)
                    .fontWeight(.bold)
                Spacer()
            }
            .padding(.top, 10)
            }else{
                HStack{
                    VStack(alignment: .leading){
                        Text(fechaFormato.string(from:fecha))
                            .font(.title)
                            .fontWeight(.bold)
                        Text(horaFormato.string(from: fecha))
                            .font(.title3)
                            .foregroundColor(.gray)
                            .fontWeight(.bold)
                    }
                    Spacer()
                }.onAppear {
                    fecha = clasificacion!.fecha!
                }
                
                
            }
            DatePicker("Fecha", selection:$fecha, in:start...fin,displayedComponents: [.date])
                .padding(.bottom, 10)
               
           
            ForEach(ondas, id: \.self) { onda in
                filaOnda(ondas: $ondas, idOnda: onda.idOnda, ondaSeleccionada: $ondaSeleccionada)
            }
            
            
            filaNumeros(ondas: $ondas, ondaSeleccionada: $ondaSeleccionada)
            
            #if proyectoLPS
            VStack{
                Picker("Filtro", selection: $resultado) {
                    Image(systemName:"hand.thumbsup").tag("good")
                    Image(systemName: "hand.thumbsdown").tag("bad")
                }.pickerStyle(.segmented)
            }
            #endif
            Spacer()
            
            
            if(clasificacion == nil){
            Button {
                for onda in ondas{
                    ondas[onda.idOnda].ondaString = onda.valores[0] + "." + onda.valores[1] + onda.valores[2] + onda.valores[3] + onda.valores[4] + onda.valores[5]
                    ondas[onda.idOnda].valor = Double(ondas[onda.idOnda].ondaString)!
                    print("string:  \(ondas[onda.idOnda].ondaString)  double:  \(ondas[onda.idOnda].valor)")
                }
                
                
                #if proyectoLPS
                vm.addClasificacion(usuario: usuario, a3: ondas[0].valor, a5: ondas[1].valor, a6: ondas[2].valor, a9: ondas[3].valor, a11: ondas[4].valor, fecha: fecha, resultado: resultado == "good" ? true: false)
                #else
                vm.addClasificacion(usuario: usuario, a3: ondas[0].valor, a5: ondas[1].valor, a6: ondas[2].valor, a9: ondas[3].valor, a11: ondas[4].valor, fecha: fecha, resultado: calculo(ondas: ondas))
                #endif
                //vm.guardarDatos()
                modoPresentacion.wrappedValue.dismiss()
            } label: {
                BotonPersonalizado(texto: "Guardar", color: .accentColor)
            }
            }else{
                HStack{
                    Button {
                        eliminar = true
                        modoPresentacion.wrappedValue.dismiss()
                        
                        
                    } label: {
                        BotonPersonalizado(texto: "Eliminar", color: .red)
                    }
                    Button {
                        for onda in ondas{
                            ondas[onda.idOnda].ondaString = onda.valores[0] + "." + onda.valores[1] + onda.valores[2] + onda.valores[3] + onda.valores[4] + onda.valores[5]
                            ondas[onda.idOnda].valor = Double(ondas[onda.idOnda].ondaString)!
                            print("string:  \(ondas[onda.idOnda].ondaString)  double:  \(ondas[onda.idOnda].valor)")
                        }
                        clasificacion!.a3 = ondas[0].valor
                        clasificacion!.a5 = ondas[1].valor
                        clasificacion!.a6 = ondas[2].valor
                        clasificacion!.a9 = ondas[3].valor
                        clasificacion!.a11 = ondas[4].valor
                        clasificacion!.fecha = fecha
                    
                        
                        #if proyectoLPS
                        clasificacion!.resultado = resultado == "good" ? true: false
                        #else
                        clasificacion!.resultado = calculo(ondas: ondas)
                        #endif
                        
                        vm.guardarDatos()
                        modoPresentacion.wrappedValue.dismiss()
                    } label: {
                        BotonPersonalizado(texto: "Guardar", color: .accentColor)
                    }
                }
                
            }
            
            
        }.onAppear {
           
            if(clasificacion != nil){
                ondas = [Onda(idOnda: 0, nombre: "Onda 1", valor: clasificacion!.a3),
                         Onda(idOnda: 1, nombre: "Onda 2", valor: clasificacion!.a5),
                                    Onda(idOnda: 2, nombre: "Onda 3", valor: clasificacion!.a6),
                                    Onda(idOnda: 3, nombre: "Onda 4", valor: clasificacion!.a9),
                                    Onda(idOnda: 4, nombre: "Onda 5", valor: clasificacion!.a11),]
            }
            
        }.padding()
            
    }
}

/*
struct EditarClasificacionView_Previews: PreviewProvider {
    static var previews: some View {
        EditarClasificacionView()
    }
}*/

func calculo(ondas: [Onda]) -> Bool{
    var resultado = false
    
    if(ondas[1].valor > 0.0409){ //a05
        print("Primer if")
        if(ondas[0].valor > 0.10135){
            print("Segundo if")
            if(ondas[2].valor > -0.76087){ //a06
                print("Tercer if")
                if(ondas[2].valor > 0.90763){ //a06
                    print("Cuarto if")
                    if(ondas[4].valor > -0.41912){ //a011
                        print("Quinto if FALSE")
                        resultado = false
                    }else{
                        print("Quinto if TRUE")
                        resultado = true
                    }
                }else{
                    print("Cuarto if TRUE")
                    resultado = true
                }
            }
        }
    }
    return resultado
}

struct filaOnda: View {
    @Binding var ondas: [Onda]
    let idOnda: Int
    @Binding var ondaSeleccionada: Int
    
   
    
    var body: some View{
        HStack{
            if(idOnda == ondaSeleccionada){
                Image(systemName: "checkmark.circle.fill")
                    .foregroundColor(.accentColor)
                    .padding(.leading)
                
            }else{
                Image(systemName:"circle")
                    .padding(.leading)
            }
            
            Text(ondas[idOnda].nombre)
            Spacer()
        } //!!! Fondo cuadro gris redondeado
        .frame(height: 50)
        .background(
            RoundedRectangle(cornerRadius: 10).fill(Color(UIColor.systemGray5))
        )
        .onTapGesture {
            ondaSeleccionada = idOnda
        }
    }
}

struct filaNumeros: View {
    @Binding var ondas: [Onda]
    @Binding var ondaSeleccionada: Int
    @Environment(\.colorScheme) var colorScheme
    
    @State var valorSeleccionado = 1
    
    let opcionesValor1 = ["-1", "-0", "0", "1"]
    let opcionesValores = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]

    
    var body: some View{
        VStack{
            

            HStack(spacing: 15){
                
                Spacer()
                circuloNumero(valor: $ondas[ondaSeleccionada].valores[0], numeroSeleccioando: $valorSeleccionado, indice: 1)
                Text(".")
                    .font(.title)
                    .fontWeight(.black)
                    .foregroundColor(.accentColor)
                circuloNumero(valor: $ondas[ondaSeleccionada].valores[1], numeroSeleccioando: $valorSeleccionado, indice: 2)
                circuloNumero(valor: $ondas[ondaSeleccionada].valores[2], numeroSeleccioando: $valorSeleccionado, indice: 3)
                circuloNumero(valor: $ondas[ondaSeleccionada].valores[3], numeroSeleccioando: $valorSeleccionado, indice: 4)
                circuloNumero(valor: $ondas[ondaSeleccionada].valores[4], numeroSeleccioando: $valorSeleccionado, indice: 5)
                circuloNumero(valor: $ondas[ondaSeleccionada].valores[5], numeroSeleccioando: $valorSeleccionado, indice: 6)
                Spacer()
            }
            .frame(height: 80)
            .background(
                RoundedRectangle(cornerRadius: 10).fill(colorScheme == .dark ? Color(UIColor.systemGray5) : Color(UIColor.systemGray6) )
            )
            

            
            switch valorSeleccionado {
            case 1:
                pickerPersonalizado(valor: $ondas[ondaSeleccionada].valores[0], opciones: opcionesValor1)
            case 2:
                pickerPersonalizado(valor: $ondas[ondaSeleccionada].valores[1], opciones: opcionesValores)
            case 3:
                pickerPersonalizado(valor: $ondas[ondaSeleccionada].valores[2], opciones: opcionesValores)
            case 4:
                pickerPersonalizado(valor: $ondas[ondaSeleccionada].valores[3], opciones: opcionesValores)
            case 5:
                pickerPersonalizado(valor: $ondas[ondaSeleccionada].valores[4], opciones: opcionesValores)
            case 6:
                pickerPersonalizado(valor: $ondas[ondaSeleccionada].valores[5], opciones: opcionesValores)
            default:
                Text("")
            }
            
            
        }
        
    }
}

struct circuloNumero: View {
    @Binding var valor: String
    @Binding var numeroSeleccioando: Int
    @Environment(\.colorScheme) var colorScheme
    let indice : Int
    
    var body: some View{
        
        if(indice == numeroSeleccioando){
            Text(valor)
                .foregroundColor(.white)
                .frame(width: 35, height: 35)
                .background(Circle().fill(.blue))
                .shadow(radius: 5)
        }else{
            Text(valor)
                .foregroundColor(.primary)
                .frame(width: 35, height: 35)
                .background(Circle().fill(colorScheme == .dark ? Color.black : Color.white))
                .shadow(radius: 5)
                .onTapGesture {
                    numeroSeleccioando = indice
                }
        }
        
    }
}

struct pickerPersonalizado: View {
    @Binding var valor: String
    let opciones: [String]
    
    var body: some View{
        VStack{
            
        
        Picker("Elegir", selection: $valor) {
                    ForEach(opciones, id: \.self) {
                        Text("\($0)")
                            .foregroundColor(.primary)
            }
        }.pickerStyle(.wheel)
        }.frame(height: 170)
    }
}


struct Onda: Hashable{
    var idOnda: Int
    var nombre: String
    var valor: Double
    var ondaString = ""
    var valores = ["0", "0", "0", "0", "0", "0"]
    
    init(idOnda: Int, nombre: String, valor: Double){
        self.nombre = nombre
        self.valor = valor
        self.idOnda = idOnda
        
        ondaString = String(format: "%.5f", self.valor)
        
        
        valores[0] = String(ondaString[ondaString.index(ondaString.startIndex, offsetBy: 0)])
        if(valores[0] == "-"){
            valores[0] = "-" + String(ondaString[ondaString.index(ondaString.startIndex, offsetBy: 1)])
            valores[1] = String(ondaString[ondaString.index(ondaString.startIndex, offsetBy: 3)])
            valores[2] = String(ondaString[ondaString.index(ondaString.startIndex, offsetBy: 4)])
            valores[3] = String(ondaString[ondaString.index(ondaString.startIndex, offsetBy: 5)])
            valores[4] = String(ondaString[ondaString.index(ondaString.startIndex, offsetBy: 6)])
            valores[5] = String(ondaString[ondaString.index(ondaString.startIndex, offsetBy: 7)])
        }else{
            valores[1] = String(ondaString[ondaString.index(ondaString.startIndex, offsetBy: 2)])
            valores[2] = String(ondaString[ondaString.index(ondaString.startIndex, offsetBy: 3)])
            valores[3] = String(ondaString[ondaString.index(ondaString.startIndex, offsetBy: 4)])
            valores[4] = String(ondaString[ondaString.index(ondaString.startIndex, offsetBy: 5)])
            valores[5] = String(ondaString[ondaString.index(ondaString.startIndex, offsetBy: 6)])
        }
        
    }
}
