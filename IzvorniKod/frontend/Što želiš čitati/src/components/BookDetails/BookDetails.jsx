import react from 'react';


//const BookDetails = ({show, item, onClose}) => {
const BookDetails = () => {
    //if(!show)
    //{
    //    return null;
    //}
    //let thumbnail = item.volumeInfo.imageLinks && item.volumeInfo.imageLinks.smallThumbnail;
    let tumbnail = "image";
    return (
        <>
            <div className="overlay">
                <div className="overlay-inner">
                    <button className="close" onClick={onClose}>Zatvori</button>
                    <div className="inner-box">
                        <img src={thumbnail} alt="" />
                        <div className="info">
                            {/*<h1>Naziv</h1>*/}
                            {/*<h3>Autori</h3>*/}
                            {/*<h3>Oznaka vrste knjiga</h3>*/}
                            {/*<h4>Godina izdanja</h4><br />*/}
                            {/*<h4>Izdavac</h4><br />*/}
                            {/*<h4>Kategorija izdavaca</h4><br />*/}
                            {/*<h4>Zanr</h4><br />*/}
                            {/*<h4>ISBN</h4><br />*/}
                            {/*<h4>Broj izdanja</h4><br />*/}
                            {/*<h4>Stanje ocuvanosti</h4><br />*/}
                            {/*<h4>Tekstni opis</h4><br />*/}
                            {/*<h4>Lista ponuda</h4><br />*/}

                            <h1>{item.volumeInfo.title}</h1>
                            <h3>{item.volumeInfo.authors}</h3>
                            <h3>{item.volumeInfo.clasification}</h3>
                            <h4>{item.volumeInfo.publishingYear}</h4><br />
                            <h4>{item.volumeInfo.publisher}</h4><br />
                            <h4>{item.volumeInfo.publisherCategory}</h4><br />
                            <h4>{item.volumeInfo.genre}</h4><br />
                            <h4>{item.volumeInfo.ISBN}</h4><br />
                            <h4>{item.volumeInfo.issueNumber}</h4><br />
                            <h4>{item.volumeInfo.preservationState}</h4><br />
                            <h4>{item.volumeInfo.offerList}</h4><br />
                        </div>
                    </div>
                    <h4 className="description">{item.volumeInfo.description}</h4>
                </div>
            </div>
        </>
    )
}

export default BookDetails;