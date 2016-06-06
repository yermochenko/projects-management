package by.vsu.mf.ammc.pm.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import by.vsu.mf.ammc.pm.dao.mysql.user.ContactsTypeDaoImpl;
import by.vsu.mf.ammc.pm.datasource.Connector;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.main.user.ContactsTypeServiceImpl;
import by.vsu.mf.ammc.pm.service.user.ContactsTypeService;

public class ServiceLocator {
	private Map<Class<?>, Object> services = new ConcurrentHashMap<>();

	private Connection connection;

	public ServiceLocator() throws ServiceException {
		try {
			connection = Connector.connect();

			/* создание объектов слоя Data Access Objects */
			ContactsTypeDaoImpl contactsTypeDao = new ContactsTypeDaoImpl();
			contactsTypeDao.setConnection(connection);

			/* создание объектов слоя сервисов */
			ContactsTypeServiceImpl contactsTypeService = new ContactsTypeServiceImpl();
			contactsTypeService.setDao(contactsTypeDao);

			/* регистрация сервисов */
			services.put(ContactsTypeService.class, contactsTypeService);
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
