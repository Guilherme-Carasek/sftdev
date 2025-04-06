import './SWFilm.css'

export default function SWFilm({title, films, fallbackText}) {

    
return( 
    <>
    <section>
        <h2>{title}</h2>
        
        {(!films || films.length === 0) && <p>{fallbackText}</p>}

        {films && films.length > 0 && (
            <ul>
                {films.map( (film) => (
                    <li key={film.episode_id}>
                        <h4 className="filmTitle">{film.title}</h4>
                        <p className='openingCrawl'>{film.opening_crawl}</p>
                    </li>
                ) )}
            </ul>
        )}
</section>
        </>
)
}