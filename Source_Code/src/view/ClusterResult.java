package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import java.awt.TextArea;
import javax.swing.JLabel;

public class ClusterResult extends JFrame {

    private JPanel contentPane;
    private TextArea textArea;
    private JLabel lblClusterResults;

    /**
     * Create the frame.
     */
    public ClusterResult() {
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

        setVisible(true);
        setBounds(100, 100, 650, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textArea = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        textArea.setBounds(10, 50, 614, 252);
        textArea.setEditable(false);
        contentPane.add(textArea);

        lblClusterResults = new JLabel("Cluster Results");
        lblClusterResults.setBounds(285, 11, 102, 14);
        contentPane.add(lblClusterResults);
    }
    
    public void setTxtArea(String s) {
        textArea.setText(s);
    }
}
