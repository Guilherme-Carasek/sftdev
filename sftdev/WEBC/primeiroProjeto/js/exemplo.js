/*  Ciclo do while (array_desafio_1)
Utilizando o ciclo do … while insere valores até ser introduzido o valor 0 (deverão ser numéricos, caso contrário deverá apresentar uma mensagem de erro).
No final deverão ser apresentados os seguintes valores:
Listagem do vetor;
Máximo e mínimo do vetor;
Média dos valores introduzidos;
Número de elementos inseridos.
 
Nota: o valor 0 não deverá ser adicionado ao vetor */
const prompt = require('prompt-sync')()

const lista = []
let valor = undefined

do{
    valor = prompt("valor: ")
    if (valor == 0)break
    if (valor != NaN){
        lista.push(valor)
    }else console.log("não é número")
}while (valor != 0)

function soma(vec){
    resultado = Number(0)
    for (i in vec){
        resultado += Number(vec[i])
    }
return resultado
}

console.log(`vetor: ${lista}`)   
console.log(`mínimo: ${Math.min(...lista)}`) 
console.log(`máximo: ${Math.max(...lista)}`) 
console.log(`média: ${soma(lista)/lista.length}`)
