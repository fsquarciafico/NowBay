/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtri;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class Manutenzione implements Filter {
    
    private String user = null;
    private String pw = null;
    private boolean stato = false;
    
    public Manutenzione() {
    }    
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String manutenzione = request.getParameter("manutenzione");
        int man = 0;
        //controlla che la variabile manutenzione sia settata
        if (manutenzione != null) {
            man = Integer.parseInt(manutenzione);
        }
        String nome = (String) request.getParameter("name");
        String password = (String) request.getParameter("password");
        //controlla che nome e password siano settati
        if (nome != null && password != null) {
            //se username e password corrispondono a quelli dell'amministratore
            if (nome.equalsIgnoreCase(user) && password.equalsIgnoreCase(pw)) {
                //se ha impostato la manutenzione imposta lo stato a 1 altrimenti a zero
                if (man == 1) {
                    stato = true;
                } else {
                    stato = false;
                    RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("manutenzione.jsp" + "?stato=" + stato);
            dispatcher.forward(request, response);
            return;
        }
        if (!stato) { /* non sono in manutenzione*/  
            chain.doFilter(request, response); /**/
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("manutenzione.jsp" + "?stato=" + stato);
            dispatcher.forward(request, response);
        }
    }
    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        this.user = filterConfig.getInitParameter("name");
        this.pw = filterConfig.getInitParameter("password");
        }
}