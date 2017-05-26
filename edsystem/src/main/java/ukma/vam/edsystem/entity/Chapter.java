package ukma.vam.edsystem.entity;

public class Chapter {

	private Long chapter_id;
	
	private String name;
	
	private String text;
	
	private Theme theme;
	
	public Chapter(){
		theme = new Theme();
	}
	
	public Chapter(String name, String text, Long theme_id){
		this.name = name;
		this.text = text;
		if(theme==null)
			theme = new Theme();
		this.theme.setTheme_id(theme_id);
	}

	public Long getChapter_id() {
		return chapter_id;
	}

	public void setChapter_id(Long chapter_id) {
		this.chapter_id = chapter_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	
	public void setThemeId(Long id){
		if(theme==null)
			theme = new Theme();
		this.theme.setTheme_id(id);
	}
	
	public Long getThemeId(){
		return this.theme.getTheme_id();
	}
	
	public void setThemeName(String name){
		if(theme==null)
			theme = new Theme();
		this.theme.setName(name);
	}
	
	public String getThemeName(){
		return this.theme.getName();
	}
}
