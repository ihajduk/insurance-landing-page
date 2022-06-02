import React from "react";

export interface UserView {
    id: string;
    name: string;
}

export const User = (props: UserView) => {
    return (
        <table className="table">
            <tbody>
            <tr>
                <th>userId</th>
                <th>userName</th>
            </tr>
            <tr>
                <th className="userId">{props.id}</th>
                <th className="userName">{props.name}</th>
            </tr>
            </tbody>
        </table>
    );
}
