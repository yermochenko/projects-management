package by.vsu.mf.ammc.pm.dao.mysql.user;

import by.vsu.mf.ammc.pm.dao.mysql.BaseDao;
import by.vsu.mf.ammc.pm.dao.user.UserDao;
import by.vsu.mf.ammc.pm.domain.user.Contact;
import by.vsu.mf.ammc.pm.domain.user.ContactsType;
import by.vsu.mf.ammc.pm.domain.user.User;
import by.vsu.mf.ammc.pm.domain.user.UsersGroup;
import by.vsu.mf.ammc.pm.exception.DaoException;
import javafx.scene.Group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Timofei on 20.05.2016.
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public Integer create(User user) throws DaoException {
        String sqlScript = "INSERT INTO user ( name, password, first_name, middle_name, last_name, is_admin, group_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getMiddleName());
            statement.setString(5, user.getLastName());
            statement.setBoolean(6, user.getAdmin());
            statement.setInt(7, user.getGroup().getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return null;
    }

    @Override
    public User read(Integer id) throws DaoException {
        String sqlScript = "SELECT id, name, password, first_name, middle_name, last_name, is_admin, group_id FROM contact WHERE id = ?";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;

        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(id);
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setMiddleName(resultSet.getString("middle_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setAdmin(resultSet.getBoolean("is_admin"));
                user.setGroup(resultSet.getObject("group_id", UsersGroup.class));

            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return user;
    }

    @Override
    public void update(User user) throws DaoException {
        String sqlScript = "UPDATE user SET name = ?, password = ?, first_name = ? , middle_name= ?, last_name= ?, is_admin= ?, group_id= ? WHERE id = ?";
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getMiddleName());
            statement.setString(5, user.getLastName());
            statement.setBoolean(6, user.getAdmin());
            statement.setInt(7, user.getGroup().getId());
            statement.setInt(8, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public void delete(Integer id) throws DaoException {
        String sqlScript = "DELETE FROM user WHERE id = ?";
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
