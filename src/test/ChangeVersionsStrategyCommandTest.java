package test;

import static org.junit.jupiter.api.Assertions.*;

import controller.commands.ChangeVersionsStrategyCommand;
import org.junit.jupiter.api.Test;

import model.DocumentManager;
import model.VersionsManager;
import model.strategies.StableVersionsStrategy;
import model.strategies.VersionsStrategy;
import model.strategies.VolatileVersionsStrategy;
import view.LatexEditorView;

class ChangeVersionsStrategyCommandTest {
	private final LatexEditorView latexEditorView = new LatexEditorView();
	private final DocumentManager documentManager = new DocumentManager();
	private final VersionsManager versionsManager = new VersionsManager(null, latexEditorView);
	private final ChangeVersionsStrategyCommand changeCommand = new ChangeVersionsStrategyCommand(versionsManager);
	
	@Test
	void testVolatile() {
		VersionsStrategy strategy = new VolatileVersionsStrategy();
		versionsManager.setStrategy(strategy);
		
		latexEditorView.setType("articleTemplate");
		latexEditorView.setVersionsManager(versionsManager);
		latexEditorView.setStrategy("stable");
		changeCommand.execute();
		
		String test = "test ok";
		if(versionsManager.getStrategy() instanceof VolatileVersionsStrategy)
			test = "not ok";
		
		assertEquals("test ok", test);
	}
	
	@Test
	void testStable() {
		VersionsStrategy strategy = new StableVersionsStrategy();
		versionsManager.setStrategy(strategy);
		
		latexEditorView.setType("articleTemplate");
		latexEditorView.setVersionsManager(versionsManager);
		latexEditorView.setStrategy("volatile");
		changeCommand.execute();
		
		String test = "test ok";
		if(versionsManager.getStrategy() instanceof StableVersionsStrategy)
			test = "not ok";
		
		assertEquals("test ok", test);
	}
		
}
