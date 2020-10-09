package Tree;

import db.ElementDao;
import models.Element;
import models.ElementList;
import models.ElementSingle;

import java.sql.SQLException;
import java.util.regex.Pattern;

public class Tree {
    private ElementList root;
    private ElementList current;

    public Tree() {
        root = null;
        current = null;
    }

    public void addElementSingle(String key, String value) {
        ElementSingle newElementSingle = new ElementSingle(key, value, current);
        current.getChildren().add(newElementSingle);
    }

    public void addElementList(String key) {
        ElementList newElementList = new ElementList(key);
        if (root == null) {
            root = newElementList;
            current = root;
        } else {
            newElementList.setParent(current);
            current.getChildren().add(newElementList);
            current = newElementList;
        }
    }

    public void toDown() {
        if (current.getParent() != null)
            current = (ElementList) current.getParent();
    }

    public void saveToDb() {
        try {
            ElementDao elementDao = new ElementDao();
            elementDao.deleteAll();
            elementDao.saveElementList(root);
            saveToDb(elementDao, root);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void saveToDb(ElementDao elementDao, ElementList elementRoot) throws SQLException {
        for (Element element : elementRoot.getChildren()) {
            if (element instanceof ElementList) {
                elementDao.saveElementList((ElementList) element);
                saveToDb(elementDao, (ElementList) element);
            } else {
                elementDao.saveElementSingle((ElementSingle) element);
            }
        }
    }
}
