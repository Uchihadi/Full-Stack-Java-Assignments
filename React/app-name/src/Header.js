import './Page.css';

function Header() {
    let name = "This is a React Page";
    return( // Return the list to About, Contact and Home
    // Each of the lists below (if pressed) brings you to its own page
    <ul className='FrontPage'>
        <li><a href="PostAPIReact"> PostAPIReact </a></li>
        <li><a href="Conditional"> Conditional </a></li>
        <li><a href="GetAPI"> GetAPI </a></li>
        <li><a href="UserDetails"> User Details </a></li>
        <li><a href="Home"> Home </a></li>
        <li><a href="Contact"> Contact </a></li>
        
    </ul>
    )

}

// Exporting Header function to be used in App.JS
export default Header;