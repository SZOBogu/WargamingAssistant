import React from 'react'
import 'bootstrap/dist/css/bootstrap.min.css';
import {Link} from "react-router-dom"

function NavBar(){
    return(
        <div>
            <nav className="navbar navbar-dark bg-dark">
                <Link class="badge badge-dark" to="/">Home</Link>
                <Link class="badge badge-dark" to="/dice">Dice Roll Simulator</Link>
                <Link class="badge badge-dark" to="/scenario">Scenario Generator</Link>
                <Link class="badge badge-dark" to="/roster">Roster Builder</Link>
            </nav>
        </div>
    );
}

export default NavBar;