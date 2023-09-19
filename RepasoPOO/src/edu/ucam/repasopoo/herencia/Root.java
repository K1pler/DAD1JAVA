package edu.ucam.repasopoo.herencia;

public class Root {

	public static void main(String[] args) {
		Poligono poligono = new Triangulo();

		System.out.println(poligono.getLados());
		
		
		poligono = new Cuadrado();

		System.out.println(poligono.getLados());
	}

}
