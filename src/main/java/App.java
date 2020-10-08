import Tree.Tree;
import parser.ParseData;

public class App {
    public static void main(String[] args) {
        try {
            Tree tree = new Tree();
            ParseData parseData = new ParseData("data.txt", tree);
            parseData.update();
            tree.saveToDb();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
