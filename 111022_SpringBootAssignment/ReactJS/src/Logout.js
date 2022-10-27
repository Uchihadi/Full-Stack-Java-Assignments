import Header from './Header';
import Footer from './Footer';
import './Page.css'

// Importing Header, defining component from "Header"

function Logout(){
    let name = 'You have logged out successfully. Hope to see you soon!';
    // Use Data Binding Concept = Binding Variable into our React Page
    return(
        <div>
            <Header/>
            <h1> Logged Out </h1>
            <h2>{name}</h2> 

            {/* Returning variable from {name} declared earlier using Data Binding Concept */}
        </div>
    )
}

// We need to export this component to others
// Exporting the function for use in other components, we can only Export on the function here
export default Logout;