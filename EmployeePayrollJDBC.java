package com.employeepayroll;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class EmployeePayrollJDBC {
    public static void main(String[] args) {

        //Establish a connection to DB
        String DB_URL = "jdbc:mysql://localhost:3306/payroll_service";
        String userName = "tiger";

        Connection connection;

        try {
            //load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded !");
        } catch (ClassNotFoundException c) {
            System.out.println("class not found !!");
            c.printStackTrace();
        }
        listDrivers();

        try {
            System.out.println("Connecting to database : "+DB_URL);
            connection = DriverManager.getConnection(DB_URL, userName , "root");
            System.out.println("Connection is successful !! " + connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void listDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
            Driver driverClass = (Driver)driverList.nextElement();
            System.out.println("	" + driverClass.getClass().getName());
        }
    }
}
