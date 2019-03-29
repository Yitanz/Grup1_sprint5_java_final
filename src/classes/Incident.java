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
    private String name_state;
    private String title;
    private String descript;
    private String id_priority;
    private String id_user_report;
    private String id_user_assign;

    public Incident(String name_state, String title, String descript, String id_priority, String id_user_report, String id_user_assign) {
        this.name_state = name_state;
        this.title = title;
        this.descript = descript;
        this.id_priority = id_priority;
        this.id_user_report = id_user_report;
        this.id_user_assign = id_user_assign;
    }

    public void setName_state(String name_state) {
        this.name_state = name_state;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public void setId_priority(String id_priority) {
        this.id_priority = id_priority;
    }

    public void setId_user_report(String id_user_report) {
        this.id_user_report = id_user_report;
    }

    public void setId_user_assign(String id_user_assign) {
        this.id_user_assign = id_user_assign;
    }

    public String getName_state() {
        return name_state;
    }

    public String getTitle() {
        return title;
    }

    public String getDescript() {
        return descript;
    }

    public String getId_priority() {
        return id_priority;
    }

    public String getId_user_report() {
        return id_user_report;
    }

    public String getId_user_assign() {
        return id_user_assign;
    }
}
