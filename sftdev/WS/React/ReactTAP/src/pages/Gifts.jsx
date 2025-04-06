import { useEffect, useState } from "react"
import GiftCard from "../components/GiftCard"

export default function Gifts() {

    const [giftsList, setGiftsList] = useState([]);

    useEffect(() => {
        fetch("http://127.0.0.1:3000/gifts")
        .then((response) => response.json())
        .then((resData) => setGiftsList(resData.gifts));
    }, [])

    return <div>
        <GiftCard 
            title="Prendas"
            gifts={giftsList}
            fallbackText="não há prendas registadas"
        />

        
    </div>
}
