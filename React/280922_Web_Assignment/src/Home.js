import logo from './logo.svg';
import Header from './Header';
import Footer from './Footer';
import './Page.css'
import { useEffect, useState } from 'react';

function Home() {
   const[UserList,setUserList] = useState([]);

   const getApiResponse=(pageNo)=>{
      fetch("https://reqres.in/api/users?page="+pageNo)
      .then(res=>res.json())
      .then(ress2=>{
         setUserList(ress2['data']);
      })
   }

   const showPerson = (obj) => {

   }

   useEffect(()=>getApiResponse(1),[])
   const [glassList,setGlassList] = useState([
      {"name":"Sunglass 1","price":"$70"},{"name":"Sunglass 2","price":"$40"},
      {"name":"Sunglass 3","price":"$80"},{"name":"Sunglass 4","price":"$170"},
      {"name":"Sunglass 5","price":"$90"},{"name":"Sunglass 6","price":"$130"},
      {"name":"Sunglass 7","price":"$100"},{"name":"Sunglass 8","price":"$70"}
   ]);

  return (
   <>
   <Header/>

   <div id="myCarousel" class="carousel slide banner_main" data-ride="carousel">
            <ol class="carousel-indicators">
               <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
               <li data-target="#myCarousel" data-slide-to="1"></li>
               <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
               <div class="carousel-item active">
                  <div class="container-fluid">
                     <div class="carousel-caption">
                        <div class="row">
                           <div class="col-xl-5 col-lg-5 col-md-5 col-sm-12">
                              <div class="text-bg">
                                 <h1>Welcome to my React Channel</h1>
                                 <p>React makes it painless to create interactive UIs. Design simple views for each state in your application, and React will efficiently update and render just the right components when your data changes.
                                    Declarative views make your code more predictable and easier to debug. </p>
                                 <a class="read_more" href="#">Read more</a>
                              </div>
                           </div>
                           <div class="col-xl-7 col-lg-7 col-md-7 col-sm-12">
                              <div class="images_box">
                                 <figure><img src="images/img2.png"/></figure>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="carousel-item">
                  <div class="container-fluid ">
                     <div class="carousel-caption">
                        <div class="row">
                           <div class="col-xl-5 col-lg-5 col-md-5 col-sm-12">
                              <div class="text-bg">
                                 <h1>Get Thinking A long time</h1>
                                 <p>React makes it painless to create interactive UIs. Design simple views for each state in your application, and React will efficiently update and render just the right components when your data changes.
                                    Declarative views make your code more predictable and easier to debug. </p>
                                 <a class="read_more" href="#">Read more</a>
                              </div>
                           </div>
                           <div class="col-xl-7 col-lg-7 col-md-7 col-sm-12">
                              <div class="images_box">
                                 <figure><img src="images/img2.png"/></figure>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="carousel-item">
                  <div class="container-fluid">
                     <div class="carousel-caption ">
                        <div class="row">
                           <div class="col-xl-5 col-lg-5 col-md-5 col-sm-12">
                              <div class="text-bg">
                                 <h1>Welcome to my React Channel</h1>
                                 <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis </p>
                                 <a class="read_more" href="#">Read more</a>
                              </div>
                           </div>
                           <div class="col-xl-7 col-lg-7 col-md-7 col-sm-12">
                              <div class="images_box">
                                 <figure><img src="images/img2.png"/></figure>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
            {
                  glassList.map((obj,index)=>{
                     return(
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-6">
                        <div class="glasses_box">
                           <figure><img src="images/glass1.png" alt="#"/></figure>
                           <h3><span class="blu">$</span>{obj.price}</h3>
                           <p>{obj.name}</p>
                        </div>
                     </div>
                     )
                  })
               }
              
              <select className='button2' onChange={(e)=>getApiResponse(e.target.value)}>
               <option value="1"> Page 1</option>
               <option value="2"> Page 2</option>
               <option value="3"> Page 3</option>

              </select>

              <div className='box'>
                {
                (UserList <= 0)? 
                <h1>No User is Found</h1>:''
                }

                {/* If (cond == true)?"Execute" */}

                {
                    UserList && UserList.map((userObj, idx) => {
                        return <div onClick={()=>showPerson(userObj)}
                        key = {idx} > {userObj.first_name} <img src = {userObj.avatar}></img> </div>
                    })
                    
                }
            </div>


              {/* {
                  UserList.map((obj,index)=>{
                     return(
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-6">
                        <div class="glasses_box">
                           <figure><img src={obj.avatar} alt="#"/></figure>
                           <h3><span class="blu"></span>{obj.first_name}</h3>
                           <p>{obj.email}</p>
                        </div>
                     </div>
                     )
                  })
               } */}

            <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
            <i class="fa fa-long-arrow-left" aria-hidden="true"></i>
            </a>
            <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
            <i class="fa fa-long-arrow-right" aria-hidden="true"></i>
            </a>
         </div>
         <Footer/>
   </>
  );
}

export default Home;