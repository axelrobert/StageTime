package stagetime

class JqueryDatePickerTagLib {
    def jqDatePicker = {attrs, body ->
        def out = out
        def name = attrs.name    //The name attribute is required for the tag to work seamlessly with grails
        def value = attrs.value
        def id = attrs.id ?: name

        //Create date text field and supporting hidden text fields need by grails
        out.println "<input type=\"text\" name=\"${name}\" id=\"${id}\" value=\"${value}\"/>"
        out.println "<span class=\"glyphicon glyphicon-calendar\"></span>"
        out.println "<input type=\"hidden\" name=\"${name}_day\" id=\"${id}_day\" />"
        out.println "<input type=\"hidden\" name=\"${name}_month\" id=\"${id}_month\" />"
        out.println "<input type=\"hidden\" name=\"${name}_year\" id=\"${id}_year\" />"

        //Code to parse selected date into hidden fields required by grails
        out.println "<script type=\"text/javascript\"> \$(document).ready(function(){"
        out.println "\$(\"#${name}\").datepicker({"
        out.println "dateFormat: \"dd/mm/yy\","
        out.println "onClose: function(dateText, inst) {"
        out.println "\$(\"#${name}_month\").attr(\"value\",new Date(dateText).getMonth() +1);"
        out.println "\$(\"#${name}_day\").attr(\"value\",new Date(dateText).getDate());"
        out.println "\$(\"#${name}_year\").attr(\"value\",new Date(dateText).getFullYear());"
        out.println "}"

        out.println "});"
        out.println "})</script>"
    }
}
