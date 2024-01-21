import react, { useState } from "react";
import image from "../../images/bookCover.jpg";
import BookDetails from "../BookDetails/BookDetails";

const BookBoxOffer = ({ book }) => {
    console.log(book)
    const [show, setShow]=useState(false);
    const [bookItem, setItem]=useState();
    return (
        <>
            {
                book.map((item) => {
                    let image = item.volumeInfo.imageLinks && item.volumeInfo.imageLinks.smallThumbnail;
                    if(image != undefined)
                    {
                        return (
                            <>
                            <div className="bookCardOffer">
                                <img src={image} alt="" />
                                <div className="bookCardBottomOffer">
                                        <h3 className="bookCardTitleOffer">{item.volumeInfo.title}</h3>
                                        <h3 className="bookCardAuthorOffer">{item.volumeInfo.autors}</h3>
                                </div>
                            </div>
                                <BookDetails show={show} item={bookItem} onClose={()=>setShow(false)}/>    
                            </>
                        )
                    }
                })
            }
                        
        </>
    )
}

export default BookBoxOffer;