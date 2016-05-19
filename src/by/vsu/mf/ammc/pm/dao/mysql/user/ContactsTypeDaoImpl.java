package by.vsu.mf.ammc.pm.dao.mysql.user;

import by.vsu.mf.ammc.pm.dao.mysql.BaseDao;
import by.vsu.mf.ammc.pm.dao.user.ContactsTypeDao;
import by.vsu.mf.ammc.pm.domain.user.ContactsType;
import by.vsu.mf.ammc.pm.exception.DaoException;

/**
 * Created by Борис on 19.05.2016.
 */
public class ContactsTypeDaoImpl extends BaseDao implements ContactsTypeDao {
    @Override
    public Integer create(ContactsType contactsType) throws DaoException {
        return null;
    }

    @Override
    public ContactsType read(Integer id) throws DaoException {
        return null;
    }

    @Override
    public void update(ContactsType contactsType) throws DaoException {

    }

    @Override
    public void delete(Integer ic) throws DaoException {

    }
}
