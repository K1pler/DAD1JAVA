package edu.ucam.accones;

import java.io.IOException;
import java.util.List;

import edu.ucam.modelos.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertarUsuario extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		// Obtener los parámetros del formulario
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		boolean esAdmin = "true".equals(request.getParameter("esAdmin"));

		
		Usuario usuario = new Usuario(nombre, email, password, esAdmin);
		List<Usuario> usuarios = AuthUtil.leerUsuarios();
		// TODO Auto-generated method stub

		usuarios.add(usuario);
		AuthUtil.escribirUsuarios(usuarios);

		// Redirigir al listado de usuarios o mostrar mensaje de éxito
		return "CrearUsuario.jsp"; 
	}

}
