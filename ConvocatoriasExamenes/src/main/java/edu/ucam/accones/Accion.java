package edu.ucam.accones;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public abstract class Accion {
	
	public abstract String ejecutar (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
