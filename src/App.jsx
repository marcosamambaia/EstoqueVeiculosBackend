import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Marcas from "./components/Marcas";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/marcas" element={<Marcas />} />
      </Routes>
    </Router>
  );
}

export default App;
