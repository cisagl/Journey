const Fourth = () => {
  return (
    <section className="container">
      <div className="col-12 mt-5 mt-sm-0">
        <div className="row titlePadding">
          <div className="col">
            <div className="col-12">
              <h1 className="titles" style={{textAlign: "left"}}>BMI Calculator</h1>
              <p>
                <br />
                Lorem ipsum dolor sit amet consectetur adipisicing elit.
                Debitis, illum. Lorem ipsum dolor sit amet consectetur,
                adipisicing elit. Dolor, omnis!
              </p>
              <br />
              <p>
                Lorem ipsum dolor sit amet consectetur adipisicing elit.
                Debitis, illum. Lorem ipsum dolor sit amet consectetur,
                adipisicing elit. Dolor, omnis!
              </p>
            </div>
            <div className="row">
              <div className="col-sm-12 col-md-4">
                <input type="number" id="cm" placeholder="Height" />
              </div>
              <div className="col-sm-12 col-md-4">
                <input type="number" id="kg" placeholder="Weight" />
              </div>
            </div>
            <br />
          </div>
          <div
            className="col bmiImg d-flex justify-content-center"
            style={{flexDirection: "column"}}
          >
            <img src="/images/bmi-index.jpg" alt="" />
            <div className="arrow"></div>
          </div>
        </div>
      </div>
    </section>
  );
}

export default Fourth;