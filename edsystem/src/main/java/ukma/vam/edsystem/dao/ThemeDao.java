package ukma.vam.edsystem.dao;

import java.sql.SQLException;
import java.util.List;

import ukma.vam.edsystem.entity.Answer;
import ukma.vam.edsystem.entity.Chapter;
import ukma.vam.edsystem.entity.Choice;
import ukma.vam.edsystem.entity.Question;
import ukma.vam.edsystem.entity.Tests;
import ukma.vam.edsystem.entity.Theme;

public interface ThemeDao {
	
	public void createThemes() throws SQLException;
	
	public List<Theme> getThemes();
	
	public Theme getThemeById(Long id);
	
	public Chapter getChapterById(Long id);
	
	public Tests getTestById(Long id);
	
	public Question getQuestionById(Long id);
	
	public List<Chapter> getChaptersByTheme(Long theme_id);
	
	public void addChapter(Chapter chapter) throws SQLException;
	
	public List<Tests> getTestsByChapter(Long chapter_id);
	
	public void addTest(Tests test) throws SQLException;
	
	public List<Question> getQuestionsByTest(Long test_id);
	
	public void addQuestion(Question question) throws SQLException;
	
	public List<Choice> getChoicesByQuestion(Long question_id);
	
	public void addChoice(Choice choice) throws SQLException;
	
	public void updateTheme(int count, Long theme_id) throws SQLException;
	
	public void deleteChoice(Long id) throws SQLException;
	
	public List<Choice> getChoices(Long test_id);
	
	public List<Answer> getUserAnswersByTheme(Long user_id, Long theme_id);
	
	public List<Tests> getTestsByChapterName(String name);
	
	public Chapter getChapterByName(String name);
	
	public void addAnswer(Answer answer) throws SQLException;
}
