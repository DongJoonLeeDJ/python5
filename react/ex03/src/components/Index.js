import React from 'react'
import { Button, Card, Carousel, Col, Container, Row } from 'react-bootstrap'
import cs from '../img/cs.png';
import daegu from '../img/daegu.jpg';
import clock from '../img/clock.jpg';

export const Index = () => {
  return (
    <Container className='mt-3 mb-3' style={{paddingBottom:'4rem'}}>
        <Row className='my-3'>
            <Carousel>
                <Carousel.Item>
                    <img
                    className="d-block w-100"
                    src={daegu}
                    alt="First slide"
                    />
                    <Carousel.Caption>
                    <h3>Daegu night</h3>
                    <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <img
                    className="d-block w-100"
                    src={clock}
                    alt="Second slide"
                    />
                    <Carousel.Caption>
                    <h3>Clock</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                    </Carousel.Caption>
                </Carousel.Item>
            </Carousel>
        </Row>
        <Row className='g-4'>
            <Col xs={12} md={4}>
                <Card>
                    <Card.Img variant="top" src={cs} className="p-3"/>
                    <Card.Body>
                        <Card.Title>C#</Card.Title>
                        <Card.Text>
                            C#으로 CURD 구현 가능
                        </Card.Text>
                        <Button variant="primary">Go To C#</Button>
                    </Card.Body>
                </Card>
            </Col>
            <Col xs={12} md={4}>
                <Card>
                    <Card.Img variant="top" src={cs} className="p-3"/>
                    <Card.Body>
                        <Card.Title>Java</Card.Title>
                        <Card.Text>
                            Java프로젝트로 좋은걸
                        </Card.Text>
                        <Button variant="primary">Go To Java</Button>
                    </Card.Body>
                </Card>
            </Col>
            <Col xs={12} md={4}>
                <Card>
                    <Card.Img variant="top" src={cs} className="p-3"/>
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
