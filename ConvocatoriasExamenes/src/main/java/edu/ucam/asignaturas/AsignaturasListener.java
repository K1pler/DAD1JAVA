package edu.ucam.asignaturas;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import java.io.File;
import java.io.IOException;

/**
 * Application Lifecycle Listener implementation class AsignaturasListener
 *
 */
public class AsignaturasListener implements ServletContextListener {

	private static final String ASIGNATURAS_FILE = "asignaturas.txt";
	
    public AsignaturasListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Intenta crear el archivo si no existe al iniciar la aplicación
        File file = new File(sce.getServletContext().getRealPath("/"), ASIGNATURAS_FILE);
        if (!file.exists()) {
            try {
                boolean isCreated = file.createNewFile();
                if (isCreated) {
                    System.out.println("Archivo de asignaturas creado.");
                } else {
                    System.out.println("No se pudo crear el archivo de asignaturas.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}
