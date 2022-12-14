// Importing both Header and Footer to the About Page
import Header from './Header';
import Footer from './Footer';
import React from 'react';

// Taken from index.html that concerns only the 'Products' section
const Products = () => {
    return(
    <>
    <Header/>
    <div id="body">
    <div class="header">
        <div>
            <h1>Products</h1>
        </div>
	</div>
    <div>
				<ul>
					<li>
						<h1>All Time Classic</h1>
						<p>This website template has been designed by freewebsitetemplates.com for you, for free.</p>
					</li>
					<li>
						<img src="images/kiwi.jpg" alt=""/>
						<h2>Kiwi</h2>
					</li>
					<li>
						<img src="images/mango.jpg" alt=""/>
						<h2>Mango</h2>
					</li>
					<li>
						<img src="images/cantaloupe.jpg" alt=""/>
						<h2>Cantaloupe</h2>
					</li>
				</ul>
				<ul>
					<li>
						<h1>Berry Special</h1>
						<p>This website template has been designed by freewebsitetemplates.com for you, for free.</p>
					</li>
					<li>
						<img src="images/blackberry.jpg" alt=""/>
						<h2>blackberry</h2>
					</li>
					<li>
						<img src="images/strawberry.jpg" alt=""/>
						<h2>Strawberry</h2>
					</li>
					<li>
						<img src="images/blueberry.jpg" alt=""/>
						<h2>BLUEBERRY</h2>
					</li>
				</ul>
				<ul>
					<li>
						<h1>Fruit Blast</h1>
						<p>This website template has been designed by freewebsitetemplates.com for you, for free.</p>
					</li>
					<li>
						<img src="images/grapes.jpg" alt=""/>
						<h2>Grapes</h2>
					</li>
					<li>
						<img src="images/green-apple.jpg" alt=""/>
						<h2>Green Apple</h2>
					</li>
					<li>
						<img src="images/pineapple.jpg" alt=""/>
						<h2>Pineapple</h2>
					</li>
				</ul>
			</div>
    </div>
    <Footer/>
    </>
    )
}

// We need to export this component to others
// Exporting the function for use in other components, we can only Export on the function here
export default Products;