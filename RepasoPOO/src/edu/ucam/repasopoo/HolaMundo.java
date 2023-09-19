package edu.ucam.repasopoo;


public class HolaMundo {
	
	private String name = "";
	
	public HolaMundo() {
		
	}
	
	public HolaMundo(String name) {
		this.name = name;
	}

	public void sayHello() {
		System.out.println("Hola" + (!this.name.equals("")?" " +this.name:"") + "!!");
	}
	
	public void pruebaNullPointer (String parametro) {
		try {
			if (parametro.equals("")) {
				System.out.println("Está vacío");
			}else {
				System.out.println(parametro);
			}
		}catch (NullPointerException npe) {
			System.out.println("Parámetro null");
		}
	}

}
