import './MyButton.css'

export default function MyButton({children, onSelect, active}) {

    

    return <button onClick={onSelect} className= {active ? "btnActive" : "btnColor" +" myBtn"}  >{children}</button>
}