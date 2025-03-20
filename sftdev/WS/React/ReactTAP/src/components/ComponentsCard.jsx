import reactLogo from '../assets/react.svg'
import './ComponentsCard.css'

export default function ComponentsCard(props) {

    return <div className="c-card">
        <h3> {props.title} </h3>
        <h6> {props.description} </h6>
        <img src= {reactLogo} alt={reactLogo} />
    </div>
}
