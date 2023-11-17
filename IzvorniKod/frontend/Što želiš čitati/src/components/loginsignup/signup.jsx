import React, { useState } from "react";
import './signup.css'
import { Link } from "react-router-dom";
import axios from 'axios';
import visible from '../../images/visible.png';
import hidden from '../../images/hidden.png';

const Signup = () => {

    const [formData,setFormData]=useState({
        username:'',
        email:'',
        address:'',
        country:'',
        phone:'',
        password:'',
        selectedOption:''
    });
    const [isPasswordVisible, setIsPasswordVisible] = useState(false);
    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };
    const handleToggleVisibility = () => {
        setIsPasswordVisible(!isPasswordVisible);
    };
    
    const handleSubmit = async (e) => {
        e.preventDefault();
		
		if (!formData.selectedOption) {
            console.error('Molim odaberite jednu opciju');
            return;
        }
    
        try {
          await axios.post('http://example.com:3000/signup', formData);

          console.log('User registered successfully');
        } catch (error) {
          console.error('Registration failed', error);
        }
    
    }

    return (
        <div className="container">
            <div className="header">
                <div className="text">Registracija</div>
            </div>
            <form onSubmit={handleSubmit}>
                <div className="input">
                    <label htmlFor="username">Korisničko ime</label>
                    <input type="text" id="username" name="username" onChange={handleChange} />
                </div>
                <div className="input">
                    <label htmlFor="email">E-mail</label>
                    <input type="email" id="email" name="email" onChange={handleChange} />
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
                    <label htmlFor="phone">Telefon</label>
                    <input type="text" id="phone" name="phone" onChange={handleChange}/>
                </div>
                <div className="input">
                    <label htmlFor="password">Lozinka</label>
                    <input type={isPasswordVisible ? 'text' : 'password'} id="password" name="password" onChange={handleChange} />
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
                <button type="sumbit" className="submit">Sign Up</button>
            </form>
            <div className="submit-container">
                <div className="change">Već imaš korisnički račun? <a href="/" className="redirect">Kliknite ovdje!</a></div>
            </div>
        </div>

    )
}
export default Signup