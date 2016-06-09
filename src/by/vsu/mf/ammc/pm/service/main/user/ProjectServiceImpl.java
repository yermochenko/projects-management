package by.vsu.mf.ammc.pm.service.main.user;

import by.vsu.mf.ammc.pm.dao.project.ProjectDao;
import by.vsu.mf.ammc.pm.dao.user.UserDao;
import by.vsu.mf.ammc.pm.domain.project.Project;
import by.vsu.mf.ammc.pm.domain.user.User;
import by.vsu.mf.ammc.pm.exception.DaoException;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.user.ProjectService;

import java.util.List;

/**
 * Created by Pasha_R on 08.06.2016.
 */
public class ProjectServiceImpl implements ProjectService {
    private ProjectDao dao;
    private UserDao userDao;

    public void setDao(ProjectDao dao) {
        this.dao = dao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<Project> findAll(Integer project_categoryId) throws ServiceException {
        try {
            List<Project> projects = dao.readByCategoryId(project_categoryId);
            for(Project project : projects) {
                User manager = project.getManager();
                manager = userDao.read(manager.getId());
                project.setManager(manager);
            }
            return projects;
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
    }


    @Override
    public Project findById(Integer id) throws ServiceException {
        try {
            return dao.read(id);
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void save(Project type) throws ServiceException {
        try {
            if(type.getId() != null) {
                dao.update(type);
            } else {
                Integer id = dao.create(type);
                type.setId(id);
            }
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(Integer id) throws ServiceException {
        try {
            dao.delete(id);
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
    }
}

