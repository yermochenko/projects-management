package by.vsu.mf.ammc.pm.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import by.vsu.mf.ammc.pm.dao.mysql.project.managment.TeamDaoImpl;
import by.vsu.mf.ammc.pm.dao.mysql.user.ContactsTypeDaoImpl;
import by.vsu.mf.ammc.pm.dao.mysql.user.UserDaoImpl;
import by.vsu.mf.ammc.pm.datasource.Connector;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.main.user.ContactsTypeServiceImpl;
import by.vsu.mf.ammc.pm.service.main.user.TeamServiceImpl;
import by.vsu.mf.ammc.pm.service.main.user.UserServiceImpl;
import by.vsu.mf.ammc.pm.service.user.ContactsTypeService;
import by.vsu.mf.ammc.pm.service.user.TeamService;
import by.vsu.mf.ammc.pm.service.user.UserService;

public class ServiceLocator {
	private Map<Class<?>, Object> services = new ConcurrentHashMap<>();

	private Connection connection;

	public ServiceLocator() throws ServiceException {
		try {
			connection = Connector.connect();

			/* создание объектов слоя Data Access Objects */
			ContactsTypeDaoImpl contactsTypeDao = new ContactsTypeDaoImpl();
			contactsTypeDao.setConnection(connection);

			UserDaoImpl userDao = new UserDaoImpl();
			userDao.setConnection(connection);

			TeamDaoImpl teamDao = new TeamDaoImpl();
			teamDao.setConnection(connection);

			/* создание объектов слоя сервисов */
			ContactsTypeServiceImpl contactsTypeService = new ContactsTypeServiceImpl();
			contactsTypeService.setDao(contactsTypeDao);

			UserServiceImpl userService = new UserServiceImpl();
			userService.setDao(userDao);

			TeamServiceImpl teamService = new TeamServiceImpl();
			teamService.setTeamDao(teamDao);
			teamService.setUserDao(userDao);

			/* регистрация сервисов */
			services.put(ContactsTypeService.class, contactsTypeService);
			services.put(UserService.class, userService);
			services.put(TeamService.class, teamService);
		} catch(SQLException e) {
			throw new ServiceException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T getService(Class<T> serviceClass) {
		return (T)services.get(serviceClass);
	}

	public void close() throws ServiceException {
		try {
			connection.close();
		} catch(SQLException e) {
			throw new ServiceException(e);
		}
	}
}
