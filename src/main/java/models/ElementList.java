package models;

import java.util.LinkedList;
import java.util.List;

public class ElementList {
    private String key;
    private List<Element> elements;

    public ElementList(String key) {
        this.key = key;
        elements = new LinkedList<>();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }
}
