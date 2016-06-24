package by.vsu.mf.ammc.pm.service.user;

import java.util.List;

import by.vsu.mf.ammc.pm.domain.project.management.TasksCategory;
import by.vsu.mf.ammc.pm.exception.ServiceException;

public interface TasksCategoryService {
	List<TasksCategory> findAll() throws ServiceException;

	TasksCategory findById(Integer id) throws ServiceException;

	void save(TasksCategory type) throws ServiceException;

	void delete(Integer id) throws ServiceException;
}