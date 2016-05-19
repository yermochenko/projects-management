package by.vsu.mf.ammc.pm.dao.mysql.user;

import by.vsu.mf.ammc.pm.dao.mysql.BaseDao;
import by.vsu.mf.ammc.pm.dao.user.ContactDao;
import by.vsu.mf.ammc.pm.dao.user.UserDao;
import by.vsu.mf.ammc.pm.domain.user.Contact;
import by.vsu.mf.ammc.pm.domain.user.ContactsType;
import by.vsu.mf.ammc.pm.domain.user.User;
import by.vsu.mf.ammc.pm.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Борис on 19.05.2016.
 */
public class ContactDaoImpl extends BaseDao implements ContactDao {
    @Override
    public Integer create(Contact contact) throws DaoException {
        String sqlScript = "INSERT INTO contact (name, user_id, type_id) VALUES (?, ?, ?)";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setString(1,contact.getName());
            statement.setInt(2,contact.getUser().getId());
            statement.setInt(3,contact.getType().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return null;
    }

    @Override
    public Contact read(Integer id) throws DaoException {
        String sqlScript = "SELECT id, name, user_id, type_id FROM contact WHERE id = ?";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Contact contact = null;

        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                contact = new Contact();
                contact.setId(id);
                contact.setName(resultSet.getString("name"));
                contact.setUser(resultSet.getObject("user_id", User.class));
                contact.setType(resultSet.getObject("type_id", ContactsType.class));
            }

        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return contact;
    }

    @Override
    public void update(Contact contact) throws DaoException {
        String sqlScript = "UPDATE contact SET name = ?, user_id = ?, type_id = ? WHERE id = ?";
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setString(1, contact.getName());
            statement.setInt(2, contact.getUser().getId());
            statement.setInt(3, contact.getType().getId());
            statement.setInt(4, contact.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public void delete(Integer id) throws DaoException {
        String sqlScript = "DELETE FROM contact WHERE id = ?";
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
