package by.vsu.mf.ammc.pm.service.main.user;

import by.vsu.mf.ammc.pm.dao.project.ProjectsCategoryDao;
import by.vsu.mf.ammc.pm.domain.project.ProjectsCategory;
import by.vsu.mf.ammc.pm.exception.DaoException;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.user.ProjectsCategoryService;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by likan on 10.06.2016.
 */
public class ProjectCategoryServiceImpl implements ProjectsCategoryService{
    private ProjectsCategoryDao projectscategoryDao;
    public void setDao(ProjectsCategoryDao dao) {
        this.projectscategoryDao = dao;
    }
    public List<ProjectsCategory> findAll(Integer categoryId) throws ServiceException {
        try {
            List<ProjectsCategory> categories = projectscategoryDao.read();
            Map<Integer, ProjectsCategory> projectsCategoryMap = new HashMap<>();
            for(ProjectsCategory category : categories ) {
                projectsCategoryMap.put(category.getId(), category);
            }
            for(ProjectsCategory category : categories) {
                ProjectsCategory parent = category.getParent();
                if(parent != null) {
                    parent = projectsCategoryMap.get(parent.getId());
                    category.setParent(parent);
                    parent.getChildren().add(category);
                }
            }
            Iterator<ProjectsCategory> iterator = categories.iterator();
            while(iterator.hasNext()) {
                ProjectsCategory group = iterator.next();
                if(group.getParent() != null) {
                    iterator.remove();
                }
            }
            return categories;
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
    }
    @Override
    public ProjectsCategory findById(Integer id) throws ServiceException {
        try {
            return projectscategoryDao.read(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(Integer id) throws ServiceException {
        try {
            projectscategoryDao.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void save(ProjectsCategory type) throws ServiceException {
        try {
            if (type.getId() != null) {
                projectscategoryDao.update(type);
            } else {
                Integer id = projectscategoryDao.create(type);
                type.setId(id);
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
