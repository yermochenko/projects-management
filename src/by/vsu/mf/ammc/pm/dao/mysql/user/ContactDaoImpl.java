package by.vsu.mf.ammc.pm.dao.mysql.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.vsu.mf.ammc.pm.dao.mysql.BaseDao;
import by.vsu.mf.ammc.pm.dao.user.ContactDao;
import by.vsu.mf.ammc.pm.domain.user.Contact;
import by.vsu.mf.ammc.pm.domain.user.ContactsType;
import by.vsu.mf.ammc.pm.domain.user.User;
import by.vsu.mf.ammc.pm.exception.DaoException;

/**
 * Created by Борис on 19.05.2016.
 */
public class ContactDaoImpl extends BaseDao implements ContactDao {
	@Override
	public Integer create(Contact contact) throws DaoException {
		String sqlScript = "INSERT INTO `contact` (`name`, `user_id`, `type_id`) VALUES (?, ?, ?)";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sqlScript, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, contact.getName());
			statement.setInt(2, contact.getUser().getId());
			statement.setInt(3, contact.getType().getId());
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
	public Contact read(Integer id) throws DaoException {
		String sqlScript = "SELECT `name`, `user_id`, `type_id` FROM `contact` WHERE `id` = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sqlScript);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			Contact contact = null;
			if(resultSet.next()) {
				contact = new Contact();
				contact.setId(id);
				contact.setName(resultSet.getString("name"));
				contact.setUser(new User());
				contact.getUser().setId(resultSet.getInt("user_id"));
				contact.setType(new ContactsType());
				contact.getType().setId(resultSet.getInt("type_id"));
			}
			return contact;
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { resultSet.close(); } catch(NullPointerException | SQLException e) {}
			try { statement.close(); } catch(NullPointerException | SQLException e) {}
		}
	}

	@Override
	public void update(Contact contact) throws DaoException {
		String sqlScript = "UPDATE `contact` SET `name` = ?, `user_id` = ?, `type_id` = ? WHERE `id` = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sqlScript);
			statement.setString(1, contact.getName());
			statement.setInt(2, contact.getUser().getId());
			statement.setInt(3, contact.getType().getId());
			statement.setInt(4, contact.getId());
			statement.executeUpdate();
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { statement.close(); } catch(NullPointerException | SQLException e) {}
		}
	}

	@Override
	public void delete(Integer id) throws DaoException {
		String sqlScript = "DELETE FROM `contact` WHERE `id` = ?";
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
