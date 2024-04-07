<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="edu.ucam.servlet.Control"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="Control?<%=Control.PARAM_ACTION_ID%>=INSERTAR_USUARIO">Insertar</a>
	<br>
	<a href="Control?<%=Control.PARAM_ACTION_ID%>=BORRAR_USUARIO">Borrar</a>
	<br>

	<a href="Control?<%=Control.PARAM_ACTION_ID%>=MODIFICAR_USUARIO">Modificar</a>
	<br>

	<a href="Control?<%=Control.PARAM_ACTION_ID%>=LISTAR_USUARIO">Listar</a>
	<br>

	<a href="Control?<%=Control.PARAM_ACTION_ID%>=BUSCAR_USUARIO">GET</a>
	<br>
	<br>

</body>
</html>