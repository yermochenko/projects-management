package by.vsu.mf.ammc.pm.dao.mysql.project.managment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import by.vsu.mf.ammc.pm.dao.mysql.BaseDao;
import by.vsu.mf.ammc.pm.dao.project.management.TasksCategoryDao;
import by.vsu.mf.ammc.pm.domain.project.management.TasksCategory;
import by.vsu.mf.ammc.pm.exception.DaoException;

/**
 * Created by Pasha_R on 06.06.2016.
 */
public class TasksCategoryDaoImpl extends BaseDao implements TasksCategoryDao {
	@Override
	public Integer create(TasksCategory category) throws DaoException {
		String sqlScript = "INSERT INTO `task_category` (`name`, `parent_id`) VALUE (?, ?)";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sqlScript, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, category.getName());
			statement.setInt(2, category.getParent().getId());
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
	public TasksCategory read(Integer id) throws DaoException {
		String sqlScript = "SELECT `name`, `parent_id` FROM `task_category` WHERE `id` = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sqlScript);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			TasksCategory category = null;
			if (resultSet.next()) {
				category = new TasksCategory();
				category.setId(id);
				category.setName(resultSet.getString("name"));
				category.setParent(new TasksCategory());
				category.getParent().setId(resultSet.getInt("parent_id"));
			}
			return category;
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { resultSet.close(); } catch(NullPointerException | SQLException e) {}
			try { statement.close(); } catch(NullPointerException | SQLException e) {}
		}
	}

	@Override
	public List<TasksCategory> read() throws DaoException {
		String sqlScript = "SELECT `id`, `name`, `parent_id` FROM `task_category`";
		Connection connection = getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlScript);
			List<TasksCategory> tasksCategory = new ArrayList<>();
			TasksCategory tasksCategory1 = null;
			while(resultSet.next()) {
				tasksCategory1 = new TasksCategory();
				tasksCategory1.setId(resultSet.getInt("id"));
				tasksCategory1.setName(resultSet.getString("name"));
				tasksCategory1.setParent(new TasksCategory());
				tasksCategory1.getParent().setId(resultSet.getInt("parent_id"));
				tasksCategory.add(tasksCategory1);
			}
			return tasksCategory;
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { resultSet.close(); } catch(NullPointerException | SQLException e) {}
			try { statement.close(); } catch(NullPointerException | SQLException e) {}
		}
	}

	@Override
	public void update(TasksCategory category) throws DaoException {
		String sqlScript = "UPDATE `task_category` SET `name` = ?, `parent_id` = ? WHERE `id` = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sqlScript);
			statement.setString(1, category.getName());
			statement.setInt(2, category.getParent().getId());
			statement.setInt(3, category.getId());
			statement.executeUpdate();
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { statement.close(); } catch(NullPointerException | SQLException e) {}
		}
	}

	@Override
	public void delete(Integer id) throws DaoException {
		String sqlScript = "DELETE FROM `task_category` WHERE `id` = ?";
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
