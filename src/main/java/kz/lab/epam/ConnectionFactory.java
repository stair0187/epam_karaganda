package kz.lab.epam;

import java.sql.*;

public class ConnectionFactory {
    public static Connection createConnection(){
        try {
            Class.forName("org.postgresql.Driver"); // загружает класс драйвера

        } catch (ClassNotFoundException ex) {
            System.out.println("не удалось загрузить класс");

        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/AutoPartShop", "postgres", "root");

        } catch (SQLException ex) {
            System.out.println("не удалось установить подключение к базе");
        }
     return connection;

    }

    }

