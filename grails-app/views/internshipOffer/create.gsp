<%--
  Created by IntelliJ IDEA.
  User: Axel
  Date: 01/03/14
  Time: 11:41
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>StageTime - Create Internship Offer</title>
</head>

<body>
    <div>
        <h1>Create Event</h1>
        <g:if test="${flash.message}">
            <div><g:message code="${flash.message}"/></div>
        </g:if>
        <g:if test="${flash.error}">
            <div><g:message code="${flash.error}"/></div>
        </g:if>

        <g:form action="create" method="POST">
            <g:render template="form"/>
            <g:submitButton name="create" value="Create" />
        </g:form>
    </div>
</body>
</html>