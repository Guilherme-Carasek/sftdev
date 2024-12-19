const prompt = require('prompt-sync')()

/* Crie um programa (utilizando funções) que gere 5 números entre 1 e 50 que sejam múltiplos de 5 e que guarde num array. 
Finalmente imprime o conteúdo do array usando um for à sua escolha. (function_ex1)
 
function randomNumber(min, max) {
    return Math.floor(Math.random() * (max - min) + min);
}
 
Crie uma nova função para introduzir 5 valores inteiros válidos entre 1 e 30 e guarde num array. */

function gerarMultiploDe5(valorMax){
    return (Math.round(Math.random()*(valorMax/5))*5);
}
//console.log(gerarMultiploDe5(50))
const lista = []
for (i=0;i<5;i++){
    lista.push(gerarMultiploDe5(50))
}

console.log(lista)