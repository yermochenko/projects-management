package by.vsu.mf.ammc.pm.service.project;

import java.util.List;

import by.vsu.mf.ammc.pm.domain.project.Project;
import by.vsu.mf.ammc.pm.domain.project.ProjectsCategory;
import by.vsu.mf.ammc.pm.exception.ServiceException;

public interface ProjectService {
	List<Project> findByCategory(ProjectsCategory category) throws ServiceException;

	Project findById(Integer id) throws ServiceException;

	void save(Project project) throws ServiceException;

	void delete(Integer id) throws ServiceException;
}