package com.hueic.CerGS.ui;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AboutFrm.java
 *
 * Created on Mar 13, 2011, 12:47:33 PM
 */

/**
 *
 * @author qhvic
 */
public class AboutFrm extends javax.swing.JFrame {

    /** Creates new form AboutFrm */
    public AboutFrm() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("<html>\n<body>\nCertificate Generation System<br/>Version 1.0<br/>© 2011 ConnectPlus.<br/>All rights reserved.\n</body>\n</html>");
        jLabel1.setPreferredSize(new java.awt.Dimension(150, 56));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel3.setText("<html> <body> Name group: ConnectPlus <br/> Develop by: <br/> Nguyen Huu Chung <br/> Dao Huu Bien <br/>Tran Quoc Huy\n\t  <br/></body> </html>");
        jLabel3.setPreferredSize(new java.awt.Dimension(130, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        getContentPane().add(jLabel3, gridBagConstraints);

        jButton1.setText("Close");
        jButton1.setPreferredSize(new java.awt.Dimension(85, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        getContentPane().add(jButton1, gridBagConstraints);

        jSeparator1.setPreferredSize(new java.awt.Dimension(400, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        getContentPane().add(jSeparator1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AboutFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

}
