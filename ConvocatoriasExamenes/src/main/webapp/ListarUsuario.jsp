<%@ page import="java.util.List"%>
<%@ page import="edu.ucam.modelos.Usuario"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Listado de Usuarios</title>
</head>
<body>
	<h2>Usuarios</h2>
	<%
	List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
	if (usuarios != null) {
		for (Usuario usuario : usuarios) {
	%>
	Nombre:
	<%=usuario.getNombre()%>, Email:
	<%=usuario.getEmail()%>, Admin:
	<%=usuario.isEsAdmin() ? "Sí" : "No"%><br>
	<%
	}
	} else {
	%>
	<p>No hay usuarios para mostrar.</p>
	<%
	}
	%>
</body>
</html>
