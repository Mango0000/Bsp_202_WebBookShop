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
}
