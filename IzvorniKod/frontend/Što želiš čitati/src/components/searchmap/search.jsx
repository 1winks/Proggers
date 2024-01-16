import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './search.css'
//import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet';
import 'leaflet/dist/leaflet.css'; 
import L from 'leaflet';
import markerIcon from '../../images/location.png'


const Search = () => {
  const [searchTerm, setSearchTerm] = useState('');
  const [searchResults, setSearchResults] = useState([]);
  const [mapCenter, setMapCenter] = useState([45.8150, 15.9785]);   
  // eslint-disable-next-line no-unused-vars
  const [mapZoom, setMapZoom] = useState(8);
  const [mapLoaded, setMapLoaded] = useState(false);
  //xin
  const [selectedPonuditelj, setSelectedPonuditelj] = useState(null);
  const [booksForSelectedPonuditelj, setBooksForSelectedPonuditelj] = useState([]);

  useEffect(() => {
    setMapLoaded(true);
  }, []);

  useEffect(() => {
    let map;
    if (mapLoaded) {

      const mapContainer = document.getElementById('map');

      if (mapContainer._leaflet_id) {
        mapContainer._leaflet_id = null;
      }

      map = L.map('map').setView(mapCenter, mapZoom);

      L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
      }).addTo(map);

      map.eachLayer((layer) => {
        if (layer instanceof L.Marker) {
          map.removeLayer(layer);
        }
      });

      searchResults.forEach((result) => {
        const customIcon = L.icon({
          iconUrl: markerIcon,
          iconSize: [32, 32], 
          iconAnchor: [16, 32], 
          popupAnchor: [0, -32], 
        });
        
        L.marker([result.latitude, result.longitude],{ icon: customIcon })
          .addTo(map)
          .bindPopup(result.ponuditelj)
          //xin
          .on('click', () => setSelectedPonuditelj(result.ponuditelj));
      });

      map.whenReady(() => {
        map.flyTo(mapCenter, mapZoom);
      });
      return () => {
        if (map) {
          map.off();
          map.remove(); 
        }
      };
    }
  }, [mapLoaded, mapCenter, mapZoom, searchResults]);

  //xin
  useEffect(() => {
    const fetchBooksForPonuditelj = async () => {
      if (selectedPonuditelj) {
        try {
          const response = await axios.get(`https://65a2704c42ecd7d7f0a79fe1.mockapi.io/test?ponuditelj=${selectedPonuditelj}`);
          const books = response.data;
          setBooksForSelectedPonuditelj(books);
          console.log(`Ponuditelj ${selectedPonuditelj}:`, books);
        } catch (error) {
          console.error(error);
        }
      }
    };

    fetchBooksForPonuditelj();
  }, [selectedPonuditelj]);

  const handleSearch = async () => {
    try {
      
      const response = await axios.get('https://65a2704c42ecd7d7f0a79fe1.mockapi.io/test');

      const filteredResults = response.data.filter((result) => {
        return (
          (result.naziv && typeof result.naziv === 'string' && result.naziv.includes(searchTerm)) ||
          (result.autor && typeof result.autor === 'string' && result.autor.includes(searchTerm)) ||
          (result.godinaIzdanja && typeof result.godinaIzdanja === 'number' && result.godinaIzdanja.toString().includes(searchTerm)) ||
          (result.izdavac && typeof result.izdavac === 'string' && result.izdavac.includes(searchTerm)) ||
          (result.kategorijaIzdavac && typeof result.kategorijaIzdavac === 'string' && result.kategorijaIzdavac.includes(searchTerm)) ||
          (result.zanr && typeof result.zanr === 'string' && result.zanr.includes(searchTerm)) ||
          (result.ISBN && typeof result.ISBN === 'number' && result.ISBN.toString().includes(searchTerm)) ||
          (result.brojIzdanja && typeof result.brojIzdanja === 'number' && result.brojIzdanja.toString().includes(searchTerm)) ||
          (result.stanjeOcuvanosti && typeof result.stanjeOcuvanosti === 'number' && result.stanjeOcuvanosti.toString().includes(searchTerm)) ||
          (result.tekstniOpis && typeof result.tekstniOpis === 'string' && result.tekstniOpis.includes(searchTerm)) ||
          (result.oznakaVrsteKnjige && typeof result.oznakaVrsteKnjige === 'string' && result.oznakaVrsteKnjige.includes(searchTerm)) ||
          (result.ponuditelj && typeof result.ponuditelj === 'string' && result.ponuditelj.includes(searchTerm))
        );
      });
  
      console.log('Filtered Results:', filteredResults);
  
      setSearchResults(filteredResults);

      //xin
      setSelectedPonuditelj(null);
      setBooksForSelectedPonuditelj([]);
  
    } catch (error) {
      console.error(error);
    }
  };
 
  return (
    <div className="search-container">
      <div>
        <div className="search-header">Pretraga</div>
        <div className='search-bar'>
          <input
            id='search'
            name='search'
            type="text"
            placeholder=' značajke knjige, naziv ponuditelja'
            value={searchTerm}
            onChange={(e) => setSearchTerm(e.target.value)}
          />
          <button onClick={handleSearch}>search</button>
        </div>
      </div>
  
      <div id="map" style={{ height: '500px', width: '80%', margin: '30px' }}></div>
      {/*xin*/}
      {selectedPonuditelj && (
        <div>
          <h2>{`Ponuditelj ${selectedPonuditelj}`}</h2>
          <ul>
            {booksForSelectedPonuditelj.map((book) => (
              <li key={book.id}>{book.naziv}</li>
            ))}
          </ul>
        </div>
      )}
      

    </div>
  );

}
export default Search;