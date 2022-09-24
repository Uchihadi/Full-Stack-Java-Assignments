import Footer from './Footer';
import Header from './Header';
// Importing Header, defining component from "Header"


function About(){
    let name = 'This is about Nurhadi';
    // Use Data Binding Concept = Binding Variable into our React Page
    return(
        <div>
            <Header/>
            <h1> About Me </h1>
            <h2>{name}</h2>
            <div className='innerForm'>
            <article>Hi! My name is Nurhadi. I am a Full Stack Developer currently in training under GECO Asia Pte Ltd together with 11 other potential software developers.
            Training under the tutelage of Mentor Praveen.
            I am 26 years old this year.
            Wish me luck for the programme, thank you! </article>
                
            </div> 
            <Footer/>
            {/* Returning variable from {name} declared earlier using Data Binding Concept */}
        </div>
    )
}

// We need to export this component to others
// Exporting the function for use in other components, we can only Export on the function here
export default About;