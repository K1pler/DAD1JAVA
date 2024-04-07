<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login</h2>
<% if (request.getParameter("error") != null) { %>
    <p>Error de autenticación, por favor intenta de nuevo.</p>
<% } %>
 <form action="Control" method="POST">
        <input type="hidden" name="ID_ACCION" value="Login" />
     
    Email: <input type="text" name="email"><br>
    Password: <input type="password" name="password"><br>
    <input type="submit" value="Login">
</form>
</body>
</html>
    