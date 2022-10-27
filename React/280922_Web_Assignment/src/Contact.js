import Header from './Header';
import Footer from './Footer';
import React, {useState} from 'react';

// Importing Header, defining component from "Header"

function Contact(){
    let name = 'Please send me your name and email so that I can contact you. Would take at least 3 working days to get back to you. Thank you!';
    // Using The Simple Login Form for Contact
    return(
        <>
            <Header/>
            <div id="contact" class="request">
            <div class="container">
               <div class="row">
                  <div class="col-md-12">
                     <div class="titlepage">
                        <h2>Request <span class="white">A call Back</span></h2>
                     </div>
                  </div>
               </div>
               <div class="row">
                  <div class="col-md-6">
                     <form id="request" class="main_form">
                        <div class="row">
                           <div class="col-md-12 ">
                              <input class="contactus" placeholder="Full Name" type="type" name="Full Name"/> 
                           </div>
                           <div class="col-md-12">
                              <input class="contactus" placeholder="Email" type="type" name="Email"/> 
                           </div>
                           <div class="col-md-12">
                              <input class="contactus" placeholder="Phone Number" type="type" name="Phone Number"/>                          
                           </div>
                           <div class="col-md-12">
                              <textarea class="textarea" placeholder="Message" type="type" Message="Name">Message </textarea>
                           </div>
                           <div class="col-md-12">
                              <button class="send_btn">Send</button>
                           </div>
                        </div>
                     </form>
                  </div>
                  <div class="col-md-6">
                     <div id="map"></div>
                  </div>
               </div>
            </div>
         </div> 
            <Footer/>
        </>
        
    )
}

// We need to export this component to others
// Exporting the function for use in other components, we can only Export on the function here
export default Contact;