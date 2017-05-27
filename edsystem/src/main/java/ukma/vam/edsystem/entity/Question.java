package ukma.vam.edsystem.entity;

public class Question {

	private Long q_id;
	
	private String text;
	
	private Tests test;
	
	public Question(){
		test = new Tests();
	}
	
	public Question(String text, Long test_id){
		this.text = text;
		if(test==null){
			test = new Tests();
		}
		test.setTest_id(test_id);
	}

	public Long getQ_id() {
		return q_id;
	}

	public void setQ_id(Long q_id) {
		this.q_id = q_id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Tests getTest() {
		return test;
	}

	public void setTest(Tests test) {
		this.test = test;
	}
	
	public void setTestId(Long id){
		if(test==null){
			test = new Tests();
		}
		test.setTest_id(id);
	}
	
	public Long getTestId(){
		return test.getTest_id();
	}
	
	public void setTestName(String name){
		if(test==null){
			test = new Tests();
		}
		test.setName(name);
	}
	
	public String getTestName(){
		return test.getName();
	}
}
