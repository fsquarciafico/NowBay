/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtri;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.*;


public class Logging implements Filter {
    
    private String path="/Users/antonioranaudo/NetBeansProjects/JustVintage/web/text/log.txt";
   
   public Logging() {
    }    
    
    private void doBeforeProcessing(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        String uri=((HttpServletRequest)request).getRequestURI();
         //crea l'oggetto PrintStream per la lettura da file
         PrintStream pr=new PrintStream(new BufferedOutputStream(new FileOutputStream(path,true)));
         //crea un buffer di stringhe
         StringBuffer buf = new StringBuffer();
         //stampa sul file di log la provenienza delle richieste
         pr.println("richiesta proveniente da:"+uri);
         for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
             String name = (String)en.nextElement();
             Object value = request.getParameter(name);
             //salva sul buffer l'utente
             buf.append(name);
             buf.append("=");
             buf.append(value);
             //stampa il buffer sul file
             pr.println(" parametri: "+buf.toString());
         }
         pr.close();
    }    
    
    private void doAfterProcessing(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        PrintStream pr=new PrintStream(new BufferedOutputStream(new FileOutputStream(path,true)));
        for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
            String name = (String)en.nextElement();
            Object value = request.getAttribute(name);
            StringBuffer buf = new StringBuffer();
            buf.append(name);
            buf.append("=");
            buf.append(value);
            pr.println(" attributi: "+buf.toString());
        }
        pr.close();
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        doBeforeProcessing(request, response);
        chain.doFilter(request, response);
        doAfterProcessing(request, response);
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
        
    }
}
