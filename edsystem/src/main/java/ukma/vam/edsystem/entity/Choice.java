package ukma.vam.edsystem.entity;

public class Choice {

	private Long ch_id;
	
	private String text;
	
	private boolean correct;
	
	private Question question;
	
	public Choice(){
		question = new Question();
	}
	
	public Choice(String text, boolean correct, Long q_id){
		this.text = text;
		this.correct = correct;
		if(question==null){
			question = new Question();
		}
		question.setQ_id(q_id);
	}

	public Long getCh_id() {
		return ch_id;
	}

	public void setCh_id(Long ch_id) {
		this.ch_id = ch_id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	public void setQuestionId(Long id){
		if(question==null){
			question = new Question();
		}
		question.setQ_id(id);
	}
	
	public Long getQuestionId(){
		return question.getQ_id();
	}
	
	public void setQuestionText(String text){
		if(question==null){
			question = new Question();
		}
		question.setText(text);
	}
	
	public String getQuestionText(){
		return question.getText();
	}
}
