package quiz.question;

public class InputQuestion extends Question {

	public InputQuestion(String question, QType type, String answer) {
		super(question, type, answer);
		
	}

	@Override
	public String toString() {
		return "InputQuestion [getQuestion()=" + getQuestion() + ", getType()=" + getType() + ", getAnswer()="
				+ getAnswer() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
