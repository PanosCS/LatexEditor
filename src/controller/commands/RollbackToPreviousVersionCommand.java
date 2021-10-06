package controller.commands;

import model.VersionsManager;

public class RollbackToPreviousVersionCommand implements Command {
	private final VersionsManager versionsManager;
	
	
	public RollbackToPreviousVersionCommand(VersionsManager versionsManager) {
		this.versionsManager = versionsManager;
	}


	@Override
	public void execute() {
		versionsManager.rollback();
	}

}
