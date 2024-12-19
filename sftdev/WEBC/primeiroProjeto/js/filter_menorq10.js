const prompt = require('prompt-sync')()

const numeros = [1,2,213,123,1,45,2,51,123]

const maioresQue10 = numeros.filter((val) => val > 10)

console.log(maioresQue10)