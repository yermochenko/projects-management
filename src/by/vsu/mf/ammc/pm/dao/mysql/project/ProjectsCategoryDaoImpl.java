package by.vsu.mf.ammc.pm.dao.mysql.project;

import by.vsu.mf.ammc.pm.dao.mysql.BaseDao;
import by.vsu.mf.ammc.pm.dao.project.ProjectsCategoryDao;
import by.vsu.mf.ammc.pm.domain.project.Project;
import by.vsu.mf.ammc.pm.domain.project.ProjectsCategory;
import by.vsu.mf.ammc.pm.domain.user.User;
import by.vsu.mf.ammc.pm.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Pasha_R on 06.06.2016.
 */
public class ProjectsCategoryDaoImpl extends BaseDao implements ProjectsCategoryDao {

    @Override
    public Integer create(ProjectsCategory object) throws DaoException {
        String sqlScript = "INSERT INTO `project_category` ( `name`, `parent_id`) VALUE (?, ?)";
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
    public ProjectsCategory read(Integer key) throws DaoException {
        String sqlScript = "SELECT `user_id`, `name`, `parent_id` FROM project_category WHERE `id` = ?";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setInt(1, key);
            resultSet = statement.executeQuery();
            ProjectsCategory project_category = null;
            if (resultSet.next()) {
                project_category = new ProjectsCategory();
                project_category.setId(key);
                project_category.setName(resultSet.getString("name"));
                project_category.setParent(new ProjectsCategory());
                project_category.getParent().setId(resultSet.getInt("parent_id"));
            }
            return project_category;
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { resultSet.close(); } catch(NullPointerException | SQLException e) {}
            try { statement.close(); } catch(NullPointerException | SQLException e) {}
        }
    }

    @Override
    public void update(ProjectsCategory object) throws DaoException {
        String sqlScript = "UPDATE `project_category` SET `user_id` = ?, `name` = ?, `parent_id` = ?, WHERE `id` = ?";
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
        String sqlScript = "DELETE FROM `projects_category` WHERE `id` = ?";
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
