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
        // Supongamos que tienes un método que genera un ID único para la asignatura
        String id = generarIdUnico();

        // Crear la asignatura y añadirla a la "base de datos" (archivo en este caso)
        Asignatura asignatura = new Asignatura(id, nombre);
        AsignaturaUtil.insertarAsignatura(asignatura);

        // Establecer un atributo de mensaje, si es necesario, para mostrar en la página de administración
        request.setAttribute("mensaje", "Asignatura insertada con éxito.");

        return "CrearAsignatura.jsp";
    }

    private String generarIdUnico() {
        // Implementa la lógica para generar un ID único para cada asignatura
        // Esto es solo un placeholder
        return "ID" + System.currentTimeMillis();
    }
}