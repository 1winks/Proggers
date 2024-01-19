import React, {useState} from "react";
import './login.css'
import knjiga from '../../images/book.png'
import { Link } from "react-router-dom";
import axios from "axios";
import visible from '../../images/visible.png';
import hidden from '../../images/hidden.png';


const Login = () => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [isPasswordVisible, setIsPasswordVisible] = useState(false);
    const [error, setError] = useState(null); 

    const handleLogin = async (e) => {
        e.preventDefault();

        try {
            const response = await axios.post('http://localhost:8080/api/auth/signin', {
                username: username,
                password: password
            });

            console.log(response.data);


        } catch (error) {
            console.error("Login failed", error);
            setError("Prijava nije uspjela. Molimo provjerite svoje podatke.");
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

            {error && <div className="error-message">{error}</div>}

            <form className="form-signin" method="post" onSubmit={handleLogin}>
                <div className="input">
                    <label htmlFor="username">Korisničko ime</label>
                    <input type="text" 
                        value={username} 
                        id="username" 
                        name="username"
                        onChange={(e) => setUsername(e.target.value)}
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
                    <button type="submit" className="submit">Login</button>
					{/*<div className="change">Još nemaš profil? <Link to="/signup" className="redirect">Kliknite ovdje!</Link> |  <Link to="/" className="redirect">GUEST LOGIN</Link></div>*/}
                    <div className="change">Još nemaš profil?<a href="/signup" className="redirect">Kliknite ovdje!</a> |  <a href="/main" className="redirect">GUEST LOGIN</a></div>
                </div>
            </form>
            
        </div>

    )
}
export default Login