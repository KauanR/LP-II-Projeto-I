package br.com.uri.quiz.controllers;

import br.com.uri.quiz.models.Teacher;

public class AddQuiz {

	private Teacher teacher = new Teacher();
	
	public AddQuiz() {
		this.teacher.readData();
		//this.teacher.writeData();
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
}
