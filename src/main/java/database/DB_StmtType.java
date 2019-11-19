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

    GET_BOOKS("SELECT * FROM Books;");
    
    private DB_StmtType(String sqlstring) {
        this.sqlstring = sqlstring;
    }

    public String getSqlstring() {
        return sqlstring;
    }
    
    private String sqlstring;
}
