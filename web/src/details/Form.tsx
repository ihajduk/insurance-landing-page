import React, {useState} from "react";
import {UserApi} from "../api/UserApi";
import {UserView} from "./User";

export interface FormProps {
    userApi: UserApi,
    userStateChanger: (userView: UserView) => void
}

export const Form = (formProps: FormProps) => {
    const [userId, setUserId] = useState('')
    const fetchUser = async (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault()
        await formProps.userApi.loadUser(userId).then(fetchedUser => {
            formProps.userStateChanger(fetchedUser);
        });
    };
    return (
        <div>
            <form className="form-container" onSubmit={fetchUser}>
                <input className="input"
                       id="inputValue"
                       type="text"
                       placeholder="Insert user id"
                       onChange={e => setUserId(e.target.value)}
                />
                <button className="btn">Search</button>
            </form>
        </div>
    );
};
