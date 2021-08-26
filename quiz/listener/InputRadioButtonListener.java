package quiz.listener;

import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

import quiz.question.Question;


public class InputRadioButtonListener implements InputMethodListener {

	private Question question;
	private String answer;
	
	public InputRadioButtonListener(Question question, String answer) {
		this.question = question;
		this.answer = answer;
		
	}
	
	public Question getQuestion() {
		return question;
	}


	public String getAnswer() {
		return answer;
	}

	@Override
	public void inputMethodTextChanged(InputMethodEvent event) {
		
		System.out.println(getQuestion());
		
		System.out.println(getAnswer());
		

	}

	@Override
	public void caretPositionChanged(InputMethodEvent event) {
		
		System.out.println(getQuestion());
		
		System.out.println(getAnswer());
	}

}