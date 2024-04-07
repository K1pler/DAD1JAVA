package edu.ucam.asignaturas;

import edu.ucam.accones.Accion;
import edu.ucam.modelos.Asignatura;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListarAsignatura extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        List<Asignatura> asignaturas = AsignaturaUtil.leerAsignaturas();
        request.setAttribute("asignaturas", asignaturas);
        
        return "ListarAsignaturas.jsp"; // La ruta al JSP que lista las asignaturas
    }
}
