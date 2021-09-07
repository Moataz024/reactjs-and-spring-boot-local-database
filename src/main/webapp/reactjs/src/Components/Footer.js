import React from 'react';
import {Container, Navbar , Col} from "react-bootstrap";


class Footer extends React.Component {

    render() {
        return (
            <Navbar fixed="bottom" bg="dark" variant="dark">
                <Container>
                    <Col lg={12} className="text-center text-muted">
                        akwa footer tnajem tshoufha f hyetk
                    </Col>
                </Container>

            </Navbar>

        );

    }

}

export default Footer;