package by.vsu.mf.ammc.pm.service.user;

import by.vsu.mf.ammc.pm.domain.project.management.TasksCategory;
import by.vsu.mf.ammc.pm.exception.ServiceException;

import java.util.List;

/**
 * Created by user on 08.06.2016.
 */
public interface TasksCategoryService {
    List<TasksCategory> findAll() throws ServiceException;

    TasksCategory findById(Integer id) throws ServiceException;

    void save(TasksCategory type) throws ServiceException;

    void delete(Integer id) throws ServiceException;
}


