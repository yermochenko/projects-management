package by.vsu.mf.ammc.pm.service.main.user;

import java.util.List;

import by.vsu.mf.ammc.pm.dao.user.UserDao;
import by.vsu.mf.ammc.pm.dao.user.UsersGroupDao;
import by.vsu.mf.ammc.pm.domain.user.User;
import by.vsu.mf.ammc.pm.domain.user.UsersGroup;
import by.vsu.mf.ammc.pm.exception.DaoException;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.user.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	private UsersGroupDao usersGroupDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setUsersGroupDao(UsersGroupDao usersGroupDao) {
		this.usersGroupDao = usersGroupDao;
	}

	@Override
	public List<User> findAll() throws ServiceException {
		try {
			return userDao.read();
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<User> findByGroup(UsersGroup group) throws ServiceException {
		try {
			List<User> users = userDao.readByGroup(group.getId());
			for(User user : users) {
				user.setGroup(group);
			}
			return users;
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public User findById(Integer id) throws ServiceException {
		try {
			User user = userDao.read(id);
			UsersGroup group = usersGroupDao.read(user.getGroup().getId());
			user.setGroup(group);
			return user;
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void save(User user) throws ServiceException {
		try {
			if(user.getId() != null) {
				if(user.getPassword() == null) {
					User old = userDao.read(user.getId());
					if(old != null) {
						user.setPassword(old.getPassword());
					}
				}
				if(user.getPassword() != null) {
					userDao.update(user);
				}
			} else {
				user.setPassword("12345");
				Integer id = userDao.create(user);
				user.setId(id);
			}
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void delete(Integer id) throws ServiceException {
		try {
			userDao.delete(id);
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}
}