package by.vsu.mf.ammc.pm.domain.project.management;

import by.vsu.mf.ammc.pm.domain.Entity;
import by.vsu.mf.ammc.pm.domain.user.User;

public class Employee extends Entity {
	private User user;
	private Team team;
	private EmployeesRole role;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public EmployeesRole getRole() {
		return role;
	}

	public void setRole(EmployeesRole role) {
		this.role = role;
	}
}