/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cafeshopmanagementsystem;

import java.sql.*;

/**
 *
 * @author Furkan
 */
public class SQLHalper {

    public SQLHalper() {
        try {
            Connection connect = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-VMQ6V7E7;databaseName=CAFE;integratedSecurity=True;encrypt=True;trustServerCertificate=True"); // LINK YOUR DATABASE
            System.out.println("bağlandı");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
