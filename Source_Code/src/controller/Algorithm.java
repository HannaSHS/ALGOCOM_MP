/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import model.AScores;
import model.BScores;
import model.Range;
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

    List<Range> rangeList;

    double[] centers, initialDOH;
    int[] freqCount;
    int numOfClusters;
    int size;
    int clusterSize;

    public Algorithm(ArrayList<Student> studentList, int numOfClusters) {
        this.studentList = studentList;
        this.numOfClusters = numOfClusters;
        this.size = studentList.size();
        this.clusterList = new ArrayList();
        this.clusterSize = size / numOfClusters;

        this.initRange();
    }

    public void initRange() {
        this.rangeList = new ArrayList();

        rangeList.add(new Range(0, 10));
        rangeList.add(new Range(11, 20));
        rangeList.add(new Range(21, 30));
        rangeList.add(new Range(31, 40));
        rangeList.add(new Range(41, 50));
        rangeList.add(new Range(51, 60));
        rangeList.add(new Range(61, 70));
        rangeList.add(new Range(71, 80));
        rangeList.add(new Range(81, 90));
        rangeList.add(new Range(91, 100));
    }

    public void execute() {
        generateCenters();

        /*initialize clusters*/
        for (int i = 0; i < numOfClusters; i++) {
            List<Student> cluster = new ArrayList();
            clusterList.add(cluster);
        }

        boolean z = true;

        while (z) {
//		   	clear clusters
            System.out.println();
            for (int k = 0; k < clusterList.size(); k++) {
                clusterList.get(k).clear();
            }

            System.out.println();
            for (int j = 0; j < size; j++) {
                Student stude = studentList.get(j);	//get student
                double mark = stude.getaScores();	//get student ascore

                //find the center such that it is the center closest to mark
                double distance = Math.abs(centers[0] - mark);
                int index = 0;
                for (int k = 1; k < centers.length; k++) {
                    double cdistance = Math.abs(centers[k] - mark);
                    if (cdistance < distance) {
                        index = k;
                        distance = cdistance;
                    }
                }
                clusterList.get(index).add(stude);
            }

            if (recalculateCenters()) {
                z = false;
            }
        }

        equalizeClusters();
    }

    public void generateCenters() {
        int min = 0, max = 0;
        double interval = 0.00;

        for (int i = 0; i < studentList.size() - 1; i++) {
            min = Math.min(studentList.get(i).getaScores(), studentList.get(i + 1).getaScores());	//determine minimum mark from ascores
            max = Math.max(studentList.get(i).getaScores(), studentList.get(i + 1).getaScores());	//determine maximum mark from ascores
        }

        centers = new double[numOfClusters];	//initialize centers array

        interval = ((double) (max - min)) / numOfClusters;

        centers[0] = (min + (interval / 2));	//make this as the first center

        for (int j = 1; j < centers.length; j++) {
            centers[j] = centers[j - 1] + interval;
        }
    }

    public boolean recalculateCenters() {
        boolean flag = true;

        System.out.println();
        for (int i = 0; i < clusterList.size(); i++) {
            double sum = 0;
            double average = 0;
            for (int j = 0; j < clusterList.get(i).size(); j++) {
                Student stude = clusterList.get(i).get(j);
                sum += stude.getaScores();
            }
            System.out.println("Cluster Size: " + clusterList.get(i).size());
            average = sum / ((double) clusterList.get(i).size());
//    		System.out.println("Average: " + average);
            if (average != centers[i] && average == Double.NaN) {
                centers[i] = average;
                flag = false;
            }
        }
        return flag;
    }

    public void equalizeClusters() {
        for (int i = clusterList.size() - 1; i >= 1; i--) {
            List<Student> extras = new ArrayList();
//    		System.out.println(clusterList.get(i).size());
            if (clusterList.get(i).size() > clusterSize) {
                int numExtras = clusterList.get(i).size() - clusterSize;
//    			System.out.println(numExtras);
                for (int a = 0; a < numExtras; a++) {
                    double distance = centers[i];
//    				System.out.println("Distance: " + distance);
                    int index = 0;

                    for (int j = 0; j < clusterList.get(i).size(); j++) {
                        Student stude = clusterList.get(i).get(j);	//get student
                        double mark = stude.getaScores();	//get student ascore

                        double cdistance = Math.abs(centers[i - 1] - mark);

//            			System.out.println("Distance: " + distance + "\tCDistance: " + cdistance);
                        if (cdistance < distance) {
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

        for (int a = 0; a <= clusterList.size() - 2; a++) {
            List<Student> extras = new ArrayList();
//    		System.out.println(clusterList.get(i).size());
            if (clusterList.get(a).size() > clusterSize) {
                int numExtras = clusterList.get(a).size() - clusterSize;
//    			System.out.println(numExtras);
                for (int z = 0; z < numExtras; z++) {
                    double distance = centers[a];
//    				System.out.println("Distance: " + distance);
                    int index = 0;

                    for (int b = 0; b < clusterList.get(a).size(); b++) {
                        Student stude = clusterList.get(a).get(b);	//get student
                        double mark = stude.getaScores();	//get student ascore

                        double cdistance = Math.abs(centers[a + 1] - mark);

//            			System.out.println("Distance: " + distance + "\tCDistance: " + cdistance);
                        if (cdistance < distance) {
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

        recalculateCenters();

        for (int y = 0; y < clusterList.size(); y++) {
//            System.out.println("New Cluster Size: " + clusterList.get(y).size());
            System.out.println("Cluster " + (y + 1));
            for (int j = 0; j < clusterList.get(y).size(); j++) {
                System.out.println("Id: " + clusterList.get(y).get(j).getId());
            }
        }
    }

    public void makeHet() {
        initialDOH = new double[clusterList.size()];
        freqCount = new int[clusterList.size()];
        ArrayList<Double> dohOfClusters = new ArrayList<>();
        ArrayList<int[]> freqList = new ArrayList();
        ArrayList<Integer> bScores = new ArrayList<>();

        for (int i = 0; i < clusterList.size(); i++) {
            initialDOH[i] = calcDOH(clusterList.get(i));
            freqCount = getRangeCounts(clusterList.get(i));
            freqList.add(freqCount);

            dohOfClusters.add(initialDOH[i]);
        }

        for (int i = 0; i < clusterList.size(); i++) {
            for (int j = i + 1; j < clusterList.size(); j++) {
                double first = calcDOH(clusterList.get(i));
                double second = calcDOH(clusterList.get(j));

                if (first == 1.0 && second == 1.0) {
                    break;
                }
            }

            for (int o = 1; o < clusterList.get(i).size(); o++) {
                bScores.add(clusterList.get(i).get(o).getbScores());
            }

            List<Range> needi = new ArrayList();  //no scores
            List<Range> needj = new ArrayList();  //with scores
            for (int e = 0; e < bScores.size(); e++) {
                for (int f = 0; f < rangeList.size(); f++) {
                    if (rangeList.get(f).contains(bScores.get(e))) {
                        needj.add(rangeList.get(f));
                    } else {
                        needi.add(rangeList.get(f));
                    }
                }
            }

            //get intersection
            List<Range> intersection1 = new ArrayList();
            HashSet<Range> set1 = new HashSet<Range>();
            for (int k = 0; k < needi.size(); k++) {
                set1.add(needi.get(k));
            }

            HashSet<Range> set2 = new HashSet<Range>();
            for (int k = 0; k < needj.size(); k++) {
                if (set1.contains(needj.get(k))) {
                    set2.add(needj.get(k));
                }

            }

            for (Range n : set2) {
                intersection1.add(n);
            }
            
            List<Range> intersection2 = new ArrayList();
            HashSet<Range> set3 = new HashSet<Range>();
            for (int k = 0; k < needj.size(); k++) {
                set1.add(needi.get(k));
            }

            HashSet<Range> set4 = new HashSet<Range>();
            for (int k = 0; k < needi.size(); k++) {
                if (set3.contains(needi.get(k))) {
                    set4.add(needj.get(k));
                }

            }

            for (Range n : set4) {
                intersection2.add(n);
            }
//            for(int c = 0; c < freqList.size(); c++) {
//                for(int d = 0; d < freqList.get(c).length; d++) {
//                    
//                }
//            }
        }
    }

//    public void makeHet() {
//        ArrayList<Double> dohOfClusters = new ArrayList<>();
//        ArrayList<Integer> bScores = new ArrayList<>();
//        ArrayList<int[]> freqOfRange = new ArrayList<>();
//
//        for (int i = 0; i < clusterList.size(); i++) {
//            double doh = calcDOH(clusterList.get(i));
//            dohOfClusters.add(doh);
//            int[] freq = getRangeCounts(clusterList.get(i));
//            freqOfRange.add(freq);
//        }
//
//        for (int n = 0; n < clusterList.size(); n++) {
//            for (int m = 0; m < clusterList.size(); m++) {
//                double intitialDOH1 = dohOfClusters.get(n);
//                double intitialDOH2 = dohOfClusters.get(m);
//                if (intitialDOH1 == 1.0 && intitialDOH2 == 1.0 && intitialDOH1 == intitialDOH2) {
//                    break;
//                }
//
//                for (int o = 1; o < clusterList.get(n).size(); o++) {
//                    bScores.add(clusterList.get(n).get(o).getbScores());
//
//                }
//
//            }
//        }
//    }
    public double calcDOH(List<Student> list) {
        List<Range> ranges = this.rangeList;
        double doh = 0;

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < ranges.size(); j++) {
                if (ranges.get(j).contains(list.get(i).getbScores())) {
                    ranges.remove(j);
                    break;
                }
            }
        }

        int numRanges = rangeList.size() - ranges.size();
        doh = ((double) numRanges) / list.size();

        return doh;
    }

    public int[] getRangeCounts(List<Student> list) {
        int[] rangeCounts = new int[rangeList.size()];

        for (int i = 0; i < list.size(); i++) {
            int ctr = 0;
            for (int j = 0; j < rangeList.size(); j++) {
                if (rangeList.get(j).contains(list.get(i).getbScores())) {
                    rangeCounts[j] = ctr++;
                }
            }
        }

        return rangeCounts;
    }

    public ArrayList<List<Student>> getClusterList() {
        return this.clusterList;
    }
}
