package by.vsu.mf.ammc.pm.dao.mysql.project.managment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.vsu.mf.ammc.pm.dao.mysql.BaseDao;
import by.vsu.mf.ammc.pm.dao.project.management.EmployeeDao;
import by.vsu.mf.ammc.pm.domain.project.management.Employee;
import by.vsu.mf.ammc.pm.domain.project.management.EmployeesRole;
import by.vsu.mf.ammc.pm.domain.project.management.Team;
import by.vsu.mf.ammc.pm.domain.user.User;
import by.vsu.mf.ammc.pm.exception.DaoException;

/**
 * Created by Борис on 19.05.2016.
 */
public class EmployeeDaoImpl extends BaseDao implements EmployeeDao {
	@Override
	public Integer create(Employee employee) throws DaoException {
		String sqlScript = "INSERT INTO `employee` (`user_id`, `team_id`, `role`) VALUES (?, ?, ?)";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sqlScript, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setInt(1, employee.getUser().getId());
			statement.setInt(2, employee.getTeam().getId());
			statement.setInt(3, employee.getRole().ordinal());
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
	public Employee read(Integer id) throws DaoException {
		String sqlScript = "SELECT `user_id`, `team_id`, `role` FROM `employee` WHERE `id` = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sqlScript);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			Employee employee = null;
			if(resultSet.next()) {
				employee = new Employee();
				employee.setId(id);
				employee.setUser(new User());
				employee.getUser().setId(resultSet.getInt("user_id"));
				employee.setTeam(new Team());
				employee.getTeam().setId(resultSet.getInt("team_id"));
				employee.setRole(EmployeesRole.values()[resultSet.getInt("role")]);
			}
			return employee;
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { resultSet.close(); } catch(NullPointerException | SQLException e) {}
			try { statement.close(); } catch(NullPointerException | SQLException e) {}
		}
	}

	@Override
	public void update(Employee employee) throws DaoException {
		String sqlScript = "UPDATE `employee` SET `user_id` = ?, `team_id` = ?, `role` = ? WHERE `id` = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sqlScript);
			statement.setInt(1, employee.getUser().getId());
			statement.setInt(2, employee.getTeam().getId());
			statement.setInt(3, employee.getRole().ordinal());
			statement.setInt(4, employee.getId());
			statement.executeUpdate();
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { statement.close(); } catch(NullPointerException | SQLException e) {}
		}
	}

	@Override
	public void delete(Integer id) throws DaoException {
		String sqlScript = "DELETE FROM `employee` WHERE `id` = ?";
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
