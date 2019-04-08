/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author root
 */
public class Incident {

    private int name_state;
    private String title;
    private String descript;
    private int id_priority;
    private int id_user_report;
    private int id_user_assign;
    private int id;
    private String resultat;

    public Incident() {
    }

    public Incident(String title, String descript, int state, int id_priority) {
        this.title = title;
        this.descript = descript;
        this.id_priority = id_priority;
        this.name_state = state;
    }

    public Incident(String title, String descript, int name_state, int id_priority, int id_user_report, int id_user_assign) {

        this.name_state = name_state;
        this.title = title;
        this.descript = descript;
        this.id_priority = id_priority;
        this.id_user_report = id_user_report;
        this.id_user_assign = id_user_assign;

    }

    public Incident(int id, String title, String descript, int name_state, int id_priority) {

        this.name_state = name_state;
        this.title = title;
        this.descript = descript;
        this.id_priority = id_priority;
        this.id = id;
    }

    public Incident(int id, String title, String descript, int name_state, int id_priority, int id_user_report, int id_user_assign, String resultat) {

        this.name_state = name_state;
        this.title = title;
        this.descript = descript;
        this.id_priority = id_priority;
        this.id_user_report = id_user_report;
        this.id_user_assign = id_user_assign;
        this.id = id;
        this.resultat = resultat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName_state(int name_state) {

        this.name_state = name_state;

    }

    public void setTitle(String title) {

        this.title = title;

    }

    public void setDescript(String descript) {

        this.descript = descript;

    }

    public void setId_priority(int id_priority) {

        this.id_priority = id_priority;

    }

    public void setId_user_report(int id_user_report) {

        this.id_user_report = id_user_report;

    }

    public void setId_user_assign(int id_user_assign) {

        this.id_user_assign = id_user_assign;

    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public int getName_state() {

        return name_state;

    }

    public String getTitle() {

        return title;

    }

    public String getDescript() {

        return descript;

    }

    public int getId_priority() {

        return id_priority;

    }

    public int getId_user_report() {

        return id_user_report;

    }

    public int getId_user_assign() {

        return id_user_assign;

    }

    public int getId() {
        return id;
    }

    public String getResultat() {
        return resultat;
    }

}
