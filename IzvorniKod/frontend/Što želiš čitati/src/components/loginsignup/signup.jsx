import React, { useState } from "react";
import './signup.css'
import { Link, useNavigate } from "react-router-dom";
import axios from 'axios';
import visible from '../../images/visible.png';
import hidden from '../../images/hidden.png';

const Signup = () => {

    {/*const navigate = useNavigate();*/}
    const [registrationError, setRegistrationError] = useState('');

    const [formData,setFormData]=useState({
        name:'',
        mail:'',
        telephone:'',
        address:'',
        country:'',
        password:'',
        selectedOption:''
    });
    const [isPasswordVisible, setIsPasswordVisible] = useState(false);
    const [registrationSuccess, setRegistrationSuccess] = useState(false);

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };
    const handleToggleVisibility = () => {
        setIsPasswordVisible(!isPasswordVisible);
    };
    
    const handleSubmit = async (e) => {
        e.preventDefault();

        if (
            !formData.name ||
            !formData.mail ||
            !formData.telephone ||
            !formData.address ||
            !formData.country ||
            !formData.password ||
            !formData.selectedOption
        ) {
            setRegistrationError('Molim Vas da popunite sva polja !');
            return;
        }
        try {
          await axios.post('http://localhost:8080/api/auth/signup', formData);

          console.log('User registered successfully');
          setRegistrationSuccess(true);
		  
          {/*navigate('/login');*/}
		  //preskoci na stranicu login
		  window.location.href = "/";

        } catch (error) {
          console.error('Registration failed', error);
          setRegistrationError('Registracija nije uspjela. Molim pokušajte ponovno.');
        }
    
    }

    return (
        <div className="container">
            <div className="header">
                <div className="text">Registracija</div>
            </div>
            {registrationError && <div className="error-message">{registrationError}</div>}
            <form onSubmit={handleSubmit}>
                <div className="input">
                    <label htmlFor="name">Korisničko ime</label>
                    <input type="text" id="name" name="name" onChange={handleChange} />
                </div>
                <div className="input">
                    <label htmlFor="mail">E-mail</label>
                    <input type="email" id="mail" name="mail" onChange={handleChange} />
                </div>
                <div className="input">
                    <label htmlFor="address">Adresa</label>
                    <input type="text" id="address" name="address" onChange={handleChange} />
                </div>
                <div className="input">
                    <label htmlFor="country">Država</label>
                    <input type="text" id="country" name="country" onChange={handleChange} />
                </div>
                <div className="input">
                    <label htmlFor="telephone">Telefon</label>
                    <input type="tel" id="telephone" name="telephone" onChange={handleChange}/>
                </div>
                <div className="input">
                    <label htmlFor="password">Lozinka</label>
                    <input 
                        type={isPasswordVisible ? 'text' : 'password'} 
                        id="password" 
                        name="password" 
                        onChange={handleChange} 
                    />
                    <img
                        src={isPasswordVisible?hidden:visible} 
                        alt={isPasswordVisible?'hidden':'visible'} 
                        onClick={handleToggleVisibility}
                        className="toggle"
                    />
                </div>
                <div className="input">
                    <div className="option-container">
                        <label className="options">
                            <input
                                type="radio"
                                name="selectedOption"
                                value={"izdavac"}
                                checked={formData.selectedOption === 'izdavac'}
                                onChange={handleChange}
                                className="option-radio"
                            />
                            izdavač
                        </label>
                        <label className="options">
                            <input
                                type="radio"
                                name="selectedOption"
                                value={"antikvarijat"}
                                checked={formData.selectedOption === 'antikvarijat'}
                                onChange={handleChange}
                                className="option-radio"
                            />
                            antikvarijat
                        </label>
                        <label className="options">
                            <input
                                type="radio"
                                name="selectedOption"
                                value={"preprodavac"}
                                checked={formData.selectedOption === 'preprodavac'}
                                onChange={handleChange}
                                className="option-radio"
                            />
                            preprodavač
                        </label>
                    </div>
                </div>
                <button type="submit" className="submit">Sign Up</button>
            </form>
            <div className="submit-container">
				{/*<div className="change">Već imaš korisnički račun? <Link to="/login" className="redirect">Kliknite ovdje!</Link></div>*/}
                <div className="change">Već imaš korisnički račun? <a href="/" className="redirect">Kliknite ovdje!</a></div>
            </div>
            
        </div>

    )
}
export default Signup