import './App.css';
import {BrowserRouter,Routes,Route} from 'react-router-dom';
import { CNavbars } from './components/CNavbars';
import { Select } from './components/Select';
import { Insert } from './components/Insert';
import { Index } from './components/Index';
import { Footer } from './components/Footer';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <CNavbars/>
        <Routes>
          <Route path="/index" element={<Index/>}> </Route>
          <Route path="/select" element={<Select/>}> </Route>
          <Route path="/insert" element={<Insert/>}> </Route>
        </Routes>
        <Footer/>
      </BrowserRouter>
    </div>
  );
}

export default App;
