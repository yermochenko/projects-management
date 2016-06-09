package by.vsu.mf.ammc.pm.service.user;

import by.vsu.mf.ammc.pm.domain.user.UsersGroup;
import by.vsu.mf.ammc.pm.exception.ServiceException;

import java.util.List;

public interface UsersGroupService {




    List<UsersGroup> findAll() throws ServiceException;

    UsersGroup findById(Integer id) throws ServiceException;

    void save(UsersGroup type) throws ServiceException;

    void delete(Integer id) throws ServiceException;
}
