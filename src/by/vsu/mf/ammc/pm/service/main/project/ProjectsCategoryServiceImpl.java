package by.vsu.mf.ammc.pm.service.main.project;

import java.util.List;

import by.vsu.mf.ammc.pm.dao.project.ProjectsCategoryDao;
import by.vsu.mf.ammc.pm.domain.project.ProjectsCategory;
import by.vsu.mf.ammc.pm.exception.DaoException;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.HierarchyEntityHelper;
import by.vsu.mf.ammc.pm.service.project.ProjectsCategoryService;

/**
 * Created by likan on 10.06.2016.
 */
public class ProjectsCategoryServiceImpl implements ProjectsCategoryService {
	private ProjectsCategoryDao dao;

	public void setDao(ProjectsCategoryDao dao) {
		this.dao = dao;
	}

	public List<ProjectsCategory> findAll() throws ServiceException {
		try {
			List<ProjectsCategory> categories = dao.read();
			HierarchyEntityHelper.process(categories);
			return categories;
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public ProjectsCategory findById(Integer id) throws ServiceException {
		try {
			return dao.read(id);
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void delete(Integer id) throws ServiceException {
		try {
			dao.delete(id);
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void save(ProjectsCategory category) throws ServiceException {
		try {
			if(category.getId() != null) {
				dao.update(category);
			} else {
				Integer id = dao.create(category);
				category.setId(id);
			}
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}
}