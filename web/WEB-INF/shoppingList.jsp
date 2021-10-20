<%-- 
    Document   : shoppingList
    Created on : Oct 18, 2021, 11:31:28 AM
    Author     : 821320
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
        <p>Hello ${username} </p>
        <a href="/ShoppingList?action=logout">Logout</a>
        
        <h2>List</h2>
        
        <form method="POST" action="">
            
            <table>
                <tr>
                    <td>
                        Add item:
                    </td>
                    <td>
                        <input type="text" name="newItem">
                        <input type="hidden" name="action" value="add"> 
                    </td>
                    <td>
                        <button type="submit" value="Add item">Add</button>
                    </td>
                </tr>
            </table>
            <br>
            
        </form>
        
        <form method="POST" action="">
            <table>
                <c:forEach var="item" items="${items}">

                        <tr>
                            <td>
                                <input type="radio" name="item" value="${item}">
                            </td>
                            <td>
                                ${item}
                            </td>
                        </tr>
                </c:forEach>
            </table>

            <c:if test="${items != null}">

                    <br>
                    <input type="submit" value="Delete">
                    <input type="hidden" name="action" value="delete">

            </c:if>        
        </form>
        
        
            
        
        
    </body>
</html>
