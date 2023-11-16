import React from "react";

function Card(props) {
    return (
        <div className="card">
           
            <img src={props.image} className="cardImage"/>
            <p className="cardName">{props.name}</p>
            
            
        </div>
    )
}

export default Card