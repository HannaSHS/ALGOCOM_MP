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
    
    private int id;
    private String firstname;
    private String middlename;
    private String lastname;
    private AScores aScores;
    private BScores bScores;
    
    public Student(int id, String firstname, String middlename, String lastname, AScores aScores, BScores bScores) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.aScores = aScores;
        this.bScores = bScores;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    public int getaScores() {
        return aScores.getAScores();
    }

    public int getbScores() {
        return bScores.getBScores();
    }
}
