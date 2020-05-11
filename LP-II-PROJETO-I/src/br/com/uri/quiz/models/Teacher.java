package br.com.uri.quiz.models;

import java.util.ArrayList;

public class Teacher extends Employee {

	private ArrayList<Discipline> disciplines = new ArrayList<Discipline>();
	private ArrayList<Quiz> quizzes = new ArrayList<Quiz>();

	@Override
	public void readData() {
		super.readData();
		
		boolean addDisciplineFlag = true;
		while(addDisciplineFlag) {
			this.addDiscipline(new Discipline());
			System.out.println("Adicionar outra disciplina?(y/n)");
			addDisciplineFlag = scanner.next().toLowerCase().equals("y");
		}
		
		boolean addQuizzesFlag = true;
		while(addQuizzesFlag) {
			this.addQuiz(new Quiz());
			System.out.println("Adicionar outro quiz?(y/n)");
			addQuizzesFlag = scanner.next().toLowerCase().equals("y");
		}
	}

	@Override
	public void writeData() {
		super.writeData();
		for(Discipline discipline: disciplines) {
			discipline.writeData();
		}
		for(Quiz quiz : quizzes) {
			quiz.writeData();
		}
	}
	
	public void addDiscipline(Discipline discipline) {
		disciplines.add(discipline);
	}

	public ArrayList<Discipline> getDisciplines() {
		return disciplines;
	}

	public void setDisciplines(ArrayList<Discipline> disciplines) {
		this.disciplines = disciplines;
	}
	
	public void addQuiz(Quiz quiz) {
		this.quizzes.add(quiz);
	}

	public ArrayList<Quiz> getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(ArrayList<Quiz> quizzes) {
		this.quizzes = quizzes;
	}
}
