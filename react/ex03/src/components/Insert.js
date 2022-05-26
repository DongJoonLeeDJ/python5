import React, { useState } from 'react'
import { Button, Container, Form } from 'react-bootstrap';
import axios  from 'axios';

export const Insert = () => {
  const [title, setTitle] = useState('');
  const [content, setContent] = useState('');

  const doSubmit = ()=>{
    axios.post('http://localhost:8080/api/new',{
      'title': title,
      'content': content,
    })
    .then((res)=>{
      console.log(res);
    })
    .catch((error)=>{
      console.log(error);
    });
  }
  return (
    <div>
      <h1>Insert</h1>
      <Container>
        <Form>
          <Form.Group className="mb-3" controlId="formBasicEmail">
            <Form.Label>제목</Form.Label>
            <Form.Control type="text" placeholder="Title" 
                    onChange={(event) => setTitle(event.target.value)} 
                    value={title}/>
            <Form.Text className="text-muted">
              title 을 적으세요...
            </Form.Text>
          </Form.Group>

          <Form.Group className="mb-3" controlId="formBasicPassword">
            <Form.Label>내용</Form.Label>
            <Form.Control as="textarea" placeholder="Content" 
                        onChange={(event) => setContent(event.target.value)} 
                        value={content}/>
          </Form.Group>
          <Button variant="primary" onClick={doSubmit}>
            Submit
          </Button>
        </Form>
      </Container>

    </div>
  )
}
