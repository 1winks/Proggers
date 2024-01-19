import react, { useState, useEffect } from "react";
import { useParams } from 'react-router-dom';
import "./bookListOffer.css";
import { useNavigate } from "react-router-dom";
import BookBoxOffer from "./BookBoxOffer";
import "../BookDetails/BookDetails.css";
import BookDetails from "../BookDetails/BookDetails"

const BookListOffer = () => {
	const [search, setSearch] = useState("");
	const [bookData, setData] = useState([]);

	const searchBook = (evt) => {
		if (evt.key === "Enter") {
			console.log("Enter")
			//axios.get("")
			//.then(res=>setData(res.data.items))
			//.catch(err=>console.log(err))
		} else {
			console.log("Click")
			//axios.get("")
			//.then(res=>setData(res.data.items))
			//.catch(err=>console.log(err))
		}
	}


	return (
		<div className="bookListOffer">
			<div className="bookListHeaderOffer">
				<div className="row1Offer">
					<h1>&#34;A reader lives a thousand lives before he dies. The man who never reads lives only once.&#34;</h1>
				</div>
				{/*<div className="row2">*/}
				{/*	<h2>Pretra&#382;i knjige</h2>*/}
				{/*	<div className="search">*/}
				{/*		<input type="text" placeholder="Upi&#353;i ime knjige"*/}
				{/*			value={search} onChange={e => setSearch(e.target.value)}*/}
				{/*			onKeyPress={searchBook} />*/}
				{/*		<button variant="text" onClick={searchBook}>Tra&#382;i</button>*/}
				{/*	</div>*/}
				{/*</div>*/}
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