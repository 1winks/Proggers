import React from "react"
import './addbook.css'


function AddBook() {
    return (
        <div>

            <div id="naslovKontejner">
                <h1 id="naslov">Dodavanje knjige</h1>
            </div>

            <form>
                <div className="inputAddBook"> {/*TODO: Napraviti da kursor nije zalijepljen za lijevu stranu tekstnog okvira, već da je malo pomaknut udesno. */}
                    <label htmlFor="title">Naziv knjige</label>
                    <input type="text" id="title" name="title"/>
                </div>
                <div className="inputAddBook">
                    <label htmlFor="author">Autor</label>
                    <input type="text" id="author" name="author"/>
                </div>
                <div className="inputAddBook">
                    <label htmlFor="year">Godina izdanja</label>
                    <input type="text" id="year" name="year"/>
                </div>
                <div className="inputAddBook">
                    <label htmlFor="publisher">Izdavač</label>
                    <input type="text" id="publisher" name="publisher"/>
                </div>

                <div className="inputAddBook">
                    <label htmlFor="publisherCategory">Vrsta izdavača</label>
                    <select className="inputAddBook" id="publisherCategory" name="publisherCategory">
                        <option value="optionDefault">-</option>
                        <option value = "opcija1">Domaći</option>
                        <option value = "opcija2">Strani</option>

                    </select>

                </div>
                <div className="inputAddBook">
                    <label htmlFor="genre">Žanr</label>
                    <input type="text" id="genre" name="genre"/>
                </div>
                <div className="inputAddBook">
                    <label htmlFor="ISBN">ISBN</label>
                    <input type="text" id="ISBN" name="ISBN"/>
                </div>
                <div className="inputAddBook">
                    <label htmlFor="editionNo">Broj izdanja</label>
                    <input type="text" id="editionNo" name="editionNo"/>
                </div>
                <div className="inputAddBook">
                    <label htmlFor="preservationStatus">Stanje očuvanosti</label>
                    <input type="text" id="preservationStatus" name="preservationStatus"/>
                </div>
                <div className="inputAddBook">
                    <label htmlFor="description">Tekstni opis</label>
                    <textarea className="inputAddBook" id="description" name="description" rows="8" cols="46"/>
                </div>
                <div className="inputAddBook">
                    <label htmlFor="images">Slike korica</label>
                    <input type="file" id="images" name="images[]" accept="image/*" multiple></input>
                </div>

                <div className="inputAddBook">
                    <label htmlFor="type">Oznaka vrste knjige</label>
                    <select className="inputAddBook" id="type" name="type">
                        <option value="optionDefault">-</option>
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