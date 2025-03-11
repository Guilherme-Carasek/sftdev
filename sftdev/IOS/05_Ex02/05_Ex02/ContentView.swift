//
//  ContentView.swift
//  05_Ex02
//
//  Created by MultiLab PRT 15 on 11/03/2025.
//

import SwiftUI

struct ContentView: View {
	
	@State var card = "back"
	
	@State var playerWins = 0
	@State var playerLosses = 0
	
	@State var background = "background-plain"
	@State var nextBackground = "background-cloth"
	
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
	
	func buttonDealClicked(color:String){
		var random = Int.random(in: 1...2)
		if random == 1 {
			card = "card12"
			if color == "red" {
				playerWins += 1
			} else {
				playerLosses += 1
			}
		} else {
			card = "card14"
			if color == "red" {
				playerLosses += 1
			} else {
				playerWins += 1
			}
		}
	}
	
    var body: some View {
		ZStack {
			Image(background)
				.resizable()
				.aspectRatio(contentMode: .fill)
				.ignoresSafeArea()
			VStack (spacing: 50){
				Spacer(minLength: 150)
				Image(card)
				
				
				HStack{
					Button {
						buttonDealClicked(color: "red")
					} label: {
						ZStack{
							Color(.red)
							Text("RED")
								.foregroundStyle(Color.black)
								.font(.title)
						}
					}
					.cornerRadius(50)
					.padding()
					Button {
						buttonDealClicked(color: "black")
					} label: {
						ZStack{
							Color(.black)
							Text("BLACK")
								.foregroundStyle(Color.red)
								.font(.title)
						}
					}
					.cornerRadius(50)
					.padding()
				}
				
				HStack(spacing:45){
					VStack{
						Text("Wins")
						Text(String(playerWins))
					}
					
					VStack{
						Text("Losses")
						Text(String(playerLosses))
					}
				}
				.font(.title)
				.foregroundColor(.white)
				
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

			}
			.padding()
		}
        
    }
}

#Preview {
    ContentView()
}
