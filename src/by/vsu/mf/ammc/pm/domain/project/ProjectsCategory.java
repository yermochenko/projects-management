package by.vsu.mf.ammc.pm.domain.project;

import java.util.ArrayList;
import java.util.List;

import by.vsu.mf.ammc.pm.domain.HierarchyEntity;

public class ProjectsCategory extends HierarchyEntity<ProjectsCategory> {
	private List<Project> projects = new ArrayList<>();

	public List<Project> getProjects() {
		return projects;
	}
}