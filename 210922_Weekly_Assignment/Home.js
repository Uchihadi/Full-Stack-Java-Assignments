import Header from './Header';
import Footer from './Footer';
import './Page.css'

// Importing Header, defining component from "Header"

function Home(){
    let name = 'To find out about me, press the buttons at top left side of the page';
    // Use Data Binding Concept = Binding Variable into our React Page
    return(
        <div>
            <Header/>
            <h1> Home </h1>
            <article>{name}</article> 
            <Footer/>

            {/* Returning variable from {name} declared earlier using Data Binding Concept */}
        </div>
    )
}

// We need to export this component to others
// Exporting the function for use in other components, we can only Export on the function here
export default Home;