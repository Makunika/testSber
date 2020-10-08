package models;

public class ElementSingle extends Element {
    private String key;
    private String value;
    private Element parent;

    public ElementSingle(String key, String value) {
        super();
        this.key = key;
        this.value = value;
        this.parent = null;
    }

    public ElementSingle(String key, String value, ElementList parent) {
        this(key, value);
        this.parent = parent;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
