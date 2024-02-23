import './App.css'
import Card from './components/Card'
import Head from './components/Head'
import Ship from './components/Ship'
import { BrowserRouter, Routes, Route } from "react-router-dom";

function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="*" element={<Card />} />
        <Route path="/Ship/:model" element={<Ship  />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
