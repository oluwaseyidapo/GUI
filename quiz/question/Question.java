package quiz.question;

public class Question {
	
	private String question;
	private QType type;
	private String answer;
	
	public Question(String question, QType type, String answer) {
		super();
		this.question = question;
		this.type = type;
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public QType getType() {
		return type;
	}

	public String getAnswer() {
		return answer;
	}
	
	public enum QType{
		
		MULTI("Multiple choice"), INPUT("input");
		
		private String value;
		
		private QType(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}
	}
}
