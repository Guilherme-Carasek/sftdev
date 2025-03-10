//
//  ContentView.swift
//  03_02football
//
//  Created by MultiLab PRT 15 on 10/03/2025.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        ZStack{
            Color.green
                .ignoresSafeArea()
            VStack{
                Text("Porto: 0")
                    .font(.title)
                    .fontWeight(.bold)
                
                Image("football")
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                
                Text("Boavista: -5")
                    .font(.title)
                    .fontWeight(.bold)

            }
        }
    }
}

#Preview {
    ContentView()
}
