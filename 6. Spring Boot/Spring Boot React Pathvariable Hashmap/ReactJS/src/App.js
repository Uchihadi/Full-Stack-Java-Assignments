import './App.css';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import Contact from './Contact';
import GetAPI from './GetAPI';
import Conditional from './Conditional';
import UserDetails from './UserDetails';
import Login from './Login';
import About from './About';
import PostAPI from './PostAPI';



const App = () => {
  return (
    <>
    {/* Write down navigation below for each URL */}
    
    <Router>
      <Routes>
        <Route path = "/Contact" element = {<Contact/>}/>
        <Route path = "/GetAPI" element = {<GetAPI/>}/>
        <Route path = "/Conditional" element = {<Conditional/>}/>
        <Route path = "/UserDetails" element = {<UserDetails/>}/>
        <Route path = "/Login" element = {<Login/>}/>
        <Route path = "/PostAPI" element = {<PostAPI/>}/>

    {/* Route path is to connect the URL to the end */}
    
    {/* Below on line 26, it will bring you to Home page as you start the react application */}
    <Route path = "/" element = {<About/>}/>
    </Routes>
 
    </Router>
    
    
    </>
  );
}

export default App;
