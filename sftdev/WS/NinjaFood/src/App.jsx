import './App.css'
import HomePage from './pages/HomePage.jsx'
import {RouterProvider,createBrowserRouter } from 'react-router-dom'
import LayoutMaster from './components/LayoutMaster.jsx'
import ErrorPage from './pages/Error.jsx'
import { AuthProvider } from './contexts/AuthContext.jsx'
import Menu from './pages/Menu.jsx'
import Login from './pages/Login.jsx'
import Register from './pages/Register.jsx'


const router = createBrowserRouter([
  {path: '/',
    element: <LayoutMaster/>,
    errorElement: <ErrorPage/>,
    children: [
      {path: '/', element: <HomePage/>},
      {path: '/menu', element: <Menu/>},
      {path: '/login', element: <Login/>},
      {path: '/register', element: <Register/>}
      

    ]
  }
])


export default function App() {
  return (
    <AuthProvider>
      <RouterProvider router = {router}/>
    </AuthProvider>
  );
}
