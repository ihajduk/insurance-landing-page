import {UserApi} from "../api/UserApi";
import {UserView} from "../details/User";

export class InMemoryUserApi implements UserApi {
    private users: UserView[] = []

    addUser(user: UserView) {
        this.users.push(user)
    }

    loadUser(userId: String): Promise<UserView> {
        return new Promise<UserView>(resolve => {
            resolve(this.findUser(userId))
            }
        )
    }

    private findUser(userId: String): UserView {
        return this.users.find(it => it.id === userId)!!
    }
}