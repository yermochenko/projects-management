package by.vsu.mf.ammc.pm.service.main.project;

import java.util.List;

import by.vsu.mf.ammc.pm.dao.project.ProjectDao;
import by.vsu.mf.ammc.pm.dao.project.ProjectsCategoryDao;
import by.vsu.mf.ammc.pm.dao.user.UserDao;
import by.vsu.mf.ammc.pm.domain.project.Project;
import by.vsu.mf.ammc.pm.domain.project.ProjectsCategory;
import by.vsu.mf.ammc.pm.domain.user.User;
import by.vsu.mf.ammc.pm.exception.DaoException;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.project.ProjectService;

public class ProjectServiceImpl implements ProjectService {
	private ProjectDao projectDao;
	private ProjectsCategoryDao categoryDao;
	private UserDao userDao;

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	public void setCategoryDao(ProjectsCategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<Project> findByCategory(ProjectsCategory category) throws ServiceException {
		try {
			List<Project> projects = projectDao.readByCategory(category.getId());
			for(Project project : projects) {
				project.setCategory(category);
				User manager = project.getManager();
				manager = userDao.read(manager.getId());
				project.setManager(manager);
			}
			return projects;
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Project findById(Integer id) throws ServiceException {
		try {
			Project project = projectDao.read(id);
			ProjectsCategory category = project.getCategory();
			category = categoryDao.read(category.getId());
			project.setCategory(category);
			User manager = project.getManager();
			manager = userDao.read(manager.getId());
			project.setManager(manager);
			return project;
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void delete(Integer id) throws ServiceException {
		try {
			projectDao.delete(id);
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void save(Project project) throws ServiceException {
		try {
			if(project.getId() != null) {
				if(project.getDescription() == null) {
					Project oldProject = projectDao.read(project.getId());
					project.setDescription(oldProject.getDescription());
				}
				projectDao.update(project);
			} else {
				Integer id = projectDao.create(project);
				project.setId(id);
			}
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}
}