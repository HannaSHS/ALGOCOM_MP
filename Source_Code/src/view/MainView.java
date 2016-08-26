/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Algorithm;
import controller.FileRead;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Student;

public class MainView extends JFrame implements ActionListener {

    private JButton btnNewButton, btnChooseFolder, btnStartSectioning;
    private JLabel lblNewSectioning, lblSectioningName, lblNumberOfResulting, lblChooseStudentList, lblFileDirectory, lblSaveFileLocation, lblFolderDirectory;
    private JPanel contentPane;
    private JTextField txtFieldName, txtFieldNum;
    
    private String filepath;
    private ArrayList<Student> studentList;

    /**
     * Create the frame.
     */
    public MainView() {
        for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                break;
            }
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 350);
        setVisible(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewSectioning = new JLabel("NEW SECTIONING");
        lblNewSectioning.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewSectioning.setBounds(295, 11, 102, 15);
        contentPane.add(lblNewSectioning);

        lblSectioningName = new JLabel("Sectioning Name");
        lblSectioningName.setBounds(80, 55, 151, 15);
        contentPane.add(lblSectioningName);

        txtFieldName = new JTextField();
        txtFieldName.setBounds(260, 50, 256, 25);
        contentPane.add(txtFieldName);
        txtFieldName.setColumns(10);

        lblNumberOfResulting = new JLabel("Number of Resulting Sections");
        lblNumberOfResulting.setBounds(80, 96, 170, 14);
        contentPane.add(lblNumberOfResulting);

        txtFieldNum = new JTextField();
        txtFieldNum.setBounds(260, 91, 86, 25);
        contentPane.add(txtFieldNum);
        txtFieldNum.setColumns(10);

        lblChooseStudentList = new JLabel("Choose Student List File (.csv)");
        lblChooseStudentList.setBounds(80, 135, 201, 14);
        contentPane.add(lblChooseStudentList);

        btnNewButton = new JButton("Choose File");
        btnNewButton.addActionListener((ActionListener) this);
        btnNewButton.setBounds(80, 148, 116, 23);
        contentPane.add(btnNewButton);

        lblFileDirectory = new JLabel("");
        lblFileDirectory.setBounds(260, 152, 364, 14);
        contentPane.add(lblFileDirectory);

        lblSaveFileLocation = new JLabel("Save File Location (.csv)");
        lblSaveFileLocation.setBounds(80, 190, 146, 14);
        contentPane.add(lblSaveFileLocation);

        btnChooseFolder = new JButton("Choose Folder");
        btnChooseFolder.addActionListener((ActionListener) this);
        btnChooseFolder.setBounds(80, 203, 116, 23);
        contentPane.add(btnChooseFolder);

        lblFolderDirectory = new JLabel("");
        lblFolderDirectory.setBounds(260, 207, 364, 14);
        contentPane.add(lblFolderDirectory);

        btnStartSectioning = new JButton("START SECTIONING");
        btnStartSectioning.addActionListener(this);
        btnStartSectioning.setBounds(263, 250, 146, 23);
        contentPane.add(btnStartSectioning);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == btnNewButton) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Student List (.csv)", "csv", "CSV");
            fileChooser.setFileFilter(filter);
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                filepath = selectedFile.getAbsolutePath();
                lblFileDirectory.setText(filepath);
                //read file
                FileRead fr = new FileRead();

                if (filepath.endsWith(".csv")) {
                	fr.readCSVFile(filepath);
                    studentList = fr.getStudentList();
                } else if (filepath.endsWith(".xlsx") || filepath.endsWith(".xls")) {
//                    fr.readExcelFile(filepath);
                }
            }
        } else if (e.getSource() == btnChooseFolder) {
            JFrame parentFrame = new JFrame();

            JFileChooser fileChooser = new JFileChooser(new File(System.getProperty("user.home")));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Student List (.csv)", "csv", "CSV");
            fileChooser.setFileFilter(filter);
            fileChooser.setDialogTitle("Specify a file to save");
            int userSelection = fileChooser.showSaveDialog(parentFrame);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
//	            
                lblFolderDirectory.setText(fileToSave.getPath());
//	            try {
//	                FileWriter fw = new FileWriter(fileToSave.getPath());
////	                fw.write(text);
////	                fw.flush();
////	                fw.close();
                //
//	                JOptionPane.showMessageDialog(null, "Results are saved.");
//	            } catch (Exception e2) {
//	                JOptionPane.showMessageDialog(null, e2.getMessage());
//	            }
            }
        } else if(e.getSource() == btnStartSectioning) {
        	Algorithm algorithm = new Algorithm(studentList, Integer.parseInt(txtFieldNum.getText()));
            algorithm.execute();
        }

    }
}
