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
    const handleLogin = async () => {
        try {
            const response = await axios.post('http://your-api-endpoint/login', {
                username: username,
                password: password
            });

            console.log(response.data); 

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

            <div className="input">
                <label htmlFor="username">Korisničko ime</label>
                <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} />
            </div>
            <div className="input">
                <label htmlFor="password">Lozinka</label>
                <input 
                    type={isPasswordVisible ? 'text' : 'password'} 
                    value={password} 
                    onChange={(e) => setPassword(e.target.value)} 
                    className="password-input"
                />
                <img
                    src={isPasswordVisible?hidden:visible} 
                    alt={isPasswordVisible?'hidden':'visible'} 
                    onClick={handleToggleVisibility}
                    className="toggle"
                />
            </div>
            <div className="submit-container">
                <div className="submit" onClick={handleLogin}>Login</div>
                <div className="change">Još nemaš profil? <Link to="/signup" className="redirect">Kliknite ovdje!</Link> |  <Link to="/" className="redirect">GUEST LOGIN</Link></div>
            </div>
        </div>

    )
}
export default Login