import MyButton from "./MyButton";


export default function Delete(btnAction) {

    return (
        <div className="deleteAlert">
            <h3> Tem certeza? </h3>
            <p> Esta ação é para sempre </p>
            <MyButton onSelect={btnAction}>Continuar</MyButton>
        </div>
    )
}