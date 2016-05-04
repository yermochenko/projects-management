package by.vsu.mf.ammc.pm.domain.user;

import by.vsu.mf.ammc.pm.domain.NamedEntity;

public class ContactsType extends NamedEntity {
	private String regexp;

	public String getRegexp() {
		return regexp;
	}

	public void setRegexp(String regexp) {
		this.regexp = regexp;
	}
}
