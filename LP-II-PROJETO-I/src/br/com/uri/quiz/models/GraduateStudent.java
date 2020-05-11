package br.com.uri.quiz.models;

import br.com.uri.quiz.interfaces.Entity;

public class GraduateStudent extends Student implements Entity {

	private String graduate;
	private String institute;
	private Course course;
	private String yearOfStart;
	
	@Override
	public void readData() {
		super.readData();

		System.out.println("Digite a graduação: ");
        while(!this.setGraduate(scanner.nextLine()));
        
        System.out.println("Digite a instituição da graduação: ");
        while(!this.setInstitute(scanner.nextLine()));

        this.setCourse(new Course());

        System.out.println("Digite o ano de início: ");
        while(!this.setYearOfStart(scanner.nextLine()));
	}

	@Override
	public void writeData() {
		super.writeData();
		System.out.println("Graduação: " + this.graduate);
		System.out.println("Instituto: " + this.institute);
		System.out.println("Curso: " + this.course.getName());
		System.out.println("Ano de inicio: " + this.getYearOfStart());
	}
	
	public String getGraduate() {
		return graduate;
	}

	public boolean setGraduate(String graduate) {
		if(graduate.equals("")) {
			this.invalidValuePrint();
			return false;
		} else {
			this.graduate = graduate;
			return true;
		}
	}

	public String getInstitute() {
		return institute;
	}

	public boolean setInstitute(String institute) {
		if(institute.equals("")) {
			this.invalidValuePrint();
			return false;
		} else {
			this.institute = institute;
			return true;
		}
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getYearOfStart() {
		return yearOfStart;
	}

	public boolean setYearOfStart(String yearOfStart) {
		if(yearOfStart.equals("")) {
			this.invalidValuePrint();
			return false;
		} else {
			this.yearOfStart = yearOfStart;
			return true;
		}
	}
}
