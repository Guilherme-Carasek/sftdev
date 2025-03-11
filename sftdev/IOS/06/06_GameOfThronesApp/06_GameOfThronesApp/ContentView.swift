//
//  ContentView.swift
//  06_GameOfThronesApp
//
//  Created by MultiLab PRT 15 on 11/03/2025.
//

import SwiftUI

struct ContentView: View {
	@State var imageClicked = false
	
	var body: some View {
		ZStack{
			Image("background")
				.resizable()
				.ignoresSafeArea()
				.scaledToFill()
			
			VStack {
				//char img
				Button{
					imageClicked.toggle()
				}label: {
					Image(.jon)
						.resizable()
						.scaledToFit()
						.frame(height:200)
						.cornerRadius(100)
				}
				
				
				//char name
				Text("Jim No")
					.font(.largeTitle)
					.foregroundStyle(.white)
					.shadow(radius: 10)
				
				//char description
				Text("Jon Snow, born Aegon Targaryen, is the son of Lyanna Stark and Rhaegar Targaryen, the late Prince of Dragonstone. From infancy, Jon is presented as the bastard son of Lord Eddard Stark, Lyanna's brother, and raised alongside Eddard's lawful children at Winterfell. Jon's true parentage is kept secret from everyone, including Jon himself, in order to protect him from those that sought the complete annihilation of House Targaryen.")
					.font(.title3)
					.foregroundStyle(.white)
					.shadow(radius: 10)
					.padding()
					.multilineTextAlignment(.center)
				
			}
			.padding()
		}
		.sheet(isPresented: $imageClicked){
			DetailsView()
		}
	}
}

#Preview {
    ContentView()
}
