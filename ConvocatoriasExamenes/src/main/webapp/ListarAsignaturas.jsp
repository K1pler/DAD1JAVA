<%@ page import="edu.ucam.modelos.Asignatura" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listado de Asignaturas</title>
</head>
<body>

<h2>Asignaturas</h2>

<%
List<Asignatura> asignaturas = (List<Asignatura>) request.getAttribute("asignaturas");
if (asignaturas != null && !asignaturas.isEmpty()) {
    for (Asignatura asignatura : asignaturas) {
%>
        ID: <%=asignatura.getId()%>, Nombre: <%=asignatura.getNombre()%><br/>
<%
    }
} else {
%>
    <p>No hay asignaturas para mostrar.</p>
<%
}
%>

</body>
</html>