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
		answer.setChoice_id(rs.getLong("ch_id"));
		answer.setChoiceText(rs.getString("text"));
		answer.setChoiceCorrect(rs.getBoolean("correct"));
		
		return answer;
	}

}
