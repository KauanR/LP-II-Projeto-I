package br.com.uri.quiz.models;

import br.com.uri.quiz.interfaces.Entity;

public abstract class Employee extends Person implements Entity {

	public void readData(String type) {
		System.out.println("Digite o nome do funcion�rio: ");
		while(!this.setName(scanner.nextLine()));
	}
	
	public void writeData() {
		System.out.println("Nome do funcion�rio: " + this.getName());
	}
}
