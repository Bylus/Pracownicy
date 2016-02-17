/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pracownicy;

import java.sql.*;

/**
 *
 * @author Szymon
 */
public class DataBase {
    
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private static final String URL = "jdbc:mysql://149.156.136.151:3306/szbylica";
    
    public void insert(Worker worker){
        try {
            
        } catch (Exception e) {
            System.out.println(e);
        }

    }    
    
}
