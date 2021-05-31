package br.unibrasil.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SrvSocket {
	public void execute() {
		try {
			ServerSocket server = new ServerSocket(12345);			
			String recebido = "";
				while(!recebido.toUpperCase().equals("FECHAR")) 
				{
					System.out.println("Aguardando conexão");
					Socket client = server.accept();
					System.out.println("Conectou!!");
					Scanner scanner = new Scanner(client.getInputStream());
					recebido = "";
				
					while((!recebido.toUpperCase().equals("SAIR"))&&(!recebido.toUpperCase().equals("FECHAR"))) 
					{
						try {
							recebido = scanner.nextLine();
						} catch (Exception e) {
							recebido = "SAIR";
						}
						System.out.println(recebido);			
					}	
					client.close();//O server não morrer
				}
			server.close();  

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
