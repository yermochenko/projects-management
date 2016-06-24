package by.vsu.mf.ammc.pm.domain.project.management;

public enum EmployeesRole {
	/**
	 * Persistent role
	 */
	BUSINESS_ANALYST,
	/**
	 * Persistent role
	 */
	PROGRAMMER,
	/**
	 * Calculated role
	 */
	TEAM_LEADER,
	/**
	 * Calculated role
	 */
	PROJECT_MANAGER;

	public static EmployeesRole getByIdentity(Integer identity) {
		return EmployeesRole.values()[identity];
	}
}