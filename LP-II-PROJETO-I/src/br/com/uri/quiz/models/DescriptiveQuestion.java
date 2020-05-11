package br.com.uri.quiz.models;

public class DescriptiveQuestion extends Question {

	private String correctAnswer;
	
	public DescriptiveQuestion() {
		super("descritiva");
	}
	
	@Override
	public void readData() {
		super.readData();
		System.out.println("Digite a resposta da questão: ");
		while(!this.setDescription(scanner.nextLine()));
	}
	
	@Override
	public void writeData() {
		super.writeData();
		System.out.println("Resposta correta: " + this.correctAnswer);
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public boolean setCorrectAnswer(String correctAnswer) {
		if(correctAnswer.equals("")) {
			this.invalidValuePrint();
			return false;
		} else {
			this.correctAnswer = correctAnswer;
			return true;
		}
	}
}
