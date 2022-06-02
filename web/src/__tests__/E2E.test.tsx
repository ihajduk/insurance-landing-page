import React from 'react';
import {configure, mount, ReactWrapper} from "enzyme";
import {inMemoryUserApi, submitForm, updateForm} from "../testCommons/TestConfiguration";
import Adapter from 'enzyme-adapter-react-16';
import {UserView} from "../details/User";
import App from "../App";

describe("Search User", () => {

    let wrapper: ReactWrapper;
    configure({adapter: new Adapter()});

    afterEach(() => {
        wrapper.unmount()
    })

    async function fillInSearchFormWith(userId: String) {
        const input = wrapper.find('.input').first()
        return updateForm(input, 'inputValue', userId)
    }

    async function submitSearchForm() {
        return submitForm(wrapper.find('.btn').first())
    }

    it('it finds user via search form', async () => {
        //given
        const user: UserView = {id: "32167", name: "Pawel"}
        inMemoryUserApi.addUser(user)

        wrapper = mount(
            <App userApi={inMemoryUserApi}/>
        );

        await fillInSearchFormWith("32167")
        await submitSearchForm()

        //when
        wrapper.update()

        //then
        expect(wrapper.find('.userId').text()).toContain(user.id)
        expect(wrapper.find('.userName').text()).toContain(user.name)
    })

})

