package controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.AScores;
import model.BScores;
import model.Student;

public class FileRead {
    
    ArrayList<Student> studentList = new ArrayList<>();

    public void readCSVFile(String filepath) {

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(filepath));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] param = line.split(cvsSplitBy);

                System.out.println("Student [id= " + param[0] + " , "
                        + "name= " + param[1] + " " + param[2] + " " 
                        + param[3] + " , overall average= " + param[6] + "]");
                if(!param[0].equals("student_id")){
                    int id = Integer.parseInt(param[0]);
                    String firstname = param[1];
                    String middlename = param[2];
                    String lastname = param[3];
                    int communicationSkills = Integer.parseInt(param[4]);
                    int groupWork = Integer.parseInt(param[5]);
                    int subjectKnowledge = Integer.parseInt(param[6]);

                    AScores aScores = new AScores(communicationSkills, groupWork);
                    BScores bScores = new BScores(subjectKnowledge);
                    Student student = new Student(id, firstname, middlename, lastname, aScores, bScores);
                    studentList.add(student);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public ArrayList<Student> getStudentList(){
        return studentList;
    }
    
/*    public void readExcelFile(String filepath){
     
    }
*/    
}