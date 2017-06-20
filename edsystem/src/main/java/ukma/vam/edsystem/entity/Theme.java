package ukma.vam.edsystem.entity;

public class Theme{

	private Long theme_id;
	
	private String name;
	
	private int count_question;
	
	private Double completeness;
	
	public Theme(){
	}
	
	public Theme(String name){
		this.name = name;
		this.count_question = 0;
	}

	public Long getTheme_id() {
		return theme_id;
	}

	public void setTheme_id(Long theme_id) {
		this.theme_id = theme_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount_question() {
		return count_question;
	}

	public void setCount_question(int count_question) {
		this.count_question = count_question;
	}

	public Double getCompleteness() {
		return completeness;
	}

	public void setCompleteness(Double completeness) {
		this.completeness = completeness;
	}
	
}
