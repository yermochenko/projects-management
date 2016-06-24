package by.vsu.mf.ammc.pm.dao.mysql.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.vsu.mf.ammc.pm.dao.mysql.BaseDao;
import by.vsu.mf.ammc.pm.dao.project.ModuleDao;
import by.vsu.mf.ammc.pm.domain.project.Module;
import by.vsu.mf.ammc.pm.domain.project.Project;
import by.vsu.mf.ammc.pm.exception.DaoException;

public class ModuleDaoImpl extends BaseDao implements ModuleDao {
	@Override
	public Integer create(Module module) throws DaoException {
		String sqlScript = "INSERT INTO  `module` (`name`, `parent_id`, `project_id`) VALUES (?,?,?)";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sqlScript, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, module.getName());
			statement.setInt(2, module.getParent().getId());
			statement.setInt(3, module.getProject().getId());
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			resultSet.next();
			return resultSet.getInt(1);
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			try { resultSet.close(); } catch (NullPointerException | SQLException e) {}
			try { statement.close(); } catch (NullPointerException | SQLException e) {}
		}
	}

	@Override
	public Module read(Integer id) throws DaoException {
		String sqlScript = "SELECT `name`, `parent_id`, `project_id` FROM `module` WHERE `id` = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sqlScript);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			Module module = null;
			if (resultSet.next()) {
				module = new Module();
				module.setId(id);
				module.setName(resultSet.getString("name"));
				module.setParent(new Module());
				module.getParent().setId(resultSet.getInt("parent_id"));
				module.setProject(new Project());
				module.getProject().setId(resultSet.getInt("project_id"));
			}
			return module;
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			try { resultSet.close(); } catch (NullPointerException | SQLException e) {}
			try { statement.close(); } catch (NullPointerException | SQLException e) {}
		}
	}

	@Override
	public void update(Module module) throws DaoException {
		String sqlScript = "UPDATE `module` SET `name` = ?, `parent_id` = ?, `project_id` = ? WHERE `id` = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sqlScript);
			statement.setString(1, module.getName());
			statement.setInt(2, module.getParent().getId());
			statement.setInt(3, module.getProject().getId());
			statement.setInt(4, module.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			try { statement.close(); } catch (NullPointerException | SQLException e) {}
		}
	}

	@Override
	public void delete(Integer id) throws DaoException {
		String sqlScript = "DELETE FROM `module` WHERE `id` = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sqlScript);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			try { statement.close(); } catch (NullPointerException | SQLException e) {}
		}
	}
}