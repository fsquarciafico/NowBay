/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Statement;


public class Acquisto {
    private float prezzo=0,totale=0;
    private String e_mail=" ";
    private String descrizione=" ";
    private Date data=null;
    private int cod_prod=0;
    private int idacquisto=0;
    public Acquisto(){    
    }
    /*metodi get e set*/
    public void setPrezzo(float prezzo)
    {
        this.prezzo=prezzo;
    }
    public float getPrezzo()
    {
        return this.prezzo;
    }
    public void setTotale(float totale)
    {
        this.totale=totale;
    }
    public float getTotale()
    {
        return this.totale;
    }
    public void setId(int id_acquisto)
    {
        this.idacquisto=id_acquisto;
    }
    public int setAcq()
    {
        return this.idacquisto;
    }
    public void setE_mail(String e_mail)
    {
        this.e_mail=e_mail;
    }
    public String getE_mail()
    {
        return this.e_mail;
    }
    public void setDescrizione(String descrizione)
    {
        this.descrizione=descrizione;
    }
    public String getDescrizione()
    {
        return this.descrizione;
    }
    public Date getData()
    {
        return this.data;
    }
    public void setData(Date data)
    {
        this.data=data;
    }
    /*metodo che aggiunge gli acquisti effettuati nel data base*/
    public void addAcquisto(ArrayList<Prodotto> carrello,String e_mail,float tot) throws SQLException, ClassNotFoundException {
        Prodotto p=new Prodotto();
        /*connessione al data base*/
        ConnDab db=new ConnDab();
        Connection c=db.connect();
        Statement st=c.createStatement();
        /*scorrimento dell'arrey per inserire i prodotti*/
        for(int i=0;i<carrello.size();i++) {
            p=carrello.get(i);
            this.descrizione=p.getDescrizione();
            this.prezzo=p.getPrezzo();
            this.cod_prod=p.getCod_prod();
            this.e_mail=e_mail;
            this.totale=tot;
            /*data odierna*/
            Date d=new Date();
            java.sql.Date dataSql = new java.sql.Date(d.getTime());
            this.data=dataSql;
            /*inserimanto dei prodotti acquistati nella tabella acquisto*/
            st.executeUpdate("INSERT into acquisto(e_mail,totale,data,descrizione,prezzo,cod_prod) VALUES ('"+e_mail+"','"+totale+"','"+data+"','"+descrizione+"','"+prezzo+"','"+cod_prod+"')");
        }
        c.close();
    }
    /*metodo che interroga il database e restituisce l'arrayList contenente gli acquisti effettuati dall'utente*/
    public static ArrayList<Acquisto> getAcq(String e_mail) throws SQLException, ClassNotFoundException {
        ArrayList<Acquisto> acqui=new ArrayList<Acquisto>();
        /*connessione al database*/
        ConnDab db=new ConnDab();
        Connection c=db.connect();
        Statement st=c.createStatement();
        /*interrogazione del database per trovare gli acquisti effettuati da un utente*/
        ResultSet rs=st.executeQuery("SELECT * FROM acquisto WHERE e_mail='"+e_mail+"'order by data;");
        /*riempimento dell'ArrayList acquisto*/
        while (rs.next()) {
            Acquisto ac=new Acquisto();
            ac.totale=rs.getFloat("totale");
            ac.data=rs.getDate("data"); 
            ac.descrizione=rs.getString("descrizione");
            ac.prezzo=rs.getFloat("prezzo");
            acqui.add(ac);
        }
        c.close();
        return acqui;
    }
}