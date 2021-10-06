package controller.commands;

import model.VersionsManager;

public class EditCommand implements Command {
	private final VersionsManager versionsManager;
	
	
	public EditCommand(VersionsManager versionsManager) {
		super();
		this.versionsManager = versionsManager;
	}


	@Override
	public void execute() {
		versionsManager.saveContents();
	}

}
