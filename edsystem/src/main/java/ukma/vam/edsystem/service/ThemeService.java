package ukma.vam.edsystem.service;

import java.sql.SQLException;
import java.util.List;

import ukma.vam.edsystem.entity.Chapter;
import ukma.vam.edsystem.entity.Choice;
import ukma.vam.edsystem.entity.Question;
import ukma.vam.edsystem.entity.Tests;
import ukma.vam.edsystem.entity.Theme;

public interface ThemeService {

	public List<Theme> getAllThemes();
	
	public Theme getThemeById(Long id);
	
	public Chapter getChapterById(Long id);
	
	public Tests getTestById(Long id);
	
	public Question getQuestionById(Long id);
	
	public List<Chapter> getAllChapters(Long theme_id);
	
	public void addChapter(String name, String text, Long theme_id) throws SQLException;
	
	public List<Tests> getTestsByChapter(Long chapter_id);
	
	public void addTest(String name, Long chapter_id) throws SQLException;
	
	public List<Question> getQuestionsByTest(Long test_id);
	
	public void addQuestion(String text, Long test_id, Long theme_id) throws SQLException;
	
	public List<Choice> getChoicesByQuestion(Long question_id);
	
	public void addChoice(String text, boolean correct, Long q_id) throws SQLException;
	
	public List<Choice> getChoices(Long test_id);
}
