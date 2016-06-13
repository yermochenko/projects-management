package by.vsu.mf.ammc.pm.dao.mysql.project.specification;

import by.vsu.mf.ammc.pm.dao.mysql.BaseDao;
import by.vsu.mf.ammc.pm.dao.project.specification.RequirementDao;
import by.vsu.mf.ammc.pm.domain.project.Module;
import by.vsu.mf.ammc.pm.domain.project.specification.Requirement;
import by.vsu.mf.ammc.pm.domain.project.specification.UseCase;
import by.vsu.mf.ammc.pm.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Pasha_R on 06.06.2016.
 */
public class RequirementDaoImpl extends BaseDao implements RequirementDao {
    @Override
    public Integer create(Requirement object) throws DaoException {
        String sqlScript = "INSERT INTO `requirement` ( `name`, `description`, `importance`, `change_probability`, `use_case_id`, `module_id`) VALUE (?, ?, ?, ?, ?, ?)";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet r = null;
        try {
            statement = connection.prepareStatement(sqlScript, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString((int)1, object.getName());
            statement.setString((int)2, object.getDescription());
            statement.setFloat((int)3, object.getImportance());
            statement.setFloat((int)4, object.getChangeProbability());
            statement.setInt((int)5, object.getUseCase().getId());
            statement.setInt((int)6, object.getModule().getId());
            statement.executeUpdate();
            r = statement.getGeneratedKeys();
            r.next();
            return r.getInt(1);
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { r.close(); } catch(NullPointerException | SQLException e) {}
            try { statement.close(); } catch(NullPointerException | SQLException e) {}
        }
    }

    @Override
    public Requirement read(Integer key) throws DaoException {
        String sqlScript = "SELECT `user_id`, `name`, `description`, `importance`, `change_probability`, `use_case_id`, `module_id` FROM requirement WHERE `id` = ?";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setInt(1, key);
            resultSet = statement.executeQuery();
            Requirement requir = null;
            if (resultSet.next()) {
                requir = new Requirement();
                requir.setId(key);
                requir.setName(resultSet.getString("name"));
                requir.setDescription(resultSet.getString("description"));
                requir.setImportance(resultSet.getFloat("importance"));
                requir.setChangeProbability(resultSet.getFloat("change_probability"));
                requir.setUseCase(new UseCase());
                requir.getUseCase().setId(resultSet.getInt("use_case_id"));
                requir.setModule(new Module());
                requir.getModule().setId(resultSet.getInt("module_id"));
            }
            return requir;
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { resultSet.close(); } catch(NullPointerException | SQLException e) {}
            try { statement.close(); } catch(NullPointerException | SQLException e) {}
        }
    }

    @Override
    public void update(Requirement object) throws DaoException {
        String sqlScript = "UPDATE `requirement` SET `user_id` = ?, `name` = ?, `description` = ?, `importance` = ?, `change_probability` = ?, `use_case_id` = ?, `module_id` = ?, WHERE `id` = ?";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setInt(1, object.getId());
            statement.setString(2, object.getName());
            statement.setString(3, object.getDescription());
            statement.setFloat(4, object.getImportance());
            statement.setFloat(5, object.getChangeProbability());
            statement.setInt(6, object.getUseCase().getId());
            statement.setInt(7, object.getModule().getId());
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { statement.close(); } catch(NullPointerException | SQLException e) {}
        }
    }

    @Override
    public void delete(Integer key) throws DaoException {
        String sqlScript = "DELETE FROM `requirement` WHERE `id` = ?";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setInt(1, key);
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { statement.close(); } catch(NullPointerException | SQLException e) {}
        }
    }
}
