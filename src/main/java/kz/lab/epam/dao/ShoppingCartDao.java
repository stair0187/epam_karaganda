package kz.lab.epam.dao;

import kz.lab.epam.entity.OrderItem;
import kz.lab.epam.entity.ShoppingCart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDao {
    public Boolean insert(ShoppingCart cart) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertSQL = "INSERT INTO SHOPPING_CART (USER_ID) VALUES (?)";
        try {
            dbConnection = ConnectionFactory.createConnection();
            preparedStatement = dbConnection.prepareStatement(insertSQL);
            preparedStatement.setLong(1, cart.getUserId());
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






    public Boolean delete(ShoppingCart cart) {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String deleteSQL = "DELETE FROM SHOPPING_CART WHERE ID=?";
        try {
            dbConnection = ConnectionFactory.createConnection();
            preparedStatement = dbConnection.prepareStatement(deleteSQL);
            preparedStatement.setLong(1, cart.getId());
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

    public List<ShoppingCart> findAll(long userId) {



        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String selectSQL = "SELECT * FROM SHOPPING_CART WHERE USER_ID=?";
        try {
            dbConnection = ConnectionFactory.createConnection();
            preparedStatement = dbConnection.prepareStatement(selectSQL);
            preparedStatement.setLong(1,userId);


            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();
            List<ShoppingCart> carts = new ArrayList<ShoppingCart>();

            while (rs.next()) {
                ShoppingCart cart = new ShoppingCart();
                cart.setUserId(rs.getLong("USER_ID"));
                carts.add(cart);
            }
            return carts;

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
