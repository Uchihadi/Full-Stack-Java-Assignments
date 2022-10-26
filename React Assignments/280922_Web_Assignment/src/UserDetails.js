import Header from './Header';
import { useState } from 'react';
import Footer from './Footer';
import './Page.css'

function UserDetails(){
    
    const getAPIResponse = (pageNo) => {
        fetch("https://reqres.in/api/users?page=" +pageNo)
        .then(result => result.json())
        .then(result => {
                setUserList(result['data']);
                console.log(result);
        })
    }

    const[UserList, setUserList] = useState("");
    const[firstName, setFirstName] = useState("");
    const[lastName, setLastName] = useState("");
    const[email, setEmail] = useState("");
    const[avatar, setAvatar] = useState("");
    const[id, setID] = useState("");

    //set counter for clearing details box
    const[sum, setSum] = useState("");

    //get details of employee
    const getDetails = (Users)=>{
        setFirstName(Users.first_name);
        setLastName(Users.last_name);
        setID(Users.id);
        setEmail(Users.email);
        setAvatar(Users.avatar);
        setSum(1);
    }

    //clear details box
    const clearDetails = () => {
        setUserList("");
        setFirstName("");
        setLastName("");
        setID("");
        setEmail("");
        setAvatar("");
    }

    return(
        <div>
            <Header CurrentMenu = 'UserDetails'/>
            <h1>Current User List</h1>
            <div className='box'>
            <p className='Details'> Hello my name is: {firstName} {lastName}</p>
            <p className='Details'> My ID: {id}</p>
            <p className='Details'> You can contact me at <a href={email}>{email}</a></p>
            
            <p className='Details'><img src = {avatar}></img></p> 
            {
                sum == 1?<button className='button2' onClick={clearDetails}>Clear</button>:'' 
            }
            </div> 
        
        Page No: <select className = "button" onChange={(e)=>getAPIResponse(e.target.value)}>
            <option defaultValue = {""} hidden></option>
            <option value="1">Page 1</option>
            <option value="2">Page 2</option>
            <option value="3">Page 3</option>
        </select>
        
        
        {(UserList && UserList.length <= 0)? <h2> No User in this Page! </h2>:
            <table>
            {
                UserList && UserList.map((User, index)=>{
                    return <td onClick = {() => getDetails(User)} key = {index}>
                        <th>{User.first_name}</th>
                        <th><img src={User.avatar}/></th>
                        </td>
                })
            }
            </table>
        }
        <Footer/>
        </div>
    )
}

export default UserDetails;