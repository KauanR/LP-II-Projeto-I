package br.com.uri.quiz.models;

import java.util.ArrayList;

public class ObjectiveQuestion extends Question {

	private ArrayList<String> answers = new ArrayList<String>();
	private String correctAnswer = "";
	
	public ObjectiveQuestion() {
		super("Objetiva");
	}

	@Override
	public void readData() {
		super.readData();

		boolean addAnswerFlag = true;
		
		while(addAnswerFlag && this.answers.size() <= 5) {
			System.out.println("Digite a alternativa");
			while(!this.addAnswers(scanner.nextLine()));
			
			if(this.correctAnswer.equals("")) {
				System.out.println("É a resposta correta?(y/n)");
				if(scanner.next().toLowerCase().equals("y")) this.correctAnswer = this.answers.get(this.answers.size() -1);
				scanner.nextLine();
			}

			if(this.answers.size() > 2) {
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
	
	public boolean addAnswers(String answer) {
		if(answer.equals("")) {
			this.invalidValuePrint();
			return false;
		} else {			
			this.answers.add(answer);
			return true;
		}
	}

	public ArrayList<String> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	
}
