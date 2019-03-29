/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import classes.Employee;
import connect.DBEmployee;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author ivan
 */
public class EmpleatAction {
    public static String registerEmployee(Employee prov){
        String  result = null, last=null;
        DBEmployee connect =  new DBEmployee();
        Connection cn = connect.getConnect();
        PreparedStatement pst = null;
        String sql = "INSERT INTO users values(null, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            pst = cn.prepareStatement(sql);
            pst.setString(1, prov.getNom());
            pst.setString(2, prov.getCognom1());
            pst.setString(3, prov.getCognom2());
            pst.setString(4, prov.getEmail());
            pst.setTimestamp(5, prov.getEmail_verified_at());
            pst.setString(6, prov.getPassword());
            pst.setDate(7, (Date) prov.getData_naixement());
            pst.setString(8, prov.getAdreca());
            pst.setString(9, prov.getCiutat());
            pst.setString(10, prov.getProvincia());
            pst.setString(11, prov.getCodi_postal());
            pst.setString(12, prov.getTipus_document());
            pst.setString(13, prov.getNumero_document());
            pst.setString(14, prov.getSexe());
            pst.setString(15, prov.getTelefon());
            pst.setInt(16, prov.getId_rol());
            pst.setInt(17, prov.getId_dades_empleat());
            pst.execute();
            //pst = cn.prepareStatement("SELECT MAX (id) AS id FROM users");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                last = rs.getString(1);
            }
            result = "Empleat registrat amb exit, ID:"+last;
        }catch(SQLException e){
            result = "Error en la consulta: "+e.getMessage();
        }finally{
            try{
            if(cn != null){
                cn.close();
                pst.close();
            }
            }catch(Exception e){
                result = "Error: "+e;
            }
        }
        return result;
    }
    
        public static String updateEmployee(Employee prov){
        String  result = null, last=null;
        DBEmployee connect =  new DBEmployee();
        Connection cn = connect.getConnect();
        PreparedStatement pst = null;
        String sql = "UPDATE users SET nom=?,cognom1=?,cognom2=?,email=?,email_verified_at=?,password=?,data_naixement=?,adreca=?,ciutat=?,provincia=?,";
        try{
            pst = cn.prepareStatement(sql);
            pst.setString(1, prov.getNom());
            pst.setString(2, prov.getCognom1());
            pst.setString(3, prov.getCognom2());
            pst.setString(4, prov.getEmail());
            pst.setTimestamp(5, prov.getEmail_verified_at());
            pst.setString(6, prov.getPassword());
            pst.setDate(7, (Date) prov.getData_naixement());
            pst.setString(8, prov.getAdreca());
            pst.setString(9, prov.getCiutat());
            pst.setString(10, prov.getProvincia());
            pst.setString(11, prov.getCodi_postal());
            pst.setString(12, prov.getTipus_document());
            pst.setString(13, prov.getNumero_document());
            pst.setString(14, prov.getSexe());
            pst.setString(15, prov.getTelefon());
            pst.setInt(16, prov.getId_rol());
            pst.setInt(17, prov.getId_dades_empleat());
            pst.execute();
            pst = cn.prepareStatement("SELECT MAX(id) AS id FROM users");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                last = rs.getString(1);
            }
            result = "Empleat registrat amb exit, ID:"+last;
        }catch(SQLException e){
            result = "Error en la consulta: "+e.getMessage();
        }finally{
            try{
            if(cn != null){
                cn.close();
                pst.close();
            }
            }catch(Exception e){
                result = "Error: "+e;
            }
        }
        return result;
    }
}
