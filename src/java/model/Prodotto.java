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
import java.util.ArrayList;

/**
 *
 * @author Ferdinando
 */
public class Prodotto {

    private String tipo_prod = " ", immagine = " ", descrizione = " ";
    private int cod_prod = 0, novita = 0;
    private float prezzo = 0;

    public Prodotto() {
    }
    /*metodi get e set*/
    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public int getCod_prod() {
        return cod_prod;
    }

    public void setCod_prod(int cod_prod) {
        this.cod_prod = cod_prod;
    }

    public String getTipo_prod() {
        return tipo_prod;
    }

    public void setTipo_prod(String tipo_prod) {
        this.tipo_prod = tipo_prod;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    /*metodo che restituisce l'array di prodotti*/
    public static ArrayList<Prodotto> getCatProd() throws SQLException, ClassNotFoundException {
        ArrayList<Prodotto> prod = new ArrayList<Prodotto>();
        /*connessione al database*/
        ConnDab db = new ConnDab();
        Connection c = db.connect();
        Statement st = c.createStatement();
        /*interrogazione del database, rs contiene il risultato della query*/
        ResultSet rs = st.executeQuery("SELECT * FROM prodotto;");
        while (rs.next()) {
            Prodotto pr = new Prodotto();
            pr.cod_prod = rs.getInt("cod_prod");
            pr.immagine = rs.getString("immagine");
            pr.prezzo = rs.getFloat("prezzo");
            pr.descrizione = rs.getString("descrizione");
            pr.tipo_prod = rs.getString("tipo_prod");
            /*aggiunge all'array l'oggetto prodotto*/
            prod.add(pr);
        }
        c.close();
        return prod;
    }
    /*metodo che restituisce l'array list prodotto selezionato per tipologia*/
    public static ArrayList<Prodotto> getCatProdxtipo(String tipo) throws SQLException, ClassNotFoundException {
        ArrayList<Prodotto> prod = new ArrayList<Prodotto>();
        ConnDab db = new ConnDab();
        Connection c = db.connect();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM prodotto where tipo_prod= '" + tipo + "';");
        while (rs.next()) {
            Prodotto pr = new Prodotto();
            pr.cod_prod = rs.getInt("cod_prod");
            pr.immagine = rs.getString("immagine");
            pr.prezzo = rs.getFloat("prezzo");
            pr.descrizione = rs.getString("descrizione");
            pr.tipo_prod = rs.getString("tipo_prod");
            prod.add(pr);
        }
        c.close();
        return prod;
    }
    /*metodo che restituisce i dettagli del prodotto*/
    public static Prodotto dett(int cod_prod) throws SQLException, ClassNotFoundException {
        ConnDab db = new ConnDab();
        Connection c = db.connect();
        Statement st = c.createStatement();
        Prodotto p = null;
        /*interrogazione del database*/
        ResultSet rs = st.executeQuery("SELECT * FROM prodotto WHERE cod_prod='" + cod_prod + "';");
        while (rs.next()) {
            p = new Prodotto();
            p.cod_prod = rs.getInt("cod_prod");
            p.immagine = rs.getString("immagine");
            p.prezzo = rs.getFloat("prezzo");
            p.descrizione = rs.getString("descrizione");
            p.tipo_prod = rs.getString("tipo_prod");
        }
        c.close();
        return p;
    }
    /*metodo che conta i prodotti presenti all'interno del catalogo*/
    public static int countPro() throws SQLException, ClassNotFoundException {
        int count = 0;
        /*connessione al database*/
        ConnDab db = new ConnDab();
        Connection c = db.connect();
        Statement st = c.createStatement();
        /*interrogazione del database*/
        ResultSet rs = st.executeQuery("SELECT * FROM prodotto;");
        while (rs.next()) {
            count = rs.getInt(1);
        }
        c.close();
        return count;
    }
}
