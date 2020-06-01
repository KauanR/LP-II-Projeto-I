package br.com.uri.quiz.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.com.uri.quiz.models.Common;
import br.com.uri.quiz.models.DescriptiveQuestion;
import br.com.uri.quiz.models.ObjectiveQuestion;
import br.com.uri.quiz.models.Quiz;
import br.com.uri.quiz.models.QuizScore;
import br.com.uri.quiz.models.Student;

public class PlayQuiz extends Common {
	
	private QuizScore quizScore;
	
	public PlayQuiz() {
		this.quizScore = new QuizScore();
	}

	public boolean playQuiz(ArrayList<Quiz> quizzes) {
		if(quizzes.size() > 0) {
			quizScore.setQuiz(this.selectQuiz(quizzes));
			
			quizScore.setStudent(this.createStudent());
			
			double finalScore = 0;
			finalScore += this.playDescriptiveQuestions(quizScore.getQuiz().getDescritiveQuestions());
			this.scanner.nextLine();
			finalScore += this.playObjectiveQuestions(quizScore.getQuiz().getObjectiveQuestions());
			quizScore.setPoints(finalScore);
			return true;
		} else {
			System.out.println("Nenhum quiz cadastrado no momento");
			return false;
		}
	}

	private Quiz selectQuiz(ArrayList<Quiz> quizzes) {

		Map<Integer, Quiz> quizSelector = new HashMap<Integer, Quiz>();
		int i = 1;

		System.out.println("Selecione um Quiz para jogar:");
		this.dashLinePrint();
		for(Quiz quiz : quizzes) {
			System.out.println(i + " - " + quiz.getDescription());
			quizSelector.put(i, quiz);
			i++;
		}
		this.dashLinePrint();
		
		int selected = scanner.nextInt();
		return quizzes.get(selected - 1);
	}

	private Student createStudent() {
		Student student = new Student();
		student.readData();
		return student;
	}
	
	private int playDescriptiveQuestions(ArrayList<DescriptiveQuestion> questions) {
		int i = 1;
		int score = 0;
		for(DescriptiveQuestion question : questions) {
			
			System.out.println("Pergunta descritiva " + i + ": " + question.getDescription());
			System.out.println("Digite a resposta: ");
			
			String response = scanner.nextLine();
			if(question.getCorrectAnswer().equals(response)) {
				System.out.println("Resposta correta.");
				score += question.getPoints();
			} else {
				System.out.println("Resposta errada.");
			}
			
			i++;
		}
		return score;
	}
	
	private int playObjectiveQuestions(ArrayList<ObjectiveQuestion> questions) {

		int i = 1;
		int score = 0;
		for(ObjectiveQuestion question : questions) {
			System.out.println("Pergunta objetiva " + i + ": " + question.getDescription());
			System.out.println("Alternativas: ");
			
			int j = 1;
			for(String alternative: question.getAnswers()) {
				System.out.println(j + " - " + alternative);
				j++;
			}
			System.out.println("Digite a alternativa correta: ");
			
			int response = scanner.nextInt();
			if(question.getAnswers().get(response - 1).equals(question.getCorrectAnswer())) {
				System.out.println("Resposta correta.");
				score += question.getPoints();
			} else {
				System.out.println("Resposta errada.");
			}

			i++;
		}
		
		return score;
	}
	
	public QuizScore getQuizScore() {
		return quizScore;
	}
}
