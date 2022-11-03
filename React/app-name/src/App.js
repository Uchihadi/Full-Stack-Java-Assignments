import logo from './logo.svg';
import './App.css';
import PostAPIReact from './PostAPIReact';
import Conditional from './Conditional';
import UserDetails from './UserDetails';
import GetAPI from './GetAPI';
import { useState } from 'react';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import Home from './Home';
import Contact from './Contact';



const App = () => {
  return (
    <>
    {/* Write down navigation below for each URL */}
    
    <Router>
      <Routes>
        <Route path = "/PostAPIReact" element = {<PostAPIReact/>}/>
        <Route path = "/Home" element = {<Home/>}/>
        <Route path = "/GetAPI" element = {<GetAPI/>}/>
        <Route path = "/Conditional" element = {<Conditional/>}/>
        <Route path = "/UserDetails" element = {<UserDetails/>}/>
        <Route path = "/Contact" element = {<Contact/>}/>

        
    {/* Route path is to connect the URL to the end */}
    
    {/* Below on line 26, it will bring you to Home page as you start the react application */}
    <Route path = "/" element = {<Home/>}/>
    {/* <Route path = "/" element = {<About/>}/> */}
    </Routes>
 
    </Router>

    </>
   
  );
}

export default App;
