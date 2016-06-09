package by.vsu.mf.ammc.pm.service.main;

import java.util.List;

import by.vsu.mf.ammc.pm.dao.project.ProjectDao;
import by.vsu.mf.ammc.pm.domain.project.Project;
import by.vsu.mf.ammc.pm.exception.DaoException;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.project.ProjectService;

public class ProjectServiceImpl implements ProjectService {

	private ProjectDao projectDao;

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	public List<Project> findAll(Integer categoryId) throws ServiceException {
		try {
			return projectDao.readByCategoryId(categoryId);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Project findById(Integer id) throws ServiceException {
		try {
			return projectDao.read(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void delete(Integer id) throws ServiceException {
		try {
			projectDao.delete(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void save(Project type) throws ServiceException {
		try {
			if (type.getId() != null) {
				projectDao.update(type);
			} else {
				Integer id = projectDao.create(type);
				type.setId(id);
			}
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
}
