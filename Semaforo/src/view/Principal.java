package view;

import java.util.concurrent.Semaphore;

import controller.Semaforoid;

public class Principal 
{
	public static void main(String[]args)
	{
		Semaphore semaforo = new Semaphore(1);
		for(int i = 1; i < 22; i++)
		{
			Semaforoid Thread = new Semaforoid(i,semaforo);
			Thread.start();
		}
	}
}
