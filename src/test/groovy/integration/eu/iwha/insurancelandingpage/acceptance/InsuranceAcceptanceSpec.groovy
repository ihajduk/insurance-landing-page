package integration.eu.iwha.insurancelandingpage.acceptance

import integration.eu.iwha.insurancelandingpage.BaseIntegrationTest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

import static shared.data.TestData.user1
import static shared.data.TestData.userId1

class InsuranceAcceptanceSpec extends BaseIntegrationTest {

    def "should fetch user"() {
        given:
            addUser(user1)

        when:
            ResponseEntity<Map> response = getUser(userId1)

        then:
            response.statusCode == HttpStatus.OK

        and:
            response.body == [
                    "id": user1.id,
                    "name": user1.name
            ]
    }

    def "should return status 404 on user not found"() {
        when:
            ResponseEntity<Map> response = getUser("unknownUser")

        then:
            response.statusCode == HttpStatus.NOT_FOUND
    }
}
