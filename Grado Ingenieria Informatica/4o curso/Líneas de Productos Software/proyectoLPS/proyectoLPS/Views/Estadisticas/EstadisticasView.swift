//
//  EstadisticasView.swift
//  proyectoLPS
//
//  Created by Aula11 on 16/12/21.
//

import SwiftUI

struct EstadisticasView: View {
    @EnvironmentObject var vm: ViewModel
    
    var body: some View {
        
        NavigationView{
            
            
                ScrollView{
                    if(vm.clasificacionA.isEmpty){
                        Spacer()
                        LottieView(name: "notFound", loopMode: .loop)
                            .frame(width: 280, height: 280)
                            .padding(.top, 200)
                        Spacer()
                    }else{
                    HStack{
                        Text("Diagrama de Sectores")
                            .font(.headline)
                        Spacer()
                    }
                    
                    PieChartClasificacionesView(vm: vm)
                        .environmentObject(vm)
                        .padding()
                        .frame(height: 400)
                    
                    
                    Divider()
                        .padding(.bottom)
                    HStack{
                        Text("Diagrama de Barras")
                            .font(.headline)
                        Spacer()
                    }
                    .padding(.bottom)
                    GraficoBarras(vm:vm)
                        .frame(height: 200)
                        .padding(.bottom, 50)
                    Spacer()
                    
                    Spacer(minLength: 50)
                    }
                }.navigationTitle("Gráficas")
                    .padding(.horizontal)
            
        }
    }
}


struct GraficoDatos: Hashable {
    var letra:String
    var porcentaje:CGFloat
}


struct GraficoBarras: View {
    
    @EnvironmentObject var vm: ViewModel
    
    
    var dias = [GraficoDatos(letra: "L", porcentaje: 0),
                GraficoDatos(letra: "M", porcentaje: 0),
                GraficoDatos(letra: "X", porcentaje: 0),
                GraficoDatos(letra: "J", porcentaje: 0),
                GraficoDatos(letra: "V", porcentaje: 0),
                GraficoDatos(letra: "S", porcentaje: 0),
                GraficoDatos(letra: "D", porcentaje: 0)]
    
    var porcentajes = [100, 80, 60, 40, 20, 0]
    
    var body: some View {
        ZStack{
            
            VStack{
                
                HStack(alignment: .top, spacing: 10)
                {
                    HStack{
                        VStack(spacing: 0){
                            ForEach(porcentajes, id: \.self){
                                p in
                                Text("\(p)%")
                                    .font(.caption)
                                if(p != 0){
                                    Spacer()
                                }
                                
                            }
                            
                        }.padding(0)
                            .frame(height: 204)
                        
                    }
                    ForEach(dias, id: \.self){
                        data in
                        BarView(value: data.porcentaje, dia: data.letra)
                        
                    }
                }.padding(.top, 24).animation(.default)
            }
        }
    }
    
    
    init(vm:ViewModel) {
        
        
        
        for i in 0...dias.count-1 {
            var count = 0
            var total = 0
            for clasificacion in vm.clasificacionA {
                total+=1
                let actualDay = clasificacion.fecha!.dayOfWeek()
                switch actualDay {
                case "Monday":
                    if ("L" == dias[i].letra) {
                        count += 1
                    }
                case "Tuesday":
                    if ("M" == dias[i].letra) {
                        count += 1
                    }
                case "Wednesday":
                    if ("X" == dias[i].letra) {
                        count += 1
                    }
                case "Thursday":
                    if ("J" == dias[i].letra) {
                        count += 1
                    }
                case "Friday":
                    if ("V" == dias[i].letra) {
                        count += 1
                    }
                case "Saturday":
                    if ("S" == dias[i].letra) {
                        count += 1
                    }
                case "Sunday":
                    if ("D" == dias[i].letra) {
                        count += 1
                    }
                default:
                    continue
                }
            }
            dias[i].porcentaje = CGFloat(count)/CGFloat(total)
        }
    }
}

extension Date {
    func dayOfWeek() -> String? {
        let dateFormatter = DateFormatter()
        dateFormatter.dateFormat = "EEEE"
        return dateFormatter.string(from: self).capitalized
    }
}

struct BarView: View{
    @AppStorage("modoOscuro") private var modoOscuro = false
    var value: CGFloat
    var dia: String
    
    var body: some View {
        VStack {
            
            ZStack (alignment: .bottom) {
                RoundedRectangle(cornerRadius: 10)
                    .frame(width: 30, height: 200).foregroundColor(Color(UIColor.systemGray6) /*modoOscuro ? .black : .white*/)
                RoundedRectangle(cornerRadius: 10)
                    .frame(width: 30, height: value*200).foregroundColor(.accentColor)
                
            }.padding(.bottom, 8)
            
            Text(dia)
        }
        
    }
}
