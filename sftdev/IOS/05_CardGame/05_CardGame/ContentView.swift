//
//  ContentView.swift
//  05_CardGame
//
//  Created by MultiLab PRT 15 on 11/03/2025.
//

import SwiftUI

struct ContentView: View {
    
    @State var playerCard = "back"
    @State var cpuCard = "back"
    
    @State var playerScore = 0
    @State var cpuScore = 0
    
    @State var background = "background-plain"
    @State var nextBackground = "background-cloth"
    
    func buttonDealClicked(){
        var player = Int.random(in: 2...14)
        var cpu = Int.random(in: 2...14)
        
        playerCard = "card" + String(player)
        cpuCard = "card" + String(cpu)
        
        if player > cpu {
            playerScore += 1
        } else if player < cpu {
            cpuScore += 1
        }
    }
    
    func buttonBackgroundClicked(){
        background = nextBackground
        if nextBackground == "background-cloth"{
            nextBackground = "background-wood-cartoon"
        } else if nextBackground == "background-wood-cartoon"{
            nextBackground = "background-wood-grain"
        } else if nextBackground == "background-wood-grain"{
            nextBackground = "background-plain"
        } else {
            nextBackground = "background-cloth"
        }
    }
    
    
    var body: some View {
        ZStack{
            Image(background)
                .resizable()
                .aspectRatio(contentMode: .fill)
                .ignoresSafeArea()
            VStack (spacing: 50){
				Spacer()
                Image("logo")
                
                
                HStack (spacing: 50){
                    
                    Image(playerCard)
                    
                    Image(cpuCard)
                }
                
                Button{
                    buttonDealClicked()
                } label: {
                    Image("button")
                }
                
                HStack (spacing: 50){
                    VStack(spacing: 15){
                        Text("Player")
                            .font(.headline)
                            .fontWeight(.bold)
                        Text(String(playerScore))
                            .font(.title)
                    }
                    VStack(spacing: 15){
                        Text("CPU")
                            .font(.headline)
                            .fontWeight(.bold)
                        Text(String(cpuScore))
                            .font(.title)
                    }
                    
                }
                .foregroundColor(.white)
                
				HStack{
					Spacer()
					Button {
						buttonBackgroundClicked()
					} label: {
						ZStack{
							Image(nextBackground)
								.resizable()
								.cornerRadius(50)
							Text("change background")
								.foregroundColor(.white)
								.font(.title)
						}
					}
					.padding(10)
					Spacer()
				}
				
            }
            .padding()
        }
    }
}

#Preview {
    ContentView()
}
