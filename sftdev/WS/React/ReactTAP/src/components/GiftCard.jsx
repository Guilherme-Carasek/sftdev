import { useState } from "react"
import './GiftCard.css'

export default function GiftCard({title, gifts = null, fallbackText}) {

    const [gifterLook, setGifterLook] = useState()
    
    return <div>
        
        {(!gifts || gifts.length === 0) && <p>{fallbackText}</p>}

        {gifts && gifts.length > 0 && (
            <div>
                <h3>{title}</h3>
                <div className="giftContainer">
                    {gifts.map((gifter) => 
                        <div className={(gifterLook == gifter.gifter ? "giftCardSelected" : "giftCardUnselected")+" giftCard"}>
                            <button onClick={()=>setGifterLook(gifter.gifter)} key={gifter.gifter}>{gifter.gifter}</button>
                            { gifterLook == gifter.gifter && (
                                gifter.gifts ? <ul>
                                    {gifter.gifts.map((gift)=> 
                                        <li key={gift.recipient}> {gift.recipient}: {gift.gift} - {gift.price} </li>
                                    )}
                                </ul> : <p>Não há prendas</p>)
                            }
                        </div>
                    )}
                </div>
            </div>
        )}

        
    </div>
}
