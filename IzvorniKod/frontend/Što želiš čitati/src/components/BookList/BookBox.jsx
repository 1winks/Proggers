import react, { useState } from "react";
import image from "../../images/bookCover.jpg";
import BookDetails from "../BookDetails/BookDetails";

const BookBox = ({ book }) => {
    console.log(book)
    //const [show, setShow]=useState(false);
    //const [bookItem, setItem]=useState();
    return (
        <>
            {
                book.map((item) => {
                    //let image = item.volumeInfo.imageLinks && item.volumeInfo.imageLinks.smallThumbnail;
                    //if(thumbnail! = undefined)
                    //{
                        return (
                            <>
                            <div className="bookCard">
                                <img src={image} alt="" />
                                <div className="bookCardBottom">
                                        <h3 className="bookCardTitle">{item.volumeInfo.title}</h3>
                                        <h3 className="bookCardAuthor">{item.volumeInfo.autors}</h3>
                                </div>
                            </div>
                                <BookDetails show={show} item={bookItem} onClose={()=>setShow(false)}/>    
                            </>
                        )
                    //}
                })
            }
                        
        </>
    )
}

export default BookBox;