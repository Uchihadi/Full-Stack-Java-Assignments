import logo from './logo.svg';
import './App.css';
import Qn1 from './Qn1';
import Conditional from './Conditional';
import UserDetails from './UserDetails';
import GetAPI from './GetAPI';
import { useState } from 'react';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import Header from './Header';
import Footer from './Footer';



const App = () => {
  return (
    <>
    {/* Write down navigation below for each URL */}
    
    <Router>
      <Routes>
        <Route path = "/Qn1" element = {<Qn1/>}/>
        <Route path = "/GetAPI" element = {<GetAPI/>}/>
        <Route path = "/Conditional" element = {<Conditional/>}/>
        <Route path = "/UserDetails" element = {<UserDetails/>}/>

        
    {/* Route path is to connect the URL to the end */}
    
    {/* Below on line 26, it will bring you to Home page as you start the react application */}
    <Route path = "/" element = {<Qn1/>}/>
    {/* <Route path = "/" element = {<About/>}/> */}
    </Routes>
 
    </Router>

    </>
   
  );
}

export default App;
