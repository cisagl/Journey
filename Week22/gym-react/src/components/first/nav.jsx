const Nav = () => {
    return ( 
      <div className="fixed-top navnav">
      <nav className="container">
        <div className="navbar">
          <div className="logo">
            <a href="#"><img src="/images/logo.png" alt="logo" /></a>
          </div>

          <div className="links d-none d-md-block">
            <ul className="navbuttons">
              <li><a href="#">Home</a></li>
              <li><a href="#classes">Classes</a></li>
              <li><a href="#trainers">Trainers</a></li>
              <li><a href="#review">Review</a></li>
              <li><a href="#contact">Contact</a></li>
              <li><a href="#" className="joinus">JOIN US</a></li>
            </ul>
          </div>
        </div>
      </nav>
    </div>
    )
}

export default Nav;