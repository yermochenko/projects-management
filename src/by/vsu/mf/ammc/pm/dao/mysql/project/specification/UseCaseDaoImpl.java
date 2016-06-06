package by.vsu.mf.ammc.pm.dao.mysql.project.specification;

import by.vsu.mf.ammc.pm.dao.mysql.BaseDao;
import by.vsu.mf.ammc.pm.dao.project.specification.UseCaseDao;
import by.vsu.mf.ammc.pm.domain.project.Module;
import by.vsu.mf.ammc.pm.domain.project.specification.UseCase;
import by.vsu.mf.ammc.pm.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by Влад on 06.06.2016.
 */
public class UseCaseDaoImpl extends BaseDao implements UseCaseDao {
    @Override

    public Integer create(UseCase useCase) throws DaoException {
        String sqlScript = "INSERT INTO `use_case` (`name`, `module_id`) VALUES (?, ?)";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sqlScript, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, useCase.getName());
            statement.setInt(2, useCase.getModule().getId());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                resultSet.close();
            } catch (NullPointerException | SQLException e) {
            }
            try {
                statement.close();
            } catch (NullPointerException | SQLException e) {
            }
        }
    }



    @Override
    public UseCase read(Integer id) throws DaoException {

        String sqlScript = "SELECT `name`, `module_id` FROM `team` WHERE `id` = ?";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            UseCase useCase = null;
            if(resultSet.next()) {
                useCase = new UseCase();
                useCase.setId(id);
                useCase.setName(resultSet.getString("name"));
                useCase.setModule(new Module());
                useCase.getModule().setId(resultSet.getInt("module_id"));
            }
            return useCase;
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { resultSet.close(); } catch(NullPointerException | SQLException e) {}
            try { statement.close(); } catch(NullPointerException | SQLException e) {}
        }

    }






    public void update(UseCase useCase) throws DaoException {
        String sqlScript = "UPDATE `use_case` SET `name` = ?, `module_id` = ? WHERE `id` = ?";
        Connection connection = getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sqlScript);
            statement.setString(1, useCase.getName());
            statement.setInt(2, useCase.getModule().getId());
            statement.setInt(3, useCase.getId());
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { statement.close(); } catch(NullPointerException | SQLException e) {}
        }



    }

    public void delete(Integer id) throws DaoException {


        String sqlScript = "DELETE FROM `use_case` WHERE `id` = ?";
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
