//
//  ContentView.swift
//  04_Ex01
//
//  Created by MultiLab PRT 15 on 10/03/2025.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        ZStack{
            Color(.indigo)
                .opacity(Double(0.3))
                .ignoresSafeArea()
            VStack{
                
                VStack (alignment: .leading, spacing: 20){
                    Image("porto")
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                        .cornerRadius(15)
                    HStack {
                        Text("Porto")
                            .font(.largeTitle)
                            .bold()
                        
                        Spacer()
                        
                        VStack{
                            HStack{
                                Image(systemName: "star.fill")
                                Image(systemName: "star.fill")
                                Image(systemName: "star.fill")
                                Image(systemName: "star")
                                Image(systemName: "star")
                            }
                            .foregroundColor(.yellow)
                            Text("964 Reviews")
                        }
                    }
                    Text("Porto has 5 bridges")
                }
                .padding()
                .background(Rectangle()
                    .foregroundColor(.white)
                    .cornerRadius(15)
                    .shadow(radius: 15)
                            
                )
                .padding()
                
                
                VStack (alignment: .leading, spacing: 20){
                    Image("covilha")
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                        .cornerRadius(15)
                    HStack {
                        Text("Covilhã")
                            .font(.largeTitle)
                            .bold()
                        
                        Spacer()
                        
                        VStack{
                            HStack{
                                Image(systemName: "star.fill")
                                Image(systemName: "star.fill")
                                Image(systemName: "star.fill")
                                Image(systemName: "star.fill")
                                Image(systemName: "star.fill")
                            }
                            .foregroundColor(.yellow)
                            Text("514 Reviews")
                        }
                    }
                    Text("Covilhã has 1 bridge")
                }
                .padding()
                .background(Rectangle()
                    .foregroundColor(.white)
                    .cornerRadius(15)
                    .shadow(radius: 15)
                            
                )
                .padding()
            }
        }
    }
}

#Preview {
    ContentView()
}
