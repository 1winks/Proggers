import React, {useState} from "react";
import './login.css'
import knjiga from '../../images/book.png'
import { Link } from "react-router-dom";
//import axios from "axios";
import visible from '../../images/visible.png';
import hidden from '../../images/hidden.png';


const Login = () => {
    const [name, setName] = useState("");
    const [password, setPassword] = useState("");
    const [isPasswordVisible, setIsPasswordVisible] = useState(false);

    const handleLogin = async (e) => {
        e.preventDefault();

        try {
            const response = await fetch('https://65a2704c42ecd7d7f0a79fe1.mockapi.io/login', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ name: name, password: password })  
            });

            const data = await response.json();

            if (data.authenticated) {
               
                console.log("uspjesno");
                window.location.href = '/main';

            } else {
                
                console.error("ne uspjesno");
            }

        } catch (error) {
            console.error("Login failed", error);
        }
    };

    const handleToggleVisibility = () => {
        setIsPasswordVisible(!isPasswordVisible);
    };

    return (
        <div className="container">
            <div className="header">
                <img src={knjiga} alt="slika knjige" />
                <div className="text">Prijava</div>
            </div>

            <form className="form-signin" method="post" onSubmit={handleLogin}>
                <div className="input">
                    <label htmlFor="name">Korisničko ime</label>
                    <input type="text" 
                        value={name} 
                        id="name" 
                        name="name"
                        onChange={(e) => setName(e.target.value)}
                    />
                </div>
                <div className="input">
                    <label htmlFor="password" className="sr-only">Lozinka</label>
                    <input 
                        type={isPasswordVisible ? 'text' : 'password'} 
                        value={password} 
                        onChange={(e) => setPassword(e.target.value)} 
                        className="password-input"
                        id="password" 
                        name="password"
                    />
                    <img
                        src={isPasswordVisible?hidden:visible} 
                        alt={isPasswordVisible?'hidden':'visible'} 
                        onClick={handleToggleVisibility}
                        className="toggle"
                    />
                </div>
                <div className="submit-container">
                    <button type="submit" className="submit" onClick={handleLogin}>Login</button>
                    <div className="change">Još nemaš profil? <Link to="/signup" className="redirect">Kliknite ovdje!</Link> |  <Link to="/main" className="redirect">GUEST LOGIN</Link></div>
                </div>
            </form>
            
        </div>

    )
}
export default Login