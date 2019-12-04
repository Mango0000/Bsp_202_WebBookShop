<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : InfoPage
    Created on : 03.12.2019, 13:42:44
    Author     : Schulbenutzer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="InfoPageStyle.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Info Page</title>
    </head>
    <body>
        <h2>Book</h2>
        <h2>Author(s)</h2>
    <c:forEach begin="1" end="2" step="1">
        <h3>Test</h3>
    </c:forEach>
        <h2>Publisher</h2>
    </body>
</html>
