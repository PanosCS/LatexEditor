package model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;

public class Document implements Serializable{
    private String author;
    private String date;
    private String copyright;
    private String versionID = "0";
    private String contents;

    public Document(String author, String date, String copyright, String versionID, String contents) {
        this.author = author;
        this.date = date;
        this.copyright = copyright;
        this.versionID = versionID;
        this.contents = contents;
    }

    public Document(){
        contents = "";
    }

    public Document(Document document){
        this(document.author, document.date, document.copyright, document.versionID, document.contents);
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void save(String filename){
        //TODO Complete Save method
        try {
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(filename));

            printWriter.write(contents);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Document clone(){
        return new Document(author, date, copyright, versionID, contents);
    }

    public static void main(String[] args) {
        DocumentManager documentManager = new DocumentManager();
        Document article = documentManager.createDocument("reportTemplate");
        System.out.println(article.getContents());
    }
}
