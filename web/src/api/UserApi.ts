import axios from 'axios';
import {UserView} from "../details/User";

export interface UserApi {
    loadUser: (userId: String) => Promise<UserView>
}

export class RestUserApi implements UserApi {
    private url: String = "http://localhost:8080"
    private path: String = "/users"

    loadUser(userId: String): Promise<UserView> {
        return axios.get(`${this.url}${this.path}/${userId}`).then(res => {
            return res.data as UserView
        })
    }
}