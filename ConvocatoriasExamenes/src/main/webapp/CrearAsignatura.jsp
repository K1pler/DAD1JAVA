<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Crear Asignatura</title>
</head>
<body>

	<h2>A�adir Nueva Asignatura</h2>

	<form action="Control" method="post">
		<input type="hidden" name="ID_ACCION" value="INSERTAR_ASIGNATURA" />
		Nombre de la Asignatura: <input type="text" name="nombre" /><br />
		<br /> <input type="submit" value="Crear Asignatura" />
	</form>
	<h2>Confirmaci�n</h2>
	<%
	String mensaje = (String) request.getAttribute("mensaje");
	if (mensaje != null) {
		out.print("<p>" + mensaje + "</p>");
	}
	%>
	<a href="Admin.jsp">Volver a la administraci�n</a>
</body>
</html>