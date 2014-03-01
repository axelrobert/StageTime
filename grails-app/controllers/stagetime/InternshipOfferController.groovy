package stagetime

class InternshipOfferController {

    def index() {}

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
