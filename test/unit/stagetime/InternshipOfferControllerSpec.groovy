package stagetime

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import stagetime.security.SessionService

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

    void "test list"(){
        given:
        SessionService sessionService = Mock()
        Recruiter recruiter = Mock()

        and:
        recruiter.getInternshipOffers() >> null
        sessionService.getUser() >> new Recruiter()

        controller.sessionService = sessionService
        controller.list()

        expect:
        view == '/internshipOffer/list'
    }


    void "test index"(){
        given:
        controller.index()

        expect:
        response.redirectUrl == '/internshipOffer/list'
    }

    void "test edit"(){
        given:
        InternshipOfferService internshipOfferService = Mock()
        SessionService sessionService = Mock()
        GeneralService generalService = Mock()

        and :
        sessionService.getUser >> user
        generalService.createFile >> uri
        internshipOfferService.saveInternshipOffer >> save
        controller.sessionService = sessionService
        controller.generalService = generalService
        controller.internshipOfferService = internshipOfferService
        request.method = method
        controller.edit()

        expected:
        response.redirectedUrl == url

        where:
        user    |uri    |save   |method    |url
        null    |null    |null   |"GET"    |"/InternshipOffer/edit"
        null    |null    |true   |"POST"    |"/InternshipOffer/list"
        null    |null    |false   |"POST"    |"/InternshipOffer/edit"
    }
}
