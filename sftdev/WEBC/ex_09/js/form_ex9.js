function getData() {
    // variables
    const pessoas = []
    const form = document.querySelector(".form")
    const registarBTN = document.querySelector("#registarBTN")
    const resultado = document.querySelector("#resultado")
   
    function addPersonToResult() {
        resultado.innerHTML = ''
        pessoas.forEach((pessoa, index) => {
            resultado.innerHTML += `
            <div>
                <button onclick="">Remover</button>
                <span>${pessoa.nome}</span>
                <span>${pessoa.apelido}</span>
                <span>${pessoa.peso}</span>
                <span>${pessoa.altura}</span>
            </div>
            `
        })
    }
 
    function cleanInput() {
        form.querySelector("#nome").value = ''
        form.querySelector("#apelido").value = ''
        form.querySelector("#peso").value = ''
        form.querySelector("#altura").value = ''
    }
 
 
    function submitHandler(e) {
        e.preventDefault()
        const nome = document.querySelector("#nome").value
        const apelido = document.querySelector("#apelido").value
        const peso = document.querySelector("#peso").value
        const altura = document.querySelector("#altura").value
        if(nome && apelido && peso && altura) {
            pessoas.push({nome, apelido, peso, altura})
        }
        console.log(pessoas)
        cleanInput()
        addPersonToResult()
    }
 
    form.addEventListener('submit', submitHandler)
}
 
 
getData()
















































/* const nome = document.getElementById("nome")
const apelido = document.getElementById("apelido")
const peso = document.getElementById("peso")
const altura = document.getElementById("altura")
const registarBTN = document.getElementById("registarBTN")
const form = document.querySelector('.form')
registarBTN.disabled = true

const pessoas = []

function RegistarPessoa(name, lastName, weight, height){
    return {name, lastName, weight, height}
}
function PrintPessoas(vec){
    if (vec.length>0){
        texto = ""
        vec.forEach(person => {
            texto += (`nome: ${person.name}`);texto += person.lastName;texto += person.weight;texto += person.height;
        })
        return texto
    }
}
 
function defineActions() {
    // // registar
    // registarBTN.addEventListener('click', function(e) {
    //     console.log(nome.value) // e.target.value
    // })
    // // input
    nome.addEventListener('input', function(e) {
        if(nome.value.length > 2) registarBTN.disabled = false
    })
 
    form.addEventListener('submit', function(e) {
        e.preventDefault()
        if(nome.value === '' || apelido.value === '' || peso.value === '' || altura.value === '' ) {
            alert("Campo vazio")
            return
        }
        else {
            pessoas.push(RegistarPessoa(nome.value,apelido.value,peso.value,altura.value))
            document.getElementById("print").textContent=PrintPessoas(pessoas)
        }
    })
 
}
 
defineActions()
  */