package by.vsu.mf.ammc.pm.service.user;
import java.util.List;


import by.vsu.mf.ammc.pm.domain.project.management.Team;
import by.vsu.mf.ammc.pm.exception.ServiceException;

/**
 * Created by Timofei on 06.06.2016.
 */
public interface TeamService {

    List<Team> findAll(Integer projectId) throws ServiceException;

    Team findById(Integer id) throws ServiceException;

    void save(Team type) throws ServiceException;

    void delete(Integer id) throws ServiceException;
}

