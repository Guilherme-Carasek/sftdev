//
//  DetailsView.swift
//  06_GameOfThronesApp
//
//  Created by MultiLab PRT 15 on 11/03/2025.
//

import SwiftUI

struct DetailsView: View {
    var body: some View {
		ZStack{
			Image(.background)
				.resizable()
				.scaledToFill()
				.ignoresSafeArea()
			
			VStack{
				Image(.jon)
					.resizable()
					.scaledToFit()
					.padding(20)
				
			}
			
			
		}
    }
}

#Preview {
    DetailsView()
}
