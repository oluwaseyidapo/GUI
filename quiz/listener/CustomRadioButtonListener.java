package quiz.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import quiz.question.MultipleChoiceQuestion;
import quiz.question.Question;


public class CustomRadioButtonListener implements ActionListener {

	private MultipleChoiceQuestion question;
	private String optionPicked;
	public CustomRadioButtonListener(MultipleChoiceQuestion question, String optionPicked) {
		this.question = question;
		this.optionPicked = optionPicked;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println(getQuestion());
		
		System.out.println(optionPicked);
		
		if(answer().equals(optionPicked) ) {
			System.out.println("------------------Correct ----------------------");
		}else {
			System.out.println("Wrong");
		}

	}
	
	public String answer() {
		
		if(question.getAnswer().equals("option1")) {
			return question.getOption1();
		}else if(question.getAnswer().equals("option2")) {
			return question.getOption1();
		}else if(question.getAnswer().equals("option3")) {
			return question.getOption1();
		}else if(question.getAnswer().equals("option4")) {
			return question.getOption1();
		}else {
			throw new RuntimeException("Unknow");
		}
	}
	
	public Question getQuestion() {
		return question;
	}

	public String getOptionPicked() {
		return optionPicked;
	}

}