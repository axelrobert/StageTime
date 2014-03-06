<%--
  Created by IntelliJ IDEA.
  User: julien
  Date: 01/03/14
  Time: 20:42
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>StageTime - Edition offre de stage</title>
</head>

<body>
<div>
    <h1>Editer offre de stage</h1>
    <g:if test="${flash.message}">
        <div><g:message code="${flash.message}"/></div>
    </g:if>
    <g:if test="${flash.error}">
        <div><g:message code="${flash.error}"/></div>
    </g:if>

    <g:form action="edit" method="POST">
        <g:render template="form"/>
        <g:submitButton name="edit" value="Enregistrer" />
    </g:form>
</div>
</body>
</html>