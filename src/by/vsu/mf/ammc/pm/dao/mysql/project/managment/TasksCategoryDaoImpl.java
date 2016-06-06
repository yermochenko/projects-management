package by.vsu.mf.ammc.pm.dao.mysql.project.managment;

import by.vsu.mf.ammc.pm.dao.mysql.BaseDao;
import by.vsu.mf.ammc.pm.dao.project.management.TasksCategoryDao;
import by.vsu.mf.ammc.pm.domain.project.management.TasksCategory;
import by.vsu.mf.ammc.pm.domain.user.User;
import by.vsu.mf.ammc.pm.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Pasha_R on 06.06.2016.
 */
public class TasksCategoryDaoImpl extends BaseDao implements TasksCategoryDao{
    @Override
    public Integer create(TasksCategory object) throws DaoException {
        String sqlScript = "INSERT INTO `task_category` ( `name`, `parent_id`) VALUE (?, ?)";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet r = null;
        try {
            statement = connection.prepareStatement(sqlScript, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString((int)1, object.getName());
            statement.setInt((int)2, object.getParent().getId());
            statement.executeUpdate();
            r = statement.getGeneratedKeys();
            r.next();
            return r.getInt(1);
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { r.close(); } catch(NullPointerException | SQLException e) {}
            try { statement.close(); } catch(NullPointerException | SQLException e) {}
        }
    }

    @Override
    public TasksCategory read(Integer key) throws DaoException {
        String sqlScript = "SELECT `user_id`, `name`, `parent_id` FROM task_category WHERE `id` = ?";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setInt(1, key);
            resultSet = statement.executeQuery();
            TasksCategory task_category = null;
            if (resultSet.next()) {
                task_category = new TasksCategory();
                task_category.setId(key);
                task_category.setName(resultSet.getString("name"));
                task_category.setParent(new TasksCategory());
                task_category.getParent().setId(resultSet.getInt("parent_id"));
            }
            return task_category;
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { resultSet.close(); } catch(NullPointerException | SQLException e) {}
            try { statement.close(); } catch(NullPointerException | SQLException e) {}
        }
    }

    @Override
    public void update(TasksCategory object) throws DaoException {
        String sqlScript = "UPDATE `task_categoty` SET `user_id` = ?, `name` = ?, `parent_id` = ?, WHERE `id` = ?";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setInt(1, object.getId());
            statement.setString(2, object.getName());
            statement.setInt(3, object.getParent().getId());
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { statement.close(); } catch(NullPointerException | SQLException e) {}
        }
    }

    @Override
    public void delete(Integer key) throws DaoException {
        String sqlScript = "DELETE FROM `task_categoty` WHERE `id` = ?";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setInt(1, key);
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { statement.close(); } catch(NullPointerException | SQLException e) {}
        }
    }
}
