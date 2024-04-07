<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="edu.ucam.modelos.Asignatura" %>    
<!DOCTYPE html>
<html>
<head>
    <title>Buscar Asignatura</title>
</head>
<body>

<h2>Buscar Asignatura por Nombre</h2>

<form action="Control" method="post">
    <input type="hidden" name="ID_ACCION" value="BUSCAR_ASIGNATURA" />
    Nombre de la Asignatura: <input type="text" name="nombreAsignatura" required /><br/>
    <input type="submit" value="Buscar" />
</form>

<%
    // Se obtiene el ID de la asignatura si fue encontrado o se muestra un mensaje
    String idAsignatura = (String) request.getAttribute("idAsignatura");
    String mensaje = (String) request.getAttribute("mensaje");
    
    if (idAsignatura != null) {
        out.println("<p>ID de la Asignatura: " + idAsignatura + "</p>");
    } else if (mensaje != null) {
        out.println("<p>" + mensaje + "</p>");
    }
%>
<a href="Admin.jsp">Volver a la administración</a>
</body>
</html>