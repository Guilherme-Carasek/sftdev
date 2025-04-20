import { useState } from "react";
import './login.css'
import { useNavigate } from "react-router-dom";

export default function Register() {
 
    const [passwordsAreNotEqual, setPasswordsAreNotEqual] = useState(false);
    const navigate = useNavigate();

    function handleSubmit(event){
        event.preventDefault();
        const formData = new FormData(event.target);
        const data = Object.fromEntries(formData.entries());
        /* console.log(data) */
 
        if (data.password != data.confirmPassword) {
            setPasswordsAreNotEqual(true);
            return;
          }else{
            setPasswordsAreNotEqual(false);
          }
       
          const user = {
            email: data.email,
            password: data.password,
            firstName: data["first-name"],
            lastName: data["last-name"],
            role: data.role,
            termsAccepted: data.terms === "on",
          };
        
          const response = fetch("http://localhost:3000/signup", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(user),
          });
        
          navigate("/", {
            state: { message: "User registado com sucesso!" },
          });
        
       
    }

    return (
      <form onSubmit={handleSubmit}>
        <h2>Bemvindo ao NinjaFood</h2>
        <p>Faça seu registro</p>
  
        <div className="control">
          <label htmlFor="email">Email</label>
          <input id="email" type="email" name="email" required />
        </div>
  
        <div className="control-row">
          <div className="control">
            <label htmlFor="password">Password</label>
            <input id="password" type="password" name="password" required />
          </div>
          <div className="control">
            <label htmlFor="confirm-password">Confirm Password</label>
            <input
              id="confirm-password"
              type="password"
              name="confirmPassword"
              required
            />
            {passwordsAreNotEqual && <p>As passwords não coincidem</p>}
          </div>
        </div>
  
        <hr />
  
        <div className="control-row">
          <div className="control">
            <label htmlFor="first-name">Nome</label>
            <input type="text" id="first-name" name="first-name" 
            required/>
          </div>
  
          <div className="control">
            <label htmlFor="last-name">Apelido</label>
            <input type="text" id="last-name" name="last-name" required />
          </div>
        </div>
  
        <div className="control">
          <label htmlFor="phone">A sua função</label>
          <select id="role" name="role" required>
            <option value="cliente">Cliente</option>
            <option value="cozinha">Cozinha</option>
            <option value="gestor">Gestor</option>
          </select>
        </div>
        <div className="control">
          <label htmlFor="terms-and-conditions">
            <input required type="checkbox" id="terms-and-conditions" name="terms" />I
           concordo com os termos e condições
          </label>
        </div>
  
        <p className="form-actions">
          <button type="submit" className="button">
            Registrar
          </button>
        </p>
      </form>
    );
  }