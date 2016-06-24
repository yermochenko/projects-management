package by.vsu.mf.ammc.pm.domain.user;

import java.util.ArrayList;
import java.util.List;

import by.vsu.mf.ammc.pm.domain.NamedEntity;

public class User extends NamedEntity {
	private String password;
	private String firstName;
	private String middleName;
	private String lastName;
	private boolean admin;
	private UsersGroup group;
	private List<Contact> contacts = new ArrayList<>();

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public UsersGroup getGroup() {
		return group;
	}

	public void setGroup(UsersGroup group) {
		this.group = group;
	}

	public List<Contact> getContacts() {
		return contacts;
	}
}