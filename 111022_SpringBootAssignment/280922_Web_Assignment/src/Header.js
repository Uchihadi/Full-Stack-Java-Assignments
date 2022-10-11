import logo from './logo.svg';
import { NavLink } from 'react-router-dom';

function Header() {
    
    return (
      <header>
      <div class="header">
         <div class="container-fluid">
            <div class="row">
               <div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 col logo_section">
                  <div class="full">
                     <div class="center-desk">
                        <div class="logo">
                           <a href="index.html"><img src="images/logo.png" alt="#" /></a>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="col-xl-9 col-lg-9 col-md-9 col-sm-9">
                  <ul class="btn">
                     <li class="down_btn"><a href="#">Download</a></li>
                     <li><a href="#">Sign Up</a></li>
                     <li><a href="#"><i class="fa fa-search" aria-hidden="true"></i></a></li>
                     <li><button type="button" id="sidebarCollapse">
                        <img src="images/menu_icon.png" alt="#" />
                        </button>
                     </li>
                  </ul>
               </div>
            </div>
         </div>
      </div>
   </header>

    );
}

// Exporting Header function to be used in App.JS
export default Header;