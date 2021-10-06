package controller.commands;

import model.VersionsManager;

public class AddLatexCommand implements Command  {
	private final VersionsManager versionsManager;
	
	
	public AddLatexCommand(VersionsManager versionsManager) {
		super();
		this.versionsManager = versionsManager;
	}


	@Override
	public void execute() {
		versionsManager.saveContents();
	}

}
