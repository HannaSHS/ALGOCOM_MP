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
public class AScores {
    int communicationSkills;
    int groupWork;
    int summation;

    public AScores(int communicationSkills, int groupWork) {
        this.communicationSkills = communicationSkills;
        this.groupWork = groupWork;
        this.summation = this.communicationSkills + this.groupWork;
    }
    
    public int getAScores(){
        return summation;
    }
}
