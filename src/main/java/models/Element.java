package models;

public abstract class Element {
    private int id;


    public Element() {
        this.id = IdGet.getNewId();
    }

    public abstract Element getParent();
    public abstract void setParent(Element parent);


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
