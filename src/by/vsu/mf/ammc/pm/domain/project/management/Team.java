package by.vsu.mf.ammc.pm.domain.project.management;

import java.util.ArrayList;
import java.util.List;

import by.vsu.mf.ammc.pm.domain.Entity;
import by.vsu.mf.ammc.pm.domain.project.Project;
import by.vsu.mf.ammc.pm.domain.user.User;

public class Team extends Entity {
	private Project project;
	private User leader;
	private List<Employee> employees = new ArrayList<>();

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getLeader() {
		return leader;
	}

	public void setLeader(User leader) {
		this.leader = leader;
	}

	public List<Employee> getEmployees() {
		return employees;
	}
}