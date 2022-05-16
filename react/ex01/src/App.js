import './App.css';
import MyH1 from './component/MyH1';


function App() {
  return (
    <div className="App">
      <h1>안녕하세요</h1>
      <MyH1 aa="A1" bb={11}/>
      <MyH1 aa="A2" bb={22}/>
      <MyH1 aa="A3" bb={33}/>
    </div>
  );
}

export default App;
