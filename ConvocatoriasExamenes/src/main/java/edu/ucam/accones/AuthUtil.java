package edu.ucam.accones;


import edu.ucam.modelos.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AuthUtil {

    private static final String USUARIOS_FILE = "usuarios.txt";
      
    
    // Leer usuarios del archivo
    public static List<Usuario> leerUsuarios() throws IOException {
        List<Usuario> usuarios = new ArrayList<>();
        File file = new File(USUARIOS_FILE);

        if (!file.exists()) {
            // Si el archivo no existe, crea un administrador predeterminado
            Usuario adminDefault = new Usuario("Admin", "admin@gmail.com", "admin", true);
            usuarios.add(adminDefault);
            escribirUsuarios(usuarios);
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(";");
                    Usuario usuario = new Usuario(parts[0], parts[1], parts[2], Boolean.parseBoolean(parts[3]));
                    usuarios.add(usuario);
                }
            }
        }
        return usuarios;
    }
    
    

    // Escribir usuarios al archivo
    public static void escribirUsuarios(List<Usuario> usuarios) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USUARIOS_FILE))) {
            for (Usuario usuario : usuarios) {
                writer.write(usuario.getNombre() + ";" + usuario.getEmail() + ";" + usuario.getPassword() + ";" + usuario.isEsAdmin() + "\n");
            }
        }
    }

    // Autenticar usuario
    public static Usuario autenticar(String email, String password) {
        try {
            List<Usuario> usuarios = leerUsuarios();
            for (Usuario usuario : usuarios) {
                if (usuario.getEmail().equalsIgnoreCase(email) && usuario.getPassword().equals(password)) {
                    return usuario;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static boolean borrarUsuarioPorEmail(String email) throws IOException {
        List<Usuario> usuarios = leerUsuarios();
        List<Usuario> actualizados = usuarios.stream()
                                             .filter(u -> !u.getEmail().equalsIgnoreCase(email))
                                             .collect(Collectors.toList());
        if (usuarios.size() == actualizados.size()) {
            return false; // No se encontró el usuario, así que no se borró nada
        }
        escribirUsuarios(actualizados); // Reescribir el archivo sin el usuario borrado
        return true;
    }
    
    
    public static Usuario obtenerUsuarioPorEmail(String email) throws IOException {
        List<Usuario> usuarios = leerUsuarios();
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equalsIgnoreCase(email)) {
                return usuario;
            }
        }
        return null;
    }

    public static void actualizarUsuario(Usuario usuarioActualizado) throws IOException {
        List<Usuario> usuarios = leerUsuarios();
        usuarios = usuarios.stream().map(usuario -> {
            if (usuario.getEmail().equalsIgnoreCase(usuarioActualizado.getEmail())) {
                return usuarioActualizado;
            }
            return usuario;
        }).collect(Collectors.toList());

        escribirUsuarios(usuarios);
    }

    
    
}
