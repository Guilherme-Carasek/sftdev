// Guilherme Carasek e Andreia Teixeira

const categoriesList = document.getElementById("categoriesList")
const categoryTitle = document.getElementById("categoryTitle")
const productsList = document.getElementById("productsList")


//função para mostrar os produtos
const showProducts = (slug, name) => {
    fetch(`https://dummyjson.com/products/category/${slug}`)
    .then(res => res.json())
    .then(data => {
        productsList.innerHTML = '';
        categoryTitle.innerHTML = '';
        categoryTitle.innerHTML = `<b>Products in category ${name}</b>`;
        data.products.forEach( product => {
            const li = document.createElement('li');

            li.innerHTML = `<b>${product.title}</b> <br>
                Price: $${product.price} <br>
                Rating: ${product.rating}`;

            /* li.textContent = product.name + product.price + product.rating; */ //teste

            li.setAttribute("class", "list-group-item");

            productsList.appendChild(li);
        })
    })
    .catch(error => {
        console.error('Error fetching api', error);
      });
}

//função para popular o card com categorias
const populateCategories = () => {
    fetch('https://dummyjson.com/products/categories')
        .then(res => res.json())
        .then(data => {
            data.forEach( category => {
                const li = document.createElement('li');
                
                li.textContent = category.name;
                li.setAttribute("class", "list-group-item");
                //li.setAttribute("onclick", showProducts(category.slug));
                li.addEventListener("click", () => showProducts(category.slug, category.name)); 

                categoriesList.appendChild(li);
            })
        })
        .catch(error => {
            console.error('Error fetching api', error);
        });

}

window.addEventListener('DOMContentLoaded', () => {
    populateCategories();
});
