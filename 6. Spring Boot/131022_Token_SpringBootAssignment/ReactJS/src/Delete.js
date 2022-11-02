import Header from './Header';
import Footer from './Footer';
import './Page.css'
import React, {useState} from 'react';

function Delete() {
    const [userID, setUserID] = useState("leehsienloong@gmail.com");


    const submitbutton = event => {
        console.log(userID);
        if (userID == "" || userID == undefined) {
            alert("Please provide Target Email");
        } else {
            fetch("http://localhost:8080/Delete", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                "email": userID
            }),
        }   
        ).then(res => res.json())
        .then(res2 => {
            if(res2.status)
            console.log(res2); alert(res2.message)
        }).catch(err => alert(err))
    }
  }
        return (
            <div>
                <Header/>
                <h1> Spring Boot Delete Page </h1>
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
                    <label></label>
                    <input type = "button" className = "button" id = "SubmitButton" value = "Delete"
                    onClick={submitbutton} />
                </div>
                <Footer/>
            </div>
        )
    
        }

export default Delete;