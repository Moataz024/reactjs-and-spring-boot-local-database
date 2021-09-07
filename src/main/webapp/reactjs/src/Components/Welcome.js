import React from 'react';
import 'react-bootstrap/dist/react-bootstrap.min';
class Welcome extends React.Component {


    render() {
        return (

            <div className="bg-dark text-white" >
                <div className="m-4">
                    <h1 className="p-4 text-center">
                    Welcome to eTitan
                    </h1>
                    <div className="p-4 text-center">
                        <h6 className="text-white-50">

                            Manage your projects easier.
                        </h6>
                    </div>
                </div>
            </div>

        );
    }

}

export default Welcome;