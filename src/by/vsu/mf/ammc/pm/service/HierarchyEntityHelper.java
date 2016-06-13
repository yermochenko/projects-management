package by.vsu.mf.ammc.pm.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import by.vsu.mf.ammc.pm.domain.HierarchyEntity;

public class HierarchyEntityHelper {
	public static <E extends HierarchyEntity<E>> void process(List<E> entities) {
		Map<Integer, E> entitiesIdentityMap = new HashMap<>();
		for(E entity : entities) {
			entitiesIdentityMap.put(entity.getId(), entity);
		}
		for(E entity : entities) {
			E parent = entity.getParent();
			if(parent != null) {
				parent = entitiesIdentityMap.get(parent.getId());
				entity.setParent(parent);
				parent.getChildren().add(entity);
			}
		}
		Iterator<E> iterator = entities.iterator();
		while(iterator.hasNext()) {
			E entity = iterator.next();
			if(entity.getParent() != null) {
				iterator.remove();
			}
		}
	}
}
