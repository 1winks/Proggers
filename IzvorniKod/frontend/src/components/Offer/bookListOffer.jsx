import react, { useState, useEffect } from "react";
import axios from "axios";
import { useParams } from 'react-router-dom';
import "./bookListOffer.css";
import { useNavigate } from "react-router-dom";
import BookBoxOffer from "./BookBoxOffer";
import "../BookDetails/BookDetails.css";
import BookDetails from "../BookDetails/BookDetails"

const BookListOffer = () => {
	const [search, setSearch] = useState("");
	const [bookData, setData] = useState([]);

	useEffect(() => { 

		axios.get('http://localhost:8080/api/books/list', 
		// {
		// 	params: {
		// 		mylist: search
		// 	}
		// }
		)
			.then(res => {
				console.log(res.data);
				setData(res.data.items)
			})
			// .catch(err => console.log(err));
	}, [search]); 


	return (
		<div className="bookListOffer">
			<div className="bookListHeaderOffer">
				<div className="row1Offer">
					<h1>&#34;A reader lives a thousand lives before he dies. The man who never reads lives only once.&#34;</h1>
				</div>
			</div>
			<div className="bookListBodyOffer">
				{
					<BookBoxOffer book={bookData}/>
				}
			</div>
		</div >
	)
}

export default BookListOffer;