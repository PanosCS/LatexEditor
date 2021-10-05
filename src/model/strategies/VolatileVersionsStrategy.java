package model.strategies;

import model.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Volatile VersionStrategy (default strategy)
 * For each document change, the mechanism keeps the previous version of the
 * document in a main memory list of subsequent document versions.
 */
public class VolatileVersionsStrategy implements VersionsStrategy{
    private List<Document> versionsHistory;

    public VolatileVersionsStrategy() {
        versionsHistory = new ArrayList<>();
    }

    @Override
    public void putVersion(Document document) {
        versionsHistory.add(document);
    }

    @Override
    public Document getVersion() {
        return versionsHistory.size() > 0 ? versionsHistory.get(versionsHistory.size() - 1) : null;
    }

    @Override
    public void setEntireHistory(List<Document> documents) {
        versionsHistory.clear();
        versionsHistory.addAll(documents);
    }

    @Override
    public List<Document> getEntireHistory() {
        return versionsHistory;
    }

    @Override
    public void removeVersion() {
        if(versionsHistory.size() >0) versionsHistory.remove(versionsHistory.size() - 1);
    }
}
