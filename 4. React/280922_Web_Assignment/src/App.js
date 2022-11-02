import logo from './logo.svg';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import Home from './Home';
import About from './About';
import Header from './Header';
import ChooseUs from './ChooseUs';
import Contact from './Contact';
import Footer from './Footer';

function App(){
  return (
    <Router>
      <Routes>
      <Route path="/Header" element={<Header/>}/> 
          <Route path="/Home" element={<Home/>}/> 
          <Route path="/About" element={<About/>}/>
          <Route path="/ChooseUs" element={<ChooseUs/>}/>
          <Route path="/Contact" element={<Contact/>}/>
          <Route path="/" element={<Home/>}/>
      </Routes>
   </Router>

  );
}

export default App;
