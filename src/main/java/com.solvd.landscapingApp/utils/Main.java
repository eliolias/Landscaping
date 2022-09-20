package com.solvd.landscapingApp.utils;

import com.solvd.landscapingApp.connection.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;


public class Main {
    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        //TODO: Move all queries to top of classes
        //TODO: Make sure DAO is implemented correctly, to then implement business logic/service interfaces
        //TODO: XML with jaxb


        ConnectionPool con = ConnectionPool.getInstance();
        if (con != null) {
            LOGGER.info("working test");
        } else {
            LOGGER.info("failed test");
        }
    }
}
