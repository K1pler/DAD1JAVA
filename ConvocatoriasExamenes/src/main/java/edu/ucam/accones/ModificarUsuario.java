package edu.ucam.accones;

import java.io.IOException;

import edu.ucam.modelos.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ModificarUsuario extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String email = request.getParameter("email");
	        String nuevoNombre = request.getParameter("nombre");
	        // Otros parámetros según sea necesario

	        Usuario usuario = AuthUtil.obtenerUsuarioPorEmail(email);
	        if (usuario != null) {
	            usuario.setNombre(nuevoNombre);
	            // Establecer otros atributos
	            AuthUtil.actualizarUsuario(usuario);
	            request.setAttribute("mensaje", "Usuario actualizado con éxito.");
	        } else {
	            request.setAttribute("mensaje", "Usuario no encontrado.");
	        }
	        return "/ModificarUsuario.jsp";
	    }
	}


