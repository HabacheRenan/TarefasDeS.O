package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RedesController 
{
    public RedesController() 
    {
        super();
    }

    public String os() 
    {
        String so = System.getProperty("os.name");
        return so;
    }

    public String ip()
    {
    	// meu linux não aparece adaptador nem ipv4 quando digito "ip addr"
        String linha = null;
        StringBuilder output = new StringBuilder();
        String ver = os();
        if(ver.contains("Windows"))
        {
        	try
        	{
            	Process process = Runtime.getRuntime().exec("ipconfig");
            	BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            	while ((linha = reader.readLine()) != null)
            	{
            		if(linha.contains("Adaptador Ethernet") || linha.contains("IPv4"))
            		{
            			output.append(linha).append("\n");
            		}
            	}
            	reader.close();
            	process.waitFor();
        	}
        	catch (IOException | InterruptedException e) 
        	{
            	e.printStackTrace();
        	}
        }
        else
        {
        	try
        	{
            	Process process = Runtime.getRuntime().exec("ifconfig");
            	BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            	while ((linha = reader.readLine()) != null)
            	{
            		if(linha.contains("Adaptador Ethernet") || linha.contains("IPv4"))
            		{
            			output.append(linha).append("\n");
            		}
            	}
            	reader.close();
            	process.waitFor();
        	}
        	catch (IOException | InterruptedException e) 
        	{
            	e.printStackTrace();
        	}
        }
        
        return output.toString();
    }
    public double ping()
    {
    	int aux = 0;
    	double media = 0, ping = 0;
    	String[] separar;
    	String juntar;
    	String linha = null;
    	String verificar = os();
    	if(verificar.contains("Windows"))
    	{
    		try
    		{
    			Process process = Runtime.getRuntime().exec("ping -4 -n 10 www.google.com");
    			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    			while((linha = reader.readLine()) != null)
    			{
    				if(linha.contains("tempo="))
    				{
    					separar = linha.split("tempo=");
    					juntar = separar[1].trim().split("")[0];
    					ping = Double.parseDouble(juntar);
    					media += ping;
    					aux++;
    				}
    			}
    			reader.close();
    			process.waitFor();
    			media = (media/aux);
    			
    		}
    		catch (IOException | InterruptedException e) 
        	{
            	e.printStackTrace();
            	
        	}
        }
    	else
    	{
    		try
    		{
    			Process process = Runtime.getRuntime().exec("ping -4 -c 10 www.google.com");
    			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    			while((linha = reader.readLine()) != null)
    			{
    				if(linha.contains("time="))
    				{
    					separar = linha.split("time=");
    					juntar = separar[1].trim().split(" ")[0];
    					ping = Double.parseDouble(juntar);
    					media += ping;
    					aux++;
    				}
    			}
    			reader.close();
    			process.waitFor();
    			media /= aux;
    			
    		}
    		catch (IOException | InterruptedException e) 
        	{
            	e.printStackTrace();
        	}
    		
    	}
    	return media;
    }
}
