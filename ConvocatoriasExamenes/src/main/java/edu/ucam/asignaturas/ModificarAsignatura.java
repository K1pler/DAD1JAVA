package edu.ucam.asignaturas;

import java.io.IOException;

import edu.ucam.accones.Accion;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ModificarAsignatura extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String nombreActual = request.getParameter("nombreActual");
        String nuevoNombre = request.getParameter("nuevoNombre");

        boolean exito = AsignaturaUtil.actualizarNombreAsignatura(nombreActual, nuevoNombre);

        if (exito) {
            request.setAttribute("mensaje", "Asignatura actualizada con éxito.");
        } else {
            request.setAttribute("mensaje", "Asignatura no encontrada o error al actualizar.");
        }

        return "ModificarUsuario.jsp";
    }
}