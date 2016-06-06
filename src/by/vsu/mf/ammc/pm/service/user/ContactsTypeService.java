package by.vsu.mf.ammc.pm.service.user;

import java.util.List;

import by.vsu.mf.ammc.pm.domain.user.ContactsType;
import by.vsu.mf.ammc.pm.exception.ServiceException;

public interface ContactsTypeService {
	List<ContactsType> findAll() throws ServiceException;

	ContactsType findById(Integer id) throws ServiceException;

	void save(ContactsType type) throws ServiceException;

	void delete(Integer id) throws ServiceException;
}
