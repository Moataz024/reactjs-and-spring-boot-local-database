import React from 'react';
import {Nav, Navbar, NavDropdown} from "react-bootstrap";
import {Link} from "react-router-dom";

class NavigationBar extends React.Component {

    render() {
        return(
            <Navbar bg="dark" variant="dark">
                <Link to={""} className="navbar-brand">
                    eTitan
                </Link>

                <Nav
                    className="mr-auto my-2 my-lg-0"
                    style={{ maxHeight: '100px' }}
                    navbarScroll
                >
                    <Link to={""} className="nav-link">Home</Link>
                    <NavDropdown title="Users" id="navbarScrollingDropdown">
                        <Link to={"displayUsers"} className="nav-link"> <NavDropdown.Item href="#action3">Display</NavDropdown.Item></Link>
                        <Link to={"createUser"} className="nav-link"><NavDropdown.Item href="#action4">Create</NavDropdown.Item></Link>
                        <NavDropdown.Divider />
                        <NavDropdown.Item href="#action5">Something else here</NavDropdown.Item>
                    </NavDropdown>
                    <NavDropdown title="Projects" id="navbarScrollingDropdown">
                        <NavDropdown.Item href="#action3">Display</NavDropdown.Item>
                        <NavDropdown.Item href="#action4">Create</NavDropdown.Item>
                        <NavDropdown.Divider />
                        <NavDropdown.Item href="#action5">Something else here</NavDropdown.Item>
                    </NavDropdown>
                    <NavDropdown title="Tasks" id="navbarScrollingDropdown">
                        <NavDropdown.Item href="#action3">Display</NavDropdown.Item>
                        <NavDropdown.Item href="#action4">Create</NavDropdown.Item>
                        <NavDropdown.Divider />
                        <NavDropdown.Item href="#action5">Something else here</NavDropdown.Item>
                    </NavDropdown>
                    <Link to={""} className="nav-link" disabled>
                        Link
                    </Link>
                </Nav>
            </Navbar>

        );


    }

}

export default NavigationBar;