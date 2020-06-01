package br.com.uri.quiz.models;

import br.com.uri.quiz.interfaces.Entity;

public class Student extends Person implements Entity {

	@Override
	public void readData() {
		System.out.println("Digite o nome do aluno: ");
		while(!this.setName(scanner.nextLine()));
	}

	@Override
	public void writeData() {
		System.out.println("Nome do aluno: " + this.getName());
	}

}
