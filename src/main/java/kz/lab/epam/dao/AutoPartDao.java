package kz.lab.epam.dao;

import kz.lab.epam.entity.AutoPart;
import kz.lab.epam.entity.AutoPartType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutoPartDao {
    public Boolean create(AutoPart part) {
    }

    public Boolean update(AutoPart part) {
    }

    public Boolean delete(AutoPart part) {
    }

    public List<AutoPart> findAll() {


        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String selectSQL = "SELECT * FROM AUTO_PART";
        try {
            dbConnection = ConnectionFactory.createConnection();
            preparedStatement = dbConnection.prepareStatement(selectSQL);


            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();
            List<AutoPart> parts = new ArrayList<AutoPart>();

            while (rs.next()) {
                AutoPart part = new AutoPart();
                part.setId(rs.getLong("ID"));
                part.setArticule(rs.getString("ARTICULE"));
                part.setName(rs.getString("NAME"));
                part.setAutoPartType(AutoPartType.valueOf(rs.getString("TYPE")));
                part.setPrice(rs.getDouble("PRICE"));
                parts.add(part);
            }
            return parts;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                }

            }

            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ex) {
                }

            }


        }
        return null;
    }
}
