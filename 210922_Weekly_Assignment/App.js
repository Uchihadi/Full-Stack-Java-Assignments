import logo from './logo.svg';
import './App.css';
import Home from './Home';
import About from './About';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import Header from './Header';
import Footer from './Footer';
import Contact from './Contact';
import Logout from './Logout';
import './Page.css';


const App = () => {
  return (
    <>
    {/* Write down navigation below for each URL */}
    
    <Router>
      <Routes>
        <Route path = "/Home" element = {<Home/>}/>
        <Route path = "/Logout" element = {<Logout/>}/>
        <Route path = "/About" element = {<About/>}/>
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
