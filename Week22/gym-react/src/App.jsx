import Bigeighth from "./components/eighth/bigEighth"
import Bigfifth from "./components/fifth/bigFifth"
import Hero from "./components/first/hero"
import Mainfirst from "./components/first/mainFirst"
import Nav from "./components/first/nav"
import Footer from "./components/footer/footer"
import Fourth from "./components/fourth/fourth"
import BgOfSecond from "./components/second/bgOfSecond"
import Bigseventh from "./components/seventh/bigSeventh"
import Bigsixth from "./components/sixth/bigSixth"
import Bigthird from "./components/third/bigThird"

function App() {

  return (
    <div>
      <Nav />
      <Hero />
      <Mainfirst />
      <BgOfSecond />
      <Bigthird />
      <Fourth />
      <Bigfifth />
      <Bigsixth />
      <Bigseventh />
      <Bigeighth />
      <Footer />
    </div>
  )
}

export default App
