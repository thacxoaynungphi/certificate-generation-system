/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmMainReport.java
 *
 * Created on Mar 27, 2011, 8:36:57 AM
 */

package com.hueic.CerGS.ui.main.report;

/**
 *
 * @author qhvic
 */
public class frmMainReport extends javax.swing.JFrame {

    /** Creates new form frmMainReport */
    public frmMainReport() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel1 = new javax.swing.JPanel();
        lblBanner = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        tabpanel1 = new javax.swing.JTabbedPane();
        panel3 = new javax.swing.JPanel();
        lblTitle1 = new javax.swing.JLabel();
        lblContent1 = new javax.swing.JLabel();
        scrP1 = new javax.swing.JScrollPane();
        txtA1 = new javax.swing.JTextArea();
        pamel4 = new javax.swing.JPanel();
        lblTitle2 = new javax.swing.JLabel();
        lblContent2 = new javax.swing.JLabel();
        scrP2 = new javax.swing.JScrollPane();
        txtA2 = new javax.swing.JTextArea();
        panel5 = new javax.swing.JPanel();
        lblTitle3 = new javax.swing.JLabel();
        lblContent3 = new javax.swing.JLabel();
        scrP3 = new javax.swing.JScrollPane();
        txtA3 = new javax.swing.JTextArea();
        panel6 = new javax.swing.JPanel();
        lblTitle4 = new javax.swing.JLabel();
        lblContent4 = new javax.swing.JLabel();
        scrP4 = new javax.swing.JScrollPane();
        txtA4 = new javax.swing.JTextArea();
        panel7 = new javax.swing.JPanel();
        lblTitle5 = new javax.swing.JLabel();
        lblContent5 = new javax.swing.JLabel();
        scrP5 = new javax.swing.JScrollPane();
        txtA5 = new javax.swing.JTextArea();
        panel8 = new javax.swing.JPanel();
        lblTitle6 = new javax.swing.JLabel();
        lblContent6 = new javax.swing.JLabel();
        scrP6 = new javax.swing.JScrollPane();
        txtA6 = new javax.swing.JTextArea();
        panel9 = new javax.swing.JPanel();
        lblTitle7 = new javax.swing.JLabel();
        lblContent7 = new javax.swing.JLabel();
        scrP7 = new javax.swing.JScrollPane();
        txtA7 = new javax.swing.JTextArea();
        panel10 = new javax.swing.JPanel();
        lblTitle8 = new javax.swing.JLabel();
        lblContent8 = new javax.swing.JLabel();
        scrP8 = new javax.swing.JScrollPane();
        txtA8 = new javax.swing.JTextArea();
        chbXML = new javax.swing.JCheckBox();
        chbPDF = new javax.swing.JCheckBox();
        chbMSWord = new javax.swing.JCheckBox();
        panel11 = new javax.swing.JPanel();
        btnCreate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblTitleChb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Report");
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lblBanner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/MainReport.png"))); // NOI18N

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBanner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBanner, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panel1, gridBagConstraints);

        panel2.setPreferredSize(new java.awt.Dimension(832, 400));
        panel2.setLayout(new java.awt.GridBagLayout());

        tabpanel1.setPreferredSize(new java.awt.Dimension(830, 240));

        panel3.setPreferredSize(new java.awt.Dimension(832, 172));
        panel3.setLayout(new java.awt.GridBagLayout());

        lblTitle1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitle1.setText("<html>\n<body>\n\nCertificate Report\n\n</body>\n</html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel3.add(lblTitle1, gridBagConstraints);

        lblContent1.setText("ashdjkashdkjkahjslddddddddddddddddddddddddddddddddddddddddddddd");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel3.add(lblContent1, gridBagConstraints);

        scrP1.setPreferredSize(new java.awt.Dimension(750, 100));

        txtA1.setColumns(20);
        txtA1.setRows(5);
        txtA1.setPreferredSize(new java.awt.Dimension(750, 90));
        scrP1.setViewportView(txtA1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel3.add(scrP1, gridBagConstraints);

        tabpanel1.addTab("Certificate", panel3);

        pamel4.setLayout(new java.awt.GridBagLayout());

        lblTitle2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitle2.setText("<html> <body>  Certificate Develop Report  </body> </html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pamel4.add(lblTitle2, gridBagConstraints);

        lblContent2.setText("ashdjkashdkjkahjslddddddddddddddddddddddddddddddddddddddddddddd");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pamel4.add(lblContent2, gridBagConstraints);

        scrP2.setPreferredSize(new java.awt.Dimension(750, 100));

        txtA2.setColumns(20);
        txtA2.setRows(5);
        txtA2.setPreferredSize(new java.awt.Dimension(750, 90));
        scrP2.setViewportView(txtA2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pamel4.add(scrP2, gridBagConstraints);

        tabpanel1.addTab("Certificate Develop", pamel4);

        panel5.setLayout(new java.awt.GridBagLayout());

        lblTitle3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitle3.setText("<html> <body>  Employee Report  </body> </html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel5.add(lblTitle3, gridBagConstraints);

        lblContent3.setText("ashdjkashdkjkahjslddddddddddddddddddddddddddddddddddddddddddddd");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel5.add(lblContent3, gridBagConstraints);

        scrP3.setPreferredSize(new java.awt.Dimension(750, 100));

        txtA3.setColumns(20);
        txtA3.setRows(5);
        txtA3.setPreferredSize(new java.awt.Dimension(750, 90));
        scrP3.setViewportView(txtA3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel5.add(scrP3, gridBagConstraints);

        tabpanel1.addTab("Employee", panel5);

        panel6.setLayout(new java.awt.GridBagLayout());

        lblTitle4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitle4.setText("<html> <body>  Student New Registration Report  </body> </html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel6.add(lblTitle4, gridBagConstraints);

        lblContent4.setText("ashdjkashdkjkahjslddddddddddddddddddddddddddddddddddddddddddddd");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel6.add(lblContent4, gridBagConstraints);

        scrP4.setPreferredSize(new java.awt.Dimension(750, 100));

        txtA4.setColumns(20);
        txtA4.setRows(5);
        txtA4.setPreferredSize(new java.awt.Dimension(750, 90));
        scrP4.setViewportView(txtA4);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel6.add(scrP4, gridBagConstraints);

        tabpanel1.addTab("Student New Registration", panel6);

        panel7.setLayout(new java.awt.GridBagLayout());

        lblTitle5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitle5.setText("<html> <body>  Student Report  </body> </html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel7.add(lblTitle5, gridBagConstraints);

        lblContent5.setText("ashdjkashdkjkahjslddddddddddddddddddddddddddddddddddddddddddddd");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel7.add(lblContent5, gridBagConstraints);

        scrP5.setPreferredSize(new java.awt.Dimension(750, 100));

        txtA5.setColumns(20);
        txtA5.setRows(5);
        txtA5.setPreferredSize(new java.awt.Dimension(750, 90));
        scrP5.setViewportView(txtA5);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel7.add(scrP5, gridBagConstraints);

        tabpanel1.addTab("Student", panel7);

        panel8.setLayout(new java.awt.GridBagLayout());

        lblTitle6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitle6.setText("<html> <body>  Student Fee Report  </body> </html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel8.add(lblTitle6, gridBagConstraints);

        lblContent6.setText("ashdjkashdkjkahjslddddddddddddddddddddddddddddddddddddddddddddd");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel8.add(lblContent6, gridBagConstraints);

        scrP6.setPreferredSize(new java.awt.Dimension(750, 100));

        txtA6.setColumns(20);
        txtA6.setRows(5);
        txtA6.setPreferredSize(new java.awt.Dimension(750, 90));
        scrP6.setViewportView(txtA6);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel8.add(scrP6, gridBagConstraints);

        tabpanel1.addTab("Student Fee", panel8);

        panel9.setLayout(new java.awt.GridBagLayout());

        lblTitle7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitle7.setText("<html> <body>  Student Mark Report  </body> </html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel9.add(lblTitle7, gridBagConstraints);

        lblContent7.setText("ashdjkashdkjkahjslddddddddddddddddddddddddddddddddddddddddddddd");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel9.add(lblContent7, gridBagConstraints);

        scrP7.setPreferredSize(new java.awt.Dimension(750, 100));

        txtA7.setColumns(20);
        txtA7.setRows(5);
        txtA7.setPreferredSize(new java.awt.Dimension(750, 90));
        scrP7.setViewportView(txtA7);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel9.add(scrP7, gridBagConstraints);

        tabpanel1.addTab("Student Mark", panel9);

        panel10.setLayout(new java.awt.GridBagLayout());

        lblTitle8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitle8.setText("<html> <body>  Student In Course Report  </body> </html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel10.add(lblTitle8, gridBagConstraints);

        lblContent8.setText("ashdjkashdkjkahjslddddddddddddddddddddddddddddddddddddddddddddd");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel10.add(lblContent8, gridBagConstraints);

        scrP8.setPreferredSize(new java.awt.Dimension(750, 100));

        txtA8.setColumns(20);
        txtA8.setRows(5);
        txtA8.setPreferredSize(new java.awt.Dimension(750, 90));
        scrP8.setViewportView(txtA8);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel10.add(scrP8, gridBagConstraints);

        tabpanel1.addTab("Subject In Course", panel10);

        panel2.add(tabpanel1, new java.awt.GridBagConstraints());

        buttonGroup1.add(chbXML);
        chbXML.setText("XML");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 5, 5);
        panel2.add(chbXML, gridBagConstraints);

        buttonGroup1.add(chbPDF);
        chbPDF.setText("PDF");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 5, 5);
        panel2.add(chbPDF, gridBagConstraints);

        buttonGroup1.add(chbMSWord);
        chbMSWord.setText("MS Word");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 5, 5);
        panel2.add(chbMSWord, gridBagConstraints);

        btnCreate.setText("Create");
        panel11.add(btnCreate);

        btnCancel.setText("Cancel");
        panel11.add(btnCancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel2.add(panel11, gridBagConstraints);

        lblTitleChb.setText("To select the output format:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 40, 5, 5);
        panel2.add(lblTitleChb, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(panel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMainReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCreate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chbMSWord;
    private javax.swing.JCheckBox chbPDF;
    private javax.swing.JCheckBox chbXML;
    private javax.swing.JLabel lblBanner;
    private javax.swing.JLabel lblContent1;
    private javax.swing.JLabel lblContent2;
    private javax.swing.JLabel lblContent3;
    private javax.swing.JLabel lblContent4;
    private javax.swing.JLabel lblContent5;
    private javax.swing.JLabel lblContent6;
    private javax.swing.JLabel lblContent7;
    private javax.swing.JLabel lblContent8;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JLabel lblTitle3;
    private javax.swing.JLabel lblTitle4;
    private javax.swing.JLabel lblTitle5;
    private javax.swing.JLabel lblTitle6;
    private javax.swing.JLabel lblTitle7;
    private javax.swing.JLabel lblTitle8;
    private javax.swing.JLabel lblTitleChb;
    private javax.swing.JPanel pamel4;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel10;
    private javax.swing.JPanel panel11;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel5;
    private javax.swing.JPanel panel6;
    private javax.swing.JPanel panel7;
    private javax.swing.JPanel panel8;
    private javax.swing.JPanel panel9;
    private javax.swing.JScrollPane scrP1;
    private javax.swing.JScrollPane scrP2;
    private javax.swing.JScrollPane scrP3;
    private javax.swing.JScrollPane scrP4;
    private javax.swing.JScrollPane scrP5;
    private javax.swing.JScrollPane scrP6;
    private javax.swing.JScrollPane scrP7;
    private javax.swing.JScrollPane scrP8;
    private javax.swing.JTabbedPane tabpanel1;
    private javax.swing.JTextArea txtA1;
    private javax.swing.JTextArea txtA2;
    private javax.swing.JTextArea txtA3;
    private javax.swing.JTextArea txtA4;
    private javax.swing.JTextArea txtA5;
    private javax.swing.JTextArea txtA6;
    private javax.swing.JTextArea txtA7;
    private javax.swing.JTextArea txtA8;
    // End of variables declaration//GEN-END:variables

}