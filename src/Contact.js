import Header from './Header';
import Footer from './Footer';
import React, {useRef} from 'react';

// Importing Header, defining component from "Header"

const Contact = () => {
   const ContactData = [
      {
         Address: "9 DBS BUILDING, CHANGI BUSINESS PARK",
         AddressNote: "If you are having problems accessing to this place, please do not hesitate to text us or call our Customer Service No.",
         Feedback: "WE WOULD LOVE TO HEAR FROM YOU",
         FeedbackNote: "Please give us feedback on how we can serve you better for future considerations."
      }
   ]

   const Post = ContactData.find((Post) => Post);
   const {Address, AddressNote, Feedback, FeedbackNote} = Post;

    return(
    <>
    <Header/>
    <div id="page">
    <div id="body" class="contact">
			<div class="header">
				<div>
					<h1>Contact</h1>
				</div>
			</div>
			<div class="body">
				<div>
					<div>
						<img src="images/check-in.png" alt=""/>
						<h1> {Address} </h1>
						<p> {AddressNote} </p>
					</div>
				</div>
			</div>
			<div class="footer">
				<div class="contact">
					<h1>INQUIRY FORM</h1>
					<form action="index.html">
						<input type="text" name="Name" value="Name" onblur="this.value=!this.value?'Name':this.value;" onfocus="this.select()" onclick="this.value='';"/>
						<input type="text" name="Email" value="Email" onblur="this.value=!this.value?'Email':this.value;" onfocus="this.select()" onclick="this.value='';"/>
						<input type="text" name="Subject" value="Subject" onblur="this.value=!this.value?'Subject':this.value;" onfocus="this.select()" onclick="this.value='';"/>
						<textarea name="meassage" cols="50" rows="7">Share your thoughts</textarea>
						<input type="submit" value="Send" id="submit"/>
					</form>
				</div>
				<div class="section">
					<h1>{Feedback}</h1>
					<p>{FeedbackNote}</p>
				</div>
			</div>
		</div>
    </div>
    <Footer/>
    </>   
    )
}

// Exporting the function for use in other components, we can only Export on the function here
export default Contact;