package ukma.vam.edsystem.dao.orm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ukma.vam.edsystem.entity.Question;

public class QuestionMapper implements RowMapper<Question>{

	@Override
	public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Question q = new Question();
		
		q.setQ_id(rs.getLong("q_id"));
		q.setText(rs.getString("text"));
		q.setTestId(rs.getLong("test_id"));
		
		return q;
	}

	
}
