package by.vsu.mf.ammc.pm.dao.mysql.project.managment;

import by.vsu.mf.ammc.pm.dao.mysql.BaseDao;
import by.vsu.mf.ammc.pm.dao.project.management.EmployeeDao;
import by.vsu.mf.ammc.pm.domain.project.management.Employee;
import by.vsu.mf.ammc.pm.exception.DaoException;

/**
 * Created by Борис on 19.05.2016.
 */
public class EmployeeDaoImpl extends BaseDao implements EmployeeDao {
    @Override
    public Integer create(Employee employee) throws DaoException {
        return null;
    }

    @Override
    public Employee read(Integer id) throws DaoException {
        return null;
    }

    @Override
    public void update(Employee employee) throws DaoException {

    }

    @Override
    public void delete(Integer id) throws DaoException {

    }
}
