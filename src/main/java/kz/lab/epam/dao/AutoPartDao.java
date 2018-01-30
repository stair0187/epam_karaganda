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


    public Boolean insert(AutoPart part) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertSQL = "INSERT INTO AUTO_PART (ARTICULE,NAME,TYPE,PRICE) VALUES (?,?,?,?)";
        try {
            dbConnection = ConnectionFactory.createConnection();
            preparedStatement = dbConnection.prepareStatement(insertSQL);
            preparedStatement.setString(1, part.getArticule());
            preparedStatement.setString(2, part.getName());
            preparedStatement.setString(3, part.getAutoPartType().name());
            preparedStatement.setDouble(4, part.getPrice());
            preparedStatement.executeUpdate();
            return true;


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
        return false;
    }


    public Boolean update(AutoPart part) {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String updateSQL = "UPDATE AUTO_PART SET ARTICULE=?,NAME=?,TYPE=?,PRICE=? WHERE ID=?";
        try {
            dbConnection = ConnectionFactory.createConnection();
            preparedStatement = dbConnection.prepareStatement(updateSQL);
            preparedStatement.setString(1, part.getArticule());
            preparedStatement.setString(2, part.getName());
            preparedStatement.setString(3, part.getAutoPartType().name());
            preparedStatement.setDouble(4, part.getPrice());
            preparedStatement.setLong(5, part.getId());
            preparedStatement.executeUpdate();
            return true;


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
        return false;
    }



    public Boolean delete(AutoPart part) {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String deleteSQL = "DELETE FROM AUTO_PART WHERE ID=?";
        try {
            dbConnection = ConnectionFactory.createConnection();
            preparedStatement = dbConnection.prepareStatement(deleteSQL);
            preparedStatement.setLong(1, part.getId());

            preparedStatement.executeUpdate();
            return true;


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
        return false;
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
