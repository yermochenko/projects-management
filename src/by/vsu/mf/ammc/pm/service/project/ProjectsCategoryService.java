package by.vsu.mf.ammc.pm.service.project;

import java.util.List;

import by.vsu.mf.ammc.pm.domain.project.ProjectsCategory;
import by.vsu.mf.ammc.pm.exception.ServiceException;

public interface ProjectsCategoryService {
	List<ProjectsCategory> findAll() throws ServiceException;

	ProjectsCategory findById(Integer id) throws ServiceException;

	void save(ProjectsCategory category) throws ServiceException;

	void delete(Integer id) throws ServiceException;
}