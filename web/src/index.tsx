import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App, {AppProps} from './App';
import reportWebVitals from './reportWebVitals';
import {RestUserApi} from "./api/UserApi";


const userApi = new RestUserApi()
const appProps: AppProps = { userApi }

const application = (
  <React.StrictMode>
    <App {...appProps}/>
  </React.StrictMode>
);

ReactDOM.render(application, document.getElementById('root'))

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
