package by.vsu.mf.ammc.pm.dao.mysql.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.vsu.mf.ammc.pm.dao.mysql.BaseDao;
import by.vsu.mf.ammc.pm.dao.project.ProjectsCategoryDao;
import by.vsu.mf.ammc.pm.domain.project.ProjectsCategory;
import by.vsu.mf.ammc.pm.exception.DaoException;

/**
 * Created by Pasha_R on 06.06.2016.
 */
public class ProjectsCategoryDaoImpl extends BaseDao implements ProjectsCategoryDao {
	@Override
	public Integer create(ProjectsCategory category) throws DaoException {
		String sqlScript = "INSERT INTO `project_category` (`name`, `parent_id`) VALUE (?, ?)";
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
	public ProjectsCategory read(Integer id) throws DaoException {
		String sqlScript = "SELECT `name`, `parent_id` FROM `project_category` WHERE `id` = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sqlScript);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			ProjectsCategory category = null;
			if(resultSet.next()) {
				category = new ProjectsCategory();
				category.setId(id);
				category.setName(resultSet.getString("name"));
				category.setParent(new ProjectsCategory());
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
	public List<ProjectsCategory> read() throws DaoException {
		String sqlScript = "SELECT `id`, `name`, `parent_id` FROM `project_category`";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sqlScript);
			resultSet = statement.executeQuery();
			ProjectsCategory projects_category = null;
			List<ProjectsCategory> projects_Category = new ArrayList<>();

			while(resultSet.next()) {
				ProjectsCategory category = new ProjectsCategory();
				projects_category = new ProjectsCategory();
				projects_category.setId(resultSet.getInt("id"));
				projects_category.setName(resultSet.getString("name"));
				projects_category.setParent(new ProjectsCategory());
				projects_category.getParent().setId(resultSet.getInt("parent_id"));
				projects_Category.add(projects_category);
			}
			return projects_Category;
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { resultSet.close(); } catch(NullPointerException | SQLException e) {}
			try { statement.close(); } catch(NullPointerException | SQLException e) {}
		}
	}

	@Override
	public void update(ProjectsCategory category) throws DaoException {
		String sqlScript = "UPDATE `project_category` SET `name` = ?, `parent_id` = ? WHERE `id` = ?";
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
		String sqlScript = "DELETE FROM `projects_category` WHERE `id` = ?";
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

