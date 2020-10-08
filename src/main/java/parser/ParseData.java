package parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ParseData {

    private String filename;

    public ParseData(String filename) {
        this.filename = filename;
    }



    public void update() throws IOException {
        String data = new String(Files.readAllBytes(Paths.get(filename)));



    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
