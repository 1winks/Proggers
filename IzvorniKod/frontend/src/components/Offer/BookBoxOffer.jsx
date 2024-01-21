import react, { useState } from "react";
import image from "../../images/bookCover.jpg";
import BookDetails from "../BookDetails/BookDetails";

const BookBoxOffer = ({ book }) => {
    console.log('usao u funckiju');
    console.log(book)
    const [show, setShow]=useState(false);
    const [bookItem, setItem]=useState();
    return (
        <>
            {
                // console.log('usao u ovo funkciu?');
                // console.log(book);
                book.map(b => {
                    // Perform some action for each book
                    console.log(`Book Title: ${b.title}`);
                    console.log(`Author: ${b.author}`);
                    console.log(`Publisher: ${b.publisher}`);
                    console.log(`Cover :${b.cover}`);
                    console.log(`-----`);
                    return (
                        <>
                        <div className="bookCardOffer">
                            <img src={b.cover} alt="" />
                            <div className="bookCardBottomOffer">
                                    <h3 className="bookCardTitleOffer">{b.title}</h3>
                                    <h3 className="bookCardAuthorOffer">{b.author}</h3>
                            </div>
                        </div>
                            <BookDetails show={show} item={bookItem} onClose={()=>setShow(false)}/>    
                        </>
                    )
                })
                // book.map((item) => {
                //     let image = item.volumeInfo.imageLinks && item.volumeInfo.imageLinks.smallThumbnail;
                //     if(image != undefined)
                //     {
                //         return (
                //             <>
                //             <div className="bookCardOffer">
                //                 <img src={image} alt="" />
                //                 <div className="bookCardBottomOffer">
                //                         <h3 className="bookCardTitleOffer">{item.volumeInfo.title}</h3>
                //                         <h3 className="bookCardAuthorOffer">{item.volumeInfo.autors}</h3>
                //                 </div>
                //             </div>
                //                 <BookDetails show={show} item={bookItem} onClose={()=>setShow(false)}/>    
                //             </>
                //         )
                //     }
                // })
            }
                        
        </>
    )
}

export default BookBoxOffer;