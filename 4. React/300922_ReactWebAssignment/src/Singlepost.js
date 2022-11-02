import Header from './Header';
import Footer from './Footer';
import React from 'react';
import {Link} from 'react-router-dom';
import Data from './Data';
import Sidebar from './Sidebar';

// Importing Header, defining component from "Header"

const Singlepost = () => {
    const Post = Data.find((Post) => Post.ID === 1);

    // Objects Parsed over from Data.js
    const {ImageSmall, ImageBig, Title, Content, ContentExtra, Name, DatePost, MonthName} = Post;
    const DateFormat = new Date(DatePost);
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
					<img src = {ImageBig || ImageSmall} alt=""/>
					<h1> {Title} </h1>
					<span>By {Name} on {Month} {Day}, {Year}</span>
					<p>{Content}</p>
					<p>{ContentExtra}</p>
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
export default Singlepost;