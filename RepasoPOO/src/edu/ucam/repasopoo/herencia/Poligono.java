package edu.ucam.repasopoo.herencia;

public abstract class Poligono {
	private int lados;
	
	public Poligono() {
		
	}
	
	public abstract int getLados();

	public Poligono(int lados) {
		super();
		this.lados = lados;
	}	

	public void setLados(int lados) {
		this.lados = lados;
	}
	
	
}
