import { Outlet } from "react-router-dom"
import { Link } from "react-router-dom"
import Navbar from "./Navbar"
 
export default function LayoutMaster() {
    return (
        <>
            <Navbar/>
            <Outlet />
            <p>Rodapé</p>
        </>
 
    )
}