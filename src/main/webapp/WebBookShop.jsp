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
        <div style="margin-left: 700px; margin-top: 50px; margin-bottom: 20px; width: 500px; height: 650px; 
                    background-color: white; border-radius: 25px">
            <form action="WBSServlet" method="POST">
                
            <div style="margin-left: 50px; margin-top: 50px">
                </br>
                <a class="Headline">Sortieren</a></br>
                
            <div class="SortFilter">    
                <input type="radio" id="aufsteigend" name="sortRb" value="aufsteigend">
                <label for="aufsteigend">Aufsteigend</label>
                
                <input type="radio" id="absteigend" name="sortRb" value="absteigend">
                <label for="absteigend">Absteigend</label>
                
                <select name="sortBy" style="margin-left: 10px;">
                    <option>Title</option>
                    <option>Author(s)</option>
                    <option>Price</option>
                </select>
            </div>
                
            <a class="Headline">Filter</a></br>
                
            <div class="SortFilter">    
                <input type="radio" id="title" name="filterRb" value="title">
                <label for="title">Title</label>
                
                <input type="radio" id="author" name="filterRb" value="author">
                <label for="absteigend">Author(s)</label>
                
                <input type="text" name="filterText" value="${test}" width="150px" style="margin-left: 10px"/>
            </div>
                
            </br>
            
            <div>
                <%--<a class="example_d" class="button_cont" 
                   target="_blank" rel="nofollow noopener" onclick="this.form.submit()">Submit
                </a>--%>
                <input type="submit" value="Submit" name="submit" />
            </div>                
            

                <table>
                    <tbody>
                        <tr>
                            <th class="TableHeadline">Title</th>
                            <th class="TableHeadline">Author(s)</th>
                            <th class="TableHeadline">Price</th>
                        </tr>
                        <tr>
                            <td>Testdata</td>
                            <td>Testdata</td>
                            <td>Testdata</td>
                        </tr>
                        <tr>
                            <td>Testdata</td>
                            <td>Testdata</td>
                            <td>Testdata</td>
                        </tr>
                        <tr>
                            <td>Testdata</td>
                            <td>Testdata</td>
                            <td>Testdata</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            </form>
        </div>
    </body>
</html>
