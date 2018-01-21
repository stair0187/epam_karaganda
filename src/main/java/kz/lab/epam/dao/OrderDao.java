package kz.lab.epam.dao;

import kz.lab.epam.entity.Catalogue;
import kz.lab.epam.entity.Order;
import kz.lab.epam.entity.OrderStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    public Boolean insert(Order order) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertSQL = "INSERT INTO ORDER (USER_ID,TOTAL,STATUS) VALUES (?,?,?)";
        try {
            dbConnection = ConnectionFactory.createConnection();
            preparedStatement = dbConnection.prepareStatement(insertSQL);
            preparedStatement.setLong(1, order.getUser_id());
            preparedStatement.setDouble(2, order.getTotal());
            preparedStatement.setString(3, order.getOrderStatus().name());
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


    public Boolean update(Order order) {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String updateSQL = "UPDATE ORDER SET TOTAL=?,STATUS=? WHERE ID=?";
        try {
            dbConnection = ConnectionFactory.createConnection();
            preparedStatement = dbConnection.prepareStatement(updateSQL);
            preparedStatement.setDouble(1, order.getTotal());
            preparedStatement.setString(2, order.getOrderStatus().name());
            preparedStatement.setLong(3, order.getID());
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



    public Boolean delete(Order order) {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String deleteSQL = "DELETE FROM ORDER WHERE ID=?";
        try {
            dbConnection = ConnectionFactory.createConnection();
            preparedStatement = dbConnection.prepareStatement(deleteSQL);
            preparedStatement.setLong(1, order.getID());

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

    public List<Order> findAll() {


        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String selectSQL = "SELECT * FROM ORDER";
        try {
            dbConnection = ConnectionFactory.createConnection();
            preparedStatement = dbConnection.prepareStatement(selectSQL);


            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();
            List<Order> orders = new ArrayList<Order>();

            while (rs.next()) {
                Order order = new Order();
                order.setID(rs.getLong("ID"));
                order.setUser_id(rs.getLong("USER_ID"));
                order.setTotal(rs.getDouble("TOTAL"));
                order.setOrderStatus(OrderStatus.valueOf(rs.getString("STATUS")));
                orders.add(order);
            }
            return orders;

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
