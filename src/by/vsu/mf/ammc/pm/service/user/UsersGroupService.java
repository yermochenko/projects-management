package by.vsu.mf.ammc.pm.service.user;

import java.util.List;

import by.vsu.mf.ammc.pm.domain.user.UsersGroup;
import by.vsu.mf.ammc.pm.exception.ServiceException;

public interface UsersGroupService {
	List<UsersGroup> findAll() throws ServiceException;

	UsersGroup findById(Integer id) throws ServiceException;

	void save(UsersGroup type) throws ServiceException;

	void delete(Integer id) throws ServiceException;
}