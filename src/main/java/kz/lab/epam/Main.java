package kz.lab.epam;

import kz.lab.epam.dao.UserDao;
import kz.lab.epam.entity.Role;
import kz.lab.epam.entity.User;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setLogin("Pusya");
        user.setPassword("123");
        user.setName("Petya");
        user.setRole (Role.MANAGER);
        UserDao dao = new UserDao();
        dao.insert(user);



}}
