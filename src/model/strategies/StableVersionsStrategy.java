package model.strategies;

import model.Document;

import java.util.List;

public class StableVersionsStrategy implements VersionsStrategy{

    public StableVersionsStrategy() {
    }

    @Override
    public void putVersion(Document document) {

    }

    @Override
    public Document getVersion() {
        return null;
    }

    @Override
    public void setEntireHistory(List<Document> documents) {

    }

    @Override
    public List<Document> getEntireHistory() {
        return null;
    }

    @Override
    public void removeVersion() {

    }
}
