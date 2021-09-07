import 'react-bootstrap/dist/react-bootstrap.min'
import './App.css';
import NavigationBar from "./Components/NavigationBar";
import {Container , Row , Col} from "react-bootstrap";
import Welcome from "./Components/Welcome";
import Footer from './Components/Footer';
import Users from "./Components/User/Users";
import UsersList from "./Components/User/UsersList";
import {BrowserRouter as Router , Route , Switch , Redirect} from 'react-router-dom';


function App() {

  const  marginTop = {
    marginTop : "20px"
  };

  return (
      <Router>
        <div>
        <NavigationBar/>
    <Container>
      <Row>
        <Col style={marginTop}>
          <Switch>
            <Route path="/" exact component={Welcome}/>
            <Route path="/createUser" exact component={Users}/>
            <Route path="/displayUsers" exact component={UsersList}/>
          </Switch>
        </Col>
      </Row>
    </Container>
        <Footer/>
        </div>
      </Router>
  );
}

export default App;
