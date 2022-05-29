package unit.eu.iwha.insurancelandingpage

import static shared.data.TestData.user1

class InsuranceFacadeSpec extends BaseFacade {

    def 'should fetch user'() {
        given:
            setupUser(user1)

        expect:
            facade.getUser("1") == user1
    }
}
