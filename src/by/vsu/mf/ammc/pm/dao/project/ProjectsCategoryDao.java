package by.vsu.mf.ammc.pm.dao.project;

import by.vsu.mf.ammc.pm.dao.Dao;
import by.vsu.mf.ammc.pm.domain.project.ProjectsCategory;
import by.vsu.mf.ammc.pm.exception.DaoException;

import java.util.List;

public interface ProjectsCategoryDao extends Dao<Integer, ProjectsCategory> {
	List<ProjectsCategory> read() throws DaoException;
}