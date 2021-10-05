package model;

import java.util.HashMap;

/**
 * The DocumentManager keeps the prototypes of the document templates
 */
public class DocumentManager {
    private HashMap<String, Document> templates;

    public DocumentManager() {
        templates = new HashMap<>();

        //TODO Create/Add templates to Map.
        Document document = new Document();
        document.setContents(getContents("reportTemplate"));
        templates.put("reportTemplate", document);

        document = new Document();
        document.setContents(getContents("bookTemplate"));
        templates.put("bookTemplate", document);

        document = new Document();
        document.setContents(getContents("articleTemplate"));
        templates.put("articleTemplate", document);

        document = new Document();
        document.setContents(getContents("letterTemplate"));
        templates.put("letterTemplate", document);

        document = new Document();
        templates.put("emptyTemplate", document);
    }

    /**
     * Retrieves a prototype from the Map and clones it.
     * @param templateID identifier key for a specific template.
     * @return Document prototype
     */
    public Document createDocument(String templateID){
        return templates.get(templateID).clone();
    }

    public String getContents(String type) {
        return switch (type) {
            case "articleTemplate" -> "\\documentclass[11pt,twocolumn,a4paper]{article}\n\n" +

                    "\\begin{document}\n" +
                    "\\title{Article: How to Structure a LaTeX Document}\n" +
                    "\\author{Author1 \\and Author2 \\and ...}\n" +
                    "\\date{\\today}\n\n" +

                    "\\maketitle\n\n" +

                    "\\section{Section Title 1}\n\n" +

                    "\\section{Section Title 2}\n\n" +

                    "\\section{Section Title.....}\n\n" +

                    "\\section{Conclusion}\n\n" +

                    "\\section*{References}\n\n" +

                    "\\end{document}\n";
            case "bookTemplate" -> "\\documentclass[11pt,a4paper]{book}\n\n" +

                    "\\begin{document}\n" +
                    "\\title{Book: How to Structure a LaTeX Document}\n" +
                    "\\author{Author1 \\and Author2 \\and ...}\n" +
                    "\\date{\\today}\n\n" +

                    "\\maketitle\n\n" +

                    "\\frontmatter\n\n" +

                    "\\chapter{Preface}\n" +
                    "% ...\n\n" +

                    "\\mainmatter\n" +
                    "\\chapter{First chapter}\n" +
                    "\\section{Section Title 1}\n" +
                    "\\section{Section Title 2}\n\n" +

                    "\\section{Section Title.....}\n\n" +

                    "\\chapter{....}\n\n" +

                    "\\chapter{Conclusion}\n\n" +

                    "\\chapter*{References}\n\n\n" +


                    "\\backmatter\n" +
                    "\\chapter{Last note}\n\n" +

                    "\\end{document}\n";
            case "letterTemplate" -> "\\documentclass{letter}\n" +
                    "\\usepackage{hyperref}\n" +
                    "\\signature{Sender's Name}\n" +
                    "\\address{Sender's address...}\n" +
                    "\\begin{document}\n\n" +

                    "\\begin{letter}{Destination address....}\n" +
                    "\\opening{Dear Sir or Madam:}\n\n" +

                    "I am writing to you .......\n\n\n" +


                    "\\closing{Yours Faithfully,}\n" +

                    "\\ps\n\n" +

                    "P.S. text .....\n\n" +

                    "\\encl{Copyright permission form}\n\n" +

                    "\\end{letter}\n" +
                    "\\end{document}\n";
            default -> "\\documentclass[11pt,a4paper]{report}\n\n" +

                    "\\begin{document}\n" +
                    "\\title{Report Template: How to Structure a LaTeX Document}\n" +
                    "\\author{Author1 \\and Author2 \\and ...}\n" +
                    "\\date{\\today}\n" +
                    "\\maketitle\n\n" +

                    "\\begin{abstract}\n" +
                    "Your abstract goes here...\n" +
                    "...\n" +
                    "\\end{abstract}\n\n" +

                    "\\chapter{Introduction}\n" +
                    "\\section{Section Title 1}\n" +
                    "\\section{Section Title 2}\n" +
                    "\\section{Section Title.....}\n\n" +

                    "\\chapter{....}\n\n" +

                    "\\chapter{Conclusion}\n\n\n" +


                    "\\chapter*{References}\n\n" +

                    "\\end{document}\n";
        };
    }
}