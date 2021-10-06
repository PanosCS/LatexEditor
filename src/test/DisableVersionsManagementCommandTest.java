package test;

import static org.junit.jupiter.api.Assertions.*;

import controller.commands.CreateCommand;
import controller.commands.DisableVersionsManagementCommand;
import controller.commands.EditCommand;
import org.junit.jupiter.api.Test;

import model.DocumentManager;
import model.VersionsManager;
import model.strategies.StableVersionsStrategy;
import model.strategies.VersionsStrategy;
import model.strategies.VolatileVersionsStrategy;
import view.LatexEditorView;

class DisableVersionsManagementCommandTest {
	private final LatexEditorView latexEditorView = new LatexEditorView();
	private final DocumentManager documentManager = new DocumentManager();
	private final VersionsManager versionsManager = new VersionsManager(null, latexEditorView);
	private final CreateCommand createCommand = new CreateCommand(documentManager, versionsManager);
	private final EditCommand editCommand = new EditCommand(versionsManager);
	private final DisableVersionsManagementCommand disableCommand = new DisableVersionsManagementCommand(versionsManager);

	@Test
	void testVolatile() {
		VersionsStrategy strategy = new VolatileVersionsStrategy();
		versionsManager.setStrategy(strategy);
		
		latexEditorView.setType("articleTemplate");
		latexEditorView.setVersionsManager(versionsManager);
		createCommand.execute();
		latexEditorView.setStrategy("volatile");
		disableCommand.execute();
		latexEditorView.setText("test edit contents\n");
		editCommand.execute();
		
		assertEquals(versionsManager.isEnabled(), false);
		assertEquals(strategy.getEntireHistory().size(), 0);
	}
}
