import React from 'react'
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import {Link} from "react-router-dom"

function NavBar(){
    return(
        <div>
            <nav>
                <Link className="btn btn-primary" to="/">Home</Link>
                <Link className="btn btn-primary" to="/dice">Dice Roll Simulator</Link>
                <Link className="btn btn-primary" to="/scenario">Scenario Generator</Link>
                <Link className="btn btn-primary" to="/roster">Roster Builder</Link>
            </nav>
        </div>
    );
}

export default NavBar;