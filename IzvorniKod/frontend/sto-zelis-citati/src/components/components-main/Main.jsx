import React from "react"

import Header from "./Header.jsx"
import Body from "./Body.jsx"
import Footer from "./Footer.jsx"


import Login from '../loginsignup/login.jsx';
import Signup from '../loginsignup/signup.jsx';
import {BrowserRouter as Router,Route,Routes} from 'react-router-dom';

function Main() {
  return (
    <div className="allEncompasingContainer">
      <Header />
      <Body />
      <Footer />
    </div>

  )
}

export default Main
