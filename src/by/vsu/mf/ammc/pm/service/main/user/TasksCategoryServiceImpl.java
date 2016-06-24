package by.vsu.mf.ammc.pm.service.main.user;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import by.vsu.mf.ammc.pm.dao.project.management.TasksCategoryDao;
import by.vsu.mf.ammc.pm.domain.project.management.TasksCategory;
import by.vsu.mf.ammc.pm.exception.DaoException;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.user.TasksCategoryService;

public class TasksCategoryServiceImpl implements TasksCategoryService {
	private TasksCategoryDao tasksCategoryDao;

	public void setTasksCategoryDao(TasksCategoryDao tasksCategoryDao) {
		this.tasksCategoryDao = tasksCategoryDao;
	}

	@Override
	public List<TasksCategory> findAll() throws ServiceException {
		try {
			List<TasksCategory> categories = tasksCategoryDao.read();
			Map<Integer, TasksCategory> tasksCategoryMap = new HashMap<>();
			for(TasksCategory category : categories) {
				tasksCategoryMap.put(category.getId(), category);
			}
			for(TasksCategory category : categories) {
				TasksCategory parent = category.getParent();
				if(parent != null) {
					parent = tasksCategoryMap.get(parent.getId());
					category.setParent(parent);
					parent.getChildren().add(category);
				}
			}
			Iterator<TasksCategory> iterator = categories.iterator();
			while(iterator.hasNext()) {
				TasksCategory category = iterator.next();
				if(category.getParent() != null) {
					iterator.remove();
				}
			}
			return categories;
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public TasksCategory findById(Integer id) throws ServiceException {
		try {
			return tasksCategoryDao.read(id);
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void save(TasksCategory category) throws ServiceException {
		try {
			if(category.getId() != null) {
				tasksCategoryDao.update(category);
			} else {
				Integer id = tasksCategoryDao.create(category);
				category.setId(id);
			}
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void delete(Integer id) throws ServiceException {
		try {
			tasksCategoryDao.delete(id);
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}
}