/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.example;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author Moksh
 */
public class RemoteMouseUI extends javax.swing.JFrame {

    public String PCinfo = String.valueOf(InetAddress.getLocalHost());


    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RemoteMouseUI.class.getName());

    public RemoteMouseUI() throws UnknownHostException {
    }


    public Component initComponents(String mobileinfo) {
        try {
            UIManager.setLookAndFeel( new FlatDarkLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }



        jPanel1 = new JPanel();
        jTabbedPane1 = new JTabbedPane();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        jLabel2 = new JLabel();
        jPanel2 = new JPanel();
        jLabel1 = new JLabel();
        jLabel3 = new JLabel();
        button1 = new Button();
        button2 = new Button();
        button3 = new Button();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(400, 400));

        jPanel1.setBackground(new Color(0, 0, 0));

        jTabbedPane1.setBackground(new Color(51, 51, 51));
        jTabbedPane1.setBorder(BorderFactory.createLineBorder(new Color(255,204,0),1,true));
        jTabbedPane1.setForeground(new Color(255, 204, 0));

        jPanel3.setBackground(new Color(51, 51, 51));
        jPanel3.setForeground(new Color(255, 204, 0));
        jPanel3.setLayout(new GridLayout());


        jLabel2.setForeground(new Color(255, 204, 0));
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText(PCinfo);
        jLabel2.setAlignmentX(0.5F);
        jLabel2.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        jLabel2.setHorizontalTextPosition(SwingConstants.CENTER);
        jPanel3.add(jLabel2);

        jTabbedPane1.addTab("pc info", jPanel3);



        jPanel2.setBackground(new Color(51, 51, 51));
        jPanel2.setForeground(new Color(255, 204, 0));
        jPanel2.setLayout(new FlowLayout());

        jLabel1.setBackground(new Color(255, 204, 51));
        jLabel1.setForeground(new Color(255, 204, 0));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText(mobileinfo);
        jLabel1.setAlignmentX(0.5F);
        jLabel1.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
        button3.setBackground(new Color(255, 204, 0));
        button3.setForeground(new Color(51, 51, 51));
        button3.setLabel("Disconnect");
        jPanel2.add(jLabel1);
        jPanel2.add(button3);
        jTabbedPane1.addTab("connectdevice", jPanel2);

        jPanel4.setBackground(new Color(51, 51, 51));
        jPanel4.setForeground(new Color(255, 204, 0));
        jPanel4.setLayout(new FlowLayout());
        jLabel3.setBackground(new Color(255, 204, 51));
        jLabel3.setForeground(new Color(255, 204, 0));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setText("Start searching");
        jLabel3.setAlignmentX(0.5F);
        jLabel3.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        jLabel3.setHorizontalTextPosition(SwingConstants.CENTER);
        button1.setBackground(new Color(255, 204, 0));
        button1.setForeground(new Color(51, 51, 51));
        button1.setLabel("Start");
        button2.setBackground(new Color(255, 204, 0));
        button2.setForeground(new Color(51, 51, 51));
        button2.setLabel("Stop");
        jPanel4.add(jLabel3);
        jPanel4.add(button1);
        jPanel4.add(button2);
        jTabbedPane1.addTab("device find", jPanel4);



        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        return jPanel1;
    }


    public void run(String modileinfo) throws UnknownHostException {

        jFrame.add(initComponents(modileinfo));
        jFrame.setMinimumSize(new Dimension(400,400));
        jFrame.setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(!severstrated) {
                    updateLabel3("Started searching");
                    severstrated = true;
                    new Thread(() -> {
                        try {
                            Server.StartServer();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }).start();
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(severstrated) {
                    Server.STOP();
                    severstrated = false;
                }
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                POP_UP1.Connection = "NotConnected";
                connecter disconnecter = new connecter();
                try {
                    disconnecter.disconnect();
                } catch (IOException ex) {
                    System.out.println("Dissconnected");
                }
                updateLabel1("no device connected");
            }
        });
    }

    public void updateLabel1( String text) {
        SwingUtilities.invokeLater(() -> {
            jLabel1.setText(text);
            jFrame.getContentPane().revalidate();
            jFrame.getContentPane().repaint();
        });
    }

    public void updateLabel3( String text) {
        SwingUtilities.invokeLater(() -> {
            jLabel3.setText(text);
            jFrame.getContentPane().revalidate();
            jFrame.getContentPane().repaint();
        });
    }


    public JFrame jFrame = new JFrame();
    public javax.swing.JLabel jLabel1 = new JLabel();
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public static javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2 = new JPanel();
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JTabbedPane jTabbedPane1;
    public Button button1;
    public Button button2;
    public Button button3;
    public boolean severstrated = true ;

}
