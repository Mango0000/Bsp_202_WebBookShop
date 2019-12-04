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
            <h4>${book.getTitle()}</h4>
            <h4>€ ${book.getPrice()}</h4>
            <h2>Author(s)</h2>
                <c:forEach var="author" items="${book.getListAuthor()}">
                    <h4>${author}</h4>
                </c:forEach>
            <h2>Publisher</h2>
            <h4>${publisher.getName()}</h4>
            <h4><a target="_blank" href="https://${publisher.getUrl()}">${publisher.getUrl()}</a></h4>
       
    </body>
</html>
