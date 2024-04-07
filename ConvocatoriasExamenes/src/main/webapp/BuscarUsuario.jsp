<%@ page import="edu.ucam.modelos.Usuario"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Detalle de Usuario</title>
</head>
<body>

	<form action="Control" method="post">
		<input type="hidden" name="ID_ACCION" value="BUSCAR_USUARIO" /> Email
		Del Usuario que busquemos: <input type="email" name="email"><br>

		<%
		Usuario usuario = (Usuario) request.getAttribute("usuario");
		if (usuario != null) {
		%>
		<h2>Detalles de Usuario</h2>
		Nombre:
		<%=usuario.getNombre()%><br> Email:
		<%=usuario.getEmail()%><br> Admin:
		<%=usuario.isEsAdmin() ? "Sí" : "No"%><br>
		<!-- Agregar aquí más campos si es necesario -->
		<%
		} else {
		out.println("<p>Usuario no encontrado.</p>");
		}
		%>



		<input type="submit" value="Buscar Usuario">
	</form>
</body>
</html>
