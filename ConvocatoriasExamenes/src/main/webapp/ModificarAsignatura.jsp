<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Modificar Asignatura</title>
</head>
<body>

<h2>Modificar Asignatura</h2>

<form action="Control" method="post">
    <input type="hidden" name="ITD_ACCION" value="MODIFICAR_ASIGNATURA" />
    Nombre Actual de la Asignatura: <input type="text" name="nombreActual" required /><br/>
    Nuevo Nombre de la Asignatura: <input type="text" name="nuevoNombre" required /><br/>
    <input type="submit" value="Actualizar Asignatura" />
</form>
</body>
<a href="Admin.jsp">Volver a la administración</a>
</html>