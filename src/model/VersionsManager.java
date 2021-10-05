package model;

import model.strategies.VersionsStrategy;

public class VersionsManager {
    private boolean enabled;
    private Document currentDocument;
    private VersionsStrategy strategy;

    public VersionsManager(VersionsStrategy strategy) {
        this.strategy = strategy;
    }

    public void enable(){
        enabled = true;
    }

    public void disable(){
        enabled = false;
    }

    public void setStrategy(VersionsStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Adds the current version to the versions history and replaces it
     * with the new document version.
     */
    public void setCurrentVersion(Document newDocumentVersion){

    }

    /**
     * Rolls Back to the Previous Version of our History.
     */
    public void rollbackToPreviousVersion(){

    }
}
