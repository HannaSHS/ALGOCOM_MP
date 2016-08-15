/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JFileChooser;
import view.MainView;

/**
 *
 * @author Hanna Sha
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainView mv = new MainView();
        mv.setVisible(true);
        /*        
        String filepath = mv.getFilepath();
        
        //read file
        FileRead fr = new FileRead();
        
        if(filepath.endsWith(".csv")){
            fr.readCSVFile(filepath);
        }else if(filepath.endsWith(".xlsx") || filepath.endsWith(".xls")){
            fr.readExcelFile(filepath);
        }
        */
    }
    
}
