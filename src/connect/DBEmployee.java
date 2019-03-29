/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author root
 */
public class DBEmployee {
    Connection connect = null;
    String url = "jdbc:mysql://localhost:3306/univeylandia_laravel";
    String user = "root";
    String password = "alumne";
    
    public DBEmployee(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, password);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public Connection getConnect(){
        return connect;
    }
    
    public void disconnect(){
        connect = null;
    }
    
}
