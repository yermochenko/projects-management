package by.vsu.mf.ammc.pm.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class HierarchyEntity<T extends HierarchyEntity<?>> extends NamedEntity {
	private T parent;
	private List<T> children = new ArrayList<>();

	public T getParent() {
		return parent;
	}

	public void setParent(T parent) {
		this.parent = parent;
	}

	public List<T> getChildren() {
		return children;
	}
}
