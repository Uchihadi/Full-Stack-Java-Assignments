import Header from './Header';
import React from 'react';
// import Footer from './Footer';
import './Page.css'
import Input1 from './Input1';
import Input2 from './Input2';
import GetAPI2 from './GetAPI2';
import { stripBasename } from '@remix-run/router';

// Importing Header, defining component from "Header"
// React State

// const handle = () => {
//         localStorage.setItem('Name', Name);
//         localStorage.setItem('Password', Password);
// }

class Qn1 extends React.Component{

    constructor() {
        super(); // Calling Parent Class Constructor
        this.state = {
            "Name":"Hadi",
            "Password": "",
            "Age": 26,
            "City": "Singapore",
            "Country": "Singapore",
            "People":[],
            "Users":[],
            "headerClass": "",
            "showInput1":false,
            "showInput2":false,
            "showAPI":false,

        }
        this.getAPIResponse(1); //Calling the API when Page is Loading
    }

    validate = () => {
        if(this.state.name == ""){
            alert("Name is Empty");
        } else if (this.state.password == "") {
            alert("Password is Empty");
        } else {
            alert("Everything is OK")
        }
    }

    getAPIResponse = (pageNo) => {
        fetch("https//reqres.in/api/users?page=" +pageNo)
        .then(res => res.json)
        .then(res2=>{
            this.setState({"List":res2['data']}); // Updating server response to the State
            console.log(res2);
        })
    }

    postAPIResponse = (pageNo) => {
        fetch("https//reqres.in/api/users?page=" +pageNo)
        .then(res => res.json)
        .then(res2=>{
            this.setState({"List":res2['data']}); // Updating server response to the State
            console.log(res2);
        })
    }

    // Return HTML Elements from this Class Components by declaring render() first by connecting the bridges
    render(){
        return (
        <div>
            <Header CurrentMenu='Qn1' />
            <h2> i) Calling Server with GET & POST API </h2>
            <h3> ii) GET API Response has to share with Functional Component & Load</h3>
            
            <div>                
                <button className = "button" onClick = {() => this.setState({'showAPI':true})}>Retrieve API</button>
                <button className = "button3" onClick = {() => this.setState({'showAPI':false})}>Clear API</button>
                {this.state.showAPI?<GetAPI2/>:null}
            </div>

            <h3> iii) Highlight Menu based on Current Page (See Header) </h3>

            <h3> iv) Conditional Style in Class Component Using Array </h3>
            
            <div>
                <button className = "button" onClick = {() => this.setState({'showInput1':true})}>Show Hello World!</button>
                <button className = "button" onClick = {() => this.setState({'showInput2':true})}>Show My Name</button>
                <button className = "button3" onClick = {() => this.setState({'showInput1':false})}>Clear Hello World!</button>
                <button className = "button3" onClick = {() => this.setState({'showInput2':false})}>Clear My Name</button>
                {this.state.showInput1?<Input1/>:null}
                {this.state.showInput2?<Input2/>:null}
            </div>            
        </div >
    )
    }  
}

// We need to export this component to others
// Exporting the function for use in other components, we can only Export on the function here
export default Qn1;