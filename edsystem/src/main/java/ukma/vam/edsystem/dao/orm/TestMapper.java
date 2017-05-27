package ukma.vam.edsystem.dao.orm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ukma.vam.edsystem.entity.Tests;

public class TestMapper implements RowMapper<Tests>{

	@Override
	public Tests mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Tests test = new Tests();
		
		test.setTest_id(rs.getLong("test_id"));
		test.setName(rs.getString("tests.name"));
		test.setChapterId(rs.getLong("chapter_id"));
		
		return test;
	}

}
