import Header from './Header';
import { useState } from 'react';
import Footer from './Footer';
import './Page.css'

// Importing Header, defining component from "Header"
// React State
function Home(){
    let name = 'These are my immediate family members';

    // Getter --> To Get Value from Variable
    // Setter --> To Set Value to the Variable
    const [Name,setName] = useState(); //State Variable is Created; Default Value Undefined
    const [Mobile,setMobile] = useState(""); //State Variable is Created; Default Value Empty
    const [Password,setPassword] = useState(""); //State Variable is Created; Default Value Empty
    const [UserList,setUserList] = useState([]); //Creating an empty Array to ensure code is executable

    // Use Data Binding Concept = Binding Variable into our React Page
    let familyList = [
        {"Name": "Abdul Rahman", "Age": 61},
        {"Name": "Suraya", "Age": 58},
        {"Name": "Nuraishah", "Age": 33},
        {"Name": "Nurhairi", "Age": 28},
    ];

    const getAPIResponse = (pageNo) => {
        fetch("https://reqres.in/api/users?page=" +pageNo)
        .then(res=>res.json())
        .then(res2=>{
            setUserList(res2['data']); //Data exists in Server Response
            console.log(res2);
        })
    }

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

    // Text Input will print console log
    const changeText = (inputObj) => {
        let val = inputObj.target.value; // Get Value
        // console.log("Hello World", val);
        setName(val);
    }

    const showPerson = (obj) => {

    }

    return(
        <div>
            <Header/>
            <h1> My Family Tree </h1>
            <article>{name}</article>

            {/* Family List under return, it returns as an {Object} & Statements. Map creates new array with results of calling a function every array element */}
            <ul>
                {
                familyList.map((familyObj,idx)=>{
                    return <li key = {idx}><span className='familyName'>{familyObj.Name}</span> -- {familyObj.Age} years old</li>
                })
                }
            </ul>
            <div>
                <button className = "button" onClick={getAPIResponse}>Click to Get API Response</button>
                <select className = "button2" onChange={(e)=>getAPIResponse(e.target.value)}>
                    <option value="1"> Page 1 </option>
                    <option value="2"> Page 2 </option>
                    <option value="3"> Page 3 </option>
                    <option value="4"> Page 4 </option>
                </select>
            <div>
                {
                (UserList && UserList.length <= 0)? 
                <h1>No User is Found</h1>:''
                }

                {/* If (cond == true)?"Execute" */}

                {
                    UserList && UserList.map((userObj, idx) => {
                        return <div onClick={()=>showPerson(userObj)}
                        key = {idx} > {userObj.first_name} {userObj.email} {userObj.id} </div>
                    })
                    
                }
            </div>
            </div>
            <div>
                {
                UserList.map((userObj, idx)=>{
                    return<div key = {idx}> 
                    <span className='familyName2'>{userObj.first_name}</span> {userObj.last_name} Email: {userObj.email}
                    <img src = {userObj.avatar}></img>
                    </div>
                })
                }          
            </div> 

            {/* (e) is for entire input box, works same as documentgetelementbyid, need to convert to JSON */}

            <div>
                <input onChange={(e)=>changeText(e)} placeholder="Enter Name"></input>
                <input onChange={(e)=>setPassword(e.target.value)} type="password" placeholder="Enter Password"></input>
                <input onChange={(e)=>setMobile(e.target.value)} placeholder="Enter Mobile No."></input>
                <button className = "button" onClick={buttonClick}>Click Here!</button>
            </div>
            <h1>{Name} {Password} {Mobile}</h1>
        

            <Footer/>
        </div>
    )
}

// We need to export this component to others
// Exporting the function for use in other components, we can only Export on the function here
export default Home;

// React State --> useState();
// const [varName, setMethod] = useState();

// Create Text box in HTML with attribute onChange = (e) => {inputFunction};
// Create Text box in HTML with attribute onChange = {(e) => setMethod(e.target.value)};

// Constant Input_Function = (e) => {let val = e.target.value;}

// Setmethod(val); --> Update Value Text box to React Variable

// {
//     UserList && UserList.map((userObj, idx)=>{
//         return<div key = {idx}> <span className='familyName2'>{userObj.first_name}</span> {userObj.last_name} Email: {userObj.email}</div>
//     })
// }