import React from "react"
import Card from "./Card.jsx"
import cardsInfo from "./cardsInfo.jsx"

function Body() {

    const token = localStorage.getItem("token");


    const filteredCards = token
      ? cardsInfo.map(card => <Card key={card.id} name={card.name} image={card.imagesrc} href={card.href} />)
      : cardsInfo.filter(card => card.id === 1 || card.id === 3)
                 .map(card => <Card key={card.id} name={card.name} image={card.imagesrc} href={card.href} />);



    return (
        <div className="bodyMain">
            {filteredCards}
        </div>
    )
}

export default Body