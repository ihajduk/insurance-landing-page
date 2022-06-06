package integration.eu.iwha.insurancelandingpage.acceptance

import eu.iwha.insurancelandingpage.api.CreateUserJson
import integration.eu.iwha.insurancelandingpage.BaseIntegrationTest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

import static shared.data.TestData.user1
import static shared.data.TestData.userName1

class InsuranceAcceptanceSpec extends BaseIntegrationTest {

    def "should fetch user"() {
        given:
            String userId = addUser(new CreateUserJson(userName1)).body.id

        when:
            ResponseEntity<Map> response = getUser(userId)

        then:
            response.statusCode == HttpStatus.OK

        and:
            response.body == [
                    "id": userId,
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
