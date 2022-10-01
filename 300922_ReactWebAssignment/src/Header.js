function Header() {
    
    return (
    <header>
      <div id = "page">
         <div id="header">
			<div>
				<a href="index.html" class="logo"><img src="images/logo.png" alt=""/></a>
				<ul id="navigation">
					<li class="selected">
						<a href="Home">Home</a>
					</li>
					<li class="menu">
						<a href="About">About</a>
						<ul class="primary">
							<li>
								<a href="Products">Products</a>
							</li>
						</ul>
					</li>
					<li class="menu">
						<a href="Blogs">Blogs</a>
						<ul class="secondary">
							<li>
								<a href="Singlepost">Strawberry</a>
							</li>
							<li>
								<a href="Singlepost2">Berries</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="Contact">Contact</a>
					</li>
				</ul>
			</div>
         </div>
      </div>
    </header>
    );
}

// Exporting Header function to be used in App.JS
export default Header;