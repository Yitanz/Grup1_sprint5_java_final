/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBIncident {
    
    Connection connect = null;
    String url = "jdbc:mysql://localhost:3306/univeylandia_test2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user = "root";
    String password = "alumne";
     
    public DBIncident(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(url,user,password);
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public Connection getConnection(){
        return connect;
    }
    
    public void desConnect(){
        connect = null;
    }
}
