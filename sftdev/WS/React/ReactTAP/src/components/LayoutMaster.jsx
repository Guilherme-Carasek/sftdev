import { Outlet } from "react-router-dom"
import { Link } from "react-router-dom"
 
export default function LayoutMaster() {
    return (
        <>
            <h4> Layout Master <Link to="/">Home</Link></h4>
            <Outlet />
            <p>Rodapé</p>
        </>
 
    )
}