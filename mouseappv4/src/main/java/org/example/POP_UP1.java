
package org.example;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;


public class POP_UP1 extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(POP_UP1.class.getName());



    @SuppressWarnings("unchecked")

    private Component initComponents(String devicename) {
        try {
            UIManager.setLookAndFeel( new FlatDarkLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(400, 200));
        setMinimumSize(new java.awt.Dimension(400, 200));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setForeground(new java.awt.Color(255, 204, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(devicename + "wants to connect");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(125, 219, 0, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setForeground(new java.awt.Color(255, 204, 51));
        jButton3.setText("Connect");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 175;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(119, 0, 0, 0);
        jPanel1.add(jButton3, gridBagConstraints);

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setForeground(new java.awt.Color(255, 204, 51));
        jButton4.setText("Refuse");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 158;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(119, 0, 0, 0);
        jPanel1.add(jButton4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
        return jPanel1;
    }
    public String RUN(String devciename){
        if(Objects.equals(Connection, "NotConnected"))
        {
            return main(devciename);
        }
        else{

            return "refuse";
        }
    }

    public String main(String devicename) {
        jFrame.add(initComponents(devicename));
        jFrame.setMinimumSize(new Dimension(500,340));
        jFrame.setMaximumSize(new Dimension(500,340));
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Connection = "Connected";
                    System.out.println(Connection);
                try {
                    connecter.connect();
                } catch (IOException ex) {

                }
                jFrame.dispose();
            }
        });
        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Connection = "NotConnected";
                    System.out.println(Connection);
                try {
                    connecter.disconnect();
                } catch (IOException ex) {

                }
                jFrame.dispose();
            }
        });
        System.out.println(Connection);
        return Connect;
    }

    public static JFrame jFrame = new JFrame();
    private static javax.swing.JButton jButton3;
    private static javax.swing.JButton jButton4;
    private static javax.swing.JLabel jLabel1;
    private static javax.swing.JPanel jPanel1;
    public static String Connection = "NotConnected";
    public static String Connect;
    // End of variables declaration
}
