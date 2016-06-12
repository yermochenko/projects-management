package by.vsu.mf.ammc.pm.service.user;

import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.domain.project.ProjectsCategory;
import java.util.List;

/**
 * Created by likan on 10.06.2016.
 */
public interface ProjectsCategoryService {
    List<ProjectsCategory> findAll(Integer projectId) throws ServiceException;

    ProjectsCategory findById(Integer id) throws ServiceException;

    void save(ProjectsCategory type) throws ServiceException;

    void delete(Integer id) throws ServiceException;
}
