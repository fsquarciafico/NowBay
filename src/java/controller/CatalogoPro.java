/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;



public class CatalogoPro extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,  ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
          String tip=(String)request.getParameter("tipo");
          /*se non è stata settata la variabile tipo*/
          if(tip==null) {
              /*invoca il metodo della classe Prodotti
              * che restituisce l'arraylist contenente tutti i 
              *prodotti presenti nel database*/
              ArrayList<Prodotto> pro=Prodotto.getCatProd();
              int c;
              c = Prodotto.countPro();
              request.setAttribute("catPro", pro);
              request.setAttribute("count", c);
              RequestDispatcher dispatcher = request.getRequestDispatcher("catalogo.jsp");
              dispatcher.forward(request, response);
          }
          /*altrimenti, l'utente ha richiesto di vedere
           * nel catalogo solo una determinata categoria di
           * prodotti e invoca il metodo della classe Prodotti
           * che restituisce l'arraylist di prodotto 
           * per una determinata categoria*/
          else {
            ArrayList<Prodotto> pro=Prodotto.getCatProdxtipo(tip);
            int c;
            c = Prodotto.countPro();
            request.setAttribute("catPro", pro); /*passo alla jsp l'array di prodotti*/
            request.setAttribute("count", c); /*passo alla jsp il conteggio dei prodotti*/
            RequestDispatcher dispatcher = request.getRequestDispatcher("catalogo.jsp");
            dispatcher.forward(request, response);
          }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            try {
                processRequest(request, response);
            } catch (InstantiationException ex) {
                Logger.getLogger(CatalogoPro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(CatalogoPro.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CatalogoPro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CatalogoPro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            try {
                processRequest(request, response);
            } catch (InstantiationException ex) {
                Logger.getLogger(CatalogoPro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(CatalogoPro.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CatalogoPro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CatalogoPro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
