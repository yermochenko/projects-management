package by.vsu.mf.ammc.pm.service.user;

import by.vsu.mf.ammc.pm.domain.user.User;
import by.vsu.mf.ammc.pm.exception.ServiceException;

import java.util.List;

public interface UserService {
    List<User> findAll() throws ServiceException;

    User findById(Integer id) throws ServiceException;

    void save(User type) throws ServiceException;

    void delete(Integer id) throws ServiceException;
}