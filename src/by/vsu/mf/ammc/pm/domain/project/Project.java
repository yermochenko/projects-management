package by.vsu.mf.ammc.pm.domain.project;

import by.vsu.mf.ammc.pm.domain.NamedEntity;
import by.vsu.mf.ammc.pm.domain.user.User;

public class Project extends NamedEntity {
	private String description;
	private ProjectsCategory category;
	private User manager;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProjectsCategory getCategory() {
		return category;
	}

	public void setCategory(ProjectsCategory category) {
		this.category = category;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}
}
