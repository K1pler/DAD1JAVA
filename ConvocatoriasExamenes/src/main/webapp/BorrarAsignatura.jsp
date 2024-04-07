<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Borrar Asignatura</title>
</head>
<body>
    <h2>Borrar Asignatura</h2>
    <form action="Control" method="post">
        <input type="hidden" name="ID_ACCION" value="BORRAR_ASIGNATURA" />
        Nombre de la Asignatura: <input type="text" name="nombreAsignatura" required><br><br>
        <input type="submit" value="Borrar Asignatura">
    </form>
    <a href="Admin.jsp">Volver a la administración</a>
</body>
</html>