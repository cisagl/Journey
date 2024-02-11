const Mainfirst = () => { 
    return (
    <section className="container maindiv">
        <div>
            <h4 className="powerfull">&nbsp; POWERFULL &nbsp;</h4>
            <h1 className="pt-1 text-white mainh1 d-none d-md-block">
            Group <br />
            Pratice <br />
            With Trainer
            </h1>

            <h1 className="pt-1 text-white mainh1 d-none d-sm-block d-md-none">
            Group Pratice With Trainer
            </h1>

            <p className="mainp">
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Cum, sequi.
            Velit dicta consequuntur accusamus ex eum ullam, aliquam
            </p>

            <div className="mainbtns d-none d-md-block">
                <button className="signupbtn">Sign Up</button>
                <button className="detailsbtn">Details</button>
            </div>

            <div className="mainbtns d-none d-sm-block d-md-none">
                <button className="signupbtn" style={{width: "100%"}}>Sign Up</button>
                <button className="detailsbtn" style={{width: "100%"}}>Details</button>
            </div>
        </div>
    </section>
    );
};

export default Mainfirst;