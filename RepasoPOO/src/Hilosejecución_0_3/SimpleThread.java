package Hilosejecución_0_3;

public class SimpleThread extends Thread {
	public static final int FOR_EVER = -1;
	protected long delay;
	protected int times;
	
	public SimpleThread (long delay,int times){
		System.out.println("Constructor SimpleThread");
		this.delay = delay; 
		this.times = times;
	}
	
	public void run(){
		try{
			for( int aux = times;(times >= 0) || (aux == FOR_EVER);times--){
				System.out.println("Mi delay es:"+delay);
				sleep(delay);
			}
			System.out.println("He terminado....("+delay+")");
		}catch(Exception e){ 
			System.out.println("Error."); 
		}
	}
}
