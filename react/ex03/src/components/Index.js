import React from 'react'
import { Button, Card, Col, Container, Row } from 'react-bootstrap'
import cs from '../img/cs.png';

export const Index = () => {
  return (
    <Container className='mt-3 mb-3 pb-5'>
        <Row className='g-4'>
            <Col xs={12} lg={4}>
                <Card>
                    <Card.Img variant="top" src={cs} className="w-100"/>
                    <Card.Body>
                        <Card.Title>C#</Card.Title>
                        <Card.Text>
                            C#으로 CURD 구현 가능합니다.
                        </Card.Text>
                        <Button variant="primary">Go To C#</Button>
                    </Card.Body>
                </Card>
            </Col>
            <Col xs={12} lg={4}>
                <Card>
                    <Card.Img variant="top" src={cs} className="w-100"/>
                    <Card.Body>
                        <Card.Title>Java</Card.Title>
                        <Card.Text>
                            Java프로젝트로 좋은걸 했어!
                        </Card.Text>
                        <Button variant="primary">Go To Java</Button>
                    </Card.Body>
                </Card>
            </Col>
            <Col xs={12} lg={4}>
                <Card>
                    <Card.Img variant="top" src={cs} className="w-100"/>
                    <Card.Body>
                        <Card.Title>python</Card.Title>
                        <Card.Text>
                            python 으로 ml,dl 했어
                        </Card.Text>
                        <Button variant="primary">Go To Python</Button>
                    </Card.Body>
                </Card>
            </Col>
        </Row>
    </Container>
  )
}
