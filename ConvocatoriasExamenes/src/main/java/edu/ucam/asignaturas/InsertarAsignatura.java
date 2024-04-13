package edu.ucam.asignaturas;
import edu.ucam.accones.Accion;
import edu.ucam.modelos.Asignatura;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class InsertarAsignatura extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener los parámetros del formulario
        String nombre = request.getParameter("nombre");
        // Método que genera un ID único para la asignatura
        String id = generarIdUnico();

        // Crear la asignatura e insertar
        Asignatura asignatura = new Asignatura(id, nombre);
        AsignaturaUtil.insertarAsignatura(asignatura);
 
        request.setAttribute("mensaje", "Asignatura insertada con éxito.");

        return "CrearAsignatura.jsp";
    }

    private String generarIdUnico() {
        return "ID" + System.currentTimeMillis();
    }
}