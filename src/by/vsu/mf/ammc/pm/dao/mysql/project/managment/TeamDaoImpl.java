package by.vsu.mf.ammc.pm.dao.mysql.project.managment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.vsu.mf.ammc.pm.dao.mysql.BaseDao;
import by.vsu.mf.ammc.pm.dao.project.management.TeamDao;
import by.vsu.mf.ammc.pm.domain.project.Project;
import by.vsu.mf.ammc.pm.domain.project.management.Team;
import by.vsu.mf.ammc.pm.domain.user.User;
import by.vsu.mf.ammc.pm.exception.DaoException;

/**
 * Created by Timofei on 20.05.2016.
 */
public class TeamDaoImpl extends BaseDao implements TeamDao {
	@Override
	public Integer create(Team team) throws DaoException {
		String sqlScript = "INSERT INTO `team` (`project_id`, `leader_id`) VALUES (?, ?)";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sqlScript, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setInt(1, team.getProject().getId());
			statement.setInt(2, team.getLeader().getId());
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
	public Team read(Integer id) throws DaoException {
		String sqlScript = "SELECT `project_id`, `leader_id` FROM `team` WHERE `id` = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sqlScript);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			Team team = null;
			if(resultSet.next()) {
				team = new Team();
				team.setId(id);
				team.setProject(new Project());
				team.getProject().setId(resultSet.getInt("project_id"));
				team.setLeader(new User());
				team.getLeader().setId(resultSet.getInt("leader_id"));
			}
			return team;
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { resultSet.close(); } catch(NullPointerException | SQLException e) {}
			try { statement.close(); } catch(NullPointerException | SQLException e) {}
		}
	}

	@Override
	public void update(Team team) throws DaoException {
		String sqlScript = "UPDATE `team` SET `project_id` = ?, `leader_id` = ? WHERE `id` = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sqlScript);
			statement.setInt(1, team.getProject().getId());
			statement.setInt(2, team.getLeader().getId());
			statement.setInt(3, team.getId());
			statement.executeUpdate();
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { statement.close(); } catch(NullPointerException | SQLException e) {}
		}
	}

	@Override
	public void delete(Integer id) throws DaoException {
		String sqlScript = "DELETE FROM `team` WHERE `id` = ?";
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
