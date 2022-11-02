import { useState } from "react";
import Footer from "./Footer";
import Header from "./Header";
import './App.css';

function Contact() {
    let name = "This is Variable";
    const [message, setMessage] = useState("");
    const [error, setError] = useState("");

    const validate = () => {
        if (message == "") {
            setError(true);
        }else{
            setError(false);
        }
    }
    
    return (
    <div>
        <Header/>
        <h1> This is the Heading of the Contact </h1>
        {/* Data Binding in React */}
        {/* When Page Loads, Error is False; Only When You Click then it will render Error to be True */}
        <input className={error ? 'errorClass':""} onChange = {(e) => setMessage(e.target.value)} 
        type="Enter Message" placeholder="Enter Message"/>
        <button onClick={validate}> Click for Validation </button>
        
        {error ? <span className="errorClass">Please Enter</span>:""}
        <Footer/>
    </div>
    
    )
}

export default Contact;

