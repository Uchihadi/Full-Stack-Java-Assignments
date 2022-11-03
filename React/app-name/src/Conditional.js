import Footer from './Footer';
import Header from './Header';
import { useState } from 'react';
import './App.css';


function Conditional() {
    let name = 'My Immediate Family';

    // Use Data Binding Concept = Binding Variable into our React Page
    let familyList = [
        {"Name": "Abdul Rahman", "Age": 61},
        {"Name": "Suraya", "Age": 58},
        {"Name": "Nuraishah", "Age": 33},
        {"Name": "Nurhairi", "Age": 28},
        {"Name": "Nurhadi", "Age": 26},
    ];

    const [headerClassName, setHeaderClassName] = useState('header');
    
    return(
        <div>
            <Header/>
            
            {/* Data Binding in React Application. Set className to the Get Object */}
            <h1> Conditional </h1>
            <h2 className={headerClassName}>{name}</h2>

            {/* Button onClick for colour; onClick () => setHeader so that the function does not load with the pages */}
            <button className="button" onClick={()=>setHeaderClassName('header1')}> Header 1 Class</button>
            <button className="button2" onClick={()=>setHeaderClassName('header2')}> Header 2 Class</button>
            <button className="button3" onClick={()=>setHeaderClassName('header3')}> Header 3 Class</button>
            {/* The empty argument is so that the colour will only change when the button has been clicked, basically the button click is an argument */}
            {/* If there is no argument, then the function will be called as the Page reloads */}

             {/* Family List under return, it returns as an {Object} & Statements. Map creates new array with results of calling a function every array element */}
             <ul>
                {
                familyList.map((familyObj,idx) => {
                    return <li key = {idx} className={familyObj.Age > 50 ? 'header4':"header5"}>{familyObj.Name} : {familyObj.Age} years old</li>
                })
                }
            </ul>

            <div className='innerForm'>
                
            </div> 
            <Footer/>
            {/* Returning variable from {name} declared earlier using Data Binding Concept */}
        </div>
    )
}

// Exporting the function for use in other components, we can only Export on the function here
export default Conditional;