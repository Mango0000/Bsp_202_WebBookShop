/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author manue
 */
public enum DB_StmtType {

    GET_BOOKS("SELECT title, price, firstname || ' ' || lastname AS name\n" +
              "FROM bookauthor ba INNER JOIN book b ON ba.book_id = b.book_id\n" +
              "                   INNER JOIN author a ON ba.author_id = a.author_id;"),
    GET_BOOKS_FROM_AUTHOR("SELECT firstname, lastname, title\n" +
                          "FROM bookauthor ba INNER JOIN author a ON ba.author_id = a.author_id\n" +
                          "                   INNER JOIN book b ON ba.book_id = b.book_id\n"+
                          "WHERE firstname = ?");
    
    private DB_StmtType(String sqlstring) {
        this.sqlstring = sqlstring;
    }

    public String getSqlstring() {
        return sqlstring;
    }
    
    private String sqlstring;
}
