package db;

class ConfigDb {
    public static String urlDb = "jdbc:postgresql://localhost:5432/testSber";
    public static String username = "testSber";
    public static String password = "testSber";

    /*
    CREATE TABLE elements
    (
    id          INT NOT NULL PRIMARY KEY,
    parent_id   INT,
    name        TEXT,
    value       TEXT,

    CONSTRAINT fk_elements_elements FOREIGN KEY (parent_id) REFERENCES elements (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE

    );
    */
}
