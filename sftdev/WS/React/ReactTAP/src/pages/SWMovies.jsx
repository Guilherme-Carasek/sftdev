import { useEffect, useState } from "react";
import SWFilm from "../components/SWFilm"

export default function MoviesIndex() {

    const [swfilms, setFilms] = useState([]);
    
        useEffect(() => {
          fetch("https://swapi.dev/api/films/")
            .then((response) => response.json())
            .then((resData) => setFilms(resData.results)
              
        );
        }, []);
        

        
    return(
        <>
        <div>
            <h1>Starwar moves</h1>

            <p>May the force be </p>

             <SWFilm 
             title="All filsm:"
                films={swfilms}
                fallbackText="no filims to shjow"
                /> 
        </div>
        </>
    )
}