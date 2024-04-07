package edu.ucam.accones;

import java.io.IOException;
import java.util.List;

import edu.ucam.modelos.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListarUsuario extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	  
	          List<Usuario> usuarios = AuthUtil.leerUsuarios();
	          request.setAttribute("usuarios", usuarios);
	          return "/ListarUsuario.jsp"; // La ruta al JSP que lista los usuarios
	      }

}
