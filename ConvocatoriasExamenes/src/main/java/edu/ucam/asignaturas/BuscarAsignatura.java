package edu.ucam.asignaturas;

import java.io.IOException;

import edu.ucam.accones.Accion;
import edu.ucam.modelos.Asignatura;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BuscarAsignatura extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String nombreAsignatura = request.getParameter("nombreAsignatura");
        Asignatura asignatura = AsignaturaUtil.obtenerAsignaturaPorNombre(nombreAsignatura);

        if (asignatura != null) {
            // Asignatura encontrada, se establece el ID para usar en la JSP
            request.setAttribute("idAsignatura", asignatura.getId());
            request.setAttribute("mensaje", "Asignatura encontrada: " + asignatura.getNombre());
        } else {
            // Asignatura no encontrada
            request.setAttribute("mensaje", "Asignatura no encontrada.");
        }

        return "BuscarAsignatura.jsp";  // Asumiendo que tienes un JSP para mostrar los detalles
    }
}
