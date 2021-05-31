package br.unibrasil.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SrvSocket {
	public void execute() {
		try {
			ServerSocket server = new ServerSocket(12345);
			System.out.println("Aguardando conexão");
			Socket client = server.accept();
			System.out.println("Conectou!!");
			Scanner scanner = new Scanner(client.getInputStream());
			String recebido = "";
			while(!recebido.toUpperCase().equals("SAIR")) {
				recebido = scanner.nextLine();
				System.out.println("recebeuMensagem");
				System.out.println(recebido);				
			}
			client.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
