package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import controller.commands.CreateCommand;
import controller.commands.LoadCommand;
import org.junit.jupiter.api.Test;

import model.DocumentManager;
import model.VersionsManager;
import view.LatexEditorView;

class LoadCommandTest {
	private final LatexEditorView latexEditorView = new LatexEditorView();
	private final DocumentManager documentManager = new DocumentManager();
	private final VersionsManager versionsManager = new VersionsManager(null, latexEditorView);
	private final CreateCommand createCommand = new CreateCommand(documentManager, versionsManager);
	private final LoadCommand loadCommand = new LoadCommand(versionsManager);

	@Test
	void test() {
		latexEditorView.setType("articleTemplate");
		createCommand.execute();
		latexEditorView.setFilename("test.tex");
		loadCommand.execute();
		
		String fileContents = "";
		try {
			Scanner scanner = new Scanner(new FileInputStream("test.tex"));
			while(scanner.hasNextLine()) {
				fileContents = fileContents + scanner.nextLine() + "\n";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String actualContents = latexEditorView.getCurrentDocument().getContents();
		
		assertEquals(fileContents, actualContents);
	}

}
