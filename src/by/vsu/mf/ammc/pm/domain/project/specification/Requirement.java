package by.vsu.mf.ammc.pm.domain.project.specification;

import by.vsu.mf.ammc.pm.domain.NamedEntity;
import by.vsu.mf.ammc.pm.domain.project.Module;

public class Requirement extends NamedEntity {
	private String description;
	private Float importance;
	private Float changeProbability;
	private UseCase useCase;
	private Module module;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getImportance() {
		return importance;
	}

	public void setImportance(Float importance) {
		this.importance = importance;
	}

	public Float getChangeProbability() {
		return changeProbability;
	}

	public void setChangeProbability(Float changeProbability) {
		this.changeProbability = changeProbability;
	}

	public UseCase getUseCase() {
		return useCase;
	}

	public void setUseCase(UseCase useCase) {
		this.useCase = useCase;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
}
