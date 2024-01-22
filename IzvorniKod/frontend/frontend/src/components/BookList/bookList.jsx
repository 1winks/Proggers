import react, { useState, useEffect } from "react";
import { useParams } from 'react-router-dom';
import "./bookList.css";
import { useNavigate } from "react-router-dom";
import BookBox from "./BookBox";
import "../BookDetails/BookDetails.css";
import BookDetails from "../BookDetails/BookDetails"
import axios from "axios";

const BookList = () => {
	const [search, setSearch] = useState("");
	const [type, setType] = useState("");
	const [bookData, setData] = useState([]);

	const searchBook = (evt) => {
		if (evt.key === "Enter") {
			console.log("Enter")
			const reqbody =  {
				query: search,
				type: type
			};
			console.log(reqbody);
			axios.post('https://proggers.xyz:8080/api/books/find', reqbody)
			.then(
				
				res=>{
					console.log(res)
					setData(res.data.items)
				}
			)
			.catch(err=>console.log(err))
		} 
	}

	// function features(mylist) {
	// 	try {
	// 		console.log(mylist);
	// 	} catch (error) {
	// 		console.error("Selection failed", error);
	// 	}
	// }


	return (
		<div className="bookList">
			<div className="bookListHeader">
				<div className="row1">
					<h1>&#34;A reader lives a thousand lives before he dies. The man who never reads lives only once.&#34;</h1>
				</div>
				<div className="row2">
					<h2>Pretra&#382;i knjige</h2>
					<select id="myList" onChange={a => setType(a.target.value)}>
						<option value="title">Naziv</option>
						<option value="author">Autor</option>
						<option value="publicationYear">Godina izdanja</option>
						<option value="publisher">Izdavač</option>
						<option value="publisherCategory">Kategorija izdavača</option>
						<option value="genre">Žanr</option>
						<option value="isbn">ISBN</option>
						<option value="condition">Stanje očuvanosti</option>
						{/* <option value="opis">Tekstni opis</option> */}
						<option value="languageTag">Oznaka vrste knjiga</option>
					</select>
					<div className="search">
						<input type="text" placeholder="Upis"
							value={search} onChange={e => setSearch(e.target.value)}
							onKeyPress={searchBook} />
						<button variant="text" onClick={e => setSearch(e.target.value)}>Tra&#382;i</button>
					</div>
				</div>
			</div>
			<div className="bookListBody">
				{
					<BookBox book={bookData}/>
				}
			</div>
		</div >
	)
}

export default BookList;