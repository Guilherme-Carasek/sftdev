import { UserData } from "../data/data"
import Card from "../components/Card"
import { useParams } from "react-router-dom"

export default function Contacts() {

    let {name} = useParams();

    return <div>
        <h3> Olá { name }</h3>
        {
            UserData.map((user) => 
                <Card {...user} />
            )
        }
    </div>
}
