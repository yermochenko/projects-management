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
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pasha_R on 03.06.2016.
 */

public class ProjectDaoImpl extends BaseDao implements ProjectDao {
	@Override
	public Integer create(Project project) throws DaoException {
		String sqlScript = "INSERT INTO `project` (`name`, `description`, `category_id`, `manager_id`) VALUES (?, ?, ?, ?)";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sqlScript, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, project.getName());
			if(project.getDescription() != null) {
				statement.setString(2, project.getDescription());
			} else {
				statement.setNull(2, Types.VARCHAR);
			}
			statement.setInt(3, project.getCategory().getId());
			statement.setInt(4, project.getManager().getId());
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
	public Project read(Integer id) throws DaoException {
		String sqlScript = "SELECT `name`, `description`, `category_id`, `manager_id` FROM `project` WHERE `id` = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sqlScript);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			Project project = null;
			if(resultSet.next()) {
				project = new Project();
				project.setId(id);
				project.setName(resultSet.getString("name"));
				String description = resultSet.getString("description");
				if(!resultSet.wasNull()) {
					project.setDescription(description);
				}
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
	public void update(Project project) throws DaoException {
		String sqlScript = "UPDATE `project` SET `name` = ?, `description` = ?, `category_id` = ?, `manager_id` = ? WHERE `id` = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sqlScript);
			statement.setString(1, project.getName());
			if(project.getDescription() != null) {
				statement.setString(2, project.getDescription());
			} else {
				statement.setNull(2, Types.VARCHAR);
			}
			statement.setInt(3, project.getCategory().getId());
			statement.setInt(4, project.getManager().getId());
			statement.setInt(5, project.getId());
			statement.executeUpdate();
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { statement.close(); } catch(NullPointerException | SQLException e) {}
		}
	}

	@Override
	public void delete(Integer id) throws DaoException {
		String sqlScript = "DELETE FROM `project` WHERE `id` = ?";
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

	@Override
	public List<Project> readByCategory(Integer categoryId) throws DaoException {
		String sqlScript = "SELECT `id`, `name`, `description`, `manager_id` FROM `project` WHERE `category_id` = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sqlScript);
			statement.setInt(1, categoryId);
			resultSet = statement.executeQuery();
			Project project = null;
			List<Project> projects = new ArrayList<>();
			ProjectsCategory category = new ProjectsCategory();
			category.setId(categoryId);
			while(resultSet.next()) {
				project = new Project();
				project.setId(resultSet.getInt("id"));
				project.setName(resultSet.getString("name"));
				String description = resultSet.getString("description");
				if(!resultSet.wasNull()) {
					project.setDescription(description);
				}
				project.setCategory(category);
				project.setManager(new User());
				project.getManager().setId(resultSet.getInt("manager_id"));
				projects.add(project);
			}
			return projects;
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { resultSet.close(); } catch(NullPointerException | SQLException e) {}
			try { statement.close(); } catch(NullPointerException | SQLException e) {}
		}
	}
}