package by.vsu.mf.ammc.pm.domain.project.management;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.vsu.mf.ammc.pm.domain.NamedEntity;
import by.vsu.mf.ammc.pm.domain.project.Module;
import by.vsu.mf.ammc.pm.domain.project.specification.Requirement;

public class Task extends NamedEntity {
	private String description;
	private Integer planTime;
	private Float difficulty;
	private Date openDate;
	private Date acceptDate;
	private Date closeDate;
	private TasksCategory category;
	private Requirement requirement;
	private Module module;
	private Employee employee;
	private TasksStatus status;
	private List<Task> lockingTasks = new ArrayList<>();

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPlanTime() {
		return planTime;
	}

	public void setPlanTime(Integer planTime) {
		this.planTime = planTime;
	}

	public Float getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Float difficulty) {
		this.difficulty = difficulty;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getAcceptDate() {
		return acceptDate;
	}

	public void setAcceptDate(Date acceptDate) {
		this.acceptDate = acceptDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public TasksCategory getCategory() {
		return category;
	}

	public void setCategory(TasksCategory category) {
		this.category = category;
	}

	public Requirement getRequirement() {
		return requirement;
	}

	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public TasksStatus getStatus() {
		return status;
	}

	public void setStatus(TasksStatus status) {
		this.status = status;
	}

	public List<Task> getLockingTasks() {
		return lockingTasks;
	}
}
