import React from "react"
import "./style.css"
import jwt_decode from "jsonwebtoken";

function Header() {

    const token = localStorage.getItem("token");
  
    let greetingText = "Pozdrav goste";
  

    if (token) {
      try {
        const decodedToken = jwt_decode(token);
        const username = decodedToken.username; 
        greetingText = `Pozdrav, ${username}!`;
      } catch (error) {
        console.error("Error decoding token:", error);
      }
    }
  
    return (
      <header className="headerMain">
        <p className="greetingMain">{greetingText}</p>
      </header>
    );
}

    /* 
    
    return (
        <header className="headerMain">
            <p className="greetingMain">Pozdrav, {username}!</p>
    
        </header>
    )
    
    */


export default Header