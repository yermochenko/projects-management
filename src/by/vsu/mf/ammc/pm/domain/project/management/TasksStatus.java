package by.vsu.mf.ammc.pm.domain.project.management;

public enum TasksStatus {
	NEW(true),
	ACCEPTED(true),
	STARTED(true),
	RENEW(true),
	DONE(false),
	APPROVED(false);

	private boolean open;

	private TasksStatus(boolean open) {
		this.open = open;
	}

	public boolean isOpen() {
		return open;
	}
}
