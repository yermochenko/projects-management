package by.vsu.mf.ammc.pm.dao.mysql.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.vsu.mf.ammc.pm.dao.mysql.BaseDao;
import by.vsu.mf.ammc.pm.dao.user.ContactsTypeDao;
import by.vsu.mf.ammc.pm.domain.user.ContactsType;
import by.vsu.mf.ammc.pm.exception.DaoException;

public class ContactsTypeDaoImpl extends BaseDao implements ContactsTypeDao {
	@Override
	public Integer create(ContactsType contactsType) throws DaoException {
		String sqlScript = "INSERT INTO `contacts_type` (`name`, `regexp`) VALUES (?, ?)";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sqlScript, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, contactsType.getName());
			statement.setString(2, contactsType.getRegexp());
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
	public ContactsType read(Integer id) throws DaoException {
		String sqlScript = "SELECT `name`, `regexp` FROM `contacts_type` WHERE `id` = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sqlScript);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			ContactsType contactsType = null;
			if(resultSet.next()) {
				contactsType = new ContactsType();
				contactsType.setId(id);
				contactsType.setName(resultSet.getString("name"));
				contactsType.setRegexp(resultSet.getString("regexp"));
			}
			return contactsType;
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { resultSet.close(); } catch(NullPointerException | SQLException e) {}
			try { statement.close(); } catch(NullPointerException | SQLException e) {}
		}
	}

	@Override
	public List<ContactsType> read() throws DaoException {
		String sqlScript = "SELECT `id`, `name`, `regexp` FROM `contacts_type`";
		Connection connection = getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlScript);
			List<ContactsType> contactsTypes = new ArrayList<>();
			ContactsType contactsType = null;
			while(resultSet.next()) {
				contactsType = new ContactsType();
				contactsType.setId(resultSet.getInt("id"));
				contactsType.setName(resultSet.getString("name"));
				contactsType.setRegexp(resultSet.getString("regexp"));
				contactsTypes.add(contactsType);
			}
			return contactsTypes;
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { resultSet.close(); } catch(NullPointerException | SQLException e) {}
			try { statement.close(); } catch(NullPointerException | SQLException e) {}
		}
	}

	@Override
	public void update(ContactsType contactsType) throws DaoException {
		String sqlScript = "UPDATE `contacts_type` SET `name` = ?, `regexp` = ? WHERE `id` = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sqlScript);
			statement.setString(1, contactsType.getName());
			statement.setString(2, contactsType.getRegexp());
			statement.setInt(3, contactsType.getId());
			statement.executeUpdate();
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { statement.close(); } catch(NullPointerException | SQLException e) {}
		}
	}

	@Override
	public void delete(Integer id) throws DaoException {
		String sqlScript = "DELETE FROM `contacts_type` WHERE `id` = ?";
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