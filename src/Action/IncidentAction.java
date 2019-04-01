/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import classes.Incident;
import com.mysql.cj.protocol.Resultset;
import connect.DBIncident;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author manel
 */
public class IncidentAction {

    public static String registerIncident(Incident incidencia) {
        String result;
        ResultSet rs;
        String lats = null;
        DBIncident cc = new DBIncident();

        Connection cn = cc.getConnection();
        String sql = "insert into incidencies (titol,descripcio,id_prioritat,id_estat,id_usuari_reportador,id_usuari_assignat) values(title,description,id_priority,id_state,id_user_report,id_user_assing)";

        PreparedStatement path = null;

        try {

            path = cn.prepareStatement(sql);
            path.setString(1, incidencia.getTitle());
            path.setString(2, incidencia.getDescript());
            path.setInt(1, incidencia.getId_priority());
            path.setInt(1, incidencia.getName_state());
            path.setInt(1, incidencia.getId_user_report());
            path.setInt(1, incidencia.getId_user_assign());

            path.execute();

            path = cn.prepareStatement("select id from incidencies;");
            rs = path.executeQuery();

            if (rs.next()) {
                lats = rs.getString(1);
            }

            result = "Incidència registrada amb exit" + lats;

        } catch (SQLException e) {

            result = "Error al inserir dades" + e.getMessage();

        } finally {

            try {
                if (cn != null) {
                    cn.close();
                    path.close();
                }

            } catch (Exception e) {
                result = "Error al tanca la conexió després d'inserir dades" + e.getMessage();
            }
        }
        return result;
    }

    public static String updateIncident(Incident incidencia) {
        String result;
        ResultSet rs;
        String lats = null;
        DBIncident cc = new DBIncident();

        Connection cn = cc.getConnection();
        String sql = "update incidencies set titol?,descripcio?,id_prioritat?,id_estat?,id_usuari_reportador?,id_usuari_assignat? where id = ? ";
        PreparedStatement path = null;

        try {

            path = cn.prepareStatement(sql);
            path.setString(1, incidencia.getTitle());
            path.setString(2, incidencia.getDescript());
            path.setInt(3, incidencia.getId_priority());
            path.setInt(4, incidencia.getName_state());
            path.setInt(5, incidencia.getId_user_report());
            path.setInt(6, incidencia.getId_user_assign());
            path.setInt(7, incidencia.getId());

            path.execute();

            result = "Incidencia actualitzada correctament" + incidencia.getId();

        } catch (SQLException e) {

            result = "Error al actualitzar les dades" + e.getMessage();

        } finally {

            try {
                if (cn != null) {
                    cn.close();
                    path.close();
                }

            } catch (Exception e) {
                result = "Error al tanca la conexió després d'actulitzar les dades" + e.getMessage();
            }
        }
        return result;
    }

    public static Incident searchIncident(int key) {

        String result;
        ResultSet rs;
        DBIncident cc = new DBIncident();
        Incident incidencia = new Incident();

        Connection cn = cc.getConnection();
        String sql = "select * from incidencies where id=?;";
        PreparedStatement path = null;

        try {

            path = cn.prepareStatement(sql);
            path.setInt(1, key);
            rs = path.executeQuery();

            if (rs.next()) {
                incidencia.setId(rs.getInt(1));
                incidencia.setTitle(rs.getString(2));
                incidencia.setId_priority(rs.getInt(3));
                incidencia.setName_state(rs.getInt(4));
                incidencia.setId_user_report(rs.getInt(5));
                incidencia.setId_user_assign(rs.getInt(6));
            }
            
            incidencia.setResultat("Element trobat satisfactoriament");

        } catch (SQLException e) {

            incidencia.setResultat("Error al buscar l'incidència"+e );

        } finally {

            try {
                if (cn != null) {
                    cn.close();
                    path.close();
                }

            } catch (Exception e) {
            incidencia.setResultat("Error al tancar la conexió" );
            }
        }
        return incidencia;
    }
    
        public static String deleteIncident(int key) {

        String result;
        DBIncident cc = new DBIncident();
        Incident incidencia = new Incident();
        PreparedStatement path = null;
        Connection cn = cc.getConnection();
        String sql = "delete from incidencies where id=?;";

        try {

            path = cn.prepareStatement(sql);
            path.setInt(1, key);
            path.executeUpdate();
            
            result = "Incidencia eliminada correctament";

        } catch (SQLException e) {

            result = ("Error al buscar l'incidència"+e );

        } finally {

            try {
                if (cn != null) {
                    cn.close();
                    path.close();
                }

            } catch (Exception e) {
            result = ("Error al tancar la conexió" );
            }
        }
        return result;
    }
        
    public static ArrayList<Incident> getList(){
        
        ArrayList<Incident>incidentList = new ArrayList<Incident>();
        PreparedStatement path = null;
        ResultSet rs ;
        DBIncident cc = new DBIncident();
        Connection cn = cc.getConnection();
        String sql = "select * from incidencies;";
        Incident incidentOb = null;
        
        try {

            path = cn.prepareStatement(sql);
            rs = path.executeQuery();

            while(rs.next()) {
                
                incidentOb = new Incident();
                
                incidentOb.setId(rs.getInt(1));
                incidentOb.setTitle(rs.getString(2));
                incidentOb.setId_priority(rs.getInt(3));
                incidentOb.setName_state(rs.getInt(4));
                incidentOb.setId_user_report(rs.getInt(5));
                incidentOb.setId_user_assign(rs.getInt(6));
                
                if(incidentList.isEmpty()){
                    incidentList.add(incidentOb);
                }
            }
            
        } catch (SQLException e) {

            System.out.println("Error al buscar l'incidència"+e );

        } finally {

            try {
                if (cn != null) {
                    cn.close();
                    path.close();
                }

            } catch (Exception e) {
            System.out.println("Error al tancar la conexió" );
            }
        }        
        return incidentList;
    }
    
}
