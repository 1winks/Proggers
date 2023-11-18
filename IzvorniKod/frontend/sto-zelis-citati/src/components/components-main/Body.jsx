import React from "react"
import Card from "./Card.jsx"
import cardsInfo from "./cardsInfo.jsx"

function Body() {

const cards = cardsInfo.map(card => <Card key={card.id} name={card.name} image={card.imagesrc} />
    
)

    return (
        <div className="bodyMain">
            {cards}
        </div>
    )
}

export default Body