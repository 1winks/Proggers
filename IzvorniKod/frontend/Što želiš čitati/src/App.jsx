import React from "react"

import Header from "./components/components-main/Header.jsx"
import Body from "./components/components-main/Body.jsx"
import Footer from "./components/components-main/Footer.jsx"


import Login from './components/loginsignup/login.jsx';
import Signup from './components/loginsignup/signup.jsx';
import {BrowserRouter as Router,Route,Routes} from 'react-router-dom';

function App() {
  return (
    <div className="allEncompasingContainer">
      <Header />
      <Body />
      <Footer />
    </div>

  )
}

export default App
