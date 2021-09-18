package quiz.listener;

import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

import quiz.question.Question;


public class InputTextListener implements InputMethodListener {

	private Question question;
	private String answer;
	
	public InputTextListener(Question question, String answer) {
		this.question = question;
		this.answer = answer;
	}
	
	public Question getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}
    
    public  String answer() throws Exception {
    	if(question.getAnswer().equals(answer)) {
    		System.out.println("you are right");
    	}else {
    		throw new Exception("you are wrong");
    	}
    	return answer;
    }
    
	@Override
	public void inputMethodTextChanged(InputMethodEvent event) {
		System.out.println(getQuestion());
		System.out.println(getAnswer());
		if(answer.equals(getAnswer())) {
			System.out.println("you are right");
		} else {
			System.out.println("you are wrong");
		}
	}

	@Override
	public void caretPositionChanged(InputMethodEvent event) {
		
		System.out.println(getQuestion());
		
		System.out.println(getAnswer());
	}

}