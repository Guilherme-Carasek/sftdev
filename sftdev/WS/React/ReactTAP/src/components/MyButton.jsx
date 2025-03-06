import './MyButton.css'

export default function MyButton({children, onSelect}) {

    

    return <button onClick={onSelect} className='btnColor' >{children}</button>
}