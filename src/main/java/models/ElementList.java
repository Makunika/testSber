package models;

import java.util.LinkedList;
import java.util.List;

public class ElementList extends Element {

    private String key;
    private List<Element> children;

    private Element parent;

    public ElementList(String key) {
        super();
        this.key = key;
        this.children = new LinkedList<>();
        this.parent = null;
    }

    public ElementList(String key, ElementList parent) {
        this(key);
        this.parent = parent;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<Element> getChildren() {
        return children;
    }

    public void setChildren(List<Element> children) {
        this.children = children;
    }

    @Override
    public Element getParent() {
        return parent;
    }

    @Override
    public void setParent(Element parent) {
        this.parent = parent;
    }

}
