import Header from './Header';
import Footer from './Footer';
import React from 'react';
import { Link, useParams } from 'react-router-dom';
import Data from './Data';

// Importing Header, defining component from "Header"

const Sidebar = () => {
    const Post = Data.find((Post) => Post.ID === 3);

    // Objects Parsed over from Data.js
    const {ImageSidebar, Title3, ShortContent3, Name3, DatePost3, MonthName} = Post;
    const DateFormat = new Date(DatePost3);
    const Month = MonthName[DateFormat.getMonth()];
    const Day = DateFormat.getDate();
    const Year = DateFormat.getFullYear();

    return (
    <>
	<div class="sidebar">
		<h1>Recent Posts</h1>
		<img src= {ImageSidebar} alt=""/>
		<h2> {Title3} </h2>
		<span>By {Name3} on {Month} {Day}, {Year}</span>
		<p>{ShortContent3}</p>
		<a href="Singlepost" class="more">Read More</a>
	</div>
    </>
    )
}

// We need to export this component to others
// Exporting the function for use in other components, we can only Export on the function here
export default Sidebar;