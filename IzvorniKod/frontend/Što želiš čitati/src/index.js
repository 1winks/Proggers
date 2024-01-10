import React from "react";
import ReactDOM from "react-dom";
import { createBrowserRouter, RouterProvider, Route } from "react-router-dom";

import Main from "./components/components-main/Main.jsx"
import Login from './components/loginsignup/login';
import Signup from './components/loginsignup/signup';


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
   }
]);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<RouterProvider router={router} />);