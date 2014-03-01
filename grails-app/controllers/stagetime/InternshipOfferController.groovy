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
        def current_user = sessionService.getUser()
        String local_uri = generalService.createFile(params.filename, current_user.getId())
        InternshipOffer offer = new InternshipOffer(params, uri: local_uri)

        if (request.method == 'GET'){ // if params are not passed then we just render the page
            render (view:"create", model: [offerInstance: offer])
            return true
        } else { // else we try to save the offer
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
     * show list of internshipOffers corresponding to him
     * for recruiter only
     * @return
     */
    def list(){
        def user = (Recruiter)sessionService.getUser()
        def internshipOffers = user.getInternshipOffers()
        render(view:"list", model: [offers:internshipOffers])
    }

    /**
     * remove the entry in database, and associated documents
     *
     *params id : the id of the internship offer to delete
     */
    def delete(long id) {
        def user = InternshipOffer.get(id)
        internshipOfferService.deleteInternshipOffer(user)

        redirect(action:"index")
    }
}
