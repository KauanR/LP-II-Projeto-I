package br.com.uri.quiz.models;

import java.util.Scanner;
import java.util.UUID;

public class Common {

	private String id = UUID.randomUUID().toString();
	public Scanner scanner = new Scanner(System.in);
	
	public String getId() {
		return id;
	}
	
	public void invalidValuePrint() {
		System.out.println("Valor inválido, digite novamente: ");
	}
	
	public void dashLinePrint() {
		System.out.println("----------------------------------------------------");
	}
}
