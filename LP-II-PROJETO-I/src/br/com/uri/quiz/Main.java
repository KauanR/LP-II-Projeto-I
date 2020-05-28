package br.com.uri.quiz;

import java.util.Scanner;

import br.com.uri.quiz.controllers.AddQuiz;
import br.com.uri.quiz.controllers.PlayQuiz;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Deseja adicionar um quiz ou jogar(1 = cadastrar | 2 = jogar)?");
		
		int x = scanner.nextInt();
		
		if(x == 1) {
			AddQuiz quiz = new AddQuiz();
		} else {
			PlayQuiz play = new PlayQuiz();
		}
		
	}
}
