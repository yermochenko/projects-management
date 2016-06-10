package by.vsu.mf.ammc.pm.service.user;

import by.vsu.mf.ammc.pm.domain.project.Project;
import by.vsu.mf.ammc.pm.exception.ServiceException;

import java.util.List;

/**
 * Created by Pasha_R on 08.06.2016.
 */
public interface ProjectService {

    List<Project> findAll(Integer categoryId) throws ServiceException;

    Project findById(Integer id) throws ServiceException;

    void save(Project type) throws ServiceException;

    void delete(Integer id) throws ServiceException;
}

