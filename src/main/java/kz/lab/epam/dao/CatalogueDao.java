package kz.lab.epam.dao;

import kz.lab.epam.entity.AutoPart;
import kz.lab.epam.entity.AutoPartType;
import kz.lab.epam.entity.Catalogue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatalogueDao {
    public Boolean insert(Catalogue catalogue) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertSQL = "INSERT INTO CATALOGUE (AUTOPART_ID,COUNT) VALUES (?,?,?,?)";
        try {
            dbConnection = ConnectionFactory.createConnection();
            preparedStatement = dbConnection.prepareStatement(insertSQL);
            preparedStatement.setLong(1, catalogue.getAutopart_id());
            preparedStatement.setDouble(2, catalogue.getCount());
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


    public Boolean update(Catalogue catalogue) {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String updateSQL = "UPDATE CATALOGUE SET COUNT=? WHERE AUTOPART_ID=?";
        try {
            dbConnection = ConnectionFactory.createConnection();
            preparedStatement = dbConnection.prepareStatement(updateSQL);
            preparedStatement.setLong(1, catalogue.getCount());
            preparedStatement.setLong(2, catalogue.getAutopart_id());
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



    public Boolean delete(Catalogue catalogue) {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String deleteSQL = "DELETE FROM CATALOGUE WHERE AUTOPART_ID=?";
        try {
            dbConnection = ConnectionFactory.createConnection();
            preparedStatement = dbConnection.prepareStatement(deleteSQL);
            preparedStatement.setLong(1, catalogue.getAutopart_id());

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

    public List<Catalogue> findAll() {


        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String selectSQL = "SELECT * FROM CATALOGUE";
        try {
            dbConnection = ConnectionFactory.createConnection();
            preparedStatement = dbConnection.prepareStatement(selectSQL);


            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();
            List<Catalogue> catalogues = new ArrayList<Catalogue>();

            while (rs.next()) {
                Catalogue catalogue = new Catalogue();
                catalogue.setAutopart_id(rs.getLong("AUTOPART_ID"));
                catalogue.setCount(rs.getInt("COUNT"));
                catalogues.add(catalogue);
            }
            return catalogues;

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

