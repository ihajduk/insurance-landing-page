package integration.eu.iwha.insurancelandingpage

import eu.iwha.insurancelandingpage.InsuranceLandingPageApplication
import eu.iwha.insurancelandingpage.adapter.InMemoryUserRepository
import eu.iwha.insurancelandingpage.domain.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.ResponseEntity
import spock.lang.Specification

@SpringBootTest(classes = [InsuranceLandingPageApplication],
        properties = "application.environment=integration",
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract class BaseIntegrationTest extends Specification {

    @Autowired
    private TestRestTemplate restTemplate

    @Autowired
    private InMemoryUserRepository userRepository

    protected ResponseEntity<Map> getUser(String id) {
        restTemplate.getForEntity("/user/$id", Map)
    }

    protected void addUser(User user) {
        userRepository.addUser(user)
    }
}
