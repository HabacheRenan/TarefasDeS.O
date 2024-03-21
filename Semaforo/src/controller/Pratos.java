package controller;

import java.text.DecimalFormat;
import java.util.concurrent.Semaphore;

public class Pratos extends Thread
{
	int id;
	Semaphore semaforo;
	Pratos()
	{
		super();
	}
	
	public Pratos(int id,Semaphore semaforo)
	{
		this.id = id;
		this.semaforo = semaforo;
	}
	
	
	
	public void run()
	{
		if(id % 2 == 0)
		{
			System.out.println("A lasanha de bolonesa iniciou...");
			cozimentolasanha(1200,600);
		}
		else
		{
			System.out.println("A sopa de cebola iniciou...");
			cozimentocebola(800,500);
		}
	}
	
	public void cozimentolasanha(int max, int min)
	{
		double porcentagem = 0;
		double tempo = (int) (Math.random()*(max-min)+min);
		double aux = 100;
		while( tempo > aux )
		{
			porcentagem = (aux/tempo)*100;
			DecimalFormat formato = new DecimalFormat("#");      
			porcentagem = Double.valueOf(formato.format(porcentagem));
			System.out.println("\nA lasanha de bolonesa numero #" + getId() + " está a " + porcentagem + "% de ficar pronta");
			aux += 100;
			try
			{
				sleep(100);
			}
			catch(Exception e)
			{
				System.err.println(e.getMessage());
			}
		}
		try
		{
			System.out.println("\nA lasanha ficou pronta");
			semaforo.acquire();
			sleep(500);
			System.out.println("\nA lasanha foi entregue");
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
	
	public void cozimentocebola(int max, int min)
	{
		double porcentagem = 0;
		double tempo = (int) (Math.random()*(max-min)+min);
		double aux = 100;
		while( tempo > aux )
		{
			porcentagem = (aux/tempo)*100;
			DecimalFormat formato = new DecimalFormat("#");      
			porcentagem = Double.valueOf(formato.format(porcentagem));
			System.out.println("\nA Sopa de cebola numero #" + getId() + " está a " + porcentagem + "% de ficar pronta");
			aux += 100;
			try
			{
				sleep(100);
			}
			catch(Exception e)
			{
				System.err.println(e.getMessage());
			}
		}
		try
		{
			System.out.println("\nA Sopa de cebola ficou pronta");
			semaforo.acquire();
			sleep(500);
			System.out.println("\nA Sopa de cebola foi entregue");
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
