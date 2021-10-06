package test;

import static org.junit.jupiter.api.Assertions.*;

import controller.commands.CreateCommand;
import controller.commands.EditCommand;
import org.junit.jupiter.api.Test;

import model.DocumentManager;
import model.VersionsManager;
import view.LatexEditorView;

class EditCommandTest {
	private final LatexEditorView latexEditorView = new LatexEditorView();
	private final DocumentManager documentManager = new DocumentManager();
	private final VersionsManager versionsManager = new VersionsManager(null, latexEditorView);
	private final CreateCommand createCommand = new CreateCommand(documentManager, versionsManager);
	private final EditCommand editCommand = new EditCommand(versionsManager);

	@Test
	void test() {
		latexEditorView.setType("articleTemplate");
		createCommand.execute();
		
		latexEditorView.setText("test edit contents\n");
		editCommand.execute();
		String actualContents = latexEditorView.getCurrentDocument().getContents();
		
		assertEquals("test edit contents\n", actualContents);
	}

}
