/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ferdinando
 */
public class Utente {
    private boolean loggato=false;    
    private String nome="", cognome="", e_mail="" ,indirizzo="", cod_fis="", iban="", password="";
    
    public Utente() {
    }
    /*metodi get e set*/
    public String getNome(){
        return nome;
    }
    public void setNome(String Nome){
        this.nome=nome;
        
    }
    public String getCognome(){
        return cognome;
    }
    public void setCognome(String cognome){
        this.cognome=cognome;
        
    }
    public String getE_mail(){
        return e_mail;
    }
    public void setE_mail(String e_mail){
        this.e_mail=e_mail;
        
    }
    public String getCod_Fis(){
        return cod_fis;
    }
    public void setCod_fis(String cod_fis){
        this.cod_fis=cod_fis;
        
    }
    public String getIndirzzo(){
        return indirizzo;
    }
    public void setIndirizzo(String indirizzo){
        this.indirizzo=indirizzo;
        
    }
    public String getIban(){
        return iban;
    }
    public void setIban(String iban){
        this.iban=iban;
        
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
        
    }
    public boolean isLoggato() {
        return loggato;
    }
    public void setLoggato(boolean loggato) {
        this.loggato = loggato;
    }
    /*metodo che setta la variabili dell'utente se e_mail e password corrispondono*/
    public void logg(String e_mail,String password) throws SQLException, ClassNotFoundException
    {
        /*connessione al database*/
        ConnDab db=new ConnDab();
        Connection c=db.connect();
        Statement st=c.createStatement();
        /*interrogazione del database*/
        String query = "SELECT * FROM utente_reg WHERE e_mail='"+e_mail+"' AND password='"+password+"'";
        ResultSet rs=st.executeQuery(query);
        while (rs.next())
        {            
            this.e_mail=(rs.getString("e_mail"));
            this.cod_fis=(rs.getString("cod_fis"));
            this.nome=(rs.getString("nome"));
            this.cognome=(rs.getString("cognome"));
            this.iban=(rs.getString("iban"));
            this.indirizzo=(rs.getString("indirizzo"));
            this.password=(rs.getString("password"));
            this.loggato=true;
        
    }
       c.close();
    } 
    /*metodo che ripristina l'utente*/
    public void ripristina()
    {
        this.cod_fis="";
        this.cognome="";
        this.e_mail="";
        this.iban="";
        this.indirizzo="";
        this.loggato=false;
        this.nome="";
        this.password="";
    }
}
