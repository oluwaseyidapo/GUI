package quiz.listener;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import quiz.Testing;
import quiz.question.InputQuestion;
import quiz.question.Question;


public class CustomJTextDocumentListener implements DocumentListener {

	private final InputQuestion question;
	public CustomJTextDocumentListener(Question question) {
		this.question = (InputQuestion) question;
	}
	
	public InputQuestion getQuestion() {
		return question;
	}
	
	private boolean isCorect(String input) {
		if(input == null) {
			return false;
		}
		return question.getAnswer().equals(input);
	}
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		try {
			String input = e.getDocument().getText(0, e.getDocument().getLength());
			System.out.println(getQuestion());
			System.out.println(input);
			if(isCorect(input)) {
				System.out.println("you are right");
				
				Testing.NEXT_QUESTION(getQuestion());
			}else {
				System.out.println("you are wrong");
			}
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		try {
			String input = e.getDocument().getText(0, e.getDocument().getLength());
			System.out.println(getQuestion());
			System.out.println(input);
			if(isCorect(input)) {
				System.out.println("you are right");
				Testing.NEXT_QUESTION(getQuestion());
			}else {
				System.out.println("you are wrong");
			}
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		
		try {
			String input = e.getDocument().getText(0, e.getDocument().getLength());
			System.out.println(getQuestion());
			System.out.println(input);
			if(isCorect(input)) {
				System.out.println("you are right");
				
				Testing.NEXT_QUESTION(getQuestion());
			}else {
				System.out.println("you are wrong");
			}
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
	}
}