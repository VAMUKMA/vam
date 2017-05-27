package ukma.vam.edsystem.entity;

public class Answer {

	private Long answer_id;
	
	private Choice choice;
	
	private User user;
	
	public Answer(){
		choice = new Choice();
		user = new User();
	}
	
	public Answer(Long ch_id, Long user_id){
		if(choice==null){
			choice = new Choice();
		}
		if(user==null){
			user = new User();
		}
		choice.setCh_id(ch_id);
		user.setUser_id(user_id);
	}

	public Long getAnswer_id() {
		return answer_id;
	}

	public void setAnswer_id(Long answer_id) {
		this.answer_id = answer_id;
	}

	public Choice getChoice() {
		return choice;
	}

	public void setChoice(Choice choice) {
		this.choice = choice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Long getChoice_id() {
		return choice.getCh_id();
	}

	public void setChoice_id(Long ch_id) {
		if(choice==null){
			choice = new Choice();
		}
		choice.setCh_id(ch_id);
	}
	
	public String getChoiceText() {
		return choice.getText();
	}

	public void setChoiceText(String text) {
		if(choice==null){
			choice = new Choice();
		}
		choice.setText(text);
	}
	
	public boolean isChoiceCorrect() {
		return choice.isCorrect();
	}

	public void setChoiceCorrect(boolean correct) {
		if(choice==null){
			choice = new Choice();
		}
		choice.setCorrect(correct);
	}
	
	public void setQuestionText(String text){
		if(choice==null){
			choice = new Choice();
		}
		choice.setQuestionText(text);
	}
	
	public String getQuestionText(){
		return choice.getQuestionText();
	}
	
	public Long getUser_id() {
		return user.getUser_id();
	}

	public void setUser_id(Long user_id) {
		if(user==null){
			user = new User();
		}
		user.setUser_id(user_id);
	}
	
	public String getUserEmail() {
		return user.getEmail();
	}

	public void setUserEmail(String email) {
		if(user==null){
			user = new User();
		}
		user.setEmail(email);
	}
}
