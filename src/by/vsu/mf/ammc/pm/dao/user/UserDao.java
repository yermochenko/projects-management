package by.vsu.mf.ammc.pm.dao.user;

import by.vsu.mf.ammc.pm.dao.Dao;
import by.vsu.mf.ammc.pm.domain.user.User;
import by.vsu.mf.ammc.pm.exception.DaoException;

import java.util.List;

public interface UserDao extends Dao<Integer, User> {
    List<User> read() throws DaoException;
}
