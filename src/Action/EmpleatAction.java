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
import java.util.ArrayList;

/**
 *
 * @author ivan
 */
public class EmpleatAction {

    public static String registerEmployee(Employee prov) {
        String result = null, last = null;
        DBEmployee connect = new DBEmployee();
        Connection cn = connect.getConnect();
        PreparedStatement pst = null;
        String sql = "INSERT INTO users values(null, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
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
            if (rs.next()) {
                last = rs.getString(1);
            }
            result = "Empleat registrat amb exit, ID:" + last;
        } catch (SQLException e) {
            result = "Error en la consulta: " + e.getMessage();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                    pst.close();
                }
            } catch (Exception e) {
                result = "Error: " + e;
            }
        }
        return result;
    }

    public static String updateEmployee(Employee prov) {
        String result = null, last = null;
        DBEmployee connect = new DBEmployee();
        Connection cn = connect.getConnect();
        PreparedStatement pst = null;
        String sql = "UPDATE users SET nom=?,cognom1=?,cognom2=?,email=?,email_verified_at=?,password=?,data_naixement=?,adreca=?,ciutat=?,provincia=?,codi_postal=?,tipus_document=?,numero_document=?,sexe=?,telefon=?,id_rol=?,id_dades_empleat=? WHERE id=?  ";
        try {
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
            result = "Empleat modificat amb exit, ID:" + last;
        } catch (SQLException e) {
            result = "Error en la consulta: " + e.getMessage();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                    pst.close();
                }
            } catch (Exception e) {
                result = "Error: " + e;
            }
        }
        return result;
    }

    public static Employee searchEmployee(String clave) {
        Employee prov = new Employee();
        DBEmployee connect = new DBEmployee();
        Connection cn = connect.getConnect();
        PreparedStatement pst = null;
        String sql = "SELECT * FROM users WHERE id = ?";
        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, clave);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                prov.setId(Integer.parseInt(rs.getString(1)));
                prov.setNom(rs.getString(2));
                prov.setCognom1(rs.getString(3));
                prov.setCognom2(rs.getString(4));
                prov.setEmail(rs.getString(5));
                prov.setEmail_verified_at(rs.getTimestamp(6));
                prov.setPassword(rs.getString(7));
                prov.setData_naixement(rs.getDate(8));
                prov.setAdreca(rs.getString(9));
                prov.setCiutat(rs.getString(10));
                prov.setProvincia(rs.getString(11));
                prov.setCodi_postal(rs.getString(12));
                prov.setTipus_document(rs.getString(13));
                prov.setNumero_document(rs.getString(14));
                prov.setSexe(rs.getString(15));
                prov.setTelefon(rs.getString(16));
                prov.setId_rol(rs.getInt(17));
                prov.setId_dades_empleat(rs.getInt(18));

            }

            prov.setResultat("Cerca exitosa");

        } catch (SQLException e) {
            prov.setResultat("Error en la consulta: " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                    pst.close();
                }
            } catch (Exception e) {
                prov.setResultat("Error: " + e);
            }
        }
        return prov;
    }

    public static String deleteEmployee(String clave) {
        String result = null;
        DBEmployee connect = new DBEmployee();
        Connection cn = connect.getConnect();
        PreparedStatement pst = null;
        String sql = "UPDATE users SET email_verified_at = null WHERE id = ?";

        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, clave);
            pst.executeQuery();

            result = "Empleat donat de baixa";

        } catch (SQLException e) {
            result = "Error en la consulta: " + e.getMessage();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                    pst.close();
                }
            } catch (Exception e) {
                result = "Error: " + e;
            }
        }
        return result;
    }

    public static ArrayList<Employee> getListEmployee() {
        ArrayList<Employee> arrProv = new ArrayList<Employee>();
        DBEmployee connect = new DBEmployee();
        Connection cn = connect.getConnect();
        PreparedStatement pst = null;
        Employee prov = null;
        String sql = "SELECT * FROM users";
        try {
            pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                prov = new Employee();
                prov.setId(Integer.parseInt(rs.getString(1)));
                prov.setNom(rs.getString(2));
                if (arrProv.isEmpty()) {
                    arrProv.add(0, prov);
                } else {
                    arrProv.add(prov);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                    pst.close();
                }
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
        return arrProv;
    }
}
