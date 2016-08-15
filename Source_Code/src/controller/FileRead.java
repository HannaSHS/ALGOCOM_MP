package controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.Student;

public class FileRead {

    public void readCSVFile(String filepath) {

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(filepath));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] student = line.split(cvsSplitBy);

                System.out.println("Student [id= " + student[0] + " , "
                        + "name= " + student[1] + " " + student[2] + " " 
                        + student[3] + " , overall average= " + student[6] + "]");

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
    public void readExcelFile(String filepath){
     
    }
}