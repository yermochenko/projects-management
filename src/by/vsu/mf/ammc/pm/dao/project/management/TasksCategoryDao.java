package by.vsu.mf.ammc.pm.dao.project.management;

import by.vsu.mf.ammc.pm.dao.Dao;
import by.vsu.mf.ammc.pm.domain.project.management.TasksCategory;
import by.vsu.mf.ammc.pm.exception.DaoException;
import java.util.List;

public interface TasksCategoryDao extends Dao<Integer, TasksCategory> {
    List<TasksCategory> read() throws DaoException;
}
