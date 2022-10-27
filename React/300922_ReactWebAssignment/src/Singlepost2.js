import Header from './Header';
import Footer from './Footer';
import React from 'react';
import {Link} from 'react-router-dom';
import Data from './Data';
import Sidebar from './Sidebar';

// Importing Header, defining component from "Header"

const Singlepost2 = () => {
    const Post2 = Data.find((Post2) => Post2.ID == 2);

    // Objects Parsed over from Data.js
    const {ImageBig2, Title2, Content2, Content2Extra, Name2, DatePost2, MonthName} = Post2;
    const DateFormat = new Date(DatePost2);
    const Month = MonthName[DateFormat.getMonth()];
    const Day = DateFormat.getDate();
    const Year = DateFormat.getFullYear();

    return (
    <>
    <Header/>
    <div id="page">
        <div id="body">
			<div class="header">
				<div>
					<h1>Single Post</h1>
				</div>
			</div>
			<div class="singlepost">
				<div class="featured">
					<img src = {ImageBig2} alt=""/>
					<h1> {Title2} </h1>
					<span>By {Name2} on {Month} {Day}, {Year}</span>
					<p>{Content2}</p>
					<p>{Content2Extra}</p>
					<Link to="/Blogs" class="load"> back to blog </Link>
				</div>
				<Sidebar/>
			</div>
		</div>
    </div>
    <Footer/>
    </>
    )
}

// We need to export this component to others
// Exporting the function for use in other components, we can only Export on the function here
export default Singlepost2;