import {Component} from "react";
import {Card, Button, Nav, Form} from "react-bootstrap";
import axios from 'axios';

export default class UserDetails extends Component {

    constructor(props) {
        super(props);
        this.state = {
            selectedProject : 0,
            tab : 1
        }
        this.handleChange=this.handleChange.bind(this);
        this.enrollProject=this.enrollProject.bind(this);

    }
    componentDidMount() {

        axios.get("http://localhost:8080/project")
            .then(response => {
                this.setState({projectList: response})
            });
        axios.get("http://localhost:8080/task")
            .then(response => {
                this.setState({taskList : response})
            })
    };
    componentDidUpdate(prevProps) {

        if (this.props.val !== prevProps.val) {
            this.getUserDetails(this.props.val)

        }
    };
    handleChange =e =>{
    this.setState({[e.target.name]:e.target.value});
    this.setState({
        selectedProject : e.target.value
    })
        this.getUserDetails(this.props.val);
};
    getUserDetails(uid) {
        axios.get('http://localhost:8080/user/' + uid ).then(response => {
            this.setState({userDetails: response})

        })
    };
    enrollProject(){

        axios.put("http://localhost:8080/user/"+this.props.val+"/projects/"+this.state.selectedProject)
            .then(response => {
            })
    };

    render() {
        if (!this.state.userDetails)
            return (<p className="text-white-50 p-5">Charge user</p>)
        return(
            <div>


            <Card className="border border-dark bg-dark text-white m-2 ">

                <Card.Header variant="bg-gradient p-2">
                    <Nav variant="pills" defaultActiveKey="#project">
                        <Nav.Item>
                            <Nav.Link href="#project" >Project</Nav.Link>
                        </Nav.Item>
                        <Nav.Item>
                            <Nav.Link href="#link" >Task</Nav.Link>
                        </Nav.Item>

                    </Nav>
                </Card.Header>
                <Card.Body>
                    <Card.Title className="mb-3">Select project</Card.Title>
                    {this.state.tab === 1 ?
                    <Card.Text >
                        <Form onSubmit={this.enrollProject}>

                                <Form.Select  onChange={this.handleChange} aria-label="htmlSize-4" className="bg-dark text-white " size="2">
                                    <option name="project" >Select a project</option>
                                    {this.state.projectList.data.map(project =>
                                    <option value={project.pid}>{project.p_name}</option>
                                        )}
                                </Form.Select>
                                <Button variant="outline-primary text-white mt-3" type="submit" >
                                    Add
                                </Button>
                            </Form>
                        </Card.Text>:
                        <Card.Text >
                            <Form onSubmit={this.enrollProject}>

                                <Form.Select  onChange={this.handleChange} aria-label="htmlSize-4" className="bg-dark text-white " size="2">
                                    <option name="task" >Select a task</option>
                                    {this.state.projectList.data.map(project =>
                                        <option value={project.pid}>{project.p_name}</option>
                                    )}
                                </Form.Select>
                                <Button variant="outline-primary text-white mt-3" type="submit" >
                                    Add
                                </Button>
                            </Form>
                        </Card.Text>



                    }
                    </Card.Body>
                </Card>

            </div>

        );
    }
}