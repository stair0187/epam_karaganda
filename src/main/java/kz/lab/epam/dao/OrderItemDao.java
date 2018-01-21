package kz.lab.epam.dao;

import kz.lab.epam.entity.Order;
import kz.lab.epam.entity.OrderItem;
import kz.lab.epam.entity.OrderStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDao {
    public Boolean insert(OrderItem item) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertSQL = "INSERT INTO ORDER_ITEM (ORDER_ID,AUTOPART_ID,COUNT) VALUES (?,?,?)";
        try {
            dbConnection = ConnectionFactory.createConnection();
            preparedStatement = dbConnection.prepareStatement(insertSQL);
            preparedStatement.setLong(1, item.getOrderId());
            preparedStatement.setLong(2, item.getAutopartId());
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


    public Boolean update(OrderItem item) {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String updateSQL = "UPDATE ORDER_ITEM SET COUNT=? WHERE ORDER_ID=? AND AUTOPART_ID=?";
        try {
            dbConnection = ConnectionFactory.createConnection();
            preparedStatement = dbConnection.prepareStatement(updateSQL);
            preparedStatement.setLong(1, item.getCount());
            preparedStatement.setLong(2, item.getOrderId());
            preparedStatement.setLong(3, item.getAutopartId());
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



    public Boolean delete(OrderItem item) {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String deleteSQL = "DELETE FROM ORDER_ITEM WHERE ORDER_ID=?";
        try {
            dbConnection = ConnectionFactory.createConnection();
            preparedStatement = dbConnection.prepareStatement(deleteSQL);
            preparedStatement.setLong(1, item.getOrderId());

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

    public List<OrderItem> findAll() {


        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String selectSQL = "SELECT * FROM ORDER_ITEM";
        try {
            dbConnection = ConnectionFactory.createConnection();
            preparedStatement = dbConnection.prepareStatement(selectSQL);


            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();
            List<OrderItem> items = new ArrayList<OrderItem>();

            while (rs.next()) {
                OrderItem item = new OrderItem();
                item.setOrderId(rs.getLong("ORDER_ID"));
                item.setAutopartId(rs.getLong("AUTOPART_ID"));
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
