package stagetime

class GeneralService {
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

}
