import React, {useState} from 'react';
import './App.css';
import {UserApi} from "./api/UserApi";
import {Form} from "./details/Form"
import {User, UserView} from "./details/User";

export interface AppProps {
    userApi: UserApi
}

const App = (appProps: AppProps) => {
    const [user, setUser] = useState({id: "", name: ""});
    const changeUser = (userView: UserView) => {
        setUser(userView)
    }
    return (
        <div>
            <div className="App-header">
                Insurance Landing Page
            </div>
            <Form userApi={appProps.userApi} userStateChanger={changeUser}/>
            <User id={user.id} name={user.name}/>
        </div>
    );
};

export default App;
