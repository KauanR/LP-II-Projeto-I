package br.com.uri.quiz.models;

import java.util.ArrayList;

import br.com.uri.quiz.interfaces.Entity;

public class Quiz extends Common implements Entity {

	private String description;
	private byte situation;
	private ArrayList<DescriptiveQuestion> descritiveQuestions = new ArrayList<DescriptiveQuestion>();
	private ArrayList<ObjectiveQuestion> objectiveQuestions = new ArrayList<ObjectiveQuestion>();
	
	
	@Override
	public void readData() {
		System.out.println("Digite a descrição do Quiz:");
		while(!this.setDescription(scanner.nextLine()));

		boolean addQuestionFlag = true;
		while(addQuestionFlag) {
			System.out.println("Adicionar uma pergunta descritiva ou objetiva? (D = descritiva | O = objetiva)");
			
			String questionType = scanner.nextLine();
			while(!questionType.toLowerCase().equals("d") && !questionType.toLowerCase().equals("o")) {
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
			scanner.nextLine();
		}
		System.out.println("Digite a situação do Quiz? (R = rascunho | P = pronto | I = inativo)");
		while(!this.setSituation(scanner.nextLine()));
	}

	@Override
	public void writeData() {
		this.dashLinePrint();
		System.out.println("Descrição do quiz: " + this.description);
		System.out.print("Situação: ");
		switch(situation) {
			case 1:
				System.out.println("rascunho");
				break;
			case 2:
				System.out.println("pronto");
				break;
			case 3:
				System.out.println("inativo");
				break;
		}
		System.out.println("");
		System.out.println("Questões descritivas:");
		for(DescriptiveQuestion desc : descritiveQuestions) {
			desc.writeData();
		}
		System.out.println("Questões objetivas:");
		for(ObjectiveQuestion obj : objectiveQuestions) {
			obj.writeData();
		}
		this.dashLinePrint();
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
	
	public byte getSituation() {
		return situation;
	}

	public boolean setSituation(String situation) {
		switch(situation.toLowerCase()) {
			case "r":
				this.situation = 1;
				return true;
			case "p":
				this.situation = 2;
				return true;
			case "i":
				this.situation = 3;
				return true;
			default:
				this.invalidValuePrint();
				return false;
		}
	}

	public void addDescriptiveQuestion(DescriptiveQuestion descriptive) {
		descriptive.readData();
		this.descritiveQuestions.add(descriptive);
	}
	
	public void addObjectiveQuestion(ObjectiveQuestion objective) {
		objective.readData();
		this.objectiveQuestions.add(objective);
	}
}
