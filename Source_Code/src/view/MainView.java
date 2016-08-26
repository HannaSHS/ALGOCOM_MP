/*TEMPORARY VIEW*/
/*TEMPORARY VIEW*/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.FileRead;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Hanna Sha
 */
public class MainView extends javax.swing.JFrame {

    String filepath;

    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chooseFileButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        sectionNameTextField = new javax.swing.JTextField();
        sectionNameLabel = new javax.swing.JLabel();
        sectionCountLabel = new javax.swing.JLabel();
        sectionCountTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fileDirectoryLabel = new javax.swing.JLabel();
        folderDirectoryLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        chooseFolderButton = new javax.swing.JButton();
        startSectioningButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        chooseFileButton.setText("Choose File");
        chooseFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileButtonActionPerformed(evt);
            }
        });

        titleLabel.setText("NEW SECTIONING");

        sectionNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sectionNameTextFieldActionPerformed(evt);
            }
        });

        sectionNameLabel.setText("Sectioning Name");

        sectionCountLabel.setText("Number of Resulting Sections");

        sectionCountTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sectionCountTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Choose Student List file (.csv)");

        fileDirectoryLabel.setText("Directory");

        folderDirectoryLabel.setText("Directory");

        jLabel7.setText("Saved file location (.csv)");

        chooseFolderButton.setText("Choose Folder");
        chooseFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFolderButtonActionPerformed(evt);
            }
        });

        startSectioningButton.setText("START SECTIONING");
        startSectioningButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startSectioningButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel4)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(sectionCountLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(sectionCountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(chooseFolderButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(folderDirectoryLabel))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(chooseFileButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(fileDirectoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(147, 147, 147))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(titleLabel)
                            .addGap(211, 211, 211))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(sectionNameLabel)
                            .addGap(71, 71, 71)
                            .addComponent(sectionNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(startSectioningButton)
                        .addGap(191, 191, 191))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(titleLabel)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sectionNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sectionNameLabel))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sectionCountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sectionCountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chooseFileButton)
                    .addComponent(fileDirectoryLabel))
                .addGap(4, 4, 4)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(folderDirectoryLabel)
                    .addComponent(chooseFolderButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(startSectioningButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chooseFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFileButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Student List (.csv)", "csv", "CSV");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            filepath = selectedFile.getAbsolutePath();
            fileDirectoryLabel.setText(filepath);
            //read file
            FileRead fr = new FileRead();

            if (filepath.endsWith(".csv")) {
                fr.readCSVFile(filepath);
            } else if (filepath.endsWith(".xlsx") || filepath.endsWith(".xls")) {
                fr.readExcelFile(filepath);
            }
        }
    }//GEN-LAST:event_chooseFileButtonActionPerformed

    private void sectionNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectionNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sectionNameTextFieldActionPerformed

    private void sectionCountTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectionCountTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sectionCountTextFieldActionPerformed

    private void chooseFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFolderButtonActionPerformed
        // TODO add your handling code here:
        JFrame parentFrame = new JFrame();
        
        JFileChooser fileChooser = new JFileChooser(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Student List (.csv)", "csv", "CSV");
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("Specify a file to save");
        int userSelection = fileChooser.showSaveDialog(parentFrame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
//            File fileToSave = fileChooser.getSelectedFile();
//            
//            folderDirectoryLabel.setText(fileToSave.getPath());
//            try {
//                FileWriter fw = new FileWriter(fileToSave.getPath());
////                fw.write(text);
////                fw.flush();
////                fw.close();
//
//                JOptionPane.showMessageDialog(null, "Results are saved.");
//            } catch (Exception e2) {
//                JOptionPane.showMessageDialog(null, e2.getMessage());
//            }
        }
    }//GEN-LAST:event_chooseFolderButtonActionPerformed

    private void startSectioningButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startSectioningButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startSectioningButtonActionPerformed

    public String getFilepath() {
        return this.filepath;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooseFileButton;
    private javax.swing.JButton chooseFolderButton;
    private javax.swing.JLabel fileDirectoryLabel;
    private javax.swing.JLabel folderDirectoryLabel;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel sectionCountLabel;
    private javax.swing.JTextField sectionCountTextField;
    private javax.swing.JLabel sectionNameLabel;
    private javax.swing.JTextField sectionNameTextField;
    private javax.swing.JButton startSectioningButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
