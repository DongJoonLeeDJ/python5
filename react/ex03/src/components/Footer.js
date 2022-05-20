import React from 'react'
import { Col, Container, Row } from 'react-bootstrap'

export const Footer = () => {
  return (
    <Container>
        <Row className='bg-primary text-white p-2 fixed-bottom'>
            <Col>
                &#64; Copy Right Address : Daegu <br/>
                Made by MH
            </Col>
        </Row>
    </Container>
  )
}
