package edu.ucam.asignaturas;

import edu.ucam.modelos.Asignatura;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AsignaturaUtil {
	private static final String ASIGNATURAS_FILE = "asignaturas.txt";

	// Leer asignaturas del archivo
	public static List<Asignatura> leerAsignaturas() throws IOException {
		List<Asignatura> asignaturas = new ArrayList<>();
		File file = new File(ASIGNATURAS_FILE);

		if (!file.exists()) {
			// Si el archivo no existe, podrías querer manejarlo de alguna manera
			// Por ejemplo, podrías querer crear el archivo o lanzar una excepción
			file.createNewFile(); // Esto creará un archivo vacío si no existe
		} else {
			try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
				String line;
				while ((line = reader.readLine()) != null) {
					String[] parts = line.split(";");
					// Asegúrate de que las partes coincidan con cómo guardas las asignaturas
					// Por ejemplo, si solo guardas el id y el nombre
					Asignatura asignatura = new Asignatura(parts[0], parts[1]);
					asignaturas.add(asignatura);
				}
			}
		}
		return asignaturas;
	}

	// Método para insertar una nueva asignatura en el archivo
	public static void insertarAsignatura(Asignatura asignatura) throws IOException {
		BufferedWriter writer = null;
		try {
			// Asegúrate de que el archivo exista antes de intentar escribir en él
			File file = new File(ASIGNATURAS_FILE);
			if (!file.exists()) {
				file.createNewFile();
			}
			// Añadir true al FileWriter para habilitar el modo de añadir
			writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(asignatura.getId() + ";" + asignatura.getNombre() + "\n");
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	// Escribir asignaturas al archivo
	public static void escribirAsignaturas(List<Asignatura> asignaturas) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(ASIGNATURAS_FILE))) {
			for (Asignatura asignatura : asignaturas) {
				writer.write(asignatura.getId() + ";" + asignatura.getNombre() + "\n");
			}
		}
		// No necesitas manejar el cierre del BufferedWriter aquí ya que está en un
		// try-with-resources
	}

	public static boolean borrarAsignaturaPorNombre(String nombre) throws IOException {
        List<Asignatura> asignaturas = leerAsignaturas();
        boolean encontrado = false;

        Iterator<Asignatura> iterator = asignaturas.iterator();
        while (iterator.hasNext()) {
            Asignatura asignatura = iterator.next();
            if (asignatura.getNombre().equalsIgnoreCase(nombre)) {
                iterator.remove();  // Eliminar la asignatura si el nombre coincide
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            escribirAsignaturas(asignaturas); // Sobreescribir el archivo con las asignaturas actualizadas
        }

        return encontrado;
    }
	public static void actualizarAsignatura(Asignatura asignaturaActualizada) throws IOException {
        List<Asignatura> asignaturas = leerAsignaturas();
        boolean encontrado = false;

        for (int i = 0; i < asignaturas.size(); i++) {
            Asignatura asignatura = asignaturas.get(i);
            if (asignatura.getId().equals(asignaturaActualizada.getId())) {
                asignaturas.set(i, asignaturaActualizada);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            escribirAsignaturas(asignaturas);
        } else {
            // Manejar el caso en que la asignatura no se encuentra.
            // Puede lanzar una excepción o simplemente no hacer nada si regresar false es suficiente.
        }
    }
	public static boolean actualizarNombreAsignatura(String nombreActual, String nuevoNombre) throws IOException {
        List<Asignatura> asignaturas = leerAsignaturas();
        boolean encontrado = false;

        for (Asignatura asignatura : asignaturas) {
            if (asignatura.getNombre().equalsIgnoreCase(nombreActual)) {
                asignatura.setNombre(nuevoNombre);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            escribirAsignaturas(asignaturas);
        }

        return encontrado;
    }
	public static Asignatura obtenerAsignaturaPorNombre(String nombreAsignatura) {
        List<Asignatura> asignaturas = null;
		try {
			asignaturas = leerAsignaturas();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        for (Asignatura asignatura : asignaturas) {
            if (asignatura.getNombre().equalsIgnoreCase(nombreAsignatura)) {
                return asignatura;
            }
        }
        return null; // Si no se encuentra, se retorna null
    }
	public static String obtenerIdAsignaturaPorNombre(String nombre) throws IOException {
        List<Asignatura> asignaturas = leerAsignaturas();
        for (Asignatura asignatura : asignaturas) {
            if (asignatura.getNombre().equalsIgnoreCase(nombre)) {
                return asignatura.getId();  // Devuelve el ID si el nombre coincide
            }
        }
        return null;  // Devuelve null si no se encuentra la asignatura con ese nombre
    }
}
