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
import java.sql.SQLException;

/**
 *
 * @author manel
 */
public class IncidentAction {

    public static String registerIncident(Incident incidencia) {

        String result = null, lats = null;
        DBIncident cc = new DBIncident();

        Connection cn = cc.getConnection();
        String sql = "insert into incidencies (titol,descripcio,id_prioritat,id_estat,id_usuari_reportador,id_usuari_assignat) values(title,description,id_priority,id_state,id_user_report,id_user_assing)";

        PreparedStatement path = null;

        try {

            path = cn.prepareStatement(sql);
            path.setString(1, incidencia.getTitle());
            path.setString(2, incidencia.getDescript());
            path.setString(1, incidencia.getId_priority());
            path.setString(1, incidencia.getName_state());
            path.setString(1, incidencia.getId_user_report());
            path.setString(1, incidencia.getId_user_assign());

            path.execute();

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
        return;
    }
}
