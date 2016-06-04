package by.vsu.mf.ammc.pm.dao.mysql.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.vsu.mf.ammc.pm.dao.mysql.BaseDao;
import by.vsu.mf.ammc.pm.dao.user.UserDao;
import by.vsu.mf.ammc.pm.domain.user.User;
import by.vsu.mf.ammc.pm.domain.user.UsersGroup;
import by.vsu.mf.ammc.pm.exception.DaoException;

/**
 * Created by Timofei on 20.05.2016.
 */
public class UserDaoImpl extends BaseDao implements UserDao {
	@Override
	public Integer create(User user) throws DaoException {
		String sqlScript = "INSERT INTO `user` (`name`, `password`, `first_name`, `middle_name`, `last_name`, `is_admin`, `group_id`) VALUES (?, ?, ?, ?, ?, ?, ?)";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sqlScript, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, user.getName());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFirstName());
			statement.setString(4, user.getMiddleName());
			statement.setString(5, user.getLastName());
			statement.setBoolean(6, user.isAdmin());
			statement.setInt(7, user.getGroup().getId());
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			resultSet.next();
			return resultSet.getInt(1);
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { resultSet.close(); } catch(NullPointerException | SQLException e) {}
			try { statement.close(); } catch(NullPointerException | SQLException e) {}
		}
	}

	@Override
	public User read(Integer id) throws DaoException {
		String sqlScript = "SELECT `name`, `password`, `first_name`, `middle_name`, `last_name`, `is_admin`, `group_id` FROM `user` WHERE `id` = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sqlScript);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			User user = null;
			if(resultSet.next()) {
				user = new User();
				user.setId(id);
				user.setName(resultSet.getString("name"));
				user.setPassword(resultSet.getString("password"));
				user.setFirstName(resultSet.getString("first_name"));
				user.setMiddleName(resultSet.getString("middle_name"));
				user.setLastName(resultSet.getString("last_name"));
				user.setAdmin(resultSet.getBoolean("is_admin"));
				user.setGroup(new UsersGroup());
				user.getGroup().setId(resultSet.getInt("group_id"));
			}
			return user;
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { resultSet.close(); } catch(NullPointerException | SQLException e) {}
			try { statement.close(); } catch(NullPointerException | SQLException e) {}
		}
	}

	@Override
	public void update(User user) throws DaoException {
		String sqlScript = "UPDATE `user` SET `name` = ?, `password` = ?, `first_name` = ? , `middle_name` = ?, `last_name` = ?, `is_admin` = ?, `group_id` = ? WHERE `id` = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sqlScript);
			statement.setString(1, user.getName());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFirstName());
			statement.setString(4, user.getMiddleName());
			statement.setString(5, user.getLastName());
			statement.setBoolean(6, user.isAdmin());
			statement.setInt(7, user.getGroup().getId());
			statement.setInt(8, user.getId());
			statement.executeUpdate();
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { statement.close(); } catch(NullPointerException | SQLException e) {}
		}
	}

	@Override
	public void delete(Integer id) throws DaoException {
		String sqlScript = "DELETE FROM `user` WHERE `id` = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sqlScript);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { statement.close(); } catch(NullPointerException | SQLException e) {}
		}
	}
}
