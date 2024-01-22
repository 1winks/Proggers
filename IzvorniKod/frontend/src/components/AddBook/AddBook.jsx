import React, { useState } from "react"
import './addbook.css'
import { Link, useNavigate } from "react-router-dom";
import axios from 'axios';



function AddBook() {

    const [addBookError, setAddBookError] = useState('');

    const [formData,setFormData]=useState({
        title:'',
        author:'',
        cover: '',
        description:'',
        genre:'',
        releaseYear:'',
        ISBN:'',
        type:'',
        publisherName:'',
        publisherCategory:'',

        copies:'',
        state:'',
        sellerMail:'',
    
        /*
        editionNo:'',
        */
        
        
        
    });

    const [addBookSuccess, setAddBookSuccess] = useState(false);

    const handleChange = (e) => {

        const selectedValue = e.target.value;

        const typeMapping = {
            optionDefault: '',
            tip1: 'NATIVE',
            tip2: 'RELATED',
            tip3: 'FOREIGN'
        };

        const stateMapping = {
            optionDefault: '',
            stanje1: 'NEW',
            stanje2: 'USED'
        }

        const publisherMapping = {
            optionDefault: '',
            publ1: 'LOCAL',
            publ2: 'FOREIGN'
        }

        // if (e.target.name === 'cover') {
        //     const file = e.target.files[0];

        //     if (file) {
        //         const reader = new FileReader();
        //         reader.onloadend = () => {
        //             setFormData({ ...formData, cover: reader.result });
        //         };
        //         reader.readAsDataURL(file);
        //     } else {
        //         setFormData({ ...formData, [e.target.name]: e.target.value });
        //     }

           
        // }
        if (e.target.name === 'type') {
            setFormData({ ...formData, type: typeMapping[selectedValue] });
        } else if (e.target.name === 'state') {
            setFormData({ ...formData, state: stateMapping[selectedValue] });
        } else if (e.target.name === 'publisherCategory') {
            setFormData({ ...formData, publisherCategory: publisherMapping[selectedValue] });
        }
        else {
            setFormData({ ...formData, [e.target.name]: e.target.value });
        }
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        
        if (
            !formData.title ||
            !formData.author ||
            !formData.releaseYear ||
            /* !formData.publisher || */
           /* !formData.publisherCategory || */
            !formData.genre ||
            !formData.ISBN ||
           /* !formData.editionNo || */
            !formData.state ||
            !formData.description ||
            !formData.cover ||
            !formData.type ||
            !formData.copies ||
            !formData.sellerMail ||
            !formData.publisherName ||
            !formData.publisherCategory              
        ) {
            setAddBookError('Molim Vas da popunite sva polja !');
            return;
        }
        try {

            const data = {
                title: formData.title,
                author: formData.author,
                cover: formData.cover,
                description: formData.description,
                genre: formData.genre,
                publicationYear: formData.releaseYear,
                isbn: formData.ISBN,
                languageTag: formData.type,
                copies: formData.copies,
                publisher: formData.publisherName,
                publisherCategory: formData.publisherCategory,
                condition: formData.state
            };

            // const offerData = {
            //     copies: formData.copies,
            //     state: formData.state,
            //     sellerMail: formData.sellerMail,
            //     ISBN: formData.ISBN
            // };

            const response = await axios.post(
                'https://proggers.xyz:8080/api/sellers/addBook',
                data,
                {
                  headers: {
                    'Content-Type': 'application/json',
                    Authorization: `Bearer ${localStorage.getItem('token')}`,
                  },
                }
              );

        //   await axios.post('https://proggers.xyz:8080/editions/add', editionData);
        //   await axios.post('https://proggers.xyz:8080/offers/add', offerData);

          console.log('Book added successfully');
          setAddBookSuccess(true);
		  
		//   window.location.href = "/"; /*maknuti kasnije mozda*/

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
                    <label htmlFor="cover">Slika korica</label>
                    <input type="text" name="cover" id="cover" onChange={handleChange} />
                    {/* <input type="file" id="cover" name="cover" accept="image/*" onChange={handleChange} ></input> */}
                </div>
                <div className="inputAddBook">
                    <label htmlFor="description">Tekstni opis</label>
                    <textarea className="inputAddBook" id="description" name="description" rows="8" cols="46" onChange={handleChange} />
                </div>
                <div className="inputAddBook">
                    <label htmlFor="genre">Žanr</label>
                    <input type="text" id="genre" name="genre" onChange={handleChange} />
                </div>
                <div className="inputAddBook">
                    <label htmlFor="releaseYear">Godina izdanja</label>
                    <input type="text" id="releaseYear" name="releaseYear" onChange={handleChange} />
                </div>
                <div className="inputAddBook">
                    <label htmlFor="ISBN">ISBN</label>
                    <input type="text" id="ISBN" name="ISBN" onChange={handleChange} />
                </div>
                <div className="inputAddBook">
                    <label htmlFor="type">Vrsta knjige</label>
                    <select className="inputAddBook" id="type" name="type" onChange={handleChange} >
                        <option value="optionDefault"></option>
                        <option value = "tip1">Hrvatski jezik</option>
                        <option value = "tip2">Srodni jezik</option>
                        <option value = "tip3">Strani jezik</option>
                    </select>
                </div>
                <div className="inputAddBook">
                    <label htmlFor="publisherName">Izdavač</label>
                    <input type="text" id="publisherName" name="publisherName" onChange={handleChange} />
                </div>
                <div className="inputAddBook">
                    <label htmlFor="type">Vrsta izdavača</label>
                    <select className="inputAddBook" id="publisherCategory" name="publisherCategory" onChange={handleChange} >
                        <option value="optionDefault"></option>
                        <option value = "publ1">Domaći</option>
                        <option value = "publ2">Strani</option>
                    </select>
                </div>

                <div className="inputAddBook">
                    <label htmlFor="copies">Broj kopija</label>
                    <input type="text" id="copies" name="copies" onChange={handleChange} />
                </div>
                <div className="inputAddBook">
                    <label htmlFor="state">Stanje očuvanosti</label>
                    <select className="inputAddBook" id="state" name="state" onChange={handleChange} >
                        <option value="optionDefault"></option>
                        <option value = "stanje1">Novo</option>
                        <option value = "stanje2">Korišteno</option>
                    </select>
                </div>
                <div className="inputAddBook">
                    <label htmlFor="sellerMail">Mail adresa</label>
                    <input type="text" id="sellerMail" name="sellerMail" onChange={handleChange} />
                </div>


                


                


                <button type="submit" id="submitajknjigu">Dodaj knjigu</button>
            </form>
        </div>
    )
}

export default AddBook