package model.strategies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Document;

public class StableVersionsStrategy implements VersionsStrategy{
	private String versionID = "";
	@Override
	public void putVersion(Document document) {

		String filename = document.getVersionID() + ".tex";
		document.save(filename);
		versionID = document.getVersionID();
		
	}

	@Override
	public Document getVersion() {

		if(versionID.equals(""))
			return null;
		
		StringBuilder fileContents = new StringBuilder();
		try {
			Scanner scanner = new Scanner(new FileInputStream(versionID + ".tex"));
			while(scanner.hasNextLine()) {
				fileContents.append(scanner.nextLine()).append("\n");
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		Document document = new Document();
		document.setContents(fileContents.toString());
		return document;
	}

	@Override
	public void setEntireHistory(List<Document> documents) {

		for (Document doc : documents) {
			doc.save(doc.getVersionID() + ".tex");
		}
		if(documents.size() > 0)
			versionID = documents.get(documents.size()-1).getVersionID();
		else
			versionID = "";
	}

	@Override
	public List<Document> getEntireHistory() {

		List<Document> documents = new ArrayList<>();
		if(versionID.equals(""))
			return documents;
		int n = Integer.parseInt(versionID);
		for(int i = 0; i <= n; i++) {
			StringBuilder fileContents = new StringBuilder();
			try {
				Scanner scanner = new Scanner(new FileInputStream(i + ".tex"));
				while(scanner.hasNextLine()) {
					fileContents.append(scanner.nextLine()).append("\n");
				}
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
			Document document = new Document();
			document.setContents(fileContents.toString());
			documents.add(document);
		}
		return documents;
	}

	@Override
	public void removeVersion() {

		int n = Integer.parseInt(versionID);
		if(n == 0)
			versionID = "";
		else
			versionID = (n-1) + "";
		
	}
}
