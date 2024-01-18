import React from "react";
import ReactDOM from "react-dom";
import { createBrowserRouter, RouterProvider, Route } from "react-router-dom";

import Main from "./components/components-main/Main.jsx"
import Login from './components/loginsignup/login';
import Signup from './components/loginsignup/signup';
import BookList from './components/BookList/bookList';
import AddBook from './components/AddBook/AddBook';
import Search from './components/searchmap/search';


const router = createBrowserRouter([
   {
      path: "/",
      element: <Login/>
   },
   {
      path: "/signup",
      element: <Signup/>
   },
   {
      path: "/main",
      element: <Main/>
   },
   {
      path: "/booklist",
      element: <BookList/>
   },
   {
      path: "/addbook",
      element: <AddBook/>
   },
   {
      path: "/search",
      element: <Search/>
   }
]);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<RouterProvider router={router} />);