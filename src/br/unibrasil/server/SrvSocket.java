package br.unibrasil.server;

import java.io.IOException;
import java.io.PrintStream;
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
					//Full-Duplex
					int count = 0;
					Socket client = server.accept();//Eu recebo o client podemos partir desse
					PrintStream saida = new PrintStream(client.getOutputStream());
					System.out.println("Conectou!!");
					
					Scanner scanner = new Scanner(client.getInputStream());
					recebido = "";
				
					while((!recebido.toUpperCase().equals("SAIR"))&&(!recebido.toUpperCase().equals("FECHAR"))) 
					{
						count++; 
						try {
							recebido = scanner.nextLine();
							System.out.println(recebido);		
							saida.println(count +" - Mensagens Recebidas");
						} catch (Exception e) {
							recebido = "SAIR";
						}					
					}	
					client.close();//O server não morrer
				}
			server.close();  

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
