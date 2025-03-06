import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Header from './components/Header.jsx'
import Card from './components/Card.jsx'
/* import MainGoal from './components/MainGoal.jsx' */
import {UserData} from './data/data.js'
/* import {MyGoal} from '.data/data.js' */
import { CourseGoal } from './components/CourseGoal.jsx'
import MyButton from './components/MyButton.jsx'

function App() {
  let content = "React"

  function handleSelect(selectedBtn) {
    content = selectedBtn
  }

  
  
  return (
    <>
      <div>
        <Header/>
        {/* <MainGoal myGoal= {MyGoal}/> */}
        <a href="https://vite.dev" target="_blank">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
      </div>
      <MyButton onSelect={()=>{handleSelect('js')}}>JavaScript</MyButton>
      <MyButton onSelect={()=>{handleSelect('java')}}>Java</MyButton>
      <MyButton onSelect={()=>{handleSelect('php')}}>php</MyButton>
      <h1>Sofware Developer: {content}</h1>
      <Card
        {...UserData}
      />
      <Card
        firstName = "Filpa"
        lastName = "arujko"
        title = "rica"
      />
      <p className="read-the-docs">
        Click on the Vite and React logos to learn more
      </p>
      <CourseGoal title='Java' description='Criar algoritmos'/>
      
    </>
  )
}


export default App
