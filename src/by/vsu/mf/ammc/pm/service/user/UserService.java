package by.vsu.mf.ammc.pm.service.user;

import java.util.List;

import by.vsu.mf.ammc.pm.domain.user.User;
import by.vsu.mf.ammc.pm.domain.user.UsersGroup;
import by.vsu.mf.ammc.pm.exception.ServiceException;

public interface UserService {
	List<User> findAll() throws ServiceException;

	List<User> findByGroup(UsersGroup group) throws ServiceException;

	User findById(Integer id) throws ServiceException;

	void save(User type) throws ServiceException;

	void delete(Integer id) throws ServiceException;
}