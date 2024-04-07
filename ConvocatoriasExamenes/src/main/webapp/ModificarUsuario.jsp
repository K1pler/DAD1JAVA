<%@ page import="edu.ucam.modelos.Usuario"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<html>
<head>
    <title>Modificar Asignatura</title>
</head>
<body>

<h2>Modificar Asignatura</h2>

<form action="Control" method="post">
    <input type="hidden" name="ID_ACCION" value="MODIFICAR_ASIGNATURA" />
    Nombre Actual de la Asignatura: <input type="text" name="nombreActual" required /><br/>
    Nuevo Nombre de la Asignatura: <input type="text" name="nuevoNombre" required /><br/>
    <input type="submit" value="Actualizar Asignatura" />
</form>

</body>
</html>