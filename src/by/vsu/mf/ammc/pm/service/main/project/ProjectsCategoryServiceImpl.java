package by.vsu.mf.ammc.pm.service.main.project;

import java.util.List;

import by.vsu.mf.ammc.pm.dao.project.ProjectsCategoryDao;
import by.vsu.mf.ammc.pm.domain.project.ProjectsCategory;
import by.vsu.mf.ammc.pm.exception.DaoException;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.HierarchyEntityHelper;
import by.vsu.mf.ammc.pm.service.project.ProjectsCategoryService;

public class ProjectsCategoryServiceImpl implements ProjectsCategoryService {
	private ProjectsCategoryDao projectsCategoryDao;

	public void setProjectsCategoryDao(ProjectsCategoryDao projectsCategoryDao) {
		this.projectsCategoryDao = projectsCategoryDao;
	}

	@Override
	public List<ProjectsCategory> findAll() throws ServiceException {
		try {
			List<ProjectsCategory> categories = projectsCategoryDao.read();
			HierarchyEntityHelper.process(categories);
			return categories;
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public ProjectsCategory findById(Integer id) throws ServiceException {
		try {
			return projectsCategoryDao.read(id);
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void delete(Integer id) throws ServiceException {
		try {
			projectsCategoryDao.delete(id);
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void save(ProjectsCategory category) throws ServiceException {
		try {
			if(category.getId() != null) {
				projectsCategoryDao.update(category);
			} else {
				Integer id = projectsCategoryDao.create(category);
				category.setId(id);
			}
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}
}