package stagetime

import org.apache.commons.logging.LogFactory
import org.codehaus.groovy.grails.commons.GrailsApplication

class GeneralService {

    private static final log = LogFactory.getLog('grails.app.' + GeneralService.class.name)

    def grailsApplication

    /**
     * Returns current time
     * @return current times
     */
    def static Date getTime(){
        TimeZone reference = TimeZone.getTimeZone("GMT")
        Calendar myCal = Calendar.getInstance(reference)
        TimeZone.setDefault(reference);
        return myCal.getTime()
    }

    //documents on disk
    def static fileExists(String path){
        def f = new File(path)
        return f.exists()
    }

    def static deleteFile(String path){
        def f = new File(path)
        def ret = f.delete()
        if (!ret ){
            log.error("error on removing object")
        }
        return ret
    }
    /**
     * @param filename
     * @return uri of the file on the server
     */
    def String createFile(String filename, Long user_id){
        def prefix_path = grailsApplication.config.varDirectoryPrefix
        def path = prefix_path + user_id + "/" + filename +"_" + new Date().getTime()
        def file = new File(path)
        try {
            if (file.createNewFile()){
                log.info("New file created: "+file)
            }else{
                log.info("File already exists: "+file)
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Path not valid !")
        }

        return file.getAbsolutePath()
    }
}
