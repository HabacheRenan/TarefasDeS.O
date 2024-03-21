package view;
import java.util.concurrent.Semaphore;
import controller.Pratos;

public class Main 
{

	public static void main(String[] args) 
	{
		Semaphore semaforo = new Semaphore(1);
		
		for(int i = 1; i < 6; i++)
		{
			Pratos Thread = new Pratos(i,semaforo);
			Thread.start();
		
		

		}
	}
}
