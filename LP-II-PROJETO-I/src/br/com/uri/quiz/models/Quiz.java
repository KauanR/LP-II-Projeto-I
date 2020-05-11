package br.com.uri.quiz.models;

import java.util.ArrayList;

import br.com.uri.quiz.interfaces.Entity;

public class Quiz extends Common implements Entity {

	private String description;
	private Class classRef;
	private byte situation;
	private ArrayList<DescriptiveQuestion> descritiveQuestions = new ArrayList<DescriptiveQuestion>();
	private ArrayList<ObjectiveQuestion> objectiveQuestions = new ArrayList<ObjectiveQuestion>();
	
	
	@Override
	public void readData() {
		System.out.println("Digite a descrição do Quiz:");
		while(!this.setDescription(scanner.nextLine()));
		
		this.setClassRef(new Class());

		boolean addQuestionFlag = true;
		while(addQuestionFlag) {
			System.out.println("Adicionar uma pergunta descritiva ou objetiva? (D = descritiva | O = objetiva)");
			
			String questionType = scanner.nextLine();
			while(!questionType.toLowerCase().equals("d") || !questionType.toLowerCase().equals("o")) {
				this.invalidValuePrint();
				questionType = scanner.nextLine();
			}
			if(questionType.toLowerCase().equals("d")) {
				this.addDescriptiveQuestion(new DescriptiveQuestion());
			} else {
				this.addObjectiveQuestion(new ObjectiveQuestion());
			}
			System.out.println("Adicionar outra pergunta?(y/n)");
			addQuestionFlag = scanner.next().toLowerCase().equals("y");
		}
		System.out.println("Digite a situação do Quiz? (R = rascunho | P = pronto | I = inativo)");		
		this.setSituation(scanner.next());
	}

	@Override
	public void writeData() {
		System.out.println("Descrição do quiz: " + this.description);
		System.out.println("Classe do quiz: " + this.classRef.getName());
		System.out.print("Situação: ");
		switch(situation) {
			case 1:
				System.out.println("rascunho");
			case 2:
				System.out.println("pronto");
			case 3:
				System.out.println("inativo");
		}
		System.out.println("");
	}
	
	public String getDescription() {
		return description;
	}

	public boolean setDescription(String description) {
		if(description.equals("")) {
			this.invalidValuePrint();
			return false;
		}
		this.description = description;
		return true;
	}

	public Class getClassRef() {
		return classRef;
	}

	public void setClassRef(Class classRef) {
		this.classRef = classRef;
	}
	
	public byte getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		switch(situation) {
			case "R":
				this.situation = 1;
				break;
			case "P":
				this.situation = 2;
				break;
			case "I":
				this.situation = 3;
				break;
		}
		
	}

	public void addDescriptiveQuestion(DescriptiveQuestion descriptive) {
		this.descritiveQuestions.add(descriptive);
	}
	
	public void addObjectiveQuestion(ObjectiveQuestion objective) {
		this.objectiveQuestions.add(objective);
	}
}
