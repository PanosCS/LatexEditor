package model.strategies;

import java.util.List;

import model.Document;

public interface VersionsStrategy {
	void putVersion(Document document);
	Document getVersion();
	void setEntireHistory(List<Document> documents);
	List<Document> getEntireHistory();
	void removeVersion();
}
