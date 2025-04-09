import { useContext, useState } from 'react';
import './auth.css'
import { AuthProvider } from '../contexts/AuthContext';
import { useNavigate } from 'react-router-dom';

export default function Login() {

    const {login} = useContext(AuthContext)
    const [authData, setAuthData] = useState({email:'', password:''})
    const navigate = useNavigate();
  
  return (
    <form>
      <h2>Login</h2>
      <div className="control-row">
        <div className="control no-margin">
          <label htmlFor="email">Email</label>
          <input id='email' type='email' name='email'
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