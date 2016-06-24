package by.vsu.mf.ammc.pm.domain.user;

import by.vsu.mf.ammc.pm.domain.NamedEntity;

public class Contact extends NamedEntity {
	private User user;
	private ContactsType type;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ContactsType getType() {
		return type;
	}

	public void setType(ContactsType type) {
		this.type = type;
	}
}