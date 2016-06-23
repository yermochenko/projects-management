package by.vsu.mf.ammc.pm.dao.project;

import by.vsu.mf.ammc.pm.dao.Dao;
import by.vsu.mf.ammc.pm.domain.project.Project;
import by.vsu.mf.ammc.pm.exception.DaoException;

import java.util.List;

public interface ProjectDao extends Dao<Integer, Project> {
	List<Project> readByCategory(Integer categoryId) throws DaoException;
}
