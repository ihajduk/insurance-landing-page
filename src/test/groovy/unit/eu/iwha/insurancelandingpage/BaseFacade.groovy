package unit.eu.iwha.insurancelandingpage

import eu.iwha.insurancelandingpage.InsuranceFacade
import eu.iwha.insurancelandingpage.adapter.local.InMemoryUserRepository
import eu.iwha.insurancelandingpage.domain.User
import spock.lang.Specification
import spock.lang.Subject

abstract class BaseFacade extends Specification {

    @Subject
    protected InsuranceFacade facade

    private InMemoryUserRepository repository = new InMemoryUserRepository()

    def setup() {
        facade = new InsuranceFacade(repository)
    }

    protected def setupUser(User user) {
        repository.addUser(user)
    }
}
