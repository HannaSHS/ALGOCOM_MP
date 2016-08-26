/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.AScores;
import model.BScores;
import model.Student;

/**
 *
 * @author Hanna Sha
 */
public class Algorithm {
    
    ArrayList<Student> studentList;
    ArrayList<AScores> aScoresList;
    ArrayList<BScores> bScoresList;
    ArrayList<Integer> idList;
    int numOfClusters;
    int size;
    
    public Algorithm(ArrayList<Student> studentList, int numOfClusters) {
        this.studentList = studentList;
        this.numOfClusters = numOfClusters;
        this.size = studentList.size();
        
        System.out.println(studentList.get(0).getFirstname());
    }
    
    public void execute(){
        
    }
    
    public void generateCenters(){
        
    }
    
    //other algos here
    
}
