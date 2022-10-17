import Header from './Header';
import Footer from './Footer';
import './Page.css'
import React, {useState} from 'react';
import { useNavigate } from 'react-router-dom';

function Login() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [resjson, setResjson] = useState("");
    let navigate = useNavigate();

    const ChgEmail = event => {
        setEmail(event.target.value);
    }

    const ChgPassword = event => {
        setPassword(event.target.value);
    }

    let userId = localStorage.getItem("userId");
    let token = localStorage.getItem("token");

    const submitbutton = event => {
        console.log(email, password);
        if (email == undefined || email === "") {
            alert("Your Email is Empty/Undefined");
        } else if (password == undefined || password === "") {
            alert("Your Password is Empty/Undefined")
        } else {
            fetch("http://localhost:8080/UserLogin", {
            method: "POST",
            headers: {
                "content-type": "application/json",
                "token":token,
                "userId":userId
            },
            body: JSON.stringify({
                "email": email,
                "password": password
            }),
        }   
        ).then(res => res.json())
        .then(res2 => {
            localStorage.setItem ("Response", JSON.stringify(res2));
            localStorage.setItem ("Token", res2['token']);
            localStorage.setItem ("UserID", res2['id']);
            navigate("/PostAPIReact");
            console.log(res2);
        }).catch(err => alert("Error when you Logged In"))
        // Error.JSON --> (alert("Error when Login"))
        }
    } 
        
        return (
            <div>
                <Header/>
                <h1> The Spring Boot Login Page </h1>
                <div>
                    <label> Email </label>
                    <input type = "text" value = {email}
                    onChange = {ChgEmail} 
                    placeholder = "Enter Your Email Here" />
                </div>
                <div>
                    <label> Password </label>
                    <input type = "password" value = {password}
                    onChange = {ChgPassword} 
                    placeholder = "Enter Your Password" />
                </div>
                <div>
                    <label></label>
                    <input type = "button" className = "button" 
                    value = "Submit"
                    onClick={submitbutton} />
                </div>
                <div id ="response">{resjson}</div>
                <Footer/>
            </div>
        )
    }

export default Login;