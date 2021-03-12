/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.italika.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kiaka
 */
public class ConnectURL {
    public Connection Conectar() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectURL="jdbc:sqlserver://localhost:1433;databaseName=italika;user=sa;password=12345678;";
        Connection con = DriverManager.getConnection(connectURL);
        System.out.println("Conectado");
        return con;
        //Statement st= con.createStatement();
        
    }
}
