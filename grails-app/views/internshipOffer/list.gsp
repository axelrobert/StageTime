<%--
  Created by IntelliJ IDEA.
  User: julien
  Date: 01/03/14
  Time: 18:59
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>
</head>

<body>
<table>
    <thead>
    -    <td>titre</td>
    -    <td>date de début</td>
    -    <td>durée</td>
    -    <td>lieux</td>
    -    <td>type</td>
    -    <td>mots-clées</td>
    -    <td>candidature</td>
    </thead>
    <tbody>
        <g:each var="offer" in="offers">
            <tr>
                <td>${offer.title}</td>
                <td>${offer.begin}</td>
                <td>${offer.monthDuration}</td>
                <td>${offer.worki ngSpace}</td>
                <td>${offer.internshipType}</td>
                <td>
                    <g:each in="offer.Keyword" var="kw">
                        ${kw},
                    </g:each>
                </td>
                <td>
                    <g:each in="offer.User" var="u">
                        ${kw.firstName} ${kw.secondName},
                    </g:each>
                </td>
            </tr>
        </g:each>
    </tbody>
</table>
</body>
</html>