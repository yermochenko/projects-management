package by.vsu.mf.ammc.pm.dao.mysql.project.managment;

import by.vsu.mf.ammc.pm.dao.mysql.BaseDao;
import by.vsu.mf.ammc.pm.dao.project.management.TeamDao;
import by.vsu.mf.ammc.pm.domain.project.Project;
import by.vsu.mf.ammc.pm.domain.project.management.Employee;
import by.vsu.mf.ammc.pm.domain.project.management.EmployeesRole;
import by.vsu.mf.ammc.pm.domain.project.management.Team;
import by.vsu.mf.ammc.pm.domain.user.User;
import by.vsu.mf.ammc.pm.exception.DaoException;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Timofei on 20.05.2016.
 */
public class TeamDaoImpl extends BaseDao implements TeamDao {
    @Override
    public Integer create(Team team) throws DaoException {
        String sqlScript = "INSERT INTO team ( project_id, leader_id) VALUES ( ?, ?)";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setInt(1, team.getProject().getId());
            statement.setInt(2, team.getLeader().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return null;
    }

    @Override
    public Team read(Integer id) throws DaoException {
        String sqlScript = "SELECT id, project_id, leader_id FROM team WHERE id = ?";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Team team = null;

        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                team = new Team();
                team.setId(id);
                team.setProject(resultSet.getObject("project_id", Project.class));
                team.setLeader(resultSet.getObject("leader_id", User.class));

            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return team;
    }

    @Override
    public void update(Team team) throws DaoException {
        String sqlScript = "UPDATE team SET project_id = ?, leader_id = ? WHERE id = ?";
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setInt(1, team.getProject().getId());
            statement.setInt(2, team.getLeader().getId());
            statement.setInt(3, team.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public void delete(Integer id) throws DaoException {
        String sqlScript = "DELETE FROM team WHERE id = ?";
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
