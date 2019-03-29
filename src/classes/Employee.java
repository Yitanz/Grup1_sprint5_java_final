/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import java.util.Date;
import java.sql.Timestamp;
/**
 *
 * @author root
 */
public class Employee {
    private int id;
    private String nom;
    private String cognom1;
    private String cognom2;
    private String email;
    private Timestamp email_verified_at;
    private String password;
    private Date data_naixement;
    private String adreca;
    private String ciutat;
    private String provincia;
    private String codi_postal;
    private String tipus_document;
    private String numero_document;
    private String sexe;
    private String telefon;
    private int id_rol;
    private int id_dades_empleat;
    private 

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom1() {
        return cognom1;
    }

    public String getCognom2() {
        return cognom2;
    }

    public String getEmail() {
        return email;
    }

    public Timestamp getEmail_verified_at() {
        return email_verified_at;
    }

    public String getPassword() {
        return password;
    }

    public Date getData_naixement() {
        return data_naixement;
    }

    public String getAdreca() {
        return adreca;
    }

    public String getCiutat() {
        return ciutat;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getCodi_postal() {
        return codi_postal;
    }

    public String getTipus_document() {
        return tipus_document;
    }

    public String getNumero_document() {
        return numero_document;
    }

    public String getSexe() {
        return sexe;
    }

    public String getTelefon() {
        return telefon;
    }

    public int getId_rol() {
        return id_rol;
    }

    public int getId_dades_empleat() {
        return id_dades_empleat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmail_verified_at(Timestamp email_verified_at) {
        this.email_verified_at = email_verified_at;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setData_naixement(Date data_naixement) {
        this.data_naixement = data_naixement;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setCodi_postal(String codi_postal) {
        this.codi_postal = codi_postal;
    }

    public void setTipus_document(String tipus_document) {
        this.tipus_document = tipus_document;
    }

    public void setNumero_document(String numero_document) {
        this.numero_document = numero_document;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public void setId_dades_empleat(int id_dades_empleat) {
        this.id_dades_empleat = id_dades_empleat;
    }

    @Override
    public String toString() {
        return "Employee{" + "nom=" + nom + ", email=" + email + '}';
    }
    
    
}
