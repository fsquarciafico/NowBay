/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;


@WebServlet(name = "Registrazione", urlPatterns = {"/Registrazione"})
public class Registrazione extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        HttpSession seUt=request.getSession();
        Utente u=(Utente)seUt.getAttribute("utente");
        String nome=request.getParameter("nome");
        String cognome=request.getParameter("cognome");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String iban=request.getParameter("iban");
        String codfisc=request.getParameter("codFisc");
        String indirizzo=request.getParameter("indirizzo");
        /*se tutti i controlli vanno a buon fine*/
        if ((Controlli.contrCode(codfisc)&&Controlli.contrEmail(email))&&((Controlli.contrPassword(password))&&Controlli.contrIban(iban))) {
            //setta gli attributi dell'oggetto
            u.setNome(nome);
            u.setCognome(cognome);
            u.setPassword(password);
            u.setE_mail(email);
            u.setCod_fis(codfisc);
            u.setIndirizzo(indirizzo);
            //crea la connessione al database
            ConnDab db=new ConnDab();
            Connection c=db.connect();
            Statement st=c.createStatement();
            //query che inserisce gli attributi dell'utente all'interno della tabella utente_reg
            st.executeUpdate("INSERT into utente_reg(e_mail,cod_fis,nome ,cognome,iban,indirizzo,password) VALUES ('"+email+"','"+codfisc+"','"+nome+"','"+cognome+"','"+iban+"','"+indirizzo+"','"+password+"')");
            c.close();
            HttpSession session = request.getSession();
            //setta la sessione utente
            session.setAttribute("currentUser", u);
            String msg="Registrazione avvenuta! Ora puoi effettuare il login!";
            request.setAttribute("mess", msg);
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
       }
       //se l'utente ha inserito dati non validi
       else {
            String msg="Dati non validi!";
            //associa al mess l'oggetto msg
            request.setAttribute("mess", msg);
            RequestDispatcher dispatcher = request.getRequestDispatcher("registrazione.jsp");
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
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Registrazione.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registrazione.class.getName()).log(Level.SEVERE, null, ex);
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
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Registrazione.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registrazione.class.getName()).log(Level.SEVERE, null, ex);
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