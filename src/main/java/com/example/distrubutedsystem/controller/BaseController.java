package com.example.distrubutedsystem.controller;

import com.example.distrubutedsystem.entity.Event;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BaseController {
    Logger log;

    public void checkConnection() {
        String connectionUrl =
                "jdbc:sqlserver://localhost\\LEMONY;"
                        + "user=sa;"
                        + "password=123456;";
        try (Connection connection = DriverManager.getConnection(connectionUrl)) {
            log.info("Connected");
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Event> getAllEvent() {
        List<Event> rsList = new ArrayList<>();
        String connectionUrl =
                "jdbc:sqlserver://localhost\\LEMONY;"
                        + "user=sa;"
                        + "password=123456;";
        String selectSql = "SELECT TOP (1000) [id]\n" +
                "      ,[name]\n" +
                "      ,[rowguid]\n" +
                "  FROM [ManhNam].[dbo].[Event]";
        try (Connection connection = DriverManager.getConnection(connectionUrl);
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(selectSql);
            while (rs.next()) {
                Event ev = new Event();
                ev.setId(rs.getInt("id"));
                ev.setName(rs.getString("name"));
                log.info(ev.toString());
                rsList.add(ev);
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
        return rsList;
    }
}
