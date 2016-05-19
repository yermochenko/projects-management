package by.vsu.mf.ammc.pm.dao.mysql.project.managment;

import by.vsu.mf.ammc.pm.dao.mysql.BaseDao;
import by.vsu.mf.ammc.pm.dao.project.management.EmployeeDao;
import by.vsu.mf.ammc.pm.domain.project.management.Employee;
import by.vsu.mf.ammc.pm.domain.project.management.EmployeesRole;
import by.vsu.mf.ammc.pm.domain.project.management.Team;
import by.vsu.mf.ammc.pm.domain.user.User;
import by.vsu.mf.ammc.pm.exception.DaoException;

import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Борис on 19.05.2016.
 */
public class EmployeeDaoImpl extends BaseDao implements EmployeeDao {
    @Override
    public Integer create(Employee employee) throws DaoException {
        String sqlScript = "INSERT INTO employee (user_id, team_id, role) VALUES (?, ?, ?)";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setInt(1, employee.getUser().getId());
            statement.setInt(2, employee.getTeam().getId());
            statement.setString(3, employee.getRole().name());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return null;
    }

    @Override
    public Employee read(Integer id) throws DaoException {
        String sqlScript = "SELECT id, user_id, team_id, role FROM employee WHERE id = ?";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Employee employee = null;

        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employee = new Employee();
                employee.setId(id);
                employee.setUser(resultSet.getObject("user_id", User.class));
                employee.setTeam(resultSet.getObject("team_id", Team.class));
                employee.setRole(resultSet.getObject("role", EmployeesRole.class));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return employee;
    }

    @Override
    public void update(Employee employee) throws DaoException {
        String sqlScript = "UPDATE employee SET user_id = ?, team_id = ?, role = ? WHERE id = ?";
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setInt(1, employee.getUser().getId());
            statement.setInt(2, employee.getTeam().getId());
            statement.setString(3, employee.getRole().name());
            statement.setInt(4, employee.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public void delete(Integer id) throws DaoException {
        String sqlScript = "DELETE FROM employee WHERE id = ?";
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
