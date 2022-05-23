import React from 'react'
import { Container, Navbar, Nav } from 'react-bootstrap'
import { Link, NavLink } from 'react-router-dom'

export const CNavbars = () => {
  return (
    <div>
        <Navbar bg="primary" expand="md">
          <Container>
            <Navbar.Brand as={Link} to="/Index" style={{color:'#fff'}}>MH portfolio</Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
              <Nav className="me-auto">
                <Nav.Link as={NavLink} to="select" className='text-white'>Select</Nav.Link>
                <Nav.Link as={NavLink} to="insert" className='text-white'>insert</Nav.Link>
              </Nav>
            </Navbar.Collapse>
          </Container>
        </Navbar>
        {/* <Link path="/Index" to="/Index">Index</Link> */}
    </div>
  )
}
