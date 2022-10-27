import './Page.css';

function Header() {
    let name = "This is a React Page";
    return( // Return the list to About, Contact and Home
    // Each of the lists below (if pressed) brings you to its own page
    <ul className='FrontPage'>
        <li><a href="Home"> Home </a></li>
        <li><a href="About"> About </a></li>
        <li><a href="Contact"> Contact </a></li>
        <li><a href="Logout"> Logout </a></li>
    </ul>
    )

}

// Exporting Header function to be used in App.JS
export default Header;