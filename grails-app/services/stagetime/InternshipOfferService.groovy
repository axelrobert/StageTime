package stagetime

import grails.transaction.Transactional
import org.apache.commons.logging.LogFactory

@Transactional
class InternshipOfferService {

    private static final log = LogFactory.getLog('grails.app.' + InternshipOfferService.class.name)

    public boolean saveInternshipOffer(InternshipOffer offer, Recruiter owner) {
        owner.addToInternshipOffers(offer) //Add the offer to its owner
        if (!owner.save(flush:true)) {
            return false
        } else {
            log.info("New internship offer created: "+offer)
            return true
        }
    }

    def deleteInternshipOffer(InternshipOffer internshipOffer) {
        def path = grailsApplication.config.varDirectoryPrefix
        path += internshipOffer.uri
        GeneralService.deleteFile(path)

        internshipOffer.delete()
    }
}
