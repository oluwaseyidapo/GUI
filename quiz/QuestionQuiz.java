package quiz;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.swing.JFrame;

import quiz.question.InputQuestion;
import quiz.question.MultipleChoiceQuestion;
import quiz.question.Question;
import quiz.question.Question.QType;

public class QuestionQuiz extends JFrame { 
	
	private final String QUESTION_PATH = "./Questions.csv"; 
	private List<Question> questions;
	
	public static void main(String [] args) throws Exception {
		
		QuestionQuiz game= new QuestionQuiz();
		game.setVisible(true);
	}
	
	/**
	 * Read questions from file
	 * @return List<Question>
	 * @throws Exception
	 */
	public List<Question> reader() throws Exception {
		
		File infile = new File(QUESTION_PATH);
		
		FileReader reader = new FileReader(infile);
		
		BufferedReader bufrea = new BufferedReader(reader);
		
		List<Question> collection = new ArrayList<>();
		
		List<String> x = bufrea.lines().collect(Collectors.toList());
		
		for (int i = 0; i < x.size(); i++) {
			String[] content = x.get(i).split(",");
			if(i != 0) {
		
				if(QType.INPUT.getValue().equals(content[1])) {
					collection.add(new InputQuestion(content[0], QType.INPUT, content[6]));
				} else if(QType.MULTI.getValue().equals(content[1])) {
					collection.add(new MultipleChoiceQuestion(content[0], QType.MULTI, content[6],content[2],content[3],content[4],content[5]));
				} else {
					throw new Exception("Wrong question type");
				}
			}
		}
		
		bufrea.close();
		reader.close();
		
		return collection;
	}


	public QuestionQuiz() throws Exception {
		this.questions = reader();
		
		if(this.questions.isEmpty()) {
			throw new Exception("U need questions to play the game");
		}
	}
	
}


