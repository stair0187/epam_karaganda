package kz.lab.epam.dao;

import kz.lab.epam.entity.CartItem;
import kz.lab.epam.entity.Catalogue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartItemDao {
    public Boolean insert(CartItem item) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertSQL = "INSERT INTO CART_ITEM (CART_ID,AUTOPART_ID,COUNT) VALUES (?,?,?)";
        try {
            dbConnection = ConnectionFactory.createConnection();
            preparedStatement = dbConnection.prepareStatement(insertSQL);
            preparedStatement.setLong(1, item.getCart_id());
            preparedStatement.setLong(2, item.getAutopart_id());
            preparedStatement.setLong(3, item.getCount());
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


    public Boolean update(CartItem item) {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String updateSQL = "UPDATE CART_ITEM SET COUNT=? WHERE CART_ID=? AND AUTOPART_ID=?";
        try {
            dbConnection = ConnectionFactory.createConnection();
            preparedStatement = dbConnection.prepareStatement(updateSQL);
            preparedStatement.setLong(1, item.getCount());
            preparedStatement.setLong(2, item.getCart_id());
            preparedStatement.setLong(3, item.getAutopart_id());
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



    public Boolean delete(CartItem item) {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        String deleteSQL = "DELETE FROM CART_ITEM WHERE CART_ID=? AND AUTOPART_ID=?";
        try {
            dbConnection = ConnectionFactory.createConnection();
            preparedStatement = dbConnection.prepareStatement(deleteSQL);
            preparedStatement.setLong(1, item.getCart_id());
            preparedStatement.setLong(2, item.getAutopart_id());

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

    public List<CartItem> findAll() {


        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String selectSQL = "SELECT * FROM CART_ITEM";
        try {
            dbConnection = ConnectionFactory.createConnection();
            preparedStatement = dbConnection.prepareStatement(selectSQL);


            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();
            List<CartItem> items = new ArrayList<CartItem>();

            while (rs.next()) {
                CartItem item = new CartItem();
                item.setCart_id(rs.getLong("CART_ID"));
                item.setAutopart_id(rs.getLong("AUTOPART_ID"));
                item.setCount(rs.getInt("COUNT"));
                items.add(item);
            }
            return items;

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
