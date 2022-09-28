import Footer from './Footer';
import Header from './Header';
import { useState } from 'react';
// Importing Header, defining component from "Header"
// Import useState from React


function About(){
    return(
        <>
        <Header/>
        <div id="about"  class="about">
            <div class="container-fluid">
               <div class="row d_flex">
                  <div class="col-md-5">
                     <div class="about_img">
                        <figure><img src="images/about_img.jpg" alt="#"/></figure>
                     </div>
                  </div>
                  <div class="col-md-7">
                     <div class="titlepage">
                        <h2>About <span class="blu">Software Developers</span></h2>
                        <p>Software developers are tech experts who visualize, create, and design computer programs. Some of them build new applications for desktop computers or mobile devices. Others may develop underlying systems that power these programs. Regardless, they set out to create, test, and implement programs that answer users’ needs. 
The role of a software developer will depend on the requirements of the organization or team they’re working for. Let’s move on to the next section to learn the different roles and tasks of a software developer. </p>
                        <a class="read_more">Read More</a>
                     </div>
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
export default About;