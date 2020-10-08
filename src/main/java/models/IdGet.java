package models;

class IdGet {
    private static int ID = 0;

    public static int getNewId() {
        return ++ID;
    }
}
