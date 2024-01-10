import react from "react";
import { useParams } from 'react-router-dom';
import "./bookList.css";
import { useNavigate } from "react-router-dom";

const bookList = () => {
	return (
		<div className="header">
			<div className="row1">
				<h1>“A reader lives a thousand lives before he dies. The man who never reads lives only once.”</h1>
			</div>
			<div className="row2">
				<h2>Pretraži knjige</h2>
				<div className="search">
					<input type="text" placeholer="Upiši ime knjige" />
					<button variant="text">Traži</button>
				</div>
				<img src="../../images/book.png" alt="" />
			</div>
		</div>
	)
}

export default bookList;