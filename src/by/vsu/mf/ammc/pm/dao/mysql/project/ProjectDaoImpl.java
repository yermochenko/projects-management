package by.vsu.mf.ammc.pm.dao.mysql.project;

import by.vsu.mf.ammc.pm.dao.mysql.BaseDao;
import by.vsu.mf.ammc.pm.dao.project.ProjectDao;
import by.vsu.mf.ammc.pm.domain.project.Project;
import by.vsu.mf.ammc.pm.domain.project.ProjectsCategory;
import by.vsu.mf.ammc.pm.domain.user.User;
import by.vsu.mf.ammc.pm.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Pasha_R on 03.06.2016.
 */



public class ProjectDaoImpl extends BaseDao implements ProjectDao {
    @Override
    public Integer create(Project object) throws DaoException {
        String sqlScript = "INSERT INTO `project` ( `name`, `description`, `categoty_id`, `manager_id`) VALUE (?, ?, ?, ?)";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet r = null;
        try {
            statement = connection.prepareStatement(sqlScript, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString((int)1, object.getName());
            statement.setString((int)2, object.getDescription());
            statement.setInt((int)3, object.getManager().getId());
            statement.setInt((int)4, object.getCategory().getId());
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
    public Project read(Integer key) throws DaoException {
        String sqlScript = "SELECT `user_id`, `name`, `description`, `category_id`, `manager_id` FROM project WHERE `id` = ?";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setInt(1, key);
            resultSet = statement.executeQuery();
            Project project = null;
            if (resultSet.next()) {
                project = new Project();
                project.setId(key);
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCategory(new ProjectsCategory());
                project.getCategory().setId(resultSet.getInt("category_id"));
                project.setManager(new User());
                project.getManager().setId(resultSet.getInt("manager_id"));

            }
            return project;
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { resultSet.close(); } catch(NullPointerException | SQLException e) {}
            try { statement.close(); } catch(NullPointerException | SQLException e) {}
        }
    }

    @Override
    public void update(Project object) throws DaoException {
        String sqlScript = "UPDATE `project` SET `user_id` = ?, `name` = ?, `description` = ?, `category_id` = ?, `manager_id` = ? WHERE `id` = ?";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setInt(1, object.getId());
            statement.setString(2, object.getName());
            statement.setString(3, object.getDescription());
            statement.setInt(4, object.getCategory().getId());
            statement.setInt(5, object.getManager().getId());
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { statement.close(); } catch(NullPointerException | SQLException e) {}
        }
    }

    @Override
    public void delete(Integer key) throws DaoException {
        String sqlScript = "DELETE FROM `project` WHERE `id` = ?";
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
    @Override
    public Project readByProject_category(Integer project_categoryId) throws DaoException {
        String sqlScript = "SELECT `id`, `name` FROM `project_category` WHERE `project_category_id` = ?";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setInt(1, project_categoryId);
            resultSet = statement.executeQuery();
            Project project = null;
            if (resultSet.next()) {
                project = new Project();
                project.setId(project_categoryId);
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCategory(new ProjectsCategory());
                project.getCategory().setId(resultSet.getInt("category_id"));
                project.setManager(new User());
                project.getManager().setId(resultSet.getInt("manager_id"));

            }
            return project;
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { resultSet.close(); } catch(NullPointerException | SQLException e) {}
            try { statement.close(); } catch(NullPointerException | SQLException e) {}
        }
    }
    }

