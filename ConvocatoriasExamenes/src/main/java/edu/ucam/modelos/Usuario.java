package edu.ucam.modelos;


public class Usuario {
    private String nombre;
    private String email;
    private String password;
    private boolean esAdmin;

    public Usuario(String nombre, String email, String password, boolean esAdmin) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.esAdmin = esAdmin;
    }

	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public boolean isEsAdmin() {
		return esAdmin;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}

   
}
