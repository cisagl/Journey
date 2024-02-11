const Eighththird = () => {
    return (
        <div className="col-12 mt-5">
        <div className="row">
          <div className="col-sm-12 col-md-6">
            <div className="row">
              <div className="col-4">
                <h4>Mobile Number</h4>
                <h5>+135 773 321 4442</h5>
              </div>
              <div className="col-4">
                <h4>Email Address</h4>
                <h5>demo@demo.com</h5>
              </div>
            </div>
            <div className="row">
              <div className="col-12 mt-2">
                <h3>Make An Appointment</h3>
              </div>
            </div>
            <div className="row mt-4">
              <div className="col">
                <input className="inputbox" type="text" placeholder=" Your Name" />
              </div>
            </div>
            <div className="row">
              <div className="col">
                <input className="inputbox" type="text" placeholder=" Your Email" />
              </div>
            </div>
            <div className="row">
              <div className="col">
                <textarea
                  className="inputbox inputbox-message"
                  name="msg"
                  id=""
                  cols="30"
                  rows="10"
                  placeholder=" Your Message"
                ></textarea>
              </div>
            </div>
          </div>
          <div className="col-sm-12 col-md-6">
            <iframe
              src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d391772.10823716753!2d32.4331202601417!3d39.90290988910752!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x14d347d520732db1%3A0xbdc57b0c0842b8d!2sAnkara!5e0!3m2!1str!2str!4v1706705164658!5m2!1str!2str"
              width="100%"
              height="450"
              style={{border: "0"}}
              allowfullscreen=""
              loading="lazy"
            ></iframe>
          </div>
        </div>
      </div>
    );
    }

export default Eighththird;