package by.vsu.mf.ammc.pm.dao.mysql.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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
		String sqlScript = "INSERT INTO `projects_category` (`name`, `parent_id`) VALUE (?, ?)";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sqlScript, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, category.getName());
			if(category.getParent() != null && category.getParent().getId() != null) {
				statement.setInt(2, category.getParent().getId());
			} else {
				statement.setNull(2, Types.INTEGER);
			}
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
		String sqlScript = "SELECT `name`, `parent_id` FROM `projects_category` WHERE `id` = ?";
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
				Integer parentId = resultSet.getInt("parent_id");
				if(!resultSet.wasNull()) {
					category.setParent(new ProjectsCategory());
					category.getParent().setId(parentId);
				}
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
		String sqlScript = "SELECT `id`, `name`, `parent_id` FROM `projects_category`";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sqlScript);
			resultSet = statement.executeQuery();
			ProjectsCategory projectsCategory = null;
			Integer parentId;
			List<ProjectsCategory> projectsCategories = new ArrayList<>();
			while(resultSet.next()) {
				projectsCategory = new ProjectsCategory();
				projectsCategory.setId(resultSet.getInt("id"));
				projectsCategory.setName(resultSet.getString("name"));
				parentId = resultSet.getInt("parent_id");
				if(!resultSet.wasNull()) {
					projectsCategory.setParent(new ProjectsCategory());
					projectsCategory.getParent().setId(parentId);
				}
				projectsCategories.add(projectsCategory);
			}
			return projectsCategories;
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { resultSet.close(); } catch(NullPointerException | SQLException e) {}
			try { statement.close(); } catch(NullPointerException | SQLException e) {}
		}
	}

	@Override
	public void update(ProjectsCategory category) throws DaoException {
		String sqlScript = "UPDATE `projects_category` SET `name` = ?, `parent_id` = ? WHERE `id` = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sqlScript);
			statement.setString(1, category.getName());
			if(category.getParent() != null && category.getParent().getId() != null) {
				statement.setInt(2, category.getParent().getId());
			} else {
				statement.setNull(2, Types.INTEGER);
			}
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