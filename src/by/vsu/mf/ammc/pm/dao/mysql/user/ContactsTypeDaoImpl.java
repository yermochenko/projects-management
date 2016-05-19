package by.vsu.mf.ammc.pm.dao.mysql.user;

import by.vsu.mf.ammc.pm.dao.mysql.BaseDao;
import by.vsu.mf.ammc.pm.dao.user.ContactsTypeDao;
import by.vsu.mf.ammc.pm.domain.user.ContactsType;
import by.vsu.mf.ammc.pm.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Борис on 19.05.2016.
 */
public class ContactsTypeDaoImpl extends BaseDao implements ContactsTypeDao {
    @Override
    public Integer create(ContactsType contactsType) throws DaoException {
        String sqlScript = "INSERT INTO contacts_type (name, regexp) VALUES (?, ?)";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setString(1, contactsType.getName());
            statement.setString(2, contactsType.getRegexp());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return null;
    }

    @Override
    public ContactsType read(Integer id) throws DaoException {
        String sqlScript = "SELECT id, name, regexp FROM contacts_type WHERE id = ?";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ContactsType contactsType = null;

        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                contactsType = new ContactsType();
                contactsType.setId(id);
                contactsType.setName(resultSet.getString("name"));
                contactsType.setRegexp(resultSet.getString("regexp"));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return contactsType;
    }

    @Override
    public void update(ContactsType contactsType) throws DaoException {
        String sqlScript = "UPDATE contacts_type SET name = ?, regexp = ? WHERE id = ?";
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setString(1, contactsType.getName());
            statement.setString(2, contactsType.getRegexp());
            statement.setInt(3, contactsType.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public void delete(Integer id) throws DaoException {
        String sqlScript = "DELETE FROM contacts_type WHERE id = ?";
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }
}
