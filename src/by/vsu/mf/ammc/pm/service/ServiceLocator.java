package by.vsu.mf.ammc.pm.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import by.vsu.mf.ammc.pm.dao.mysql.project.ProjectDaoImpl;
import by.vsu.mf.ammc.pm.dao.mysql.project.ProjectsCategoryDaoImpl;
import by.vsu.mf.ammc.pm.dao.mysql.project.managment.TasksCategoryDaoImpl;
import by.vsu.mf.ammc.pm.dao.mysql.project.managment.TeamDaoImpl;
import by.vsu.mf.ammc.pm.dao.mysql.user.ContactsTypeDaoImpl;
import by.vsu.mf.ammc.pm.dao.mysql.user.UserDaoImpl;
import by.vsu.mf.ammc.pm.dao.mysql.user.UsersGroupDaoImpl;
import by.vsu.mf.ammc.pm.datasource.Connector;
import by.vsu.mf.ammc.pm.domain.project.ProjectsCategory;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.main.user.*;
import by.vsu.mf.ammc.pm.service.user.*;

public class
ServiceLocator {
	private Map<Class<?>, Object> services = new ConcurrentHashMap<>();

	private Connection connection;

	public ServiceLocator() throws ServiceException {
		try {
			connection = Connector.connect();

			/* создание объектов слоя Data Access Objects */
			ContactsTypeDaoImpl contactsTypeDao = new ContactsTypeDaoImpl();
			contactsTypeDao.setConnection(connection);

			TeamDaoImpl teamDao = new TeamDaoImpl();
			teamDao.setConnection(connection);

			UserDaoImpl userDao = new UserDaoImpl();
			userDao.setConnection(connection);

			ProjectDaoImpl projectDao = new ProjectDaoImpl();
			projectDao.setConnection(connection);

			UsersGroupDaoImpl usersGroupDao = new UsersGroupDaoImpl();
			usersGroupDao.setConnection(connection);

			TasksCategoryDaoImpl tasksCategoryDao = new TasksCategoryDaoImpl();
			tasksCategoryDao.setConnection(connection);

			ProjectsCategoryDaoImpl projectsCategoryDao = new ProjectsCategoryDaoImpl();
			projectsCategoryDao.setConnection(connection);

			/* создание объектов слоя сервисов */
			ContactsTypeServiceImpl contactsTypeService = new ContactsTypeServiceImpl();
			contactsTypeService.setDao(contactsTypeDao);

			TeamServiceImpl teamService = new TeamServiceImpl();
			teamService.setTeamDao(teamDao);
			teamService.setUserDao(userDao);

			ProjectServiceImpl projectService = new ProjectServiceImpl();
			projectService.setDao(projectDao);
			projectService.setUserDao(userDao);

			UserServiceImpl userService = new UserServiceImpl();
			userService.setDao(userDao);

			UsersGroupServiceImpl usersGroupService = new UsersGroupServiceImpl();
			usersGroupService.setDao(usersGroupDao);

			TasksCategoryServiceImpl tasksCategoryService = new TasksCategoryServiceImpl();
			tasksCategoryService.setDao(tasksCategoryDao);

			ProjectCategoryServiceImpl projectsCategoryService = new ProjectCategoryServiceImpl();
			projectsCategoryService.setDao(projectsCategoryDao);

			/* регистрация сервисов */
			services.put(ContactsTypeService.class, contactsTypeService);
			services.put(TeamService.class, teamService);
			services.put(ProjectService.class, projectService);
			services.put(UserService.class, userService);
			services.put(UsersGroupService.class, usersGroupService);
			services.put(TasksCategoryService.class, tasksCategoryService);
			services.put(ProjectsCategoryService.class, projectsCategoryService)
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
