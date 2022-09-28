import Footer from './Footer';
import Header from './Header';
import { useState } from 'react';
// Importing Header, defining component from "Header"
// Import useState from React

function ChooseUs(){
    return(
        <>
        <Header/>
        <div class="choose ">
            <div class="container">
               <div class="row">
                  <div class="col-md-12">
                     <div class="titlepage">
                        <h2>Why <span class="blu"> Choose Us</span></h2>
                     </div>
                  </div>
               </div>
            </div>
            <div class="choose_bg">
               <div class="container">
                  <div class="row">
                     <div class="col-md-12">
                        <div class="row">
                           <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 padding_right0">
                              <ul class="easy">
                                 <li class="active"><a href="#">What We Offer</a></li>
                                 <li><a href="#">More flexible</a></li>
                                 <li><a href="#">Clean mode</a></li>
                                 <li><a href="#">Ratinaready</a></li>
                              </ul>
                           </div>
                           <div class="col-xl-9 col-lg-9 col-md-9 col-sm-12 padding_left0">
                              <div class="choose_box">
                                 <i><img src="images/admin.png" alt="#"/></i>
                                 <h3> Choosing Us</h3>
                                 <p>“Choose us!” so many companies tell us, and there’s usually a reason why we listen; or why we don’t.  Last week, I was hunting for stationery. This isn’t far out of my normal routine: I like stationery, but I needed something specific. In Kuala Lumpur, there are plenty of places to look, but I had limited time and did’t want to get stuck in traffic for the rest of the afternoon.
                                    My first thought when I think ‘stationery’ is ‘bookshop’. That might just be the way I’m wired — predisposed towards any excuse to visit a bookshop — or it might have something to do with major bookshop chains in KL stocking stationery.</p>
                              </div>
                           </div>
                        </div>
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
export default ChooseUs;