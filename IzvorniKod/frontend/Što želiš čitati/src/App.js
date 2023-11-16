import React from "react"

import Header from "./components/components-main/Header.js"
import Body from "./components/components-main/Body.js"
import Footer from "./components/components-main/Footer.js"


import Login from './components/loginsignup/login';
import Signup from './components/loginsignup/signup';
import {BrowserRouter as Router,Route,Routes} from 'react-router-dom';

function App() {
  return (
    <div className="allEncompasingContainer">
      <Header />
      <Body />
      <Footer />
      <Router>
        <Routes>
          <Route path='/login' element={<Login />} />
          <Route path='/signup' element={<Signup />} />
        </Routes>
      </Router>
    </div>

  )
}

export default App
