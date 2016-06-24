package by.vsu.mf.ammc.pm.service.main.user;

import java.util.List;

import by.vsu.mf.ammc.pm.dao.user.ContactsTypeDao;
import by.vsu.mf.ammc.pm.domain.user.ContactsType;
import by.vsu.mf.ammc.pm.exception.DaoException;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.user.ContactsTypeService;

public class ContactsTypeServiceImpl implements ContactsTypeService {
	private ContactsTypeDao contactsTypeDao;

	public void setContactsTypeDao(ContactsTypeDao contactsTypeDao) {
		this.contactsTypeDao = contactsTypeDao;
	}

	@Override
	public List<ContactsType> findAll() throws ServiceException {
		try {
			return contactsTypeDao.read();
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public ContactsType findById(Integer id) throws ServiceException {
		try {
			return contactsTypeDao.read(id);
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void save(ContactsType type) throws ServiceException {
		try {
			if(type.getId() != null) {
				contactsTypeDao.update(type);
			} else {
				Integer id = contactsTypeDao.create(type);
				type.setId(id);
			}
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void delete(Integer id) throws ServiceException {
		try {
			contactsTypeDao.delete(id);
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}
}