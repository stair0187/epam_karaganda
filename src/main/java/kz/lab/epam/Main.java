package kz.lab.epam;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver"); // загружает класс драйвера

        } catch (ClassNotFoundException ex) {
            System.out.println("не удалось загрузить класс");

        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Ingridience", "postgres", "root");

        } catch (SQLException ex) {
            System.out.println("не удалось установить подключение к базе");
        }
        if (connection != null) {


            try {

                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT * FROM \"ingredients\"");
                while (resultSet.next()) {

                    System.out.println(resultSet.getLong(1) + " - " + resultSet.getString(2));

                }
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

    }
}
