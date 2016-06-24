package by.vsu.mf.ammc.pm.service.main.user;

import java.util.List;

import by.vsu.mf.ammc.pm.dao.user.UsersGroupDao;
import by.vsu.mf.ammc.pm.domain.user.UsersGroup;
import by.vsu.mf.ammc.pm.exception.DaoException;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.HierarchyEntityHelper;
import by.vsu.mf.ammc.pm.service.user.UsersGroupService;

public class UsersGroupServiceImpl implements UsersGroupService {
	private UsersGroupDao usersGroupDao;

	public void setUsersGroupDao(UsersGroupDao usersGroupDao) {
		this.usersGroupDao = usersGroupDao;
	}

	@Override
	public List<UsersGroup> findAll() throws ServiceException {
		try {
			List<UsersGroup> groups = usersGroupDao.read();
			HierarchyEntityHelper.process(groups);
			return groups;
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public UsersGroup findById(Integer id) throws ServiceException {
		try {
			return usersGroupDao.read(id);
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void save(UsersGroup type) throws ServiceException {
		try {
			if(type.getId() != null) {
				usersGroupDao.update(type);
			} else {
				Integer id = usersGroupDao.create(type);
				type.setId(id);
			}
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void delete(Integer id) throws ServiceException {
		try {
			usersGroupDao.delete(id);
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}
}