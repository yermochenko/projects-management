package by.vsu.mf.ammc.pm.dao.user;

import by.vsu.mf.ammc.pm.dao.Dao;
import by.vsu.mf.ammc.pm.domain.user.UsersGroup;
import by.vsu.mf.ammc.pm.exception.DaoException;

import java.util.List;

public interface UsersGroupDao extends Dao<Integer, UsersGroup> {
	List<UsersGroup> read() throws DaoException;
}
