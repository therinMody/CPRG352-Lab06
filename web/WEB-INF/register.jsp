<%-- 
    Document   : register
    Created on : Oct 18, 2021, 11:31:15 AM
    Author     : 821320
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
        <form method="POST" action="ShoppingList">
            <table>
                <tr>
                    <td>
                        Username:
                    </td>
                    <td>
                        <input type="text" name="username">
                        <input type="hidden" name="action" value="register">
                    </td>
                    <td>
                        <button type="submit" value="Register">Register Name</button>
                    </td>
                </tr>
            </table>
        </form>
        

    </body>
</html>
