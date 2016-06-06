package by.vsu.mf.ammc.pm.service.main.user;

import java.util.List;

import by.vsu.mf.ammc.pm.dao.user.ContactsTypeDao;
import by.vsu.mf.ammc.pm.domain.user.ContactsType;
import by.vsu.mf.ammc.pm.exception.DaoException;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.user.ContactsTypeService;

public class ContactsTypeServiceImpl implements ContactsTypeService {
	private ContactsTypeDao dao;

	public void setDao(ContactsTypeDao dao) {
		this.dao = dao;
	}

	@Override
	public List<ContactsType> findAll() throws ServiceException {
		try {
			return dao.read();
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public ContactsType findById(Integer id) throws ServiceException {
		try {
			return dao.read(id);
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void save(ContactsType type) throws ServiceException {
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
