package br.com.uri.quiz.models;

import java.util.ArrayList;

import br.com.uri.quiz.interfaces.Entity;

public class Class extends Common implements Entity {
	
	private String name;
	private ArrayList<GraduateStudent> graduateStudents = new ArrayList<GraduateStudent>();
	private ArrayList<PostGraduateStudent> postGraduateStudents = new ArrayList<PostGraduateStudent>();
	
	public void readData() {
		System.out.println("Digite o nome da turma:");
		while(!this.setName(scanner.nextLine()));
		
		boolean addStudentFlag = true;
		while(addStudentFlag) {
			System.out.println("Adicionar uma pergunta descritiva ou objetiva? (G = graduado | P = pós-graduado)");
			
			String studentType = scanner.nextLine();
			while(!studentType.toLowerCase().equals("g") || !studentType.toLowerCase().equals("o")) {
				this.invalidValuePrint();
				studentType = scanner.nextLine();
			}
			if(studentType.toLowerCase().equals("g")) {
				this.addGraduateStudent(new GraduateStudent());
			} else {
				this.addPostGraduateStudent(new PostGraduateStudent());
			}
			System.out.println("Adicionar outro aluno?(y/n)");
			addStudentFlag = scanner.next().toLowerCase().equals("y");
		}
	}

	public void writeData() {
		System.out.println("Nome da turma: " + this.name);
		for(GraduateStudent graduateStudent : graduateStudents) {
			graduateStudent.writeData();
		}
		for(PostGraduateStudent postGraduateStudent : postGraduateStudents) {
			postGraduateStudent.writeData();
		}
	}

	public String getName() {
		return name;
	}

	public boolean setName(String name) {
		if(name.equals("")) {
			this.invalidValuePrint();
			return false;
		} else {
			this.name = name;
			return true;
		}
	}
	

	public ArrayList<GraduateStudent> getGraduateStudents() {
		return graduateStudents;
	}
	

	public void setGraduateStudents(ArrayList<GraduateStudent> graduateStudents) {
		this.graduateStudents = graduateStudents;
	}
	
	public void addGraduateStudent(GraduateStudent student) {
		this.graduateStudents.add(student);
	}
	

	public ArrayList<PostGraduateStudent> getPostGraduateStudents() {
		return postGraduateStudents;
	}
	

	public void setPostGraduateStudents(ArrayList<PostGraduateStudent> postGraduateStudents) {
		this.postGraduateStudents = postGraduateStudents;
	}
	
	public void addPostGraduateStudent(PostGraduateStudent student) {
		this.postGraduateStudents.add(student);
	}
}
