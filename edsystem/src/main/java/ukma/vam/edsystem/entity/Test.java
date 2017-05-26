package ukma.vam.edsystem.entity;

public class Test {

	private Long test_id;
	
	private String name;
	
	private Chapter chapter;
	
	public Test(){
		chapter = new Chapter();
	}
	
	public Test(String name, Long chapter_id){
		this.name = name;
		if(chapter==null)
			chapter = new Chapter();
		chapter.setChapter_id(chapter_id);
	}

	public Long getTest_id() {
		return test_id;
	}

	public void setTest_id(Long test_id) {
		this.test_id = test_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Chapter getChapter() {
		return chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}
	
	public void setChapterId(Long id){
		if(chapter==null)
			chapter = new Chapter();
		chapter.setChapter_id(id);
	}
	
	public Long getChapterId(){
		return chapter.getChapter_id();
	}
}
