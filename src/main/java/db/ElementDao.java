package db;

import models.ElementList;
import models.ElementSingle;

import java.sql.*;

public class ElementDao {

    private Connection connection;

    public ElementDao() throws SQLException {
        connection = DriverManager.getConnection(ConfigDb.urlDb, ConfigDb.username, ConfigDb.password);
    }

    public void saveElementSingle(ElementSingle elementSingle) throws SQLException {
        String query = "INSERT INTO public.elements(id, parent_id, name, value) VALUES(?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, elementSingle.getId());
        if (elementSingle.getParent() != null) {
            ps.setInt(2, elementSingle.getParent().getId());
        } else {
            ps.setNull(2, Types.NULL);
        }
        ps.setString(3, elementSingle.getKey());
        ps.setString(4, elementSingle.getValue());
        ps.execute();
    }

    public void saveElementList(ElementList elementList) throws SQLException {
        String query = "INSERT INTO public.elements(id, parent_id, name, value) VALUES(?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, elementList.getId());
        if (elementList.getParent() != null) {
            ps.setInt(2, elementList.getParent().getId());
        } else {
            ps.setNull(2, Types.NULL);
        }
        ps.setString(3, elementList.getKey());
        ps.setString(4, "");
        ps.execute();
    }

}
