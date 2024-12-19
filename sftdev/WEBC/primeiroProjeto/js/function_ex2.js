/* Crie um programa que guarde num vetor objetos com as chaves: nome, idade e localidade. 
Deverá inserir pessoas enquanto o utilizador não digitar n. Finalmente deverá imprimir o array.(function_ex2)
 
Exemplo:
const pessoa = {
    nome : 'Carla',
    idade : 23,
    localidade: "Santarém"
} */
const prompt = require('prompt-sync')()

pessoa = []

function GuardarPessoas(){
    let input
    while (input !== "n"){
        input = prompt(`nome: `)
        pessoa["nome"].push(input)
        input = prompt(`idade: `)
        pessoa["idade"].push(input)
        input = prompt("localidade: ")
        pessoa["localidade"].push(input)
    }
    return pessoa;
}

pessoa = GuardarPessoas()
console.log(pessoa)
