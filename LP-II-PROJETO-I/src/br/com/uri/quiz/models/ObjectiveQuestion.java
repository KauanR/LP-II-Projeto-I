package br.com.uri.quiz.models;

import java.util.ArrayList;

public class ObjectiveQuestion extends Question {

	private ArrayList<String> answers = new ArrayList<String>();
	
	public ObjectiveQuestion() {
		super("Objetiva");
	}
	
	@Override
	public void readData() {
		super.readData();

		int answersCont = 0;
		boolean addAnswerFlag = true;
		while(answersCont < 5 && addAnswerFlag) {
			System.out.println("Digite a alternativa: ");
			this.addAnswers(scanner.nextLine());
			answersCont++;
			if(answersCont >= 2) {
				System.out.println("Deseja adicionar outra alternativa?(y/n)");
				addAnswerFlag = scanner.next().toLowerCase().equals("y");
			}
		}
	}

	@Override
	public void writeData() {
		super.writeData();
		for(String answer : answers) {
			System.out.println("Resposta: " + answer);
		}
	}
	
	public void addAnswers(String answer) {
		this.answers.add(answer);
	}

	public ArrayList<String> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}
}
