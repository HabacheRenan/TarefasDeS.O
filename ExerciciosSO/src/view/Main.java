	package view;
	import javax.swing.JOptionPane;
	import controller.RedesController;
	public class Main 
	{
		public static void main(String[] args) 
		{
			RedesController rc = new RedesController();
			int x = 0;
			String a;
			while( x != 9)
			{
				x = Integer.parseInt(JOptionPane.showInputDialog("1-Nome S.O \n2-IPConfig \n3-Ping \n9-Terminar"));
				
				switch(x)
				{
					case 1:
						a = rc.os();
						System.out.println("Nome do s.o é: " + a);
						
					break;
					case 2:
						String ipconfig = rc.ip();
						System.out.println("O ipconfig é :\n" + ipconfig);
						
					break;
					case 3:
						double ping = rc.ping();
						System.out.println("A média de ping é de: " + ping);
					
					break;
				}
			}
			
		}
	
	}
