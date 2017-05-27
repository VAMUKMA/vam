package ukma.vam.edsystem.dao.orm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ukma.vam.edsystem.entity.Theme;

public class ThemeMapper implements RowMapper<Theme>{

	@Override
	public Theme mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Theme theme = new Theme();
		
		theme.setTheme_id(rs.getLong("theme_id"));
		theme.setName(rs.getString("name"));
		theme.setCount_question(rs.getInt("count_question"));
		
		return theme;
	}

}
