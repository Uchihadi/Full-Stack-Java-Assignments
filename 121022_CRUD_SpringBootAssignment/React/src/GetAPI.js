import Header from './Header';
import { useState } from 'react';
import Footer from './Footer';
import './Page.css'

// Importing Header, defining component from "Header"
// React State
function GetAPI(){

    const [UserList,setUserList] = useState([]); //Creating an empty Array to ensure code is executable

    const getAPIResponse = (pageNo) => {
        fetch("https://reqres.in/api/users?page=" +pageNo)
        .then(res=>res.json())
        .then(res2=>{
            setUserList(res2['data']); //Data exists in Server Response
            console.log(res2);
        })
    }

    const postAPIResponse = (pageNo) => {
        fetch("https://reqres.in/api/users?page=" +pageNo)
        .then(res=>res.json())
        .then(res2=>{
            setUserList(res2['data']); //Data exists in Server Response
            console.log(res2);
        })
    }

    const showPerson = (obj) => {

    }

    return(
        <div>
            <Header CurrentMenu='GetAPI'/>
            <h1> Get API </h1>

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
                        key = {idx} > {userObj.first_name} <img src = {userObj.avatar}></img> </div>
                    })
                    
                }
            </div>
            </div>
            
            <Footer/>
        </div>
    )
}

// We need to export this component to others
// Exporting the function for use in other components, we can only Export on the function here
export default GetAPI;