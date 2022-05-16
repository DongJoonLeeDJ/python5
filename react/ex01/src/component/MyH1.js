import React, { useState } from 'react'
import axios from 'axios'

// import React, { Component } from 'react'

// class MyH1 extends Component {
//   render() {
//     return (
//       <div>MyH1</div>
//     )
//   }
// }


// function MyH1(props){
//    var a = props.aa;
//    var b = props.bb;
//    return (
//       <div>
//         <h1>MyH1</h1>
//         <p>{a}</p>
//         <p>{b}</p>
//       </div>
//    )
// }
const MyH1 = (props) => {
  function doadd(){
    setB(b+1);
    // document.getElementById('b').innerHTML=b;
    // console.log("증가"+b);
  }
  const dosub = ()=>{
    setB(b-1);
    // document.getElementById('b').innerHTML=b;
    // console.log("감소"+b);
  }
  const getax = ()=>{
    axios.get('https://dongjoonleedj.github.io/testWebHosting/myjson.json')
    .then( (res)=> { 
      setA(res.data.Name);
      setB(res.data.price);
    } )
    .catch( (error)=>{ console.log(error); } )
  }
  const [a, setA] = useState(props.aa);
  const [b, setB] = useState(props.bb);
  // var a = props.aa;
  // var b = props.bb;
  return (
    <div>
      <h1>MyH1</h1>
      <p id="a">a = {a}</p>
      <p id="b">b = {b}</p>
      <button onClick={doadd}>b증가</button>
      <button onClick={dosub}>b감소</button>
      <button onClick={getax}>json파일 가져오기</button>
    </div>
  )
}

export default MyH1