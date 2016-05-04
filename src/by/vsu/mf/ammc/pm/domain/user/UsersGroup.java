package by.vsu.mf.ammc.pm.domain.user;

import java.util.ArrayList;
import java.util.List;

import by.vsu.mf.ammc.pm.domain.HierarchyEntity;

public class UsersGroup extends HierarchyEntity<UsersGroup> {
	private List<User> users = new ArrayList<>();

	public List<User> getUsers() {
		return users;
	}
}
