/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cafeshopmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author WINDOWS 10
 */
public class database {

    public static Connection connectDB() {

        try {

            

            Connection connect = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-VMQ6V7E7;databaseName=CAFE;integratedSecurity=True;encrypt=True;trustServerCertificate=True"); // LINK YOUR DATABASE
            System.out.println("buda bağlandı");
            return connect;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
