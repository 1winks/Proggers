import react, { useState } from "react";
import image from "../../images/bookCover.jpg";
import BookDetails from "../BookDetails/BookDetails";

const BookBoxNS = ({ book }) => {
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
                            <div className="bookCardNS">
                                <img src={image} alt="" />
                                <div className="bookCardBottomNS">
                                        <h3 className="bookCardTitleNS">{item.volumeInfo.title}</h3>
                                        <h3 className="bookCardAuthorNS">{item.volumeInfo.autors}</h3>
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

export default BookBoxNS;