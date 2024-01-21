import React from "react";

function Card(props) {
    return (
        <a href={props.href}>
            <div className="card">

                <img src={props.image} className="cardImage" />
                <p className="cardName">{props.name}</p>

            </div>
        </a>
    )
}

export default Card