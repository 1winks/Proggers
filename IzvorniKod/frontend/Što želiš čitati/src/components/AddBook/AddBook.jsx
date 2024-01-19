import React, { useState } from "react"
import './addbook.css'
import { Link, useNavigate } from "react-router-dom";
import axios from 'axios';



function AddBook() {

    const [addBookError, setAddBookError] = useState('');

    const [formData,setFormData]=useState({
        title:'',
        author:'',
        year:'',
        publisher:'',
        publisherCategory:'',
        genre:'',
        ISBN:'',
        editionNo:'',
        preservationStatus:'',
        description:'',
        cover: null,
        type:''
    });

    const [addBookSuccess, setAddBookSuccess] = useState(false);

    const handleChange = (e) => {

        if (e.target.name === 'cover[]') {
            setFormData({ ...formData, cover: e.target.files});
        } else {
            setFormData({ ...formData, [e.target.name]: e.target.value });
        }
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        
        if (
            !formData.title ||
            !formData.author ||
            !formData.year ||
            !formData.publisher ||
            !formData.publisherCategory ||
            !formData.genre ||
            !formData.ISBN ||
            !formData.editionNo ||
            !formData.preservationStatus ||
            !formData.description ||
            !formData.cover ||
            !formData.type                    
        ) {
            setAddBookError('Molim Vas da popunite sva polja !');
            return;
        }
        try {
          await axios.post('http://localhost:8080/books/add', formData);

          console.log('Book added successfully');
          setAddBookSuccess(true);
		  
		  window.location.href = "/"; /*maknuti kasnije mozda*/

        } catch (error) {
          console.error('Book adding failed', error);
          setAddBookError('Dodavanje knjige nije uspjelo. Molim pokušajte ponovno.');
        }
    
    }

    return (
        <div>

            <div id="naslovKontejner">
                <h1 id="naslov">Dodavanje knjige</h1>
            </div>
            {addBookError && <div className="error-message">{addBookError}</div>}
            <form onSubmit={handleSubmit}>
                <div className="inputAddBook"> {/*TODO: Napraviti da kursor nije zalijepljen za lijevu stranu tekstnog okvira, već da je malo pomaknut udesno. */}
                    <label htmlFor="title">Naziv knjige</label>
                    <input type="text" id="title" name="title" onChange={handleChange} />
                </div>
                <div className="inputAddBook">
                    <label htmlFor="author">Autor</label>
                    <input type="text" id="author" name="author" onChange={handleChange} />
                </div>
                <div className="inputAddBook">
                    <label htmlFor="year">Godina izdanja</label>
                    <input type="text" id="year" name="year" onChange={handleChange} />
                </div>
                <div className="inputAddBook">
                    <label htmlFor="publisher">Izdavač</label>
                    <input type="text" id="publisher" name="publisher" onChange={handleChange} />
                </div>

                <div className="inputAddBook">
                    <label htmlFor="publisherCategory">Vrsta izdavača</label>
                    <select className="inputAddBook" id="publisherCategory" name="publisherCategory" onChange={handleChange} >
                        <option value="optionDefault"></option>
                        <option value = "opcija1">Domaći</option>
                        <option value = "opcija2">Strani</option>

                    </select>

                </div>
                <div className="inputAddBook">
                    <label htmlFor="genre">Žanr</label>
                    <input type="text" id="genre" name="genre" onChange={handleChange} />
                </div>
                <div className="inputAddBook">
                    <label htmlFor="ISBN">ISBN</label>
                    <input type="text" id="ISBN" name="ISBN" onChange={handleChange} />
                </div>
                <div className="inputAddBook">
                    <label htmlFor="editionNo">Broj izdanja</label>
                    <input type="text" id="editionNo" name="editionNo" onChange={handleChange} />
                </div>
                <div className="inputAddBook">
                    <label htmlFor="preservationStatus">Stanje očuvanosti</label>
                    <input type="text" id="preservationStatus" name="preservationStatus" onChange={handleChange} />
                </div>
                <div className="inputAddBook">
                    <label htmlFor="description">Tekstni opis</label>
                    <textarea className="inputAddBook" id="description" name="description" rows="8" cols="46" onChange={handleChange} />
                </div>
                <div className="inputAddBook">
                    <label htmlFor="images">Slike korica</label>
                    <input type="file" id="images" name="cover[]" accept="image/*" multiple onChange={handleChange} ></input>
                </div>

                <div className="inputAddBook">
                    <label htmlFor="type">Oznaka vrste knjige</label>
                    <select className="inputAddBook" id="type" name="type" onChange={handleChange} >
                        <option value="optionDefault"></option>
                        <option value = "opcija1">Knjiga je na stranom jeziku, a ne postoji izdanje na hrvatskom ili srodnom jeziku.</option>
                        <option value = "opcija2">Knjiga je izdana na hrvatskom jeziku i dobavljiva je na području Hrvatske.</option>
                        <option value = "opcija3">Knjiga je izdana na hrvatskom jeziku, ali nije dobavljiva na području Hrvatske.</option>
                        <option value = "opcija4">Knjiga je izdana na srodnom jeziku, dobavljiva je samo na njihovom tržištu.</option>
                        <option value = "opcija5">Knjiga je izdana na srodnom jeziku, dobavljiva je u Hrvatskoj, ne postoji na hrvatskom jeziku.</option>

                    </select>

                </div>
                <button type="submit" id="submitajknjigu">Dodaj knjigu</button>
            </form>
        </div>
    )
}

export default AddBook