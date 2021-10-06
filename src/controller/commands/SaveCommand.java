package controller.commands;

import model.VersionsManager;

public class SaveCommand implements Command {
	private final VersionsManager versionsManager;
	
	public SaveCommand(VersionsManager versionsManager) {
		this.versionsManager = versionsManager;
	}
	@Override
	public void execute() {
		versionsManager.saveToFile();
	}

}
