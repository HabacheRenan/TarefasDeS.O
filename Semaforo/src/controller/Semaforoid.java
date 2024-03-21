package controller;
import java.util.concurrent.Semaphore;

public class Semaforoid extends Thread
{	
	private int id;
	Semaphore semaforo;
	
	public Semaforoid()
	{
		super();
	}
	
	
	public Semaforoid(int id,Semaphore semaforo)
	{
		this.id = id;
		this.semaforo = semaforo;
	}
	
	public void run()
	{
		if( id % 3 == 0 )
		{
			for(int i = 0; i < 4; i++)
			{				
				try
				{
					semaforo.acquire();
					calculo(1000,2000);
					transacao(1500);
				}
				catch(Exception e)
				{
					System.err.println(e.getMessage());
				}
				finally
				{
					semaforo.release();
				}
			}
		}
		if( id % 3 == 1 )
		{
			for(int i = 0; i < 4; i++)
			{
				
				try
				{
					semaforo.acquire();
					calculo(200,1000);
					transacao(1000);
				}
				catch(Exception e)
				{
					System.err.println(e.getMessage());
				}
				finally
				{
					semaforo.release();
				}
			}
		}
		if( id % 3 == 2 ) 
		{
			for(int i = 0; i < 4; i++)
			{				
				try
				{
					semaforo.acquire();
					calculo(500,1500);
					transacao(1500);
				}
				catch(Exception e)
				{
					System.err.println(e.getMessage());
				}
				finally
				{
					semaforo.release();
				}
			}
		}	
	}
	
	public void calculo(int min, int max)
	{	
		int tempo = (int) (Math.random()*(max-min)+min);
		System.out.println("Thread #" + getId() + ", calculando...tempo estimado: " + tempo + "ms");
		
		try
		{
			sleep(tempo);
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

	
	public void transacao(int TempEspera)
	{
		System.out.println("Thread #" + getId() + ", Realizando Transacao... tempo estimado: " + TempEspera + "s");
		try 
		{
			sleep(TempEspera);
		} 
		catch (Exception e) 
		{
			System.err.println(e.getMessage());
		}
	}
}
