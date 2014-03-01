package stagetime

import grails.transaction.Transactional

@Transactional
class InternshipOfferService {

    def deleteInternshipOffer(long id) {
        def internshipOffer = InternshipOffer.get(id)
        def path = grailsApplication.config.varDirectoryPrefix
        path += internshipOffer.uri
        GeneralService.deleteFile(path)

        internshipOffer.delete()
    }
}
