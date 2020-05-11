package br.com.uri.quiz.models;

import br.com.uri.quiz.interfaces.Entity;

public class Course extends Common implements Entity {

	private String name;
	
	public void readData() {
		System.out.println("Digite o nome do curso: ");
		while(!this.setName(scanner.nextLine()));
	}
	
	public void writeData() {
		System.out.println("Nome do curso: " + this.name);
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
