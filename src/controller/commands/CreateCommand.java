package controller.commands;

import model.Document;
import model.DocumentManager;
import model.VersionsManager;

public class CreateCommand implements Command {
	private final DocumentManager documentManager;
	private final VersionsManager versionsManager;
	
	public CreateCommand(DocumentManager documentManager, VersionsManager versionsManager) {
		super();
		this.documentManager = documentManager;
		this.versionsManager = versionsManager;
	}

	@Override
	public void execute() {
		String type = versionsManager.getType();
		Document document = documentManager.createDocument(type);
		versionsManager.setCurrentVersion(document);
	}

}
