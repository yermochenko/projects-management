package by.vsu.mf.ammc.pm.service.main.user;

import by.vsu.mf.ammc.pm.dao.project.management.TasksCategoryDao;
import by.vsu.mf.ammc.pm.domain.project.management.TasksCategory;
import by.vsu.mf.ammc.pm.domain.user.UsersGroup;
import by.vsu.mf.ammc.pm.exception.DaoException;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.user.TasksCategoryService;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 08.06.2016.
 */
public class TasksCategoryServiceImpl implements TasksCategoryService {
    private TasksCategoryDao dao;

    public void setDao(TasksCategoryDao dao) {
        this.dao = dao;
    }

    @Override
    public List<TasksCategory> findAll() throws ServiceException {
        try {
            List<TasksCategory> categories = dao.read();
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
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public TasksCategory findById(Integer id) throws ServiceException {
        try {
            return dao.read(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void save(TasksCategory category) throws ServiceException {
        try {
            if (category.getId() != null) {
                dao.update(category);
            } else {
                Integer id = dao.create(category);
                category.setId(id);
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(Integer id) throws ServiceException {
        try {
            dao.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}

