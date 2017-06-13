package ukma.vam.edsystem.dao.orm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ukma.vam.edsystem.entity.Chapter;

public class ChapterMapper implements RowMapper<Chapter>{

	@Override
	public Chapter mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Chapter chapter = new Chapter();
		
		chapter.setChapter_id(rs.getLong("chapter_id"));
		chapter.setName(rs.getString("name"));
		chapter.setText(rs.getString("text"));
		chapter.setThemeId(rs.getLong("theme_id"));
		
		return chapter;
	}

	
}
