const carregarReceita = document.getElementById("carregarReceita")
const divTxt = document.getElementById("divTxt")


const ImprimirReceita = (data) => {
    divTxt.innerHTML = `
        <h2>${data.name}</h2>

    `
}

function defineActions(){
    carregarReceita.addEventListener('click', function(e){
        fetch('https://dummyjson.com/recipes/1')
            .then(res => res.json())
            .then(data => {
                ImprimirReceita(data)
            })
            .catch(error => {
                console.log (`error fetching API DATA: ${error}`)
            })
    })

}


defineActions()






















/*   const recipySelect = document.getElementById("recipySelect")
const recipyDIV = document.getElementById("recipyDIV")
 
 
const addReceipe = (data) => {
    // image (deverá ser apresentada a imagem)
    recepyDIV.innerHTML = `
        <h2>${data.name}</h2>
        <p><strong>Cuisine:</strong> ${data.cuisine}</p>
        <p><strong>Difficulty:</strong> ${data.difficulty}</p>
        <p><strong>Cook Time:</strong> ${data.cookTimeMinutes} minutos</p>
        <p>
            <strong>Ingredients:</strong>
            <ul>
                ${data.ingredients.map(ingredient => `<li>${ingredient}</li>`).join('')}
            </ul>
        </p>
        <p>
            <strong>Instructions:</strong>
            <ul>
                ${data.instructions.map(instruction => `<li>${instruction}</li>`).join('')}
            </ul>
        </p>
        <p><img src='${data.image}' alt='Image of ${data.name}'></p>
       
    `  
}
 
 
const populateSelect = () => {
    fetch('https://dummyjson.com/recipes?limit=10&select=name')
        .then(res => res.json())
        .then(data => {
            const defaultOption = document.createElement("option")
            defaultOption.value = 0
            defaultOption.textContent = "Escolha a receita"
            recipySelect.appendChild(defaultOption)
           
            // popular com receitas da api
            data.recipes.forEach(recipe => {
                const option = document.createElement("option")
                option.value = recipe.id
                option.textContent = recipe.name
                recipySelect.appendChild(option)
            })
        })
}
 
function defineActions() {
    recipySelect.addEventListener('change', function(e) {
        const selectedID = recipySelect.value
        if(selectedID !== "0") {
            fetch(`https://dummyjson.com/recipes/${selectedID}`)
                .then(res => res.json())
                .then(data => {
                    addReceipe(data)
                })
                .catch(error => {
                    console.log(`Erroe fetching API DATA: ${error}`)
                })            
        }
        else {
            recipyDIV.innerHTML = ""
        }
    })
}
 
window.addEventListener('DOMContentLoaded', () => {
    populateSelect()
    defineActions()
}) */