/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.Author;
import pojos.Book;

/**
 *
 * @author manue
 */
public class DB_Access {
    DB_PStatPool pStatPool = DB_PStatPool.getInstance();
    
    /*public List<Book> getAllBooksFromAuthor() throws Exception{
        PreparedStatement pStat = pStatPool.getPStat(DB_StmtType.GET_BOOKS_FROM_AUTHOR);
        pStat.setString(1, "Bill");
        ResultSet rs = pStat.executeQuery();
        List<Book> bookList = new ArrayList<>();
        String firstname, lastname, title;
        while (rs.next()) {
            firstname = rs.getString("firstname");
            lastname = rs.getString("lastname");
            title = rs.getString("title");
            bookList.add(new Book(firstname, lastname, title));
        }
        return bookList;
    }*/
    
    public List<Book> gettAllBooks() throws Exception{
        PreparedStatement pStat = pStatPool.getPStat(DB_StmtType.GET_BOOKS);
        ResultSet rs = pStat.executeQuery();
        List<Book> bookList = new ArrayList<>();
        List<String> authors = new ArrayList<>();
        rs.next();
        String title = rs.getString("title");
        double price = rs.getDouble("price");
        int pubid = rs.getInt("publisher_id");
;        authors.add(rs.getString("name"));
        rs.next();
        int i=0;
        while(rs.next()){
            if(title.equals(rs.getString("title"))){
                authors.add(rs.getString("name"));
            }else{
                bookList.add(new Book(authors, title, price, i, pubid));
                authors = new ArrayList<>();
                title = rs.getString("title");
                price = rs.getDouble("price");
                pubid = rs.getInt("publisher_id");
                authors.add(rs.getString("name"));
                i++;
            }
        }
        return bookList;
    }
}
