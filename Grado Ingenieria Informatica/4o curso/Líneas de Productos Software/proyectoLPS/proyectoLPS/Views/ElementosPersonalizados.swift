//
//  ElementosPersonalizados.swift
//  proyectoLPS
//
//  Created by Aula11 on 30/11/21.
//

import SwiftUI

struct ElementosPersonalizados: View {
    var body: some View {
        Text(/*@START_MENU_TOKEN@*/"Hello, World!"/*@END_MENU_TOKEN@*/)
    }
}

struct ElementosPersonalizados_Previews: PreviewProvider {
    static var previews: some View {
        ElementosPersonalizados()
    }
}


struct TextFieldPersonalizado: View{
    var placeholder: String
    @Binding var texto: String
    var body: some View {
        
        TextField(placeholder, text: $texto)
            .padding()
            .background(Color(UIColor.systemGray6))
            .cornerRadius(10.0)
    }
}


struct SecureFieldPersonalizado: View{
    var placeholder: String
    @Binding var texto: String
    @State var isSecured: Bool = true
    
    
    var body: some View {
        
        ZStack(alignment: .trailing) {
            if isSecured {
                SecureField(placeholder, text: $texto)
                    .padding()
                    .background(Color(UIColor.systemGray6))
                    .cornerRadius(10.0)
            } else {
                TextField(placeholder, text: $texto)
                    .padding()
                    .background(Color(UIColor.systemGray6))
                    .cornerRadius(10.0)
            }
            Image(systemName: self.isSecured ? "eye.slash" : "eye")
                .accentColor(.gray)
                .padding(.trailing, 10)
                .onTapGesture {
                    isSecured.toggle()
                }
            
        
        }
    }
}


struct BotonPersonalizado: View{
    var texto: String
    var color: Color
    
    var body: some View {
        
        Text(texto)
            .fontWeight(.bold)
            .foregroundColor(.white)
            .padding()
            .frame(maxWidth: .infinity)
            .background(color)
            .cornerRadius(10)
        
    }
}

