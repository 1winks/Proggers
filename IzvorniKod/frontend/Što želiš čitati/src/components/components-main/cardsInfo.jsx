import search from "../../images/search.png"
import bookList from "../../images/bookList.png"
import map from "../../images/map.jpg"
import plus from "../../images/plus.jpg"


const cardsInfo = [
    {
        id: 1,
        name: "Pretraživanje",
        imagesrc: search,
        href: "/searchbooks"
    },
    {
        id: 2,
        name: "Lista knjiga",
        imagesrc: bookList,
        href: "/booklist"
    },
    {
        id: 3,
        name: "Pretraživanje na karti",
        imagesrc: map,
        href: "/search"
    },
    {
        id: 4,
        name: "Dodaj Knjigu",
        imagesrc: plus,
        href: "/addbook"
    },
];

export default cardsInfo