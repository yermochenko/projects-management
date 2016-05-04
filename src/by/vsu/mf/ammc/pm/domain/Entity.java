package by.vsu.mf.ammc.pm.domain;

import java.io.Serializable;

public abstract class Entity implements Serializable {
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return (id == null) ? 0 : id.hashCode();
	}

	@Override
	public boolean equals(Object entity) {
		if(entity != this) {
			if(id != null && entity != null && entity.getClass() == getClass()) {
				return id.equals(((Entity)entity).id);
			}
			return false;
		}
		return true;
	}
}
