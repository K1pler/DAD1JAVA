package edu.ucam.asignaturas;

import java.io.IOException;

import edu.ucam.accones.Accion;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BorrarAsignatura extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreAsignatura = request.getParameter("nombreAsignatura");
        boolean exito = AsignaturaUtil.borrarAsignaturaPorNombre(nombreAsignatura);

        if (exito) {
            request.setAttribute("mensaje", "Asignatura borrada con éxito.");
        } else {
            request.setAttribute("mensaje", "Error al borrar la asignatura.");
        }
        return "BorrarAsignatura.jsp";
    }
}
