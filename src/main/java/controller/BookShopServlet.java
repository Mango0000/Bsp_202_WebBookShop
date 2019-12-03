/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.DB_Access;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.taglibs.standard.tei.ForEachTEI;
import pojos.Book;

/**
 *
 * @author manue
 */
@WebServlet(name = "BookShopServlet", urlPatterns = {"/BookShopServlet"})
public class BookShopServlet extends HttpServlet {
private List<Book> books = new ArrayList<>();
private List<Book> filteredbooks = new ArrayList<>();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    @Override
    public void init()
            throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        DB_Access dba = new DB_Access();
        try {
            books = dba.gettAllBooks();
            filteredbooks = books;
        } catch (Exception ex) {
            Logger.getLogger(DB_Access.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("books", filteredbooks);
        request.setAttribute("aufsteigend", "checked");
        request.setAttribute("filtert", "checked");
        request.getRequestDispatcher("WebBookShop.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("info")!=null){
            request.getRequestDispatcher("InfoPage.jsp").forward(request, response);
        }else{
        filteredbooks = books;
        Boolean filter=true;
        if(request.getParameter("filterRb")!=null){
            filter = request.getParameter("filterRb").equals("title");
        }
        String filtertext = request.getParameter("filterText").trim()+"";
        Boolean sort = false;
        if(request.getParameter("sortRb")!=null){
            sort = request.getParameter("sortRb").equals("absteigend");
        }
        String sortby = request.getParameter("sortBy")+"";
        if(filter){
            filteredbooks = filteredbooks.stream().filter(b -> b.getTitle().toLowerCase().contains(filtertext.toLowerCase())).collect(Collectors.toList());
        }else{
            filteredbooks = filteredbooks.stream().filter(b -> b.getAuthor().toLowerCase().contains(filtertext.toLowerCase())).collect(Collectors.toList());
        }
        
        if(sortby.equals("Title")){
            filteredbooks.sort(Comparator.comparing(Book::getTitle));
        }else if(sortby.equals("Price")){
            filteredbooks.sort(Comparator.comparing(Book::getPrice));
        }else{
            filteredbooks.sort(Comparator.comparing(Book::getAuthor));
        }
        if(sort){
           //request.setAttribute("absteigend", "checked");
           Collections.reverse(filteredbooks);
        }
        request.setAttribute("absteigend", sort ? "checked" : "unchecked");
        request.setAttribute("aufsteigend", sort ? "unchecked" : "checked");
        request.setAttribute("filtert", filter ? "checked" : "unchecked");
        request.setAttribute("filtera", filter ? "unchecked" : "checked");
        request.setAttribute("books", filteredbooks);
        request.setAttribute("filter", filtertext);
        request.getRequestDispatcher("WebBookShop.jsp").forward(request, response);
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
