package stagetime

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.hibernate.HibernateException
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(InternshipOfferService)
@Mock([GeneralService,InternshipOffer])
class InternshipOfferServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    @Unroll
    void "test delete good BD delete"() {
        given :
        InternshipOffer internshipOffer = Mock()
        GroovyMock(GeneralService,global: true)

        and:
        internshipOffer.delete() >> {}
        GeneralService.deleteFile(_) >> deleteFile
        def ret = service.deleteInternshipOffer(internshipOffer)

        expect:
        ret == expectedRet

        where:
        expectedRet    |deleteFile
        true           |true
        false          |false
    }

    @Unroll
    void "test delete bad BD delete"() {
        given :
        InternshipOffer internshipOffer = Mock()
        GroovyMock(GeneralService,global: true)

        and:
        internshipOffer.delete() >> {throw new HibernateException("error on deleting from BD")}
        GeneralService.deleteFile(_) >> deleteFile
        def ret = service.deleteInternshipOffer(internshipOffer)

        expect:
        ret == expectedRet

        where:
        expectedRet    |deleteFile
        false          |true
        false          |false
    }

    void "test save"() {

    }
}
