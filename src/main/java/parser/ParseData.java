package parser;

import Tree.Tree;
import exceptions.WrongDataException;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseData {

    private String filename;
    private String data;
    private Tree tree;

    public ParseData(String filename, Tree tree) {
        this.filename = filename;
        this.tree = tree;
    }



    public void update() throws Exception {
        URI uri = getClass().getResource("/" + filename).toURI();
        data = new String(Files.readAllBytes(Paths.get(uri)));
        if (checkSyntax()) {
            String regex = "(([A-Za-z_]+\\w*)\\s*=\\s*(\\\"([^\\\"\\r\\n]+?)\\\"|\\s*\\{))|}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(data);
            int checkScobe = 0;
            while(matcher.find()) {
                if (matcher.group(3) != null && matcher.group(3).equals("{")) {
                    //its list
                    tree.addElementList(matcher.group(2));
                    checkScobe++;
                } else if (matcher.group(3) != null) {
                    //its single
                    tree.addElementSingle(matcher.group(2), matcher.group(3).replace("\"", ""));
                } else {
                    //its }
                    tree.toDown();
                    checkScobe--;
                }
            }
            if (checkScobe != 0) {
                throw new WrongDataException();
            }

        } else {
            throw new WrongDataException();
        }




    }

    private boolean checkSyntax() {
        return data != null && data.matches(
                "((\\s*([A-Za-z_]+\\w*)\\s*=\\s*((\\\"[^\\\"\\n\\r]+?\\\")\\s*|\\s*\\{\\s*))|\\s*\\}\\s*)+");
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
