import { useContext } from "react";
import ShoppingList from "./ShoppingList"
import { Link, useLocation } from "react-router-dom"
import { AuthContext } from "../contexts/AuthContext";

export default function HomePage() {

    const {user, login, logout} = useContext(AuthContext)
    const location = useLocation()
    const message = location.state?.message;
    console.log(user)
    return <div>
        {message && <div>{message}</div>}
        <h1> As minhas funcionalidades </h1>
        <ul>
            <li><Link to="/shopping-list" >Lista de compras</Link></li>
            <li><Link to="/contacts/alguém">Contatos</Link></li>
            <li><Link to="/gifts">Prendas</Link></li>
            <li><Link to="/places">Lugares</Link></li>
            <li><Link to="/swmovies">Filmes</Link></li>
            <li><Link to="/login">Login</Link></li>
            <li><Link to="/register">Register</Link></li>
        </ul>
    </div>

}
