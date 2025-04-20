import { Link } from 'react-router-dom';
import './Navbar.css'


export default function Navbar() {

    return (
        <>
            <nav className="navbar">
                <div className="logo">
                    <Link to="/">🍜 NinjaFood</Link>
                </div>
                <ul className="nav-links">
                    <li><Link to="/">Home</Link></li>
                    <li><Link to="/menu">Menu</Link></li>
                    <li><Link to="/login">Login</Link></li>
                    <li><Link to="/register">Register</Link></li>
                </ul>
            </nav>
        </>
      );
    };
