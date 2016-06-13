package by.vsu.mf.ammc.pm.service.main.user;

import java.util.List;

import by.vsu.mf.ammc.pm.dao.user.UsersGroupDao;
import by.vsu.mf.ammc.pm.domain.user.UsersGroup;
import by.vsu.mf.ammc.pm.exception.DaoException;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.HierarchyEntityHelper;
import by.vsu.mf.ammc.pm.service.user.UsersGroupService;

public class UsersGroupServiceImpl implements UsersGroupService {
	private UsersGroupDao dao;

	public void setDao(UsersGroupDao dao) {
		this.dao = dao;
	}

	@Override
	public List<UsersGroup> findAll() throws ServiceException {
		try {
			List<UsersGroup> groups = dao.read();
			HierarchyEntityHelper.process(groups);
			return groups;
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public UsersGroup findById(Integer id) throws ServiceException {
		try {
			return dao.read(id);
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void save(UsersGroup type) throws ServiceException {
		try {
			if(type.getId() != null) {
				dao.update(type);
			} else {
				Integer id = dao.create(type);
				type.setId(id);
			}
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
}
