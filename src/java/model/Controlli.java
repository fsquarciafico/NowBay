/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Controlli {
    
    public Controlli() {
    }
    /*metodo che controlla la password */
    public static boolean contrPassword(String password) {
        boolean s=true;
        /*la password deve essere compresa tra 5 e 45*/
        if (password.length()<5||password.length()>45)
            s=false;
        return s;
    }
    /*metodo che controlla che il codice fiscale sia di 16 caratteri*/
    public static boolean contrCode (String codFisc) {
        boolean s=true;
        if (codFisc.length()!=16)
        s=false;
        return s;
    }
    /*metodo per il controllo dell'e_mail*/
    public static boolean contrEmail(String email) throws SQLException, ClassNotFoundException {
        boolean s=true;
        /*connessione al database*/
        ConnDab db=new ConnDab();
        Connection c=db.connect();
        Statement st=c.createStatement();
        /*interrogazione del database per vadere se l'e_mail inserita dalll'utente corrisponde a quella presente nel database*/
        ResultSet rs =st.executeQuery("SELECT *FROM utente_reg WHERE e_mail='"+email+"';" );
        while(rs.next()) {
            if ((rs.getString("e_mail")).equalsIgnoreCase(email)) {
                s=false;
            }
        }
        c.close();
        return s;
    }
   /*metodo che controlla se la lunghezza dell'iban è di 27*/
    public static boolean contrIban(String iban) {
       boolean s=true;
       if (iban.length()!=27)
           s=false;
        return s;
    }
}
