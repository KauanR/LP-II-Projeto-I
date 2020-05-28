package br.com.uri.quiz.models;

import br.com.uri.quiz.interfaces.Entity;

public class Discipline extends Common implements Entity {

	private String name;
	
	public void readData() {
		System.out.println("Digite o nome da disciplina: ");
		while(!this.setName(scanner.nextLine()));
	}
	
	public void writeData() {
		System.out.println("Nome da disciplina: " + this.name);
	}
	
	public String getName() {
		return name;
	}

	public boolean setName(String name) {
		if(name.equals("")) {
			this.invalidValuePrint();
			return false;
		} else {			
			this.name = name;
			return true;
		}
	}
}
