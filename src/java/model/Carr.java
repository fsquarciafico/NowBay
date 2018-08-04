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


public class Carr{
   
   private ArrayList<Prodotto> carrello=new ArrayList<Prodotto>();
   private float tot=0;
   private int count=0;
   
   public Carr() {   
   }
   /*metodi get e set*/
   public void setTot(float tot) {
       this.tot=tot;
   }
   public float getTot() {
       return this.tot;
   }
   public int getCount() {
       return this.count;
   }
   public void setCount(int count)
   {
       this.count=count;
   }
   public ArrayList<Prodotto> getCarrello()
   {
        return this.carrello;
   }
   public void setCarr(ArrayList<Prodotto> carrello)
  {
      
      this.carrello=carrello;
  }
   /*metodo che aggiunge i prodotti al carrello*/
   public void addCarr(int cod_prod) throws SQLException, ClassNotFoundException {
        Prodotto p=new Prodotto();
        p=Prodotto.dett(cod_prod);
        this.carrello.add(p);
        /*incrementa il contatore*/
        this.count++;
   } 
   /*metodo che calcola il totale dei prodotti presenti nel carrello*/
   public void calcTot() {
      tot=0;
      /*scorrimanto dell'array*/
      for (int i=0;i<carrello.size();i++) {
          /*aggiunta del prezzo dell'i-esimo prodotto al totale*/
          tot=tot+carrello.get(i).getPrezzo();
      }  
   }
   /*metodo che consente di eliminare i prodotti dal carrello*/
   public void eliminaPro(int cod_prod) {
         /*scorrimento dell'array*/
         for(int i=0;i<carrello.size();i++)
         {
             /*se il codice dell'iesimo prodotto del carrello è uguale a quello da eliminare */
             if(carrello.get(i).getCod_prod()==cod_prod)
                 /*elimina il prodotto e decrementa il contatore*/
             {   carrello.remove(i);
                 this.count--;
             }
         }
    
     }
   /*metodo che ripristina l'oggetto Carr*/
   public void ripristina()
   {
       this.carrello=new ArrayList<Prodotto>();
       this.tot=0;
       this.count=0;
   }
  
}