package by.vsu.mf.ammc.pm.service.main.user;

import java.util.List;

import by.vsu.mf.ammc.pm.dao.project.management.TeamDao;
import by.vsu.mf.ammc.pm.dao.user.UserDao;
import by.vsu.mf.ammc.pm.domain.project.management.Team;
import by.vsu.mf.ammc.pm.domain.user.User;
import by.vsu.mf.ammc.pm.exception.DaoException;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.user.TeamService;

public class TeamServiceImpl implements TeamService {
	private TeamDao teamDao;
	private UserDao userDao;

	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<Team> findAll(Integer projectId) throws ServiceException {
		try {
			List<Team> teams = teamDao.readByProject(projectId);
			for(Team team : teams) {
				Integer id = team.getLeader().getId();
				User leader = userDao.read(id);
				team.setLeader(leader);
			}
			return teams;
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Team findById(Integer id) throws ServiceException {
		try {
			return teamDao.read(id);
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void save(Team type) throws ServiceException {
		try {
			if(type.getId() != null) {
				teamDao.update(type);
			} else {
				Integer id = teamDao.create(type);
				type.setId(id);
			}
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void delete(Integer id) throws ServiceException {
		try {
			teamDao.delete(id);
		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}
}