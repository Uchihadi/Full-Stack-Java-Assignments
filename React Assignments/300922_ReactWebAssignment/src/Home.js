// Importing both Header and Footer to the About Page
import Header from './Header';
import Footer from './Footer';

// Taken from index.html that concerns only the 'Home' section
const Home = () => {
  return (
   <>
   <Header/>
   <div id="body" class="home">
   <div class="header">
			<img src="images/bg-home.jpg" alt=""/>
			<div>
            <a href="Products">Freeze Delight</a>
			</div>
	</div>
   <div class="body">
				<div>
					<div>
						<h1>NEW PRODUCT</h1>
						<h2>The Twist of Healthy Yogurt</h2>
						<p>This website template has been designed by freewebsitetemplates.com for you, for free. You can replace all this text with your own text.</p>
					</div>
					<img src="images/yogurt.jpg" alt=""/>
				</div>
	</div>
   </div>
   <div id="body" class="home">
         <div class="footer">
				<div>
					<ul>
						<li>
							<a href="Products" class="product"></a>
							<h1>PRODUCTS</h1>
						</li>
						<li>
							<a href="About" class="about"></a>
							<h1>OUR STORY</h1>
						</li>
						<li>
							<a href="Products" class="flavor"></a>
							<h1>FLAVORS</h1>
						</li>
						<li>
							<a href="Contact" class="contact"></a>
							<h1>OUR LOCATION</h1>
						</li>
					</ul>
				</div>
			</div>
      </div>
   <Footer/>
   </>
  );
}

export default Home;