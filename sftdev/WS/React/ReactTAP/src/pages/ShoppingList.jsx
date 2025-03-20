import { ShoppingListList } from "../data/data"


export default function ShoppingList() {
    return <div>
                <h3>Lista de Compras</h3>
                <ul>
                    {ShoppingListList.map((item)=> 
                        <li key={item.name}>{item.name} - {item.amount}</li>
                    )}
          </ul></div>

}
