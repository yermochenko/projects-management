package by.vsu.mf.ammc.pm.domain;

public abstract class NamedEntity extends Entity {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}