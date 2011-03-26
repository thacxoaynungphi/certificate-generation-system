/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainFrm.java
 *
 * Created on Mar 13, 2011, 5:37:51 PM
 */
package com.hueic.CerGS.ui.main;

import com.hueic.CerGS.entity.Account;
import com.hueic.CerGS.ui.system.frmLogin;
import com.hueic.CerGS.ui.system.frmAbout;
import com.hueic.CerGS.component.GUIProperties;
import com.hueic.CerGS.component.IconSystem;
import com.hueic.CerGS.dao.GUIDAO;
import com.hueic.CerGS.ui.main.account.frmAccount;
import com.hueic.CerGS.ui.main.certificate.frmCertificate;
import com.hueic.CerGS.ui.main.course.frmCourse;
import com.hueic.CerGS.ui.main.employee.frmEmployee;
import com.hueic.CerGS.ui.main.mark.frmMark;
import com.hueic.CerGS.ui.main.payment.frmPayment;
import com.hueic.CerGS.ui.main.permission.frmPermission;
import com.hueic.CerGS.ui.main.register.frmRegister;
import com.hueic.CerGS.ui.main.student.frmStudent;
import com.hueic.CerGS.ui.main.subject.frmSubject;
import com.hueic.CerGS.ui.system.frmChangePass;
import java.net.URL;
import javax.help.CSH;
import javax.help.HelpBroker;
import javax.help.HelpSet;

/**
 *
 * @author nhchung
 */
public class frmMain extends javax.swing.JFrame {

    /** Creates new form MainFrm */
    GUIDAO guidao = null;
    GUIProperties guip = null;
    public Account accCur;

    public frmMain() {
        initComponents();
        setLocationRelativeTo(null);
        guidao = new GUIDAO(this);
        guip = new GUIProperties();
        guidao.setGUI(guip.PLAF_JGOODIES);
        bindingLang();
        new IconSystem(this);
        HelpSet hs = getHelpSet("com/hueic/CerGS/myhelp/sample.hs");
        HelpBroker hb = hs.createHelpBroker();

        // 2. assign help to components
        CSH.setHelpIDString(mnuIHelpContent, "top");
        mnuIHelpContent.addActionListener(new CSH.DisplayHelpFromSource(hb));
    }

    public HelpSet getHelpSet(String helpsetfile) {
        HelpSet hs = null;
        ClassLoader cl = this.getClass().getClassLoader();
        try {
            URL hsURL = HelpSet.findHelpSet(cl, helpsetfile);
            hs = new HelpSet(null, hsURL);
        } catch (Exception ee) {
            System.out.println("HelpSet: " + ee.getMessage());
            System.out.println("HelpSet: " + helpsetfile + " not found");
        }
        return hs;
    }

    public void bindingLang() {
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

        buttonGroupLanguage = new javax.swing.ButtonGroup();
        buttonGroupSkin = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        panelRight = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        panelLogo = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        panelLeft = new javax.swing.JPanel();
        jTaskPaneMenu = new com.l2fprod.common.swing.JTaskPane();
        jTaskPaneGroup1 = new com.l2fprod.common.swing.JTaskPaneGroup();
        linkBtnViewInformation = new com.l2fprod.common.swing.JLinkButton();
        linkBtnChangePassword = new com.l2fprod.common.swing.JLinkButton();
        linkBtnSwitchUser = new com.l2fprod.common.swing.JLinkButton();
        linkBtnSingout = new com.l2fprod.common.swing.JLinkButton();
        jTaskPaneGroup2 = new com.l2fprod.common.swing.JTaskPaneGroup();
        linkBtnEmployee = new com.l2fprod.common.swing.JLinkButton();
        linkBtnStudent = new com.l2fprod.common.swing.JLinkButton();
        linkBtnCertificate = new com.l2fprod.common.swing.JLinkButton();
        linkBtnPayment = new com.l2fprod.common.swing.JLinkButton();
        linkBtnMark = new com.l2fprod.common.swing.JLinkButton();
        linkBtnSubject = new com.l2fprod.common.swing.JLinkButton();
        linkBtnAccount = new com.l2fprod.common.swing.JLinkButton();
        linkBtnCourse = new com.l2fprod.common.swing.JLinkButton();
        linkBtnPermisison = new com.l2fprod.common.swing.JLinkButton();
        linkBtnRegister = new com.l2fprod.common.swing.JLinkButton();
        jTaskPaneGroup3 = new com.l2fprod.common.swing.JTaskPaneGroup();
        linkBtnSearchStudent = new com.l2fprod.common.swing.JLinkButton();
        linkBtnSearchEmp = new com.l2fprod.common.swing.JLinkButton();
        mnuBSystem = new javax.swing.JMenuBar();
        mnuSystem = new javax.swing.JMenu();
        menuIChangePass = new javax.swing.JMenuItem();
        mnuILoginSystem = new javax.swing.JMenuItem();
        mnuILogoutSystem = new javax.swing.JMenuItem();
        mnuIViewInformation = new javax.swing.JMenuItem();
        mnuOptions = new javax.swing.JMenu();
        mnuLang = new javax.swing.JMenu();
        radioVietnamese = new javax.swing.JRadioButtonMenuItem();
        radioEnglish = new javax.swing.JRadioButtonMenuItem();
        radioJapan = new javax.swing.JRadioButtonMenuItem();
        radioChina = new javax.swing.JRadioButtonMenuItem();
        radioPhap = new javax.swing.JRadioButtonMenuItem();
        mnuSkin = new javax.swing.JMenu();
        radioWindows = new javax.swing.JRadioButtonMenuItem();
        radioMetal = new javax.swing.JRadioButtonMenuItem();
        radioNimbus = new javax.swing.JRadioButtonMenuItem();
        radioMotif = new javax.swing.JRadioButtonMenuItem();
        mnuISwitchUser = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuIExit = new javax.swing.JMenuItem();
        mnuHelp = new javax.swing.JMenu();
        mnuIHelpContent = new javax.swing.JMenuItem();
        mnuIAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Certificate Generation System");
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelRight.setBackground(new java.awt.Color(255, 255, 255));
        panelRight.setMinimumSize(new java.awt.Dimension(880, 600));
        panelRight.setPreferredSize(new java.awt.Dimension(880, 600));
        panelRight.setLayout(new java.awt.GridBagLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Dollar.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 30, 20, 10);
        panelRight.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Add new employee");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelRight.add(jLabel3, gridBagConstraints);

        jLabel4.setText("Search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelRight.add(jLabel4, gridBagConstraints);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Dollar.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 30, 20, 10);
        panelRight.add(jLabel5, gridBagConstraints);

        jLabel6.setText("View");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 52;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelRight.add(jLabel6, gridBagConstraints);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Dollar.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 30, 20, 10);
        panelRight.add(jLabel7, gridBagConstraints);

        jLabel8.setText("Exit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 52;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelRight.add(jLabel8, gridBagConstraints);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Dollar.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 30, 20, 10);
        panelRight.add(jLabel9, gridBagConstraints);

        jLabel10.setText("Logout");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelRight.add(jLabel10, gridBagConstraints);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Dollar.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 30, 20, 10);
        panelRight.add(jLabel11, gridBagConstraints);

        jLabel12.setText("Add new student");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelRight.add(jLabel12, gridBagConstraints);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Dollar.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 30, 20, 10);
        panelRight.add(jLabel13, gridBagConstraints);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/logoGroupMain.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 50, 0, 0);
        panelRight.add(jLabel14, gridBagConstraints);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel15.setForeground(new java.awt.Color(0, 0, 102));
        jLabel15.setText("<html>\n<body>\nCertificate Generator System\n</body>\n</html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        panelRight.add(jLabel15, gridBagConstraints);

        jLabel16.setText("<html>\n<body>\nThis is a Certificate Department which works for “ABC” institute for developing  the certificate for the<br/> students who had completed their course. This system also deals with the student  registration,<br/> checking the payment scenario, inputting the marks of the students and after all verification is<br/>  done they develop the certificate of completion of the course for the students.\n</body>\n</html>\n");
        jLabel16.setMinimumSize(new java.awt.Dimension(480, 56));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 5, 0);
        panelRight.add(jLabel16, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelRight, gridBagConstraints);

        panelLogo.setLayout(new java.awt.GridBagLayout());

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/banner copy.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelLogo.add(lblLogo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelLogo, gridBagConstraints);

        panelLeft.setBackground(new java.awt.Color(255, 255, 255));
        panelLeft.setMinimumSize(new java.awt.Dimension(220, 600));
        panelLeft.setPreferredSize(new java.awt.Dimension(220, 600));
        panelLeft.setLayout(new java.awt.GridBagLayout());

        jTaskPaneMenu.setMinimumSize(new java.awt.Dimension(209, 600));
        jTaskPaneMenu.setPreferredSize(new java.awt.Dimension(209, 600));

        jTaskPaneGroup1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/gear.png"))); // NOI18N
        jTaskPaneGroup1.setTitle("System");

        linkBtnViewInformation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/businessman_find.png"))); // NOI18N
        linkBtnViewInformation.setText("View Information");
        jTaskPaneGroup1.getContentPane().add(linkBtnViewInformation);

        linkBtnChangePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/gear.png"))); // NOI18N
        linkBtnChangePassword.setText("Change Password");
        jTaskPaneGroup1.getContentPane().add(linkBtnChangePassword);

        linkBtnSwitchUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/switch.jpg"))); // NOI18N
        linkBtnSwitchUser.setText("Switch User");
        jTaskPaneGroup1.getContentPane().add(linkBtnSwitchUser);

        linkBtnSingout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/signout.png"))); // NOI18N
        linkBtnSingout.setText("Signout");
        jTaskPaneGroup1.getContentPane().add(linkBtnSingout);

        jTaskPaneMenu.add(jTaskPaneGroup1);

        jTaskPaneGroup2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/users1.png"))); // NOI18N
        jTaskPaneGroup2.setTitle("Administration");

        linkBtnEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/application_view_detail.png"))); // NOI18N
        linkBtnEmployee.setText("Management Employee");
        linkBtnEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkBtnEmployeeActionPerformed(evt);
            }
        });
        jTaskPaneGroup2.getContentPane().add(linkBtnEmployee);

        linkBtnStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/application_view_detail.png"))); // NOI18N
        linkBtnStudent.setText("Management Student");
        linkBtnStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkBtnStudentActionPerformed(evt);
            }
        });
        jTaskPaneGroup2.getContentPane().add(linkBtnStudent);

        linkBtnCertificate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/application_view_detail.png"))); // NOI18N
        linkBtnCertificate.setText("Management Certificate");
        linkBtnCertificate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkBtnCertificateActionPerformed(evt);
            }
        });
        jTaskPaneGroup2.getContentPane().add(linkBtnCertificate);

        linkBtnPayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/application_view_detail.png"))); // NOI18N
        linkBtnPayment.setText("Management Payment");
        linkBtnPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkBtnPaymentActionPerformed(evt);
            }
        });
        jTaskPaneGroup2.getContentPane().add(linkBtnPayment);

        linkBtnMark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/application_view_detail.png"))); // NOI18N
        linkBtnMark.setText("Management Mark");
        linkBtnMark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkBtnMarkActionPerformed(evt);
            }
        });
        jTaskPaneGroup2.getContentPane().add(linkBtnMark);

        linkBtnSubject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/application_view_detail.png"))); // NOI18N
        linkBtnSubject.setText("Management Subject");
        linkBtnSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkBtnSubjectActionPerformed(evt);
            }
        });
        jTaskPaneGroup2.getContentPane().add(linkBtnSubject);

        linkBtnAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/application_view_detail.png"))); // NOI18N
        linkBtnAccount.setText("Management Account");
        linkBtnAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkBtnAccountActionPerformed(evt);
            }
        });
        jTaskPaneGroup2.getContentPane().add(linkBtnAccount);

        linkBtnCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/application_view_detail.png"))); // NOI18N
        linkBtnCourse.setText("Management Course");
        linkBtnCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkBtnCourseActionPerformed(evt);
            }
        });
        jTaskPaneGroup2.getContentPane().add(linkBtnCourse);

        linkBtnPermisison.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/application_view_detail.png"))); // NOI18N
        linkBtnPermisison.setText("Management Permission");
        linkBtnPermisison.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkBtnPermisisonActionPerformed(evt);
            }
        });
        jTaskPaneGroup2.getContentPane().add(linkBtnPermisison);

        linkBtnRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/application_view_detail.png"))); // NOI18N
        linkBtnRegister.setText("Management Register");
        linkBtnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkBtnRegisterActionPerformed(evt);
            }
        });
        jTaskPaneGroup2.getContentPane().add(linkBtnRegister);

        jTaskPaneMenu.add(jTaskPaneGroup2);

        jTaskPaneGroup3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/view.png"))); // NOI18N
        jTaskPaneGroup3.setTitle("Search");

        linkBtnSearchStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow_right_green.png"))); // NOI18N
        linkBtnSearchStudent.setText("Student");
        jTaskPaneGroup3.getContentPane().add(linkBtnSearchStudent);

        linkBtnSearchEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow_right_green.png"))); // NOI18N
        linkBtnSearchEmp.setText("Employee");
        jTaskPaneGroup3.getContentPane().add(linkBtnSearchEmp);

        jTaskPaneMenu.add(jTaskPaneGroup3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelLeft.add(jTaskPaneMenu, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelLeft, gridBagConstraints);

        mnuSystem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/gear.png"))); // NOI18N
        mnuSystem.setText("System");

        menuIChangePass.setText("Change Password");
        menuIChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuIChangePassActionPerformed(evt);
            }
        });
        mnuSystem.add(menuIChangePass);

        mnuILoginSystem.setText("Login System");
        mnuILoginSystem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuILoginSystemActionPerformed(evt);
            }
        });
        mnuSystem.add(mnuILoginSystem);

        mnuILogoutSystem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/signout.png"))); // NOI18N
        mnuILogoutSystem.setText("Logout System");
        mnuSystem.add(mnuILogoutSystem);

        mnuIViewInformation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/businessman_find.png"))); // NOI18N
        mnuIViewInformation.setText("View Information");
        mnuSystem.add(mnuIViewInformation);

        mnuOptions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/gear.png"))); // NOI18N
        mnuOptions.setText("Options");

        mnuLang.setText("Language");

        buttonGroupLanguage.add(radioVietnamese);
        radioVietnamese.setSelected(true);
        radioVietnamese.setText("Vietnamese");
        mnuLang.add(radioVietnamese);

        buttonGroupLanguage.add(radioEnglish);
        radioEnglish.setText("English");
        mnuLang.add(radioEnglish);

        buttonGroupLanguage.add(radioJapan);
        radioJapan.setText("Japan");
        mnuLang.add(radioJapan);

        buttonGroupLanguage.add(radioChina);
        radioChina.setText("China");
        mnuLang.add(radioChina);

        buttonGroupLanguage.add(radioPhap);
        radioPhap.setText("Phap");
        mnuLang.add(radioPhap);

        mnuOptions.add(mnuLang);

        mnuSkin.setText("Skin");

        buttonGroupSkin.add(radioWindows);
        radioWindows.setSelected(true);
        radioWindows.setText("Windows");
        radioWindows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioWindowsActionPerformed(evt);
            }
        });
        mnuSkin.add(radioWindows);

        buttonGroupSkin.add(radioMetal);
        radioMetal.setText("Metal");
        radioMetal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMetalActionPerformed(evt);
            }
        });
        mnuSkin.add(radioMetal);

        buttonGroupSkin.add(radioNimbus);
        radioNimbus.setText("Nimbus");
        radioNimbus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNimbusActionPerformed(evt);
            }
        });
        mnuSkin.add(radioNimbus);

        buttonGroupSkin.add(radioMotif);
        radioMotif.setText("Motif");
        radioMotif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMotifActionPerformed(evt);
            }
        });
        mnuSkin.add(radioMotif);

        mnuOptions.add(mnuSkin);

        mnuSystem.add(mnuOptions);

        mnuISwitchUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/switch.jpg"))); // NOI18N
        mnuISwitchUser.setText("Switch User");
        mnuSystem.add(mnuISwitchUser);
        mnuSystem.add(jSeparator1);

        mnuIExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/exit.png"))); // NOI18N
        mnuIExit.setText("Exit");
        mnuIExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuIExitActionPerformed(evt);
            }
        });
        mnuSystem.add(mnuIExit);

        mnuBSystem.add(mnuSystem);

        mnuHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/help.png"))); // NOI18N
        mnuHelp.setText("Help");

        mnuIHelpContent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/help (2).png"))); // NOI18N
        mnuIHelpContent.setText("Help Contents");
        mnuIHelpContent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuIHelpContentActionPerformed(evt);
            }
        });
        mnuHelp.add(mnuIHelpContent);

        mnuIAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/about.png"))); // NOI18N
        mnuIAbout.setText("About");
        mnuIAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuIAboutActionPerformed(evt);
            }
        });
        mnuHelp.add(mnuIAbout);

        mnuBSystem.add(mnuHelp);

        setJMenuBar(mnuBSystem);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuILoginSystemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuILoginSystemActionPerformed
        // TODO add your handling code here:
        frmLogin login = new frmLogin();
        login.setVisible(true);
    }//GEN-LAST:event_mnuILoginSystemActionPerformed

    private void mnuIAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIAboutActionPerformed
        // TODO add your handling code here:
        frmAbout about = new frmAbout();
        about.setVisible(true);
    }//GEN-LAST:event_mnuIAboutActionPerformed

    private void radioWindowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioWindowsActionPerformed
        // TODO add your handling code here:
        if (radioWindows.isSelected()) {
            guidao.setGUI(guip.PLAF_WINDOWS);
        }
    }//GEN-LAST:event_radioWindowsActionPerformed

    private void radioMetalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMetalActionPerformed
        // TODO add your handling code here:
        if (radioMetal.isSelected()) {
            guidao.setGUI(guip.PLAF_METAL);
        }
    }//GEN-LAST:event_radioMetalActionPerformed

    private void radioNimbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNimbusActionPerformed
        // TODO add your handling code here:
        if (radioNimbus.isSelected()) {
            guidao.setGUI(guip.PLAF_NIMBUS);
        }
    }//GEN-LAST:event_radioNimbusActionPerformed

    private void radioMotifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMotifActionPerformed
        // TODO add your handling code here:
        if (radioMotif.isSelected()) {
            guidao.setGUI(guip.PLAF_MOTIF);
        }
    }//GEN-LAST:event_radioMotifActionPerformed

    private void menuIChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIChangePassActionPerformed
        // TODO add your handling code here:
        frmChangePass changePass = new frmChangePass();
        changePass.setVisible(true);
    }//GEN-LAST:event_menuIChangePassActionPerformed

    private void mnuIManagmentEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIManagmentEmpActionPerformed
        // TODO add your handling code here:
        frmEmployee employee = new frmEmployee();
        employee.setVisible(true);
    }//GEN-LAST:event_mnuIManagmentEmpActionPerformed

    private void mnuIHelpContentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIHelpContentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuIHelpContentActionPerformed

    private void mnuIExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_mnuIExitActionPerformed

    private void linkBtnEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkBtnEmployeeActionPerformed
        // TODO add your handling code here:
        frmEmployee employee = new frmEmployee();
        employee.setVisible(true);
    }//GEN-LAST:event_linkBtnEmployeeActionPerformed

    private void linkBtnStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkBtnStudentActionPerformed
        // TODO add your handling code here:
        frmStudent student = new frmStudent();
        student.setVisible(true);
    }//GEN-LAST:event_linkBtnStudentActionPerformed

    private void linkBtnCertificateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkBtnCertificateActionPerformed
        // TODO add your handling code here:
        frmCertificate certificate = new frmCertificate();
        certificate.setVisible(true);
    }//GEN-LAST:event_linkBtnCertificateActionPerformed

    private void linkBtnPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkBtnPaymentActionPerformed
        // TODO add your handling code here:
        frmPayment payment = new frmPayment();
        payment.setVisible(true);
    }//GEN-LAST:event_linkBtnPaymentActionPerformed

    private void linkBtnSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkBtnSubjectActionPerformed
        // TODO add your handling code here:
        frmSubject subject = new frmSubject();
        subject.setVisible(true);
    }//GEN-LAST:event_linkBtnSubjectActionPerformed

    private void linkBtnMarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkBtnMarkActionPerformed
        // TODO add your handling code here:
        frmMark scoure = new frmMark();
        scoure.setVisible(true);
    }//GEN-LAST:event_linkBtnMarkActionPerformed

    private void linkBtnAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkBtnAccountActionPerformed
        // TODO add your handling code here:
        frmAccount account = new frmAccount();
        account.setVisible(true);
    }//GEN-LAST:event_linkBtnAccountActionPerformed

    private void linkBtnCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkBtnCourseActionPerformed
        // TODO add your handling code here:
        frmCourse course = new frmCourse();
        course.setVisible(true);
    }//GEN-LAST:event_linkBtnCourseActionPerformed

    private void linkBtnPermisisonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkBtnPermisisonActionPerformed
        // TODO add your handling code here:
        frmPermission permission = new frmPermission();
        permission.setVisible(true);
    }//GEN-LAST:event_linkBtnPermisisonActionPerformed

    private void linkBtnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkBtnRegisterActionPerformed
        // TODO add your handling code here:
        frmRegister register = new frmRegister();
        register.setVisible(true);
    }//GEN-LAST:event_linkBtnRegisterActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupLanguage;
    private javax.swing.ButtonGroup buttonGroupSkin;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private com.l2fprod.common.swing.JTaskPaneGroup jTaskPaneGroup1;
    private com.l2fprod.common.swing.JTaskPaneGroup jTaskPaneGroup2;
    private com.l2fprod.common.swing.JTaskPaneGroup jTaskPaneGroup3;
    private com.l2fprod.common.swing.JTaskPane jTaskPaneMenu;
    private javax.swing.JLabel lblLogo;
    private com.l2fprod.common.swing.JLinkButton linkBtnAccount;
    private com.l2fprod.common.swing.JLinkButton linkBtnCertificate;
    private com.l2fprod.common.swing.JLinkButton linkBtnChangePassword;
    private com.l2fprod.common.swing.JLinkButton linkBtnCourse;
    private com.l2fprod.common.swing.JLinkButton linkBtnEmployee;
    private com.l2fprod.common.swing.JLinkButton linkBtnMark;
    private com.l2fprod.common.swing.JLinkButton linkBtnPayment;
    private com.l2fprod.common.swing.JLinkButton linkBtnPermisison;
    private com.l2fprod.common.swing.JLinkButton linkBtnRegister;
    private com.l2fprod.common.swing.JLinkButton linkBtnSearchEmp;
    private com.l2fprod.common.swing.JLinkButton linkBtnSearchStudent;
    private com.l2fprod.common.swing.JLinkButton linkBtnSingout;
    private com.l2fprod.common.swing.JLinkButton linkBtnStudent;
    private com.l2fprod.common.swing.JLinkButton linkBtnSubject;
    private com.l2fprod.common.swing.JLinkButton linkBtnSwitchUser;
    private com.l2fprod.common.swing.JLinkButton linkBtnViewInformation;
    private javax.swing.JMenuItem menuIChangePass;
    private javax.swing.JMenuBar mnuBSystem;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JMenuItem mnuIAbout;
    private javax.swing.JMenuItem mnuIExit;
    private javax.swing.JMenuItem mnuIHelpContent;
    private javax.swing.JMenuItem mnuILoginSystem;
    private javax.swing.JMenuItem mnuILogoutSystem;
    private javax.swing.JMenuItem mnuISwitchUser;
    private javax.swing.JMenuItem mnuIViewInformation;
    private javax.swing.JMenu mnuLang;
    private javax.swing.JMenu mnuOptions;
    private javax.swing.JMenu mnuSkin;
    private javax.swing.JMenu mnuSystem;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelLogo;
    private javax.swing.JPanel panelRight;
    private javax.swing.JRadioButtonMenuItem radioChina;
    private javax.swing.JRadioButtonMenuItem radioEnglish;
    private javax.swing.JRadioButtonMenuItem radioJapan;
    private javax.swing.JRadioButtonMenuItem radioMetal;
    private javax.swing.JRadioButtonMenuItem radioMotif;
    private javax.swing.JRadioButtonMenuItem radioNimbus;
    private javax.swing.JRadioButtonMenuItem radioPhap;
    private javax.swing.JRadioButtonMenuItem radioVietnamese;
    private javax.swing.JRadioButtonMenuItem radioWindows;
    // End of variables declaration//GEN-END:variables
}
