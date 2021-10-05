package model.strategies;

import model.Document;

import java.util.List;

/**
 * For each document change the mechanism keeps the previous version of
 * the document on disk storage.
 */
public class StableVersionsStrategy implements VersionsStrategy{

    @Override
    public void putVersion(Document document) {
//        document.save();
    }

    @Override
    public Document getVersion() {
        // TODO We need to keep track of the versions on disk.
        return null;
    }

    @Override
    public void setEntireHistory(List<Document> documents) {
        for (Document document : documents) {
//            document.save();
        }
    }

    @Override
    public List<Document> getEntireHistory() {
        return null;
    }

    @Override
    public void removeVersion() {

    }
}
