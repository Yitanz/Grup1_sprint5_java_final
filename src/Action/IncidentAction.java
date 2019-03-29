/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;
import classes.Incident;
import connect.DBIncident;
import java.sql.Connection;
import java.sql.PreparedStatement;


/**
 *
 * @author manel
 */
public class IncidentAction {
    public static String registerIncident(Incident incidencia ){
        
        String result = null, lats = null;
        DBIncident cc = new DBIncident ();
        
        Connection cn = new cc;
        
        PreparedStatement path = null;
        
        
    }
}
