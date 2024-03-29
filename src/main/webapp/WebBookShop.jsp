<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : WebBookShop
    Created on : 19.11.2019, 13:53:28
    Author     : Schulbenutzer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <link href="Style.css" rel="stylesheet" type="text/css"/>
    <body>
        <div style="margin-left: 600px; margin-top: 50px; margin-bottom: 20px; width: 600px; height: 650px; 
                    background-color: white; border-radius: 25px; ">
            
            <div style="margin-left: 50px; margin-top: 50px">
                <form action="BookShopServlet" method="POST">
                </br>
                <a class="Headline">Sortieren</a></br>
                
            <div class="SortFilter">    
                <input type="radio" id="aufsteigend" name="sortRb" value="aufsteigend" ${aufsteigend} onchange="this.form.submit()">
                <label for="aufsteigend">Aufsteigend</label>
                
                <input type="radio" id="absteigend" name="sortRb" value="absteigend" ${absteigend} onchange="this.form.submit()">
                <label for="absteigend">Absteigend</label>
                
                <select name="sortBy" onchange="this.form.submit()" style="margin-left: 10px;">
                    <option ${title}>Title</option>
                    <option ${author}>Author(s)</option>
                    <option ${price}>Price</option>
                </select>
            </div>
                
            <a class="Headline">Filter</a></br>
                
            <div class="SortFilter">    
                <input type="radio" id="title" name="filterRb" value="title" ${filtert} onchange="this.form.submit()">
                <label for="title">Title</label>
                
                <input type="radio" id="author" name="filterRb" value="author" ${filtera} onchange="this.form.submit()"> 
                <label for="absteigend">Author(s)</label>
                
                <input type="text" name="filterText" value="${filter}" width="150px" onchange="this.form.submit()" style="margin-left: 10px" autofocus/>
            </div>
                
            </br>
            
            <div>
                <%--<a class="example_d" class="button_cont" 
                   target="_blank" rel="nofollow noopener" onclick="this.form.submit()">Submit
                </a>--%>
            </div>                
            </form>
            <form action="BookShopServlet" method="POST" id="myForm">
            
                <div>
                    <table class="header">
                    <tbody>
                        <tr>
                            <th class="TableHeadline" style="width:44%">Title</th>
                            <th class="TableHeadline" style="width:40%">Author(s)</th>
                            <th class="TableHeadline" style="width:16%">Price</th>
                        </tr>
                        </tbody>
                </table>
                </div>
                
                <div style="overflow: auto; height: 45vh">
                <table>
                    <tbody>
                        <c:forEach var="book" items="${books}">
                            <tr>
                                <td style="font-weight: bold">${book.getTitle()}</td>
                                <td>${book.getAuthor()}</td>
                                <td>€${book.getPrice()}</td>
                                <td><input type="button" value="i" name="info" onclick="myFunction(`${book.getTitle()}`);" style="color: blue; border-radius: 100%;"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                </div><input type="hidden" id="text" name="test" />
                </form>
            </div>
        </div>
    </body>
    <script>
    function myFunction(text){
        document.getElementById("text").value = text;
        document.getElementById("myForm").submit();
    }
</script>
</html>

