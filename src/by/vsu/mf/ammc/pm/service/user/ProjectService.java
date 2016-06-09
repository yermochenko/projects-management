package by.vsu.mf.ammc.pm.service.user;

import by.vsu.mf.ammc.pm.domain.project.management.Team;
import by.vsu.mf.ammc.pm.exception.ServiceException;

import java.util.List;

/**
 * Created by Pasha_R on 08.06.2016.
 */
public interface ProjectService {

    List<Team> findAll(Integer projectId) throws ServiceException;

    Team findById(Integer id) throws ServiceException;

    void save(Team type) throws ServiceException;

    void delete(Integer id) throws ServiceException;
}

