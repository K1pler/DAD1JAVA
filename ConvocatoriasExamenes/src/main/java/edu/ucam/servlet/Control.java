package edu.ucam.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Hashtable;

import edu.ucam.accones.Accion;
import edu.ucam.accones.BorrarUsuario;
import edu.ucam.accones.BuscarUsuario;
import edu.ucam.accones.InsertarUsuario;
import edu.ucam.accones.ListarUsuario;
import edu.ucam.accones.Login;
import edu.ucam.accones.ModificarUsuario;
import jakarta.servlet.ServletConfig;
import edu.ucam.asignaturas.BorrarAsignatura;
import edu.ucam.asignaturas.BuscarAsignatura;
import edu.ucam.asignaturas.InsertarAsignatura;
import edu.ucam.asignaturas.ListarAsignatura;
import edu.ucam.asignaturas.ModificarAsignatura;


public class Control extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Hashtable<String, Accion> acciones;

	public static final String PARAM_ACTION_ID = "ID_ACCION";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Control() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		this.acciones = new Hashtable<String, Accion>();

		this.acciones.put("Login", new Login());
		this.acciones.put("LISTAR_USUARIO", new ListarUsuario());
		acciones.put("INSERTAR_USUARIO", new InsertarUsuario());
		acciones.put("MODIFICAR_USUARIO", new ModificarUsuario());
		acciones.put("BORRAR_USUARIO", new BorrarUsuario());
		acciones.put("BUSCAR_USUARIO", new BuscarUsuario());

		// Acciones de asignaturas
		this.acciones.put("INSERTAR_ASIGNATURA", new InsertarAsignatura());
		this.acciones.put("LISTAR_ASIGNATURA", new ListarAsignatura());
		this.acciones.put("MODIFICAR_ASIGNATURA", new ModificarAsignatura());
		this.acciones.put("BORRAR_ASIGNATURA", new BorrarAsignatura());
		this.acciones.put("BUSCAR_ASIGNATURA", new BuscarAsignatura());

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jsp = "index.jsp";

		String paramIdAccion = request.getParameter(Control.PARAM_ACTION_ID);

		Accion accion = this.acciones.get(paramIdAccion);

		jsp = accion.ejecutar(request, response);

		request.getRequestDispatcher(jsp).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
