import React, {useState,useEffect} from 'react';
import {Col, Container, Row, Table} from 'react-bootstrap';
import axios from 'axios';


export const Select = () => {
  const [boards,setboards] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/boards')
    .then( (res)=>{
      setboards(res.data.data);
    }).catch((error)=>{
      console.log(error)
    })
  }, [])

  if( boards.length === 0 ){
    return <div><h1>loading...</h1></div>
  }
  
  return (
    <Container>
      <h1>Select</h1>
      <Row>
        <Col>
        <Table striped bordered hover>
          <thead>
            <tr>
              <th>순번</th>
              <th>제목</th>
              <th>날짜</th>
              <th>조회수</th>
            </tr>
          </thead>
          <tbody>
            {
              boards.map((board)=>(
                <tr key={board.id}>
                    <td>{board.id}</td>
                    <td>{board.title}</td>
                    <td>{board.wdate}</td>
                    <td>{board.count}</td>
                </tr>
              ))
            }
          </tbody>
        </Table>
        </Col>
      </Row>

    </Container>
  )
}
