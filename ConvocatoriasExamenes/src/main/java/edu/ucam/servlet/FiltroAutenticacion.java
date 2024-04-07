package edu.ucam.servlet;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Arrays;

@WebFilter("/*") // Este filtro se aplica a todas las URLs de tu aplicación
public class FiltroAutenticacion extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1565503047025802011L;


	/**
     * @see HttpFilter#HttpFilter()
     */
    public FiltroAutenticacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpSession session = request.getSession(false);
        String path = request.getRequestURI().substring(request.getContextPath().length());

        // Lista de prefijos de páginas que requieren autenticación
        String[] protectedPaths = {
            "/Admin", "/BorrarAsignatura", "/BorrarUsuario", "/BuscarAsignatura",
            "/BuscarUsuario", "/CrearAsignatura", "/CrearUsuario", "/CrudAsignaturas",
            "/CrudUsuario", "/ListarAsignatura", "/ListarUsuario", "/ModificarAsignatura",
            "/ModificarUsuario", "/Usuario"
        };

        boolean isProtectedPath = Arrays.stream(protectedPaths)
                                        .anyMatch(path::startsWith);

        if (isProtectedPath) {
            // Si es una de las páginas protegidas y el usuario no ha iniciado sesión, redirigir a login.jsp
            if (session == null || session.getAttribute("usuarioLogueado") == null) {
                response.sendRedirect(request.getContextPath() + "/login.jsp");
                return;
            }
        }

        // Si no es una página protegida o si el usuario está autenticado, permite que la solicitud continúe.
        chain.doFilter(request, response);
    }
	
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
        // Aquí puedes inicializar recursos del filtro si es necesario
    }

}
