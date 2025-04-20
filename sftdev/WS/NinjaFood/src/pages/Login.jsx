import { useContext, useState } from 'react';
import './login.css'
import { AuthContext } from '../contexts/AuthContext';
import { useNavigate } from 'react-router-dom';

export default function Login() {
    const {login} = useContext(AuthContext);
    const [authData, setAuthData] = useState(null);
    const navigate = useNavigate();

    async function handleSubmit(event){
        event.preventDefault();
        const formData = new FormData(event.target);
        const data = Object.fromEntries(formData.entries());
        const user = {
            email: data.email,
            password: data.password
        };

      let sucess = await login(user);     
      setAuthData(user);

      if(sucess){
        navigate('/');
      }else{
        alert('user com dados inválidos!')
      }

      navigate('/');
    }



  
  return (
    <form onSubmit={handleSubmit}>
      <h2>Login</h2>
      <div className="control-row">
        <div className="control no-margin">
          <label htmlFor="email">Email</label>
          <input name="email"
          />
        </div>

        <div className="control no-margin">
          <label htmlFor="password">Password</label>
          <input  
            id="password" type="password" name="password"/>
        </div>
 
      </div>

      <p className="form-actions">
        <button className="button" type='submit'>Login</button>
      </p>
    </form>
  );
}