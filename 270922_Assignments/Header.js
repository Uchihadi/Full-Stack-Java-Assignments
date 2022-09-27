import { useEffect, useState } from 'react';
import './Page.css';

function Header(props) {
    let name = "This is a React Page";
    
    // // Using Use Effect to check on localStorage
    const [Exist, setExist] = useState(false);
    
    useEffect(()=>{
        if(localStorage.getItem("token") != undefined && localStorage.getItem("token") != ""){
            setExist(true);
        } else {
            setExist(false);
        }
        
    }, [])
    
    return( // Return the list to About, Contact and Home
    // Each of the lists below (if pressed) brings you to its own page 
    
    <ul className='FrontPage'>
        <li>{props.menuname}</li>
        <li className = {props.CurrentMenu =='Qn1'?"active":''}><a href="Qn1"> Qn1 </a></li>
        <li className = {props.CurrentMenu =='Conditional'?"active":''}><a href="Conditional"> Conditional </a></li>
        <li className = {props.CurrentMenu =='GetAPI'?"active":''}><a href="GetAPI"> GetAPI </a></li>
        <li className = {props.CurrentMenu =='UserDetails'?"active":''}><a href="UserDetails"> User Details </a></li>
        {Exist?<li><a href = "#"> Click Here to Logout </a></li>:null}
        
    </ul>
    )

}

// Exporting Header function to be used in App.JS
export default Header;