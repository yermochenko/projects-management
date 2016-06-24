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
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.main.project.ProjectServiceImpl;
import by.vsu.mf.ammc.pm.service.main.project.ProjectsCategoryServiceImpl;
import by.vsu.mf.ammc.pm.service.main.user.ContactsTypeServiceImpl;
import by.vsu.mf.ammc.pm.service.main.user.TasksCategoryServiceImpl;
import by.vsu.mf.ammc.pm.service.main.user.TeamServiceImpl;
import by.vsu.mf.ammc.pm.service.main.user.UserServiceImpl;
import by.vsu.mf.ammc.pm.service.main.user.UsersGroupServiceImpl;
import by.vsu.mf.ammc.pm.service.project.ProjectService;
import by.vsu.mf.ammc.pm.service.project.ProjectsCategoryService;
import by.vsu.mf.ammc.pm.service.user.ContactsTypeService;
import by.vsu.mf.ammc.pm.service.user.TasksCategoryService;
import by.vsu.mf.ammc.pm.service.user.TeamService;
import by.vsu.mf.ammc.pm.service.user.UserService;
import by.vsu.mf.ammc.pm.service.user.UsersGroupService;

public class ServiceLocator {
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
			contactsTypeService.setContactsTypeDao(contactsTypeDao);

			TeamServiceImpl teamService = new TeamServiceImpl();
			teamService.setTeamDao(teamDao);
			teamService.setUserDao(userDao);

			ProjectServiceImpl projectService = new ProjectServiceImpl();
			projectService.setProjectDao(projectDao);
			projectService.setUserDao(userDao);
			projectService.setProjectsCategoryDao(projectsCategoryDao);

			UserServiceImpl userService = new UserServiceImpl();
			userService.setUserDao(userDao);
			userService.setUsersGroupDao(usersGroupDao);

			UsersGroupServiceImpl usersGroupService = new UsersGroupServiceImpl();
			usersGroupService.setUsersGroupDao(usersGroupDao);

			TasksCategoryServiceImpl tasksCategoryService = new TasksCategoryServiceImpl();
			tasksCategoryService.setTasksCategoryDao(tasksCategoryDao);

			ProjectsCategoryServiceImpl projectsCategoryService = new ProjectsCategoryServiceImpl();
			projectsCategoryService.setProjectsCategoryDao(projectsCategoryDao);

			/* регистрация сервисов */
			services.put(ContactsTypeService.class, contactsTypeService);
			services.put(TeamService.class, teamService);
			services.put(ProjectService.class, projectService);
			services.put(UserService.class, userService);
			services.put(UsersGroupService.class, usersGroupService);
			services.put(TasksCategoryService.class, tasksCategoryService);
			services.put(ProjectsCategoryService.class, projectsCategoryService);
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