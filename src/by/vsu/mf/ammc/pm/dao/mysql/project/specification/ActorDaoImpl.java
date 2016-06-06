package by.vsu.mf.ammc.pm.dao.mysql.project.specification;

import by.vsu.mf.ammc.pm.dao.mysql.BaseDao;
import by.vsu.mf.ammc.pm.dao.project.specification.ActorDao;
import by.vsu.mf.ammc.pm.domain.project.Project;
import by.vsu.mf.ammc.pm.domain.project.specification.Actor;
import by.vsu.mf.ammc.pm.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by user on 06.06.2016.
 */
public class ActorDaoImpl extends BaseDao implements ActorDao {
    @Override
    public Integer create(Actor actor) throws DaoException {
        String sqlScript = "INSERT INTO `actor` (`name`, `project_id`) VALUES (?, ?)";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sqlScript, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, actor.getName());
            statement.setInt(2, actor.getProject().getId());
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
    public Actor read(Integer id) throws DaoException {

        String sqlScript = "SELECT `name`, `project_id` FROM `actor` WHERE `id` = ?";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            Actor actor = null;
            if(resultSet.next()) {
                actor = new Actor();
                actor.setId(id);
                actor.setName(resultSet.getString("name"));
                actor.setProject(new Project());
                actor.getProject().setId(resultSet.getInt("project_id"));
            }
            return actor;
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { resultSet.close(); } catch(NullPointerException | SQLException e) {}
            try { statement.close(); } catch(NullPointerException | SQLException e) {}
        }
    }

    @Override
    public void update(Actor actor) throws DaoException {
        String sqlScript = "UPDATE `actor` SET `name` = ?, `project_id` = ? WHERE `id` = ?";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setString(1, actor.getName());
            statement.setInt(2, actor.getProject().getId());
            statement.setInt(3, actor.getId());
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { statement.close(); } catch(NullPointerException | SQLException e) {}
        }

    }

    @Override
    public void delete(Integer id) throws DaoException {

        String sqlScript = "DELETE FROM `actor` WHERE `id` = ?";
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
