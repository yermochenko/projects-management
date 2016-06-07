package by.vsu.mf.ammc.pm.domain.project;

import by.vsu.mf.ammc.pm.domain.HierarchyEntity;

public class Module extends HierarchyEntity<Module> {
	private Project project;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
