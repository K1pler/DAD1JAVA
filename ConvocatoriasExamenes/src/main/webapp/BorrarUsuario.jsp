<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Borrar Usuario</title>
</head>
<body>
<h2>Borrar Usuario</h2>
<form action="Control" method="post">
    <input type="hidden" name="ID_ACCION" value="BORRAR_USUARIO" />
    Email del Usuario: <input type="email" name="email" required><br>
    <input type="submit" value="Borrar Usuario">
</form>
</body>
</html>
