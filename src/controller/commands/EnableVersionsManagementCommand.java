package controller.commands;

import model.VersionsManager;

public class EnableVersionsManagementCommand implements Command {
	private final VersionsManager versionsManager;
	
	public EnableVersionsManagementCommand(VersionsManager versionsManager) {
		super();
		this.versionsManager = versionsManager;
	}


	@Override
	public void execute() {
		versionsManager.enableStrategy();
	}

}
