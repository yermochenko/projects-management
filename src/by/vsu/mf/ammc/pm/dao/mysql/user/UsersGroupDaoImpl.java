package by.vsu.mf.ammc.pm.dao.mysql.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.vsu.mf.ammc.pm.dao.mysql.BaseDao;
import by.vsu.mf.ammc.pm.dao.user.UsersGroupDao;
import by.vsu.mf.ammc.pm.domain.user.UsersGroup;
import by.vsu.mf.ammc.pm.exception.DaoException;

/**
 * Created by Timofei on 20.05.2016.
 */
public class UsersGroupDaoImpl extends BaseDao implements UsersGroupDao {
	@Override
	public Integer create(UsersGroup usersGroup) throws DaoException {
		String sqlScript = "INSERT INTO `users_group` (`name`, `parent_id`) VALUES (?, ?)";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sqlScript, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, usersGroup.getName());
			statement.setInt(2, usersGroup.getParent().getId());
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
	public UsersGroup read(Integer id) throws DaoException {
		String sqlScript = "SELECT `name`, `parent_id` FROM `users_group` WHERE `id` = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sqlScript);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			UsersGroup usersGroup = null;
			if(resultSet.next()) {
				usersGroup = new UsersGroup();
				usersGroup.setId(id);
				usersGroup.setName(resultSet.getString("name"));
				usersGroup.setParent(new UsersGroup());
				usersGroup.getParent().setId(resultSet.getInt("parent_id"));
			}
			return usersGroup;
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { resultSet.close(); } catch(NullPointerException | SQLException e) {}
			try { statement.close(); } catch(NullPointerException | SQLException e) {}
		}
	}

	@Override
	public void update(UsersGroup usersGroup) throws DaoException {
		String sqlScript = "UPDATE `users_group` SET `name` = ?, `parent_id` = ? WHERE `id` = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sqlScript);
			statement.setString(1, usersGroup.getName());
			statement.setInt(2, usersGroup.getParent().getId());
			statement.setInt(3, usersGroup.getId());
			statement.executeUpdate();
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { statement.close(); } catch(NullPointerException | SQLException e) {}
		}
	}

	@Override
	public void delete(Integer id) throws DaoException {
		String sqlScript = "DELETE FROM `users_group` WHERE `id` = ?";
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
