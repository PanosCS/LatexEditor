package model.strategies;

import model.Document;

import java.util.List;

public interface VersionsStrategy {
    /**
     * Adds a new version to the history.
     */
    public void putVersion(Document document);

    /**
     * Returns the last version that has been added to the history.
     * @return Document
     */
    public Document getVersion();

    public void setEntireHistory(List<Document> documents);
    public List<Document> getEntireHistory();
    public void removeVersion();
}
