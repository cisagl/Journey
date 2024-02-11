const Footer = () => { 
    return (
        <footer className="bg mt-5">
      <div className="container">
        <img src="/images/logo.png" alt="" />
        <div className="row">
          Lorem ipsum dolor sit amet consectetur, adipisicing elit. Consequuntur
          quos non eaque sequi fuga animi ipsam exercitationem vitae,
          perspiciatis maxime tempore, doloremque dicta dolorem ab labore nisi
          debitis dignissimos soluta porro quae delectus et odit nostrum optio!
          Omnis eum eos in facilis ad tempore cumque id accusantium eaque
        </div>
        <div className="row mt-3">
          <div className="col-md-3 col-sm-3 footerLi">
            <ul>
              <li>
                <h3><b>Information</b></h3>
              </li>
              <li>About Us</li>
              <li>Classes</li>
              <li>Blog</li>
              <li>Contact</li>
            </ul>
          </div>
          <div className="col-md-3 col-sm-3 footerLi">
            <ul>
              <li>
                <h3><b>Helpful Links</b></h3>
              </li>
              <li>Services</li>
              <li>Supports</li>
              <li>Terms & Conditions</li>
              <li>Privacy Policy</li>
            </ul>
          </div>
        </div>
      </div>
    </footer>
    );
    }

export default Footer;