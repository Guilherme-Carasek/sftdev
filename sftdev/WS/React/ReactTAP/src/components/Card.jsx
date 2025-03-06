import { useState } from 'react'

function Card(props) {
    const [count, setCount] = useState(0)
    return(
      <div className="card">
      <button onClick={()=>{setCount((count)=>count+1)}}>
        count is {count}
      </button>
      <p> {props.firstName} {props.lastName} </p>
          <p> {props.title} </p>
      </div>
      
    )
  }

  export default Card