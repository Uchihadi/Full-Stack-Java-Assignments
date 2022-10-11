import { useEffect, useState } from 'react';
import logo from './logo.svg';

function Footer () {
    return (
      <footer>
      <div class="footer">
         <div class="container">
            <div class="row">
               <div class="col-xl-6 col-lg-6 col-md-12 col-sm-12">
                  <div class="row">
                     <div class="col-md-8 col-sm-6">
                        <div class="address">
                           <h3>Address </h3>
                        </div>
                        <ul class="location_icon">
                           <li>Hiring a skilled software developer by yourself can be an uphill battle. What’s extra challenging is securing candidates who are in such high demand. For this reason, many companies resort to recruiting offshore developers. So, how do you hire developers quickly & affordably? You hire through an offshore software development firm like Full Scale. We provide a proven way for clients to assemble expert development teams without breaking the bank. Our vast pool of developers has senior-level expertise working with complex development projects. Let Full Scale help you mobilize your business goals. Get started with a FREE consultation to learn more about our services.</li>
                        </ul>
                     </div>
                     <div class="col-md-4 col-sm-6">
                        <div class="address">
                           <h3>Links</h3>
                           <ul class="Menu_footer">
                              <li class="active"> <a href="Home">Home</a> </li>
                              <li class="active"> <a href="About"> About</a> </li>
                              <li class="active"> <a href="ChooseUs"> ChooseUs</a> </li>
                              <li class="active"> <a href="Contact">Contact </a> </li>
                           </ul>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="col-xl-6 col-lg-6 col-md-12 col-sm-12">
                  <div class="row">
                     <div class="col-md-5 col-sm-6">
                        <div class="address">
                           <h3>Follow Us</h3>
                        </div>
                        <ul className="social_icon">
                           <li><a href="#">Facebook <i class = "fa fa-facebook" aria-hidden="true"></i></a></li>
                           <li><a href="#"> Twitter<i class="fa fa-twitter" aria-hidden="true"></i></a></li>
                           <li><a href="#"> Linkedin<i class="fa fa-linkedin-square" aria-hidden="true"></i></a></li>
                           <li><a href="#"> Youtube<i class="fa fa-youtube-play" aria-hidden="true"></i></a></li>
                           <li><a href="#"> Instagram<i class="fa fa-instagram" aria-hidden="true"></i></a></li>
                        </ul>
                     </div>
                     <div class="col-md-7 col-sm-6">
                        <div class="address">
                           <h3>Newsletter </h3>
                        </div>
                        <form class="bottom_form">
                           <input class="enter" placeholder="Enter Your Email" type="text" name="Enter Your Email"></input>
                           <button class="sub_btn">subscribe</button>
                        </form>
                     </div>
                  </div>
               </div>
            </div>
         </div>
         <div class="copyright">
            <div class="container">
               <div class="row">
                  <div class="col-md-12">
                     <p>Copyright 2019 All Right Reserved By <a href="https://html.design/"> Free  html Templates</a></p>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </footer>
    )
}

export default Footer;