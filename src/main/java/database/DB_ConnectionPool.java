/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import static database.DB_Config.DB_DRIVER;
import static database.DB_Config.DB_NAME;
import static database.DB_Config.DB_PASSWORD;
import static database.DB_Config.DB_URL;
import static database.DB_Config.DB_USER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manue
 */
public class DB_ConnectionPool {
    private static DB_ConnectionPool theInstance = null;
    private LinkedList<Connection> connPool = new LinkedList<>();
    private final int MAX_CON = 150;
    private int conCnt = 0;

    public static DB_ConnectionPool getInstance() {
        if(theInstance == null){
            theInstance = new DB_ConnectionPool();
        }
        return theInstance;
    }

    private DB_ConnectionPool() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Loading DB-driver failed:"+ex.toString());
        }
    }
    
    public synchronized Connection GetConnection() throws Exception{
        if(connPool.isEmpty()){
            if(MAX_CON == conCnt){
                throw new Exception("No connections available - try again later");
            }
            Connection connection = DriverManager.getConnection(DB_URL+DB_NAME,DB_USER,DB_PASSWORD);
            conCnt++;
            return connection;
        }else{
            return connPool.poll();
        }
    }
    
    public synchronized void releaseConnection(Connection connection){
        connPool.offer(connection);
    }
}
