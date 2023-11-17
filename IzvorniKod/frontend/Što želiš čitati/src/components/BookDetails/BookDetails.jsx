import React, {useState, useEffect} from 'react';
import {useParams} from 'react-router-dom';
import Loading from "../Loader/Loader";
import coverImg from "../../images/Unknown.png"
import "./BookDetails.css";
import {FaArrowLeft} from "react-icons/fa";
import {useNavigate} from "react-router-dom";

const URL = "https://openlibrary.org/works/";

const BookDetails = () => {
   const {id} = useParams();
   const [loading, setLoading] = useState(false);
   const [book, setBook] = useState(null)

   useEffect(() => {
      setLoading(true);
      async function getBookDetails(){
         try{
            const response = await fetch(`${URL}${id}.json`);
            const data = await response.json();

            if(data){
               const {description, title, covers, subject_places, subject_times, subjects} = data;
               const newBook = {
                  description: description ? description.value : "No description found",
                  title: title,
                  cover_img: coverImg,
                  subject_places: subject_places ? subject_places.join(", ") : "No subject places found",
                  subject_times: subject_times ? subject_times.join(", ") : "No subject times found",
                  subjects: subjects ? subjects.join(", ") : "No subjects found"
               };
               setBook(newBook);
            } else {
               setBook(null)
            }
            setLoading(false);
         } catch(error){
            console.log(error);
            setLoading(false);
         }
      }
      getBookDetails();
   }, [id]);

   console.log(book);

   if(loading) return <Loading />;

   return (
      <section className='book-details'>
         <div className='container'>
            <button type='button' className='flex flex-c back-btn'
            onClick={() => NavigationPreloadManager("/book")}>
               <FaArrowLeft size = {22} />
               <span className='fs-18 fw-6'>Povratak</span>
            </button>
            <div className='book-details-content grid'>
               <div className='book-details-img'>
                  <img src = {book?.slikaKorica} alt = "cover img"/>
               </div>
               <div className='book-details-info'>
                  <div className='book-details-item title'>
                     <span className='fw-6'>Naziv:</span>
                     <span>{book?.naziv}</span>
                  </div>
                  <div className='book-details-item'>
                     <span className='fw-6'>Autori:</span>
                     <span className='fw-6 fs-24'>{book?.autori}</span>
                  </div>
                  <div className='book-details-item'>
                     <span className='fw-6'>Godina izdavanja: </span>
                     <span className='text-italic'>{book?.godinaIzdanja}</span>
                  </div>
                  <div className='book-details-item'>
                     <span className='fw-6'>Izdavač: </span>
                     <span className='text-italic'>{book?.izdavac}</span>
                  </div>
                  <div className='book-details-item'>
                     <span className='fw-6'>Kategorija izdavača: </span>
                     <span className='text-italic'>{book?.kategorijaIzdavaca}</span>
                  </div>
                  <div className='book-details-item'>
                     <span className='fw-6'>Žanr: </span>
                     <span className='text-italic'>{book?.zanr}</span>
                  </div>
                  <div className='book-details-item'>
                     <span className='fw-6'>ISBN: </span>
                     <span className='text-italic'>{book?.ISBN}</span>
                  </div>
                  <div className='book-details-item'>
                     <span className='fw-6'>Broj izdanja: </span>
                     <span className='text-italic'>{book?.brojIzdanja}</span>
                  </div>
                  <div className='book-details-item'>
                     <span className='fw-6'>Stanje očuvanosti: </span>
                     <span className='text-italic'>{book?.stanjeOcuvanosti}</span>
                  </div>
                  <div className='book-details-item.description'>
                     <span className='fw-6'>Tekstni opis: </span>
                     <span className='text-italic'>{book?.tekstniOpis}</span>
                  </div>
                  <div className='book-details-item'>
                     <span className='fw-6'>Oznaka vrste knjige: </span>
                     <span className='text-italic'>{book?.oznakaVrsteKnjige}</span>
                  </div>
               </div>
            </div>
         </div>
      </section>
   )
}

export default BookDetails
