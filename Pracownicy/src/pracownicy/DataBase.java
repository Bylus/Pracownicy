/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pracownicy;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Szymon
 */
public class DataBase {
    
    private static String NAME = "baza.db";
    
    public DataBase(){
        createTable();
    }
    
    /**
    * @desc add worker to sql database
    * @param - Worker worker
    */
    public void insertWorker(Worker worker){

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + this.NAME);

            stmt = c.createStatement();
            String sql = "INSERT INTO WORKER(ID_WORKER, NAME, NAME, SURNAME, YEAR, MONTH, "
                                       + "DAY, SALARY, BONUS, STARTYEAR, COMPANY, POSITION)" +
                       "VALUES(NULL, " + worker.getName() +
                       ", '" + worker.getSurname() +
                       "', '" + worker.getYear() +
                       "', '" + worker.getMonth() +
                       "', '" + worker.getDay() +
                       "', '" + worker.getSalary() +
                       "', '" + worker.getBonus() +
                       "', '" + worker.getStartyear() +
                       "', '" + worker.getCompany() +
                       "', '" + worker.getPosition() +
                       "');"; 
            stmt.executeUpdate(sql);
           
            stmt.close();
            c.close();
        } catch ( Exception exc ) {
            System.err.println( exc.getClass().getName() + ": " + exc.getMessage() );
            System.exit(0);
        }        
    }
    
    /**
    * @desc get all workers from database
    * @return - ArrayList<Worker> - List of all workers
    */
    public ArrayList<Worker> getWorkers(){
           
        Connection c = null;
        Statement stmt = null;
        ArrayList<Worker> lista = new ArrayList<>();
        Worker  worker;
        
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + this.NAME);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM WORKER" );
            
            while ( rs.next() ) {       
                worker = new Worker(rs.getString("NAME"), rs.getString("SURNAME"), rs.getString("YEAR"),
                                    rs.getString("MONTH"), rs.getString("DAY"), rs.getString("SALARY"),
                                    rs.getString("BONUS"), rs.getString("STARTYEAR"),
                                    rs.getString("COMPANY"), rs.getString("POSITION"));                
                lista.add(worker);
            }
            
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception exc ) {
            System.err.println( exc.getClass().getName() + ": " + exc.getMessage() );
            System.exit(0);
        }
        return lista;
    }
    
    /*
    * @desc creates database if not exists
    */   
    public void createTable(){
        
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + this.NAME);

            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS WORKER " +
                         "(ID_WORKER      INTEGER PRIMARY KEY AUTOINCREMENT," +
                         " NAME           TEXT     NOT NULL, " + 
                         " SURNAME        TEXT    NOT NULL, " + 
                         " YEAR           TEXT    NOT NULL, " + 
                         " MONTH          TEXT    NOT NULL, " + 
                         " DAY            TEXT    NOT NULL, " + 
                         " SALARY         TEXT    NOT NULL, " + 
                         " BONUS          TEXT     NOT NULL, " + 
                         " STARTYEAR      TEXT     NOT NULL, " + 
                         " COMPANY        TEXT     NOT NULL, " + 
                         " POSITION       TEXT     NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception exc ) {
            System.err.println( exc.getClass().getName() + ": " + exc.getMessage() );
            System.exit(0);
        }        
    }
    
}
