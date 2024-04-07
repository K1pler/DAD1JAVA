<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crear Usuario</title>
</head>
<body>
<h2>Crear Nuevo Usuario</h2>
<form action="Control" method="post">
    <input type="hidden" name="ID_ACCION" value="INSERTAR_USUARIO" />
    Nombre: <input type="text" name="nombre"><br>
    Email: <input type="email" name="email"><br>
    Password: <input type="password" name="password"><br>
    Es Admin: <input type="checkbox" name="esAdmin" value="true"><br>
    <input type="submit" value="Crear Usuario">
</form>
</body>
</html>