package edu.ucam.accones;

import java.io.IOException;

import edu.ucam.modelos.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(
	    name = "ControlServlet",
	    urlPatterns = {"/secured/*"}
	)
public class Login extends Accion{

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");

	    Usuario usuario = AuthUtil.autenticar(email, password);

	    if (usuario != null) {
	        HttpSession session = request.getSession();
	        session.setAttribute("usuarioLogueado", usuario);
	        if (usuario.isEsAdmin()) {
	            return "Admin.jsp"; // Retornar la ruta de admin
	        } else {
	            return "Usuario.jsp"; // Retornar la ruta de usuario normal
	        }
	    } else {
	        return "Login.jsp?error=1"; // Retornar la ruta de login con error
	    }
	}

	

}
