package br.com.uri.quiz.models;

import br.com.uri.quiz.interfaces.Entity;

public abstract class Alternative extends Common implements Entity {

	private String description;
	
	public void readData() {
		System.out.println("Digite a descrição da alternativa: ");
		while(!this.setDescription(scanner.nextLine()));
	}
	
	public void writeData() {
		System.out.println("Descrição: " + this.description);
	}

	public String getDescription() {
		return description;
	}

	public boolean setDescription(String description) {
		if(description.equals("")) {
			this.invalidValuePrint();
			return false;
		} else {			
			this.description = description;
			return true;
		}
	}
	
}
