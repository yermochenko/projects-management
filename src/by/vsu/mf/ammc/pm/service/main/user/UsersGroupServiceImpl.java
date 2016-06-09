package by.vsu.mf.ammc.pm.service.main.user;

import by.vsu.mf.ammc.pm.dao.user.UsersGroupDao;
import by.vsu.mf.ammc.pm.domain.user.UsersGroup;
import by.vsu.mf.ammc.pm.exception.DaoException;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.user.UsersGroupService;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UsersGroupServiceImpl implements UsersGroupService {
    private UsersGroupDao dao;

    public void setDao(UsersGroupDao dao) {
        this.dao = dao;
    }

    @Override
    public List<UsersGroup> findAll() throws ServiceException {
        try {
            List<UsersGroup> groups = dao.read();
            Map<Integer, UsersGroup> usersGroupMap = new HashMap<>();
            for(UsersGroup group : groups) {
                usersGroupMap.put(group.getId(), group);
            }
            for(UsersGroup group : groups) {
                UsersGroup parent = group.getParent();
                if(parent != null) {
                    parent = usersGroupMap.get(parent.getId());
                    group.setParent(parent);
                    parent.getChildren().add(group);
                }
            }
            Iterator<UsersGroup> iterator = groups.iterator();
            while(iterator.hasNext()) {
                UsersGroup group = iterator.next();
                if(group.getParent() != null) {
                    iterator.remove();
                }
            }
            return groups;
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public UsersGroup findById(Integer id) throws ServiceException {
        try {
            return dao.read(id);
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
    }



    @Override
    public void save(UsersGroup type) throws ServiceException {
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
