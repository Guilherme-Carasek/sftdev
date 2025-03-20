import MyButton from "./MyButton";
import './Delete.css'

export default function Delete(props) {

    return (
        <div className="deleteAlert">
            <h3> Tem certeza? </h3>
            <p> Esta ação é para sempre </p>
            <MyButton onSelect={props.btnAction}>Continuar</MyButton>
        </div>
    )
}