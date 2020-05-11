package br.com.uri.quiz.models;

import br.com.uri.quiz.interfaces.Entity;

public class PostGraduateStudent extends GraduateStudent implements Entity {

	private String yearOfGraduate;
	
	@Override
    public void readData() {
		super.readData();
        System.out.println("Digite o ano de conclusão: ");
        while(!this.setYearOfGraduate(scanner.nextLine()));
    }

	@Override
	public void writeData() {
		super.writeData();
		System.out.println("Ano de conclusão: " + this.yearOfGraduate);
	}

	public String getYearOfGraduate() {
		return yearOfGraduate;
	}

	public boolean setYearOfGraduate(String yearOfGraduate) {
		if(yearOfGraduate.equals("")) {
			this.invalidValuePrint();
			return false;
		} else {
			this.yearOfGraduate = yearOfGraduate;
			return true;
		}
	}
	
}
