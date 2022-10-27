import Header from './Header';
import { useState } from 'react';
import Footer from './Footer';
import './Page.css'

// Importing Header, defining component from "Header"
// React State
function PostAPI(){

    // Getter --> To Get Value from Variable
    // Setter --> To Set Value to the Variable
    //State Variable is Created; Default Value Undefined
    const [Name,setName] = useState();
    const [Mobile,setMobile] = useState("");
    const [Password,setPassword] = useState(""); 


    // Clicking button will return the constant below
    const buttonClick = () => {
        console.log("This is React Button", Name, Password, Mobile); // Access Value from useState
        if (Name == undefined || Name == "") {
            alert ("Why is your name empty");
        } else if (Password == undefined || Password == "") {
            alert ("Why is your password empty");
        } else if (Mobile == undefined || Mobile == "") {
            alert ("Why is your Mobile No. empty");
        } else {
            return;
        }
    }

    const SpringBootAPI = () => {
        fetch("http:localhost:8080/message")
        .then(res => res.json())
        .then(res2 => {
            console.log(res2);
        })
    }

    // Text Input will print console log
    const changeText = (inputObj) => {
        let val = inputObj.target.value; // Get Value
        // console.log("Hello World", val);
        setName(val);
    }

    return(
        <div>
            <Header/>
            <h1> PostAPIReact </h1>

            {/* (e) is for entire input box, works same as documentgetelementbyid, need to convert to JSON */}
            <div>
                <input onChange={(e)=>changeText(e)} placeholder="Enter Name"></input>
                <input onChange={(e)=>setPassword(e.target.value)} type="password" placeholder="Enter Password"></input>
                <input onChange={(e)=>setMobile(e.target.value)} placeholder="Enter Mobile No."></input>
                <button className = "button" onClick={buttonClick}>Click Here!</button>
                <button className = "button" onClick={SpringBootAPI}>SpringBootAPI</button>

            </div>
            <h1>{Name} {Password} {Mobile}</h1>
            <Footer/>
        </div>
    )
}

// We need to export this component to others
// Exporting the function for use in other components, we can only Export on the function here
export default PostAPI;