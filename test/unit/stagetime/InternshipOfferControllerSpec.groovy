package stagetime

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(InternshipOfferController)
@Mock([InternshipOfferService, InternshipOffer])
class InternshipOfferControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test delete"() {
        given:
        GroovyMock(InternshipOffer, global:true)
        InternshipOfferService internshipOfferService = Mock()

        and:
        1 * internshipOfferService.deleteInternshipOffer(_) >> ret
        1 * InternshipOffer.get(_) >> user
        controller.internshipOfferService = internshipOfferService
        controller.delete(5)

        expect:
        response.redirectUrl == "/internshipOffer/index"


        where:
        ret     |user
        false   |null
        true    |null
    }
}
