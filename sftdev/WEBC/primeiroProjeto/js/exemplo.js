const prompt = require('prompt-sync')()



let opcao = 0

while (opcao != 6){
    console.log("1.Ler valores")
    console.log("2.Ver valores")
    console.log("3.Média")
    console.log("4.Máximo")
    console.log("5.Mínimo")
    console.log("6.Sair")
    opcao = prompt()
    console.log(`Clicou na opção ${opcao}`)
    
    switch(opcao){
        case 1: console.log(`Clicou na opção ${opcao}`)
    }

}