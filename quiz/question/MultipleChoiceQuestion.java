package quiz.question;

public class MultipleChoiceQuestion extends Question {
	
	private String Option1;
	private String Option2;
	private String Option3;
	private String Option4;
	
	public MultipleChoiceQuestion(String question, QType type, String answer, String option1, String option2,
			String option3, String option4) {
		super(question, type, answer);
		Option1 = option1;
		Option2 = option2;
		Option3 = option3;
		Option4 = option4;
	}
	
	public String getOption1() {
		return Option1;
	}
	
	public String getOption2() {
		return Option2;
	}
	
	public String getOption3() {
		return Option3;
	}
	
	public String getOption4() {
		return Option4;
	}

	@Override
	public String toString() {
		return "MultipleChoiceQuestion [Option1=" + Option1 + ", Option2=" + Option2 + ", Option3=" + Option3
				+ ", Option4=" + Option4 + ", getQuestion()=" + getQuestion() + ", getType()=" + getType()
				+ ", getAnswer()=" + getAnswer() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
