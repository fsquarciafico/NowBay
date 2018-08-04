/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnDab {
    /*username e password con cui autenticarsi nel database*/
    private static String username = "AdminNowBayDB";
    private static String password = "Admin";
    /*metodo che crea la connessione al database*/
    public Connection connect() throws SQLException, ClassNotFoundException {
        /*implementa il driver JDBC*/
        Class.forName("com.mysql.jdbc.Driver");
        /*creazione dell'oggetto Connection*/
        Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/NowBayDB ", username, password);
        return c;
    }
}