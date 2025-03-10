//
//  ContentView.swift
//  03_PrimeiraApp
//
//  Created by MultiLab PRT 15 on 10/03/2025.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        
        ZStack{
            Color(.black)
                .ignoresSafeArea()
            VStack{
                Text("Olá Porto")
                    .italic()
                    .font(.largeTitle)
                    .bold()
                    .foregroundColor(.purple)
                Image("porto")
                    .resizable()
                    .aspectRatio(contentMode: .fill)
                //.cornerRadius(100)
                    .padding()
                Text("Porto, Portugal")
                    .font(.largeTitle)
                    .fontWeight(.bold)
                    .foregroundStyle(.white)
                
            }
        }
    }
}

#Preview {
    ContentView()
}
