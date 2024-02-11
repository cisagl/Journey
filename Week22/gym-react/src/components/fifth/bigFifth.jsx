import Fifthfirst from "./fifthFirst";
import Fifthsecond from "./fifthSecond";
import Fifththird from "./fifthThird";

const Bigfifth = () => {
  return (
    <div className="bg2 mt-3">
        <section className="container titlePadding" id="trainers">
            <Fifthfirst />
            <div className="col-12 p-2">
            <Fifthsecond />
            <Fifththird />
            </div>

        </section>
    </div>
  );
}

export default Bigfifth;