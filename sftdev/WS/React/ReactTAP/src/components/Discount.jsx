import { useState } from "react"
import MyButton from "./MyButton"

export default function Discount() {
    const [price, setPrice] = useState(100)

    function setPriceTo() {
        setPrice((price)=>price-10)
    }

    return (
        <div>
            <p data-testid="price">{price}€</p>
            <MyButton onSelect= {()=>setPriceTo()}>Apply discount</MyButton>
        </div>
    )
}