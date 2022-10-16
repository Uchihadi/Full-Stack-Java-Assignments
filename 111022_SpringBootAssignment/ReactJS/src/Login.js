import Header from './Header';
import Footer from './Footer';
import './Page.css'
import React, {useState} from 'react';

function Login() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [resjson, setResjson] = useState("");
    const [errorEmail, setErrorEmail] = useState("");
    const [errorPassword, setErrorPassword] = useState("");

    const submitbutton = () => {
        let param = {
            email: email,
            password: password,
        }

        fetch("http://localhost:8080/userLoginParam", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(param)
        })
        .then(res => res.json())
        .then(res => {
            if(res.status)
            console.log(res);
            setResjson(JSON.stringify(res));
        })

        } 
        
        return (
            <div>
                <Header/>
                <h1> The Spring Boot Login Page </h1>
                <div>
                    <label> Email </label>
                    <input type = "text" id = "email" value = {email}
                    onChange = {(e) => setEmail(e.target.value)} 
                    placeholder = "Enter Your Email Here" />
                </div>
                <div>
                    <label> Password </label>
                    <input type = "password" id = "password" value = {password}
                    onChange = {(e) => setPassword(e.target.value)} 
                    placeholder = "Enter Your Password" />
                </div>
                <div>
                    <label></label>
                    <input type = "button" className = "button" id = "SubmitButton" value = "Submit"
                    onClick={submitbutton} />
                </div>
                <div id ="response">{resjson}</div>
                <Footer/>
            </div>
        )
    
    }

export default Login;