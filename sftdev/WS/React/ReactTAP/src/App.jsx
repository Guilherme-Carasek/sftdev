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
import Discount from './components/Discount.jsx'
import { EXAMPLES } from './data/coreConcepts.js'
import { CORE_CONCEPTS } from './data/coreConcepts.js'
import Delete from './components/delete.jsx'
import ComponentsCard from './components/componentsCard.jsx'
import { ShoppingListList } from './data/data.js'
import HomePage from './pages/HomePage.jsx'
import { createBrowserRouter, RouterProvider } from 'react-router-dom'
import ShoppingList from './pages/ShoppingList.jsx'
import Contacts from './pages/Contacts.jsx'
import LayoutMaster from './components/LayoutMaster.jsx'
import ErrorPage from './pages/Error.jsx'
import Gifts from './pages/Gifts.jsx'
import AvailablePlaces from './pages/PlacesIndex.jsx'
import Places from './components/places/Places.jsx'
import MoviesIndex from './pages/SWMovies.jsx'


const router = createBrowserRouter([
  {path: '/',
    element: <LayoutMaster/>,
    errorElement: <ErrorPage/>,
    children: [
      {path: '/', element: <HomePage/>},
      {path: '/shopping-list', element: <ShoppingList/>},
      {path: '/contacts/:name', element: <Contacts/>},
      {path: '/gifts', element: <Gifts/>},
      {path: '/places', element: <AvailablePlaces/>},
      {path: '/swmovies', element: <MoviesIndex/>},

    ]
  }
])

function App() {
  const [content, setContent] = useState('react')
  const [concepts, setConcepts] = useState()
  const [deleteAlert, setDeleteAlert] = useState(false)

  /* let content = "React" */

  function handleSelect(selectedBtn) {
    setContent(selectedBtn)
  }

  function handleCoreConcepts(button) {
    setConcepts(button)
  }

  function toggleDeleteAlert(isVisible) {
    setDeleteAlert(isVisible)
  }

  return <RouterProvider router={router} />
  
  
  return (
    <>
      <div>
          {deleteAlert ? ( 
            <Delete btnAction = {()=>toggleDeleteAlert(false)} />
          ) : null}

          <button onClick={()=>toggleDeleteAlert(true)}>Deletar tudo</button>

        <Header/>
        {/* <MainGoal myGoal= {MyGoal}/> */}
        <a href="https://vite.dev" target="_blank">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
      </div>
      <MyButton active={content == 'javaScript'} onSelect={()=>{handleSelect('javaScript')}}>JavaScript</MyButton>
      <MyButton active={content == 'Java'} onSelect={()=>{handleSelect('Java')}}>Java</MyButton>
      <MyButton active={content == 'php'} onSelect={()=>{handleSelect('php')}}>php</MyButton>
      <MyButton active={content == 'SQL'} children={"SQL"} onSelect={()=>handleSelect('SQL')}></MyButton>
      <h1>Sofware Developer: {content}</h1>
      <Card
        {...UserData}
      />
      <Card
        firstName = "Filpa"
        lastName = "arujko"
        title = "rica"
      />

      <div>
        {CORE_CONCEPTS.map((item) => 
            <ComponentsCard key={item.title} {...item} />
        )}
      </div>
      <ComponentsCard title="test" description="tstststst" />

      <p className="read-the-docs">
        Click on the Vite and React logos to learn more
      </p>
      <CourseGoal title='Java' description='Criar algoritmos'/>
      <Discount/>

      <div>
        <MyButton onSelect={()=>handleCoreConcepts('jsx')}>jsx</MyButton>
        <MyButton onSelect={()=>handleCoreConcepts('props')}>props</MyButton>
        <MyButton onSelect={()=>handleCoreConcepts('state')}>state</MyButton>
      </div>


      {!concepts ? ( <p>Selecione um topico</p> ) : 
      (
        <div>
          <h1> {EXAMPLES[concepts].title} </h1>
          <p> {EXAMPLES[concepts].description} </p>
          <p>{EXAMPLES[concepts].code}</p>
        </div>
      )}

      <div>
        <h3>Lista de Compras</h3>
        <ul>
        {ShoppingList.map((item)=> 
          <li key={item.name}>{item.name} - {item.amount}</li>
        )}
      </ul></div>
    </>
  )


}


export default App
