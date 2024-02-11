const Thirdofthird = () => {
  return (
    <div className="col-12 pt-3">
        <div className="row">
            <div className="col-md-12 d-none d-md-block ourclasses oclassB">
                <ul>
                <li><a href="#yoga" id="yoga">Yoga</a></li>
                <li><a href="#group" id="group">Group</a></li>
                <li><a href="#solo" id="solo">Solo</a></li>
                <li><a href="#stretching" id="stretching">Stretching</a></li>
                </ul>
            </div>
      </div>
      <div className="row classesAdd">
        <div className="col-md-6 mt-3 classesExample d-none d-md-block">
          <div className="classesPad">
            <div className="col mt-5">
              <h2 className="lessonTitle">Why are your Yoga?</h2>
              <p className="lessonDesc">
                Lorem ipsum dolor sit amet consectetur adipisicing elit.
                Accusantium praesentium optio reprehenderit minima architecto
                molestiae. Commodi sit voluptas beatae laborum!
              </p>
            </div>
            <div className="col mt-5">
              <h2 className="lessonSession">When comes Yoga Your Time</h2>
              <p className="lessonWhen">
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Magnam,
                enim?
              </p>
            </div>
          </div>
        </div>
        <div className="col-md-6 classesImage d-none d-md-block">
          <img className="lessonImg" src="/images/yoga.jpg" alt="yoga" />
        </div>
      </div>
    </div>
  );
}

export default Thirdofthird;