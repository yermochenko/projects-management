package by.vsu.mf.ammc.pm.domain.project.specification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.vsu.mf.ammc.pm.domain.NamedEntity;
import by.vsu.mf.ammc.pm.domain.project.Module;

public class UseCase extends NamedEntity {
	private Module module;
	private Map<UseCasesRelationsType, List<UseCase>> relations = new HashMap<UseCasesRelationsType, List<UseCase>>();
	{
		for(UseCasesRelationsType type : UseCasesRelationsType.values()) {
			relations.put(type, new ArrayList<UseCase>());
		}
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public List<UseCase> getRelations(UseCasesRelationsType type) {
		return relations.get(type);
	}
}
