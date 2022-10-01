import Header from "./Header";
import Footer from "./Footer";
import Data from './Data';
import Sidebar from "./Sidebar";

// Retrieving objects that has been declared in 'Data.js'
const Blogs = () => {
	
	// Finding Data based on the ID objects that has been declared
	const Post = Data.find((Post) => Post.ID == 1);
	const Post2 = Data.find((Post2) => Post2.ID == 2);

	// Retrieving Objects declared in ID 1 and ID 2
	const {ImageSmall,  Title, ShortContent, Name, MonthName, DatePost} = Post;
	const {ImageSmall2, Title2, ShortContent2, Name2, DatePost2} = Post2;

	// Formatting the Date styles of dd-mm-yyyy into a proper format
	const DateFormat = new Date(DatePost);
    const Month = MonthName[DateFormat.getMonth()];
    const Day = DateFormat.getDate();
    const Year = DateFormat.getFullYear();
	
	const DateFormat2 = new Date(DatePost2);
	const Month2 = MonthName[DateFormat2.getMonth()];
	const Day2 = DateFormat2.getDate();
    const Year2 = DateFormat2.getFullYear();

	return (
	<>
    <Header/>
    <div id="body">
    <div class="header">
		<div>
			<h1>Blogs</h1>
		</div>
	</div>
    <div class="blog">
				<div class="featured">
					<ul>
						<li>
							<img src={ImageSmall} alt=""/>
							<div>
								<h1>{Title}</h1>
								<span>By {Name} on {Month} {Day}, {Year}</span>
								<p>{ShortContent}...</p>
								<a href="Singlepost" class="more">Read More</a>
							</div>
						</li>
						<li>
							<img src={ImageSmall2} alt=""/>
							<div>
								<h1>{Title2}</h1>
								<span>By {Name2} on {Month2} {Day2}, {Year2}</span>
								<p>{ShortContent2}...</p>
								<a href="Singlepost2" class="more">Read More</a>
							</div>
						</li>
					</ul>
					<a href="blog.html" class="load">Load More</a>
				</div>
				<Sidebar/>
			</div>
    </div>
    <Footer/>    
    </>
	)
}

export default Blogs;