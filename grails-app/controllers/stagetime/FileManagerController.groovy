package stagetime

import grails.converters.JSON
import stagetime.security.SessionService

class FileManagerController {

    def exists() {
        def file = params['file']
        def user = SessionService.getUser()
        String path = grailsApplication.config.varDirectoryPrefix+user.id+"/"+file

        def ret = GeneralService.fileExists(path)

        render text: [file:file, exists: ret] as JSON;
    }
}
