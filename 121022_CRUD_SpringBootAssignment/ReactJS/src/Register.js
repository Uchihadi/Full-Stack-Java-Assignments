import Header from './Header';
import Footer from './Footer';
import './Page.css'
import React, {useState} from 'react';

function Register() {
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
        if (name == "" || name == undefined) {
            alert("Please provide your Name here.");
        }else if (email == "" || email == undefined) {
            alert("Your Email is Empty");
        } else if (password == "" || password == undefined) {
            alert("Your Password should not be Empty");
        } else if (mobile == "" || mobile == undefined) {
            alert("Your Mobile No. should not be Empty");
        } else if (address == "" || address == undefined) {
            alert("Your Address should not be Empty");
        } else {
            fetch("http://localhost:8080/Register", {
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
                <h1> The Spring Boot Register Details Page </h1>
                <div>
                    <label> Name </label>
                    <input type = "text" 
                    value = {name}
                    onChange = {ChgName} 
                    placeholder = "Enter Your Name Here" />
                </div>

                <div>
                    <label> Email </label>
                    <input type = "text" 
                    value = {email}
                    onChange = {ChgEmail} 
                    placeholder = "Enter Your Email Here" />
                </div>

                <div>
                    <label> Mobile </label>
                    <input type = "text" 
                    value = {mobile}
                    onChange = {ChgMobile} 
                    placeholder = "Enter Your Mobile Here" />
                </div>

                <div>
                    <label> Address </label>
                    <input type = "text" 
                    value = {address}
                    onChange = {ChgAddress} 
                    placeholder = "Enter Your Address Here" />
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
                    <input type = "button" className = "button" id = "SubmitButton" value = "Register"
                    onClick={submitbutton} />
                </div>
                <Footer/>
            </div>
        )
    
    }

export default Register;