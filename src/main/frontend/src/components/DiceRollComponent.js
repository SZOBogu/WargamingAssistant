import React from "react";
import axios from 'axios'

function DiceRollComponent(){
    const [name, setName] = useState('')
    const [whyMeme, setWhyMeme] = useState('')
    const [bench, setBench] = useState('')

    const handleSubmit = (e) => {
        const url = "https://wolnelektury.pl/api/books/" + title;
    }


    return(
        <div className="d-flex justify-content-center p-3">
            <form className="col=md-4" onSubmit={handleSubmit}>
                <div className="form-group">
                    <h2>Name of the exercise</h2>
                    <input type="text" value = {name} placeholder = "Single legged barbell sqyat on yoga ball or other moronism" onChange={(e) =>setName(e.target.value)}/>
                    <h2>Why is it stupid?</h2>
                    <input type="text" value = {whyMeme} placeholder = "Someone went to snap city in comical fashion?" onChange={(e) =>setWhyMeme(e.target.value)}/>
                    <h2>How much do you bench?</h2>
                    <input type="number" value = {bench} placeholder = "100" onChange={(e) =>setBench(e.target.value)}/>
                </div>
                <button className="btn btn-primary" type="submit">Post exercise</button>
            </form>
        </div>
    );
}

export default DiceRollComponent;