/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;

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
    ArrayList<List<Student>> clusterList;
    
    double[] centers;
    int numOfClusters;
    int size;
    int clusterSize;
    
    public Algorithm(ArrayList<Student> studentList, int numOfClusters) {
        this.studentList = studentList;
        this.numOfClusters = numOfClusters;
        this.size = studentList.size();
        this.clusterList = new ArrayList();
        this.clusterSize = size/numOfClusters;
        
        System.out.println("Expected number of students per cluster: " + clusterSize);
    }
    
    public void execute(){
    	generateCenters();
    	
    	/*initialize clusters*/
		for(int i = 0; i < numOfClusters; i++) {
			List<Student> cluster = new ArrayList();
			clusterList.add(cluster);
		}
  	
		boolean z = true;
		
    	while(z) {
//		   	clear clusters
			System.out.println();
    		for(int k = 0; k < clusterList.size(); k++) {
    			clusterList.get(k).clear();
    		}
   		
    		System.out.println();
    		for(int j = 0; j < size; j++) {
    			Student stude = studentList.get(j);	//get student
    			double mark = stude.getaScores();	//get student ascore
    			
    			//find the center such that it is the center closest to mark
    			double distance = Math.abs(centers[0] - mark);
    			int index = 0;
    			for(int k = 1; k < centers.length; k++) {
    				double cdistance = Math.abs(centers[k] - mark);
    				if(cdistance < distance) {
    					index = k;
    					distance = cdistance;
    				}
    			}
    			clusterList.get(index).add(stude);
    		}
    		
    		if(recalculateCenters()) {
    			z = false;
    		}
    	}
    	
    	equalizeClusters();
    }
    
    public void generateCenters(){
    	int min = 0, max = 0;
    	double interval = 0.00;
    	
        for(int i = 0; i < studentList.size() - 1; i++) {
        	min = Math.min(studentList.get(i).getaScores(), studentList.get(i+1).getaScores());	//determine minimum mark from ascores
        	max = Math.max(studentList.get(i).getaScores(), studentList.get(i+1).getaScores());	//determine maximum mark from ascores
        }
        
        centers = new double[numOfClusters];	//initialize centers array
        
        interval = ((double) (max - min))/numOfClusters;	
        
        centers[0] = (min + (interval/2));	//make this as the first center
        
        for(int j = 1; j < centers.length; j++) {
        	centers[j] = centers[j-1] + interval;
        }  
    }
    
    public boolean recalculateCenters() {
    	boolean flag = true;
    	
    	System.out.println();
    	for(int i = 0; i < clusterList.size(); i++) {
    		double sum = 0;
    		double average = 0;
    		for(int j = 0; j < clusterList.get(i).size(); j++) {
    			Student stude = clusterList.get(i).get(j);
    			sum += stude.getaScores();
    		}
    		System.out.println("Cluster Size: " + clusterList.get(i).size());
    		average = sum/((double) clusterList.get(i).size());
//    		System.out.println("Average: " + average);
    		if(average != centers[i] && average == Double.NaN) {
    			centers[i] = average;
    			flag = false;
    		}
    	}
    	return flag;
    }
    
    public void equalizeClusters() {
    	for(int i = clusterList.size() - 1; i >= 1; i--) {
    		List<Student> extras = new ArrayList();
//    		System.out.println(clusterList.get(i).size());
    		if(clusterList.get(i).size() > clusterSize) {
    			int numExtras = clusterList.get(i).size() - clusterSize;
//    			System.out.println(numExtras);
    			for(int a = 0; a < numExtras; a++) {
    				double distance = centers[i];
//    				System.out.println("Distance: " + distance);
        			int index = 0;
        			
        			for(int j = 0; j < clusterList.get(i).size(); j++) {
        				Student stude = clusterList.get(i).get(j);	//get student
            			double mark = stude.getaScores();	//get student ascore

            			double cdistance = Math.abs(centers[i-1] - mark);
            			
//            			System.out.println("Distance: " + distance + "\tCDistance: " + cdistance);
            			if(cdistance < distance) {
            				index = j;
            				distance = cdistance;
            			}
        			}
        			extras.add(clusterList.get(i).get(index));
        			clusterList.get(i).remove(index);
        			System.out.println("Extras: " + extras.size());
    			}	
    		} 		
    		clusterList.get(i - 1).addAll(extras);
    	}

		recalculateCenters();
		
		for(int a = 0; a <= clusterList.size() - 2; a++) {
			List<Student> extras = new ArrayList();
//    		System.out.println(clusterList.get(i).size());
    		if(clusterList.get(a).size() > clusterSize) {
    			int numExtras = clusterList.get(a).size() - clusterSize;
//    			System.out.println(numExtras);
    			for(int z = 0; z < numExtras; z++) {
    				double distance = centers[a];
//    				System.out.println("Distance: " + distance);
        			int index = 0;
        			
        			for(int b = 0; b < clusterList.get(a).size(); b++) {
        				Student stude = clusterList.get(a).get(b);	//get student
            			double mark = stude.getaScores();	//get student ascore

            			double cdistance = Math.abs(centers[a+1] - mark);
            			
//            			System.out.println("Distance: " + distance + "\tCDistance: " + cdistance);
            			if(cdistance < distance) {
            				index = b;
            				distance = cdistance;
            			}
        			}
        			extras.add(clusterList.get(a).get(index));
        			clusterList.get(a).remove(index);
//        			System.out.println("Extras: " + extras.size());
    			}	
    		}
    		clusterList.get(a + 1).addAll(extras);
		}
    	
		for(int y = 0; y < clusterList.size(); y++) {
			System.out.println("New Cluster Size: " + clusterList.get(y).size());
		}
    }
}
