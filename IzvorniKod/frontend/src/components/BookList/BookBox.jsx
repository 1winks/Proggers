import react, { useState } from "react";
import defaultImage from "../../images/bookCover.jpg";
import BookDetails from "../BookDetails/BookDetails";


const BookBox = ({ book }) => {
    const [show, setShow] = useState(false);
    const [bookItem, setItem] = useState();
    console.log(book)
    return (
        <>
            {
                book.map(item => {
                    let image = item.cover;
                    if (image != undefined) {
                        return (
                            <>
                                <div className="bookCard" onClick={() => { setShow(true); setItem(item) }}>
                                    <img src={image} alt="" />
                                    <div className="bookCardBottom">
                                        <h3 className="bookCardTitle">{item.title}</h3>
                                        <h3 className="bookCardAuthor">{item.author}</h3>
                                    </div>
                                </div>
                                <BookDetails show={show} item={bookItem} onClose={() => setShow(false)} />
                            </>
                        )
                    } else {
                        return (
                            <>
                                <div className="bookCard" onClick={() => { setShow(true); setItem(item) }}>
                                    <img src={defaultImage} alt="" />
                                    <div className="bookCardBottom">
                                        <h3 className="bookCardTitle">{item.volumeInfo.title}</h3>
                                        <h3 className="bookCardAuthor">{item.volumeInfo.autors}</h3>
                                    </div>
                                </div>
                                <BookDetails show={show} item={bookItem} onClose={() => setShow(false)} />
                            </>
                        )
                    }
                })
            }

        </>
    )
}

export default BookBox;