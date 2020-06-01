package br.com.uri.quiz.models;

public class QuizScore extends Common {

	private Quiz quiz;
	private Student student;
	private double points; 
	
	
	public void resultPrint() {
		this.dashLinePrint();
		System.out.println(this.getStudent().getName() + " - " + this.getQuiz().getDescription() + " - " + this.getPoints());
		this.dashLinePrint();
	}
	
	public Quiz getQuiz() {
		return quiz;
	}
	
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	
	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}

}
