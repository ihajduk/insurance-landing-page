import {HTMLAttributes, ReactWrapper} from "enzyme";
import React from "react";
import {act} from "react-dom/test-utils";
import {InMemoryUserApi} from "./InMemoryUserApi";

export const inMemoryUserApi: InMemoryUserApi = new InMemoryUserApi()

export const updateForm = async (
    nativeFieldWrapper: ReactWrapper<HTMLAttributes, any, React.Component<{}, {}, any>>,
    targetName: string,
    value: any,
) => {
    await act(async () => {
        nativeFieldWrapper.simulate(
            'change',
            {target: {name: targetName, value}}
        );
    });
}

export const submitForm = async (
    nativeFormWrapper: ReactWrapper<HTMLAttributes, any, React.Component<{}, {}, any>>,
) => {
    await act(async () => {
        nativeFormWrapper.simulate(
            'submit',
            {
                preventDefault: () => {
                }
            }
        );
    });
};