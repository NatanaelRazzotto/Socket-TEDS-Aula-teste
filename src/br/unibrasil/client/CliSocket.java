package br.unibrasil.client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CliSocket {

	public void execute() {
		Scanner teclado = new Scanner(System.in);
		try {
			Socket client = new Socket("127.0.0.1",12345);
			PrintStream saida = new PrintStream(client.getOutputStream());
			String linha = "";
			while ((!linha.toUpperCase().equals("SAIR"))&&(!linha.toUpperCase().equals("FECHAR"))) {
				linha = teclado.nextLine();
				saida.println(linha);				
			}			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
