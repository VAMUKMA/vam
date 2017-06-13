package ukma.vam.edsystem.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ukma.vam.edsystem.dao.ThemeDao;
import ukma.vam.edsystem.entity.Chapter;
import ukma.vam.edsystem.entity.Choice;
import ukma.vam.edsystem.entity.Question;
import ukma.vam.edsystem.entity.Tests;
import ukma.vam.edsystem.entity.Theme;

@Service
public class ThemeServiceImpl implements ThemeService{

	@Autowired
	private ThemeDao themeDao;
	
	@Override
	public List<Theme> getAllThemes() {
		return themeDao.getThemes();
	}

	@Override
	public List<Chapter> getAllChapters(Long theme_id) {
		return themeDao.getChaptersByTheme(theme_id);
	}

	@Override
	public void addChapter(String name, String text, Long theme_id) throws SQLException {
		Chapter chapter = new Chapter();
		chapter.setName(name);
		chapter.setText(text);
		chapter.setThemeId(theme_id);
		
		themeDao.addChapter(chapter);
	}

	@Override
	public Theme getThemeById(Long id) {
		return themeDao.getThemeById(id);
	}

	@Override
	public Chapter getChapterById(Long id) {
		return themeDao.getChapterById(id);
	}

	@Override
	public List<Tests> getTestsByChapter(Long chapter_id) {
		return themeDao.getTestsByChapter(chapter_id);
	}

	@Override
	public void addTest(String name, Long chapter_id) throws SQLException {
		Tests test = new Tests();
		test.setChapterId(chapter_id);
		test.setName(name);
		
		themeDao.addTest(test);
	}

	@Override
	public Tests getTestById(Long id) {
		return themeDao.getTestById(id);
	}

	@Override
	public List<Question> getQuestionsByTest(Long test_id) {
		return themeDao.getQuestionsByTest(test_id);
	}

	@Override
	public void addQuestion(String text, Long test_id, Long theme_id) throws SQLException {
		Question q = new Question();
		q.setText(text);
		q.setTestId(test_id);
		
		themeDao.addQuestion(q);
		
		Theme theme = themeDao.getThemeById(theme_id);
		theme.setCount_question(theme.getCount_question() + 1);
		themeDao.updateTheme(theme.getCount_question(), theme_id);
	}

	@Override
	public Question getQuestionById(Long id) {
		return themeDao.getQuestionById(id);
	}

	@Override
	public List<Choice> getChoicesByQuestion(Long question_id) {
		return themeDao.getChoicesByQuestion(question_id);
	}

	@Override
	public void addChoice(String text, boolean correct, Long q_id) throws SQLException {
		Choice choice = new Choice();
		choice.setText(text);
		choice.setCorrect(correct);
		choice.setQuestionId(q_id);
		
		themeDao.addChoice(choice);
	}

}
