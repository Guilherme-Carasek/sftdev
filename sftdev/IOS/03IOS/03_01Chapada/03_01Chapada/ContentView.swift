//
//  ContentView.swift
//  03_01Chapada
//
//  Created by MultiLab PRT 15 on 10/03/2025.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        ZStack
        {
            Color.green
                .ignoresSafeArea()
            VStack{
                Image("fumaca")
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                
                HStack {
                    Text("Cachoeira da fumaça - Chapada Diamantina")
                        .font(.title)
                        .fontWeight(.bold)
                    Image(systemName: "cloud.heavyrain.fill")
                }
                HStack (spacing: 1){
                    Image(systemName: "star.fill")
                    Image(systemName: "star.fill")
                    Image(systemName: "star.fill")
                    Image(systemName: "star.fill")
                    Image(systemName: "star.fill")

                }
                .foregroundColor(.yellow)
                
                Text("Situada a uma altitude de 1 280 metros e com uma queda de quase 400 metros em que a água, pela grande altura, não atinge a base na maior parte do ano por causa do vento, oferecendo uma \"espetacularidade cênica\" ímpar com o fluxo voltando para cima em pequenas gotas com as rajadas de ar vindas do Vale do Capão.")
                    .padding()
            }
            .foregroundColor(.white)
        }
        
    }
}

#Preview {
    ContentView()
}
