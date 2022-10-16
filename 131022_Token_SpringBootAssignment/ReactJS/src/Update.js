import Header from './Header';
import Footer from './Footer';
import './Page.css'
import React, {useState} from 'react';

function Update() {
    const [userID, setUserID] = useState("");
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [mobile, setMobile] = useState("");
    const [address, setAddress] = useState("");
    
    // const [errorName, setErrorName] = useState("");
    // const [errorEmail, setErrorEmail] = useState("");
    // const [errorPassword, setErrorPassword] = useState("");
    // const [errorAddress, setErrorAddress] = useState("");
    // const [errorMobile, setErrorMobile] = useState ("");

    const ChgName = event => {
        setName(event.target.value);
    }

    const ChgEmail = event => {
        setEmail(event.target.value);
    }

    const ChgPassword = event => {
        setPassword(event.target.value);
    }

    const ChgMobile = event => {
        setMobile(event.target.value);
    }

    const ChgAddress = event => {
        setAddress(event.target.value);
    }

    const submitbutton = event => {
        console.log(userID);
        if (userID == "" || userID == undefined) {
            alert("Please provide your Name here.");
        } else {
            fetch("http://localhost:8080/Update", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                "name": name,
                "email": email,
                "password": password,
                "mobile": mobile,
                "address": address
            }),
        }   
        ).then(res => res.json())
        .then(res2 => {
            if(res2.status)
            console.log(res2); alert(res2.error)
        }).catch(err => alert(err))
    }
  }
        return (
            <div>
                <Header/>
                <h1> Spring Boot Update Page </h1>
                <div>
                    <select onChange={(e)=> setUserID(e.target.value)}>
                    <option value="leehsienloong@gmail.com">leehsienloong@gmail.com</option>
                    <option value="ismailsabri@gmail.com">ismailsabri@gmail.com</option>
                    <option value="jokowidodo@gmail.com">jokowidodo@gmail.com</option>
                    <option value="bongbongmarcos@gmail.com">bongbongmarcos@gmail.com</option>
                    <option value="prayutchanocha@gmail.com">prayutchanocha@gmail.com</option>
                </select>
                </div>
                <div>
                    <label> Email </label>
                    <input type = "text" 
                    value = {email}
                    onChange = {ChgEmail} 
                    placeholder = "Enter Your Email Here" />
                </div>
                <div>
                    <label> Password </label>
                    <input type = "password" 
                    value = {password}
                    onChange = {ChgPassword} 
                    placeholder = "Enter Your Password Here" />
                </div>
                <div>
                    <label></label>
                    <input type = "button" className = "button" id = "SubmitButton" value = "Update"
                    onClick={submitbutton} />
                </div>
                <Footer/>
            </div>
        )
    
        }

export default Update;