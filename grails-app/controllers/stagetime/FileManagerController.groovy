package stagetime
/*
import grails.converters.JSON
import stagetime.security.SessionService

class FileManagerController {
    SessionService sessionService


    def exists() {
        def file = params['file']
        def user = sessionService.getUser()
        String path = grailsApplication.config.varDirectoryPrefix+user.id+"/"+file

        def ret = GeneralService.fileExists(new File(path))

        render text: [file:file, exists: ret] as JSON;
    }
}
*/