/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Hanna Sha
 */
public class Student {
    
    private String firstname;
    private String middlename;
    private String lastname;
    private float comm_skill_ave;
    private float work_attitude_ave;
    private float overall_ave;

    public Student() {
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getComm_skill_ave() {
        return comm_skill_ave;
    }

    public void setComm_skill_ave(float comm_skill_ave) {
        this.comm_skill_ave = comm_skill_ave;
    }

    public float getWork_attitude_ave() {
        return work_attitude_ave;
    }

    public void setWork_attitude_ave(float work_attitude_ave) {
        this.work_attitude_ave = work_attitude_ave;
    }

    public float getOverall_ave() {
        return overall_ave;
    }

    public void setOverall_ave(float overall_ave) {
        this.overall_ave = overall_ave;
    }
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }  
}
