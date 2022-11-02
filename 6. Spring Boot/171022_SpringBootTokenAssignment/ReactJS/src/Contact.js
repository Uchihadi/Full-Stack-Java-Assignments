import Header from './Header';
import Footer from './Footer';
import './Page.css'
import React, {useState} from 'react';

// Importing Header, defining component from "Header"

function Contact(){
    let name = 'Please send me your name and email so that I can contact you. Would take at least 3 working days to get back to you. Thank you!';
    // Using The Simple Login Form for Contact
    return(
        <form>
            <Header/>
            <h1> My Contact </h1>
            <article>{name}</article> 
            <div className = "InnerForm">
                <h2> Contact Me </h2>
                <div className='GroupForm'>
                    <label htmlFor='Name'> Name: </label>
                    <input type="text" name = "Name" id = "Name"></input>
                </div>

                <div className='GroupForm'>
                    <label htmlFor='Email'> Email: </label>
                    <input type="text" name = "Email" id = "Email"></input>
                </div>

                <div className='sendButton'>
                    <input type="submit" value="Send"/>  
                </div>
                          
            <Footer/>

            {/* Returning variable from {name} declared earlier using Data Binding Concept */}
            </div>



        </form>
        
    )
}

// We need to export this component to others
// Exporting the function for use in other components, we can only Export on the function here
export default Contact;