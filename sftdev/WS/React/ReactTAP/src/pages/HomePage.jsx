import ShoppingList from "./ShoppingList"
import { Link } from "react-router-dom"

export default function HomePage() {

    return <div>
        <h1> As minhas funcionalidades </h1>
        <ul>
            <li><Link to="/shopping-list" >Lista de compras</Link></li>
            <li><Link to="/contacts/alguém">Contatos</Link></li>
            <li><Link to="/gifts">Prendas</Link></li>
            <li><Link to="/places">Lugares</Link></li>
            <li><Link to="/swmovies">Filmes</Link></li>
        </ul>
    </div>

}
