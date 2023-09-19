package edu.ucam.repasopoo;

public class Root {

	public static void main(String[] args) {
		
		HolaMundo holaMundo;
		
		if(args.length > 0)
			holaMundo = new HolaMundo(args[0]);
		else
			holaMundo = new HolaMundo();
		
		
		holaMundo.sayHello();
		
		holaMundo.pruebaNullPointer("Pedro");
		holaMundo.pruebaNullPointer(null);
	}

}
