package test;

import static org.junit.jupiter.api.Assertions.*;

import controller.commands.CreateCommand;
import controller.commands.EditCommand;
import controller.commands.EnableVersionsManagementCommand;
import controller.commands.RollbackToPreviousVersionCommand;
import org.junit.jupiter.api.Test;

import model.DocumentManager;
import model.VersionsManager;
import model.strategies.StableVersionsStrategy;
import model.strategies.VersionsStrategy;
import model.strategies.VolatileVersionsStrategy;
import view.LatexEditorView;

class RollbackToPreviousVersionCommandTest {
	private final LatexEditorView latexEditorView = new LatexEditorView();
	private final DocumentManager documentManager = new DocumentManager();
	private final VersionsManager versionsManager = new VersionsManager(null, latexEditorView);
	private final CreateCommand createCommand = new CreateCommand(documentManager, versionsManager);
	private final EditCommand editCommand = new EditCommand(versionsManager);
	private final EnableVersionsManagementCommand enableCommand = new EnableVersionsManagementCommand(versionsManager);
	private final RollbackToPreviousVersionCommand rollback = new RollbackToPreviousVersionCommand(versionsManager);
	
	
	@Test
	void testStable() {
		VersionsStrategy strategy = new StableVersionsStrategy();
		versionsManager.setStrategy(strategy);
		
		latexEditorView.setType("articleTemplate");
		latexEditorView.setVersionsManager(versionsManager);
		createCommand.execute();
		String actualContents = latexEditorView.getCurrentDocument().getContents();
		latexEditorView.setStrategy("stable");
		enableCommand.execute();
		latexEditorView.setText("test edit contents\n");
		editCommand.execute();
		rollback.execute();
		String contents = latexEditorView.getCurrentDocument().getContents();
		
		assertEquals(contents, actualContents);
	}
}
