package edu.ucam.accones;

import java.io.IOException;

import edu.ucam.modelos.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BuscarUsuario extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String email = request.getParameter("email");
        Usuario usuario = AuthUtil.obtenerUsuarioPorEmail(email);
        if (usuario != null) {
            request.setAttribute("usuario", usuario);
           
        } else {
            request.setAttribute("mensaje", "Usuario no encontrado.");
       
        }
        return "/BuscarUsuario.jsp"; // La ruta al JSP que muestra los detalles del usuario
    }

}
