package stagetime

import stagetime.security.SessionService

class InternshipOfferController {

    InternshipOfferService internshipOfferService
    SessionService sessionService
    GeneralService generalService
    static scope = "prototype"

    def index() {
        redirect(action:'list')
    }

    /**
     * Controller for create view. Creates a user.
     * @return
     */
    def create() {
        if (request.method == 'GET'){ // if params are not passed then we just render the page
            render (view:"create")
            return true
        } else { // else we try to save the offer
            def current_user = sessionService.getUser()
            String local_uri = generalService.createFile(params.filename, current_user.id)
            InternshipOffer offer = new InternshipOffer(params, uri: local_uri)

            if (internshipOfferService.saveInternshipOffer(offer, current_user)){
                flash.message = "offer created"
                redirect (action:"list")
                return true
            } else {
                flash.error = "offer creation failed"
                render (view:"create", model: [offerInstance: offer])
                return false
            }
        }
    }

    /**
     * remove the entry in database, and associated documents
     *
     *params id : the id of the internship offer to delete
     */
    def delete(long id) {
        InternshipOfferService.deleteInternshipOffer(id)

        redirect(action:index)
    }
}
