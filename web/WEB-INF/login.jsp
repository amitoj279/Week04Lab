<%-- 
    Document   : login
    Created on : Oct 1, 2019, 9:03:00 AM
    Author     : 794473
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <br>
        <form action="login" method="post">
            Username: <input type="text" name="username">
            <br>
            <br>
            Password: <input type="password" name="password">
            <br>
            <br>
            <input type="submit" value="Login">      
            <br>
            ${message}            
        </form>
    </body>
</html>
