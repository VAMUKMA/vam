package ukma.vam.edsystem.dao.orm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ukma.vam.edsystem.entity.Answer;
import ukma.vam.edsystem.entity.User;

public class AnswerMapper implements RowMapper<Answer>{

	@Override
	public Answer mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Answer answer = new Answer();
		
		answer.setAnswer_id(rs.getLong("answer_id"));
		answer.setUser_id(rs.getLong("user_id"));
		answer.setUserEmail(rs.getString("email"));
		answer.setChoice_id(rs.getLong("ch_id"));
		answer.setChoiceText(rs.getString("ch_text"));
		answer.setQuestionText(rs.getString("q_text"));
		answer.setChoiceCorrect(rs.getBoolean("correct"));
		
		return answer;
	}

}
