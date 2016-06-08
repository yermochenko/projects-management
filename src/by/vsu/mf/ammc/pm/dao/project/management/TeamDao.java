package by.vsu.mf.ammc.pm.dao.project.management;

import java.util.List;
import by.vsu.mf.ammc.pm.dao.Dao;
import by.vsu.mf.ammc.pm.domain.project.management.Team;
import by.vsu.mf.ammc.pm.exception.DaoException;

public interface TeamDao extends Dao<Integer, Team> {
    List<Team> readByProject(Integer projectId) throws DaoException;
}



