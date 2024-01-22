import react from 'react';


const BookDetails = ({ show, item, onClose }) => {
    if (!show) {
        return null;
    }
    let thumbnail = item.cover;
    return (
        <>
            <div className="overlay">
                <div className="overlay-inner">
                    <button className="prevedi" variant='text'>Prevedi</button>
                    <button className="close" onClick={onClose}>Zatvori</button>
                    <div className="inner-box">
                        <img src={thumbnail} alt="" />
                        <div className="info">
                            <h1>Naslov: {item.title}</h1>
                            <h3>Autori: {item.author}</h3>
                            <h3>ISBN: {item.isbn}</h3>
                            <h4>Godina izdavanja: {item.publicationYear}</h4><br />
                            <h4>Izdavač: {item.publisher}</h4><br />
                            <h4>Kategorija izdavača: {item.publisherCategory}</h4><br />
                            <h4>Žanr: {item.genre}</h4><br />
                            <h4>Broj kopija: {item.copies}</h4><br />
                            <h4>Stanje ocuvanosti: {item.condition}</h4><br />
                            <h4>Lista ponuda</h4><br />
                        </div>
                    </div>
                    <h4 className="description">Tekstni opis: {item.description}</h4>
                </div>
            </div>
        </>
    )
}

export default BookDetails;