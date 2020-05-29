package br.com.uri.quiz.models;

import br.com.uri.quiz.interfaces.Entity;

public abstract class Question extends Common implements Entity {

	private String description;
	private String type;
	private double points;
	
	public Question(String type) {
		this.type = type;
	}
	
	public void readData() {
		System.out.println("Digite a descri��o da pergunta: ");
		while(!this.setDescription(scanner.nextLine()));
		System.out.println("Digite quantos pontos a quest�o vale: ");
		while(!this.setPoints(scanner.nextDouble()));
		scanner.nextLine();
	}
	
	public void writeData() {
		System.out.println("Descri��o: " + this.description);
		System.out.println("Tipo: " + this.type);
		System.out.println("Pontos: " + this.points);
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPoints() {
		return points;
	}

	public boolean setPoints(double points) {
		if(points < 0) {
			this.invalidValuePrint();
			return false;
		}
		this.points = points;
		return true;
	}
}
