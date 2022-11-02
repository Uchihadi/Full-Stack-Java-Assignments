import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import Home from './Home';
import About from './About';
import Products from './Products';
import Blogs from './Blogs';
import Contact from './Contact';
import Singlepost from './Singlepost';
import Singlepost2 from './Singlepost2';

// A total of 7 pages to be declared in this file for Web Development React Weekly Assignment

function App(){
  return (
    <Router>
      <Routes>
          <Route path="/Home" element={<Home/>}/> 
          <Route path="/About" element={<About/>}/>
          <Route path="/Products" element={<Products/>}/>
          <Route path="/Blogs" element={<Blogs/>}/>
          <Route path="/Singlepost" element={<Singlepost/>}/>
          <Route path="/Singlepost2" element={<Singlepost2/>}/>
          <Route path="/Contact" element={<Contact/>}/>
          <Route path="/" element={<Home/>}/>
      </Routes>
   </Router>
  );
}

export default App;
