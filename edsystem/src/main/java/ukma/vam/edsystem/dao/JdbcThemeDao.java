package ukma.vam.edsystem.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ukma.vam.edsystem.dao.orm.AnswerMapper;
import ukma.vam.edsystem.dao.orm.ChapterMapper;
import ukma.vam.edsystem.dao.orm.ChoiceMapper;
import ukma.vam.edsystem.dao.orm.QuestionMapper;
import ukma.vam.edsystem.dao.orm.TestMapper;
import ukma.vam.edsystem.dao.orm.ThemeMapper;
import ukma.vam.edsystem.entity.Answer;
import ukma.vam.edsystem.entity.Chapter;
import ukma.vam.edsystem.entity.Choice;
import ukma.vam.edsystem.entity.Question;
import ukma.vam.edsystem.entity.Tests;
import ukma.vam.edsystem.entity.Theme;

@Repository
public class JdbcThemeDao implements ThemeDao{

	private static final String SQL_INSERT_THEME = "INSERT INTO theme(name, count_question) VALUES (?, 0)";
	
	private static final String SQL_INSERT_CHAPTER = "INSERT INTO chapter(name, text, theme_id) VALUES (?, ?, ?)";
	
	private static final String SQL_INSERT_TEST = "INSERT INTO tests(name, chapter_id) VALUES (?, ?)";

	private static final String SQL_INSERT_QUESTION = "INSERT INTO question(text, test_id) VALUES (?, ?)";

	private static final String SQL_INSERT_CHOICE = "INSERT INTO choices(text, correct, q_id) VALUES (?, ?, ?)";
	
	private static final String SQL_INSERT_ANSWER = "INSERT INTO answer(ch_id, user_id) VALUES (?, ?)";

	private static final String SQL_GET_THEMES = "SELECT * FROM theme";
	
	private static final String SQL_GET_THEME_BY_ID = "SELECT * FROM theme WHERE theme_id=?";
	
	private static final String SQL_GET_CHAPTER_BY_ID = "SELECT * FROM chapter WHERE chapter_id=?";

	private static final String SQL_GET_TEST_BY_ID = "SELECT * FROM tests WHERE test_id=?";
	
	private static final String SQL_GET_QUESTION_BY_ID = "SELECT * FROM question WHERE q_id=?";

	private static final String SQL_GET_CHAPTERS_BY_THEME = "SELECT * FROM chapter WHERE theme_id=?";
		
	private static final String SQL_GET_TESTS_BY_CHAPTER = "SELECT * FROM tests WHERE chapter_id=?";

	private static final String SQL_GET_QUESTIONS_BY_TEST = "SELECT * FROM question WHERE test_id=?";

	private static final String SQL_GET_CHOICES_BY_QUESTION = "SELECT choices.text as ch_text, choices.ch_id, correct, choices.q_id, question.text as q_text, tests.name as test_name FROM (tests INNER JOIN question ON tests.test_id=question.test_id) INNER JOIN choices ON question.q_id=choices.q_id WHERE question.q_id=?";

	private static final String SQL_UPDATE_THEME = "UPDATE theme SET count_question = ? WHERE theme_id = ?";
	
	private static final String SQL_DELETE_CHOICE = "DELETE FROM choices WHERE ch_id = ?";
	
	private static final String SQL_GET_CHOICES = "SELECT choices.text as ch_text, choices.ch_id, correct, choices.q_id, question.text as q_text, tests.name as test_name FROM (tests INNER JOIN question ON tests.test_id=question.test_id) INNER JOIN choices ON question.q_id=choices.q_id WHERE tests.test_id=?";
	
	private static final String SQL_GET_USER_ANSWERS_BY_THEME = "SELECT answer_id, answer.ch_id, choices.text, correct FROM ((((chapter INNER JOIN tests ON chapter.chapter_id=tests.chapter_id) INNER JOIN question ON tests.test_id=question.test_id) INNER JOIN choices ON question.q_id=choices.q_id) INNER JOIN answer ON choices.ch_id=answer.ch_id) INNER JOIN users ON answer.user_id=users.user_id WHERE users.user_id=? AND chapter.theme_id=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void createThemes() throws SQLException {
				
		PreparedStatement ps3 = jdbcTemplate.getDataSource().getConnection().prepareStatement(SQL_INSERT_THEME);
		ps3.setString(1, "Раціональні числа та дії з ними");
		ps3.executeUpdate();
		ps3.close();
		
		PreparedStatement ps = jdbcTemplate.getDataSource().getConnection().prepareStatement(SQL_INSERT_CHAPTER);
		ps.setString(1, "dividers");
		ps.setString(2, "Дільники і кратні");
		ps.setLong(3, 13);
		ps.executeUpdate();
		ps.close();
		
		PreparedStatement ps1 = jdbcTemplate.getDataSource().getConnection().prepareStatement(SQL_INSERT_CHAPTER);
		ps1.setString(1, "divisibilityTen");
		ps1.setString(2, "Ознаки подільності на 10, на 5 і на 2");
		ps1.setLong(3, 13);
		ps1.executeUpdate();
		ps1.close();
		
		PreparedStatement ps2 = jdbcTemplate.getDataSource().getConnection().prepareStatement(SQL_INSERT_CHAPTER);
		ps2.setString(1, "divisibilityNine");
		ps2.setString(2, "Ознаки подільності на 9 і на 3");
		ps2.setLong(3, 13);
		ps2.executeUpdate();
		ps2.close();
	}

	@Override
	public List<Theme> getThemes() {
		return jdbcTemplate.query(SQL_GET_THEMES, new ThemeMapper());
	}

	@Override
	public List<Chapter> getChaptersByTheme(Long theme_id) {
		return jdbcTemplate.query(SQL_GET_CHAPTERS_BY_THEME, new ChapterMapper(), theme_id);
	}

	@Override
	public void addChapter(Chapter chapter) throws SQLException {
		
		PreparedStatement ps = jdbcTemplate.getDataSource().getConnection().prepareStatement(SQL_INSERT_CHAPTER);
		ps.setString(1, chapter.getName());
		ps.setString(2, chapter.getText());
		ps.setLong(3, chapter.getThemeId());
		ps.executeUpdate();
		ps.close();
	}

	@Override
	public Theme getThemeById(Long id) {
		return jdbcTemplate.queryForObject(SQL_GET_THEME_BY_ID, new ThemeMapper(), id);
	}

	@Override
	public Chapter getChapterById(Long id) {
		return jdbcTemplate.queryForObject(SQL_GET_CHAPTER_BY_ID, new ChapterMapper(), id);
	}

	@Override
	public List<Tests> getTestsByChapter(Long chapter_id) {
		return jdbcTemplate.query(SQL_GET_TESTS_BY_CHAPTER, new TestMapper(), chapter_id);
	}

	@Override
	public void addTest(Tests test) throws SQLException {
		
		PreparedStatement ps = jdbcTemplate.getDataSource().getConnection().prepareStatement(SQL_INSERT_TEST);
		ps.setString(1, test.getName());
		ps.setLong(2, test.getChapterId());
		ps.executeUpdate();
		ps.close();
	}

	@Override
	public Tests getTestById(Long id) {
		return jdbcTemplate.queryForObject(SQL_GET_TEST_BY_ID, new TestMapper(), id);
	}

	@Override
	public List<Question> getQuestionsByTest(Long test_id) {
		return jdbcTemplate.query(SQL_GET_QUESTIONS_BY_TEST, new QuestionMapper(), test_id);
	}

	@Override
	public void addQuestion(Question question) throws SQLException {
		
		PreparedStatement ps = jdbcTemplate.getDataSource().getConnection().prepareStatement(SQL_INSERT_QUESTION);
		ps.setString(1, question.getText());
		ps.setLong(2, question.getTestId());
		ps.executeUpdate();
		ps.close();
	}

	@Override
	public Question getQuestionById(Long id) {
		return jdbcTemplate.queryForObject(SQL_GET_QUESTION_BY_ID, new QuestionMapper(), id);
	}

	@Override
	public List<Choice> getChoicesByQuestion(Long question_id) {
		return jdbcTemplate.query(SQL_GET_CHOICES_BY_QUESTION, new ChoiceMapper(), question_id);
	}

	@Override
	public void addChoice(Choice choice) throws SQLException {
		
		PreparedStatement ps = jdbcTemplate.getDataSource().getConnection().prepareStatement(SQL_INSERT_CHOICE);
		ps.setString(1, choice.getText());
		ps.setBoolean(2, choice.isCorrect());
		ps.setLong(3, choice.getQuestionId());
		ps.executeUpdate();
		ps.close();
	}

	@Override
	public void updateTheme(int count, Long theme_id) throws SQLException {

		PreparedStatement ps = jdbcTemplate.getDataSource().getConnection().prepareStatement(SQL_UPDATE_THEME);
		ps.setInt(1, count);
		ps.setLong(2, theme_id);
		
		ps.executeUpdate();
		ps.close();
	}

	@Override
	public void deleteChoice(Long id) throws SQLException {
		
		PreparedStatement ps = jdbcTemplate.getDataSource().getConnection().prepareStatement(SQL_DELETE_CHOICE);
		ps.setLong(1, id);
		ps.executeUpdate();
		ps.close();
	}

	@Override
	public List<Choice> getChoices(Long test_id) {
		return jdbcTemplate.query(SQL_GET_CHOICES, new ChoiceMapper(), test_id);
	}

	@Override
	public List<Answer> getUserAnswersByTheme(Long user_id, Long theme_id) {
		return jdbcTemplate.query(SQL_GET_USER_ANSWERS_BY_THEME, new AnswerMapper(), user_id, theme_id);
	}

	@Override
	public List<Tests> getTestsByChapterName(String name) {
		String SQL_GET_TESTS_BY_CHAPTER_NAME = "SELECT * FROM tests INNER JOIN chapter ON tests.chapter_id=chapter.chapter_id WHERE chapter.name='"+name+"'";
		return jdbcTemplate.query(SQL_GET_TESTS_BY_CHAPTER_NAME, new TestMapper());
	}

	@Override
	public Chapter getChapterByName(String name) {
		String SQL_GET_CHAPTER_BY_NAME = "SELECT * FROM chapter WHERE name='"+name+"'";
		return jdbcTemplate.queryForObject(SQL_GET_CHAPTER_BY_NAME, new ChapterMapper());
	}

	@Override
	public void addAnswer(Answer answer) throws SQLException {
		
		PreparedStatement ps = jdbcTemplate.getDataSource().getConnection().prepareStatement(SQL_INSERT_ANSWER);
		ps.setLong(1, answer.getChoice_id());
		ps.setLong(2, answer.getUser_id());
		ps.executeUpdate();
		ps.close();
	}
	
}
