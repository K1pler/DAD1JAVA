package Hilosejecución_0_3;

public class LaunchThread {

	public static void main(String[] args) throws  Exception {
		SimpleThread st = new SimpleThread(2000,SimpleThread.FOR_EVER); st.start();
		st.join(3000); //Espera 3 segundos
		st.interrupt();
		st = new SimpleThread(1000,20); st.start(); //1 segundo 20 vecesst = new SimpleThread(500,30); st.start(); //0,5 segundos 30 veces

	}

}
