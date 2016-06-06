package by.vsu.mf.ammc.pm.dao.user;

import java.util.List;

import by.vsu.mf.ammc.pm.dao.Dao;
import by.vsu.mf.ammc.pm.domain.user.ContactsType;
import by.vsu.mf.ammc.pm.exception.DaoException;

public interface ContactsTypeDao extends Dao<Integer, ContactsType> {
	List<ContactsType> read() throws DaoException;
}
