package controller.commands;

import model.VersionsManager;

public class DisableVersionsManagementCommand implements Command {

	private final VersionsManager versionsManager;
	
	public DisableVersionsManagementCommand(VersionsManager versionsManager) {
		super();
		this.versionsManager = versionsManager;
	}

	@Override
	public void execute() {
		versionsManager.disable();
	}

}
