package controller.commands;

import model.VersionsManager;

public class ChangeVersionsStrategyCommand implements Command {
	private final VersionsManager versionsManager;
	
	public ChangeVersionsStrategyCommand(VersionsManager versionsManager) {
		super();
		this.versionsManager = versionsManager;
	}

	@Override
	public void execute() {

		versionsManager.changeStrategy();
	}

}
