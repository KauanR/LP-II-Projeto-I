package br.com.uri.quiz;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.uri.quiz.controllers.AddQuiz;
import br.com.uri.quiz.controllers.PlayQuiz;
import br.com.uri.quiz.models.Common;
import br.com.uri.quiz.models.Quiz;
import br.com.uri.quiz.models.QuizScore;

public class Main extends Common {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Quiz> quizzes = new ArrayList<Quiz>(); 
		ArrayList<QuizScore> scores = new ArrayList<QuizScore>();
		
		while(true) {			
			System.out.println("Deseja adicionar um quiz ou jogar(1 = cadastrar | 2 = jogar)?");

			int x = scanner.nextInt();

			if(x == 1) {
				AddQuiz quiz = new AddQuiz();
				quizzes.addAll(quiz.getTeacher().getQuizzes());
			} else if(x == 2) {
				PlayQuiz play = new PlayQuiz();
				boolean auxFlag = play.playQuiz(quizzes);
				if(auxFlag) {
					scores.add(play.getQuizScore());
					if(scores.size() > 0) {
						System.out.println("----------------------------------------------------");
						for(QuizScore score : scores) {
							score.resultPrint();
						}
						System.out.println("----------------------------------------------------");
					}
				}
			} else {
				System.out.println("Valor inválido, digite novamente: ");
			}
		}
	}
	
}
