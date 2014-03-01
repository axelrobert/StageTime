package stagetime

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import stagetime.security.SessionService

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(GeneralService)
@Mock([User,  SessionService])
class GeneralServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "test getTime"(){
        setup:
        println "Time: "+GeneralService.getTime()
        Date dateToTest = GeneralService.getTime()
        Date compareDate = Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTime()

        expect:
        dateToTest.before(compareDate) || dateToTest.equals(compareDate) // 1st time is generated few milliseconds before the second
        compareDate.before(dateToTest+1) // but this is not really a lot ...
    }

    /*def "test encrypt"(){
        expect:
        GeneralService.encrypt(passOne) == GeneralService.encrypt(passTwo)
        GeneralService.encrypt(passOne) != GeneralService.encrypt(passTwoBis)
        where:
        passOne | passTwo | passTwoBis
        "Pa55w0rd" | "Pa55w0rd" | "pasxword"
        "password" | "password" | "Pa56w0rd"
        "123456" | "123456" | "123656"
    }*/


    void "test file exists"() {
        given :
        File f = Mock()

        and:
        1 * f.exists() >> ret

        expect:
        GeneralService.fileExists(f) == excepted

        where:
        ret             |   excepted
        true            |   true
        false           |   false
    }

    void "test delete file"() {
        given :
        File f = Mock()

        and:
        1 * f.delete() >> ret

        expect:
        GeneralService.deleteFile(f) == excepted

        where:
        ret             |   excepted
        true            |   true
        false           |   false
    }
}
