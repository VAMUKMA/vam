package ukma.vam.edsystem.dao.orm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ukma.vam.edsystem.entity.Choice;

public class ChoiceMapper implements RowMapper<Choice>{

	@Override
	public Choice mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Choice choice = new Choice();
		
		choice.setCh_id(rs.getLong("ch_id"));
		choice.setText(rs.getString("choices.text"));
		choice.setCorrect(rs.getBoolean("correct"));
		choice.setQuestionId(rs.getLong("q_id"));
		if(rs.getString("question.text") != null){
			choice.setQuestionText(rs.getString("question.text"));
		}
		
		return choice;
	}

}
