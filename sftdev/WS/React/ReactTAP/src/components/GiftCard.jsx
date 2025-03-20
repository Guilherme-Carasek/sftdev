import { useState } from "react"
import { giftsList } from "../data/data"
import './GiftCard.css'

export default function GiftCard() {

    const [gifterLook, setGifterLook] = useState()

    return <div className="giftContainer">
        {giftsList.map((gifter) => 
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
}
