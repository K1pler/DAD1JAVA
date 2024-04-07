<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="edu.ucam.servlet.Control"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menú de Asignaturas</title>
</head>
<body>
    <ul>
        <li><a href="Control?<%=Control.PARAM_ACTION_ID%>=INSERTAR_ASIGNATURA">Insertar</a></li>
        <li><a href="Control?<%=Control.PARAM_ACTION_ID%>=BORRAR_ASIGNATURA">Borrar</a></li>
        <li><a href="Control?<%=Control.PARAM_ACTION_ID%>=MODIFICAR_ASIGNATURA">Modificar</a></li>
        <li><a href="Control?<%=Control.PARAM_ACTION_ID%>=LISTAR_ASIGNATURA">Listar</a></li>
        <li><a href="Control?<%=Control.PARAM_ACTION_ID%>=GET_ASIGNATURA">GET</a></li>
    </ul>
</body>
</html>
