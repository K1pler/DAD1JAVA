package edu.ucam.accones;

import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BorrarUsuario extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String email = request.getParameter("email");
	        boolean exito = AuthUtil.borrarUsuarioPorEmail(email);
	        if (exito) {
	            request.setAttribute("mensaje", "Usuario borrado con éxito.");
	        } else {
	            request.setAttribute("mensaje", "Error al borrar el usuario.");
	        }
	        return "/BorrarUsuario.jsp";
	    }

}
