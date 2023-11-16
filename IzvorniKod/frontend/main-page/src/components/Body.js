import React from "react"
import Card from "./Card.js"
import cardsInfo from "./cardsInfo.js"

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