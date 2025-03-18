//
//  PBCharactersList.swift
//  07_PeakyBlindersApp
//
//  Created by MultiLab PRT 15 on 17/03/2025.
//

import Foundation

class PBCharactersList {
	var allCharacters: [PBCharacter] = []
	
	init(){
		decodeJSONData()
	}
	
	func decodeJSONData(){
		if let url = Bundle.main.url(forResource: "peakyblinders", withExtension: "json") {
			do {
				let data = try Data(contentsOf: url)
				let decoder = JSONDecoder()
				decoder.keyDecodingStrategy = .convertFromSnakeCase
				allCharacters = try decoder.decode([PBCharacter].self, from: data)
				print(allCharacters.count)
			}catch{
				print("Error decoding JSON data: \(error)")
			}
		}
		
	}
}
