package springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import springmvc.model.UserInfo;

@Repository
public class LoginDaoImpl implements LoginDao {

	NamedParameterJdbcTemplate nameParameterJdbcTemplate;

	@Autowired
	public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate nameParameterJdbcTemplate)
			throws DataAccessException {
		this.nameParameterJdbcTemplate = nameParameterJdbcTemplate;
	}

	@Override
	public UserInfo findUser(String username) {
		String query = "select * from ACCOUNT where UserName = :username";

		try {
			UserInfo userInfor = nameParameterJdbcTemplate.queryForObject(query, getSqlParameterByModel(username, ""),
					new UserInforMapper());
			return userInfor;
		} catch (Exception e) {
			return null;
		}
	}

	private SqlParameterSource getSqlParameterByModel(String username, String password) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("UserName", username);
		paramSource.addValue("PassWord", password);
		return paramSource;
	}

	private static final class UserInforMapper implements RowMapper<UserInfo> {
		public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			String username = rs.getString("UserName");
			String password = rs.getString("PassWord");
			return new UserInfo(username, password);
		}
	}

	@Override
	public List<String> getUserRoles(String username) {
		String query = "select IDRole from ACCOUNT where username = :username";
		List<String> roles = nameParameterJdbcTemplate.queryForList(query, getSqlParameterByModel(username, ""), String.class);
		return null;
	}

}
