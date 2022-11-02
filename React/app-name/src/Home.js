import Footer from "./Footer";
import Header from "./Header";
import './App.css'
import { useState } from "react"; //useState comes from the React Library

// Import React State --> If changes happens in variable or input components --> Auto updates the Variable
// You would have to create connections between the function and button clicked
// Using Getters and Setters; Getter = Getting value from Variable, Setter = Sets the value
// [Getter, Setter]
// () => {}: Error Function without Argument; (a,b) => {}: Error Function with Argument

// HTML to React: React State --> useState();
// 1) const [var_name, setMethod] = useState();

// 2) Create Text box in HTML with attribute onChange ={(e) => setMethod(e.target.value)}
// 3) Create an arrowFunction with argument
// 4) Const inputFn = (e) => {
//     let value = e.target.value;
// }
// 5) setMethod(value) ; Updates the Value from the Textbox to React Variable, Value will be assigned to the Getter Variable

function Home() {
    const [email, setEmail] = useState(); // Creating the State Variable; Default Value is Undefined
    const [password, setPassword]  = useState(""); //Default value is Empty
    const [mobile, setMobile]  = useState(""); //Default value is Empty
    const [userList, setUserList] = useState([]); // Declaring as an Empty Array to define the map for the GetAPIResponse
    // If useState() you will be iterating on an undefined map which will display as unknown
    let name = "This is a Variable";
    // When we want to update the React UI dynamically, we need state variables; Connection between the UI and the React Framework
    
    let peopleList = [
        {"name": "Alex", "age": 26},
        {"name": "Benjamin", "age": 29},
        {"name": "John", "age": 24},
        {"name": "Jasper", "age": 24},
        {"name": "Jack", "age": 25},
    ];

    // Error function Syntax () => {}; Functional Component
    // Constant --> React; Function --> Core JavaScript without React
    // 

    const GetAPIResponse = (page_no) => {
        fetch ("https://reqres.in/api/users?page=" +page_no) //Fetch Method and parse it as an argument (Argument can be any)
        .then(res => res.json()) //
        .then(res2 => {
            setUserList(res2['data']); //data (firstname, email, id etc.) is exist and stored in the server API Response
            console.log(res2);
        } )
    }

    // The Console.Log automatically trigger the function as I am changing value in the TextBox
    const changeText = () => {
        console.log("Text is Changing");
    }

    const textChange =(ObjInput) => {
        let value = ObjInput.target.value; // Getting the value from the Input; target.value needed to use in order to access Object in the value
        console.log("Text is Changing", value);
        setPassword(value); // "value" will be set to the Password variable
        // setEmail(value); // "value" will be set to the Password variable
    }

    const button = () => { // works without calling explicitly
        console.log ("The Button is Clicked", password); // Accessing the value from the State
        console.log ("The Button is Clicked", email); // Accessing the value from the State
        console.log (email, password, mobile);
        if (email == undefined || email == "") {
            alert("Email should not be empty");
        }if (password == undefined || password == "") { //By right should not be undefined as the useState has initialised as Empty Strings
            alert("Password should not be empty");
        }if (mobile == undefined || mobile == "") {
            alert("Mobile should not be empty");
        }
    }

    const showLastName = (Obj) => { // Create Object
        console.log(Obj);
        console.log(Obj.last_name);
        alert(Obj.last_name);
    }

    return (
        <div>
            <Header/>
            <h2> {name} </h2>
            <ul>
                {
                    peopleList.map((obj,index) => { //index = position; obj = entire row of the objects
                        return <li> {obj.name} -- {obj.age} </li> // it is a key value pair
                    }) // showing an array of objects
                    // Integrate API using the same structure
                }
            </ul>
            <div>
                {
                    peopleList.map((obj,index) => { //index = position; obj = entire row of the objects
                        return <li> <span className="peoplename">{obj.name} </span> -- {obj.age} </li> // it is a key value pair
                    }) // showing an array of objects
                    // Integrate API using the same structure
                    // We can only return only one parent element
                }
            </div>
            <input type = "text" onChange={(e) => setEmail(e.target.value)} placeholder="Enter Email"/> 
            {/* Instead of Calling Functions, we can also set the variable to the Obj Target Value; (e) value => function (e.target.value)*/}
            {/* It will connect the React to the Text Change, when State is updated the React UI will also get updated */}
            {/* (e) => Defines the entire parameters (a substitute for document.getElementById("input_id"). value); (e) is an object of the entire specific input box, specific only for this element */}
            <input type = "text" onChange={(e) => textChange(e)} placeholder="Enter Password"/>
            <button onClick={button}> Click Me for Alert </button> 
            {/* Syntax for enabling the OnClick, We want to register the Function and not call the function button() */}
            
            <input onChange={(e) => setMobile(e.target.value)}  type="mobile_no" placeholder="Enter Mobile" />


            <h1>{email}</h1>
            <h1>{password}</h1>

            {/* Parses the page numbers as an argument */}
            <select onChange={(e) => GetAPIResponse(e.target.value)}> 
                <option value="1"> Page 1 </option>
                <option value="2"> Page 2 </option>
                <option value="3"> Page 3 </option>
                <option value="4"> Page 4 </option>
                <option value="5"> Page 5 </option>
            </select>

            <div> <button onClick={GetAPIResponse}> Click to Get API Response </button></div>
            <div>
                {/* First Solution */}
                {/* Using Ternary Operator shortened 'If' Condition --> (condition == true) ? execute:"" (false = empty string)
                if (True) {
                    Execute
                } else {
                    Execute
                }
                } */}
                {/* Whenever we have React Map Iteration, we should add one more object called Key (unique value for React Iteration)
                React Compiler identify Unique key property to avoid the React Compiler Warning*/}
                {userList.length <= 0 ? <h1> No User Found </h1>:''}
                {
                    userList.map((userObj,index) => { //index = position; obj = entire row of the objects
                        return <li onClick={() => showLastName(userObj)}  key={index}> {userObj.first_name} -- {userObj.email} -- {userObj.id}</li> // it is a key value pair
                    }) // showing an array of objects
                    // Integrate API using the same structure
                    // showLastName through Object Argument
                }
                
                
                {/* { // Second Solution: When variable has value then it will got to the second condition to map
                    userList && userList.map((userObj,index) => { //index = position; obj = entire row of the objects
                        return <li> {userObj.first_name} -- {userObj.email} -- {userObj.id}</li> // it is a key value pair
                    }) // showing an array of objects
                    // Integrate API using the same structure
                } */}
            </div>
            <Footer/>
        </div>
    )

}

export default Home;