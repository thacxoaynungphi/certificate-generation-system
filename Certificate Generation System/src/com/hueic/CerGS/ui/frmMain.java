
/*
 * MainFrm.java
 *
 * Created on Mar 13, 2011, 5:37:51 PM
 */
package com.hueic.CerGS.ui;

import com.hueic.CerGS.component.AppStatusBar;
import com.hueic.CerGS.entity.Account;
import com.hueic.CerGS.component.GUIProperties;
import com.hueic.CerGS.component.IconSystem;
import com.hueic.CerGS.dao.GUIDAO;
import com.hueic.CerGS.dao.PermissionDAO;
import java.net.URL;
import javax.help.CSH;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JOptionPane;

/**
 *
 * @author nhchung
 */
public class frmMain extends javax.swing.JFrame {

    /** Creates new form MainFrm */
    GUIDAO guidao = null;
    GUIProperties guip = new GUIProperties();
    public Account accCur;
    String theme = "ExperienceBlue";
    String lookandfeel = guip.PLAF_WINDOWSXP;
    pnlAccount account = new pnlAccount();
    pnlCertificate cer = new pnlCertificate(this);
    pnlCourse course = new pnlCourse(this);
    pnlMark mark = new pnlMark(this);
    pnlPayment payment = new pnlPayment(this);
    pnlRegister register = new pnlRegister(this);
    pnlPermission per = new pnlPermission();
    pnlSubject subject = new pnlSubject(this);
    pnlStudent student = new pnlStudent(this);
    pnlEmployee emp = new pnlEmployee(this);
    pnlViewMark viewMark;
    pnlViewPayment viewPayment;
    pnlDevelopDegree developDegree = new pnlDevelopDegree(this);
    pnlHome homeAdmin = new pnlHome(this);
    pnlReport report = new pnlReport();
    PermissionDAO perDao;

    public frmMain() {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        perDao = new PermissionDAO();
        guidao = new GUIDAO(this);
        guidao.setGUI(lookandfeel, theme);
        new IconSystem(this);
        initStatusBar();
        HelpSet hs = getHelpSet("com/hueic/CerGS/myhelp/sample.hs");
        HelpBroker hb = hs.createHelpBroker();
        CSH.setHelpIDString(mnuIHelpContent, "top");
        mnuIHelpContent.addActionListener(new CSH.DisplayHelpFromSource(hb));
        radioWindowsXP.setSelected(true);
        radioExperienceBlue.setSelected(true);
    }

    public void initStatusBar() {
        this.StatusPnl.removeAll();
        AppStatusBar status = new AppStatusBar(this);
        this.StatusPnl.add(status.getBar());
        this.tpnBusiness.setSelectedComponent(pnlHomeTab);
    }

    public HelpSet getHelpSet(String helpsetfile) {
        HelpSet hs = null;
        ClassLoader cl = this.getClass().getClassLoader();
        try {
            URL hsURL = HelpSet.findHelpSet(cl, helpsetfile);
            hs = new HelpSet(null, hsURL);
        } catch (Exception ee) {
            JOptionPane.showMessageDialog(this, "HelpSet: " + helpsetfile + " not found", "Help File", JOptionPane.ERROR_MESSAGE);
        }
        return hs;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroupSkin = new javax.swing.ButtonGroup();
        buttonGroupTheme = new javax.swing.ButtonGroup();
        panelLogo = new javax.swing.JPanel();
        tbMenu = new javax.swing.JToolBar();
        jideBtnHome = new com.jidesoft.swing.JideButton();
        jideBtnEmployee = new com.jidesoft.swing.JideButton();
        jideBtnStudent = new com.jidesoft.swing.JideButton();
        jideBtnRegister = new com.jidesoft.swing.JideButton();
        jideBtnCourse = new com.jidesoft.swing.JideButton();
        jideBtnSubject = new com.jidesoft.swing.JideButton();
        jideBtnCertificate = new com.jidesoft.swing.JideButton();
        jideBtnAccount = new com.jidesoft.swing.JideButton();
        jideBtnMark = new com.jidesoft.swing.JideButton();
        jideBtnPayment = new com.jidesoft.swing.JideButton();
        jideBtnReport = new com.jidesoft.swing.JideButton();
        panelLeft = new javax.swing.JPanel();
        tpnBusiness = new javax.swing.JTabbedPane();
        pnlHomeTab = new javax.swing.JPanel();
        pnlEmployeeTab = new javax.swing.JPanel();
        pnlStudentTab = new javax.swing.JPanel();
        pnlRegisterTab = new javax.swing.JPanel();
        pnlCourseTab = new javax.swing.JPanel();
        pnlPaymentTab = new javax.swing.JPanel();
        pnlSubjectTab = new javax.swing.JPanel();
        pnlMarkTab = new javax.swing.JPanel();
        pnlCertificateTab = new javax.swing.JPanel();
        pnlAccountTab = new javax.swing.JPanel();
        pnlPermissionTab = new javax.swing.JPanel();
        pnlViewMarkTab = new javax.swing.JPanel();
        pnlViewPaymentTab = new javax.swing.JPanel();
        pnlDevelopDegree = new javax.swing.JPanel();
        pnlReport = new javax.swing.JPanel();
        StatusPnl = new javax.swing.JPanel();
        mnuBSystem = new javax.swing.JMenuBar();
        mnuSystem = new javax.swing.JMenu();
        mnuILoginSystem = new javax.swing.JMenuItem();
        mnuILogoutSystem = new javax.swing.JMenuItem();
        menuIChangePass = new javax.swing.JMenuItem();
        mnuIConfiguration = new javax.swing.JMenuItem();
        mnuOptions = new javax.swing.JMenu();
        mnuSkin = new javax.swing.JMenu();
        radioWindows = new javax.swing.JRadioButtonMenuItem();
        radioMetal = new javax.swing.JRadioButtonMenuItem();
        radioJgoodies = new javax.swing.JRadioButtonMenuItem();
        radioWindowsXP = new javax.swing.JRadioButtonMenuItem();
        mnuTheme = new javax.swing.JMenu();
        radioDarkStar = new javax.swing.JRadioButtonMenuItem();
        radioDesertBlue = new javax.swing.JRadioButtonMenuItem();
        radioDesertGreen = new javax.swing.JRadioButtonMenuItem();
        radioDesertYellow = new javax.swing.JRadioButtonMenuItem();
        radioExperienceBlue = new javax.swing.JRadioButtonMenuItem();
        radioExperienceGreen = new javax.swing.JRadioButtonMenuItem();
        radioExperenceRoyale = new javax.swing.JRadioButtonMenuItem();
        radioLightGray = new javax.swing.JRadioButtonMenuItem();
        radioSilver = new javax.swing.JRadioButtonMenuItem();
        radioSkyBlue = new javax.swing.JRadioButtonMenuItem();
        radioSkyBluer = new javax.swing.JRadioButtonMenuItem();
        radioSkyGreen = new javax.swing.JRadioButtonMenuItem();
        radioSkyPink = new javax.swing.JRadioButtonMenuItem();
        radioSkyRed = new javax.swing.JRadioButtonMenuItem();
        radioSkyYellow = new javax.swing.JRadioButtonMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuIExit = new javax.swing.JMenuItem();
        mnuHelp = new javax.swing.JMenu();
        mnuIHelpContent = new javax.swing.JMenuItem();
        mnuIAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Certificate Generation System");
        setMinimumSize(new java.awt.Dimension(1000, 720));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelLogo.setMinimumSize(new java.awt.Dimension(1024, 40));
        panelLogo.setPreferredSize(new java.awt.Dimension(1024, 40));
        panelLogo.setLayout(new java.awt.GridBagLayout());

        tbMenu.setFloatable(false);
        tbMenu.setRollover(true);
        tbMenu.setMaximumSize(new java.awt.Dimension(1024, 40));
        tbMenu.setMinimumSize(new java.awt.Dimension(1024, 40));
        tbMenu.setPreferredSize(new java.awt.Dimension(1024, 40));

        jideBtnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/home_icon.png"))); // NOI18N
        jideBtnHome.setToolTipText("Home");
        jideBtnHome.setEnabled(false);
        jideBtnHome.setFocusable(false);
        jideBtnHome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jideBtnHome.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jideBtnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jideBtnHomeActionPerformed(evt);
            }
        });
        tbMenu.add(jideBtnHome);

        jideBtnEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/emp_icon_32.png"))); // NOI18N
        jideBtnEmployee.setToolTipText("Manager Employee");
        jideBtnEmployee.setEnabled(false);
        jideBtnEmployee.setFocusable(false);
        jideBtnEmployee.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jideBtnEmployee.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jideBtnEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jideBtnEmployeeActionPerformed(evt);
            }
        });
        tbMenu.add(jideBtnEmployee);

        jideBtnStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/student_icon -32.png"))); // NOI18N
        jideBtnStudent.setToolTipText("Manager Student");
        jideBtnStudent.setEnabled(false);
        jideBtnStudent.setFocusable(false);
        jideBtnStudent.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jideBtnStudent.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jideBtnStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jideBtnStudentActionPerformed(evt);
            }
        });
        tbMenu.add(jideBtnStudent);

        jideBtnRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/icon_register.png"))); // NOI18N
        jideBtnRegister.setToolTipText("Manager Register");
        jideBtnRegister.setEnabled(false);
        jideBtnRegister.setFocusable(false);
        jideBtnRegister.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jideBtnRegister.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jideBtnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jideBtnRegisterActionPerformed(evt);
            }
        });
        tbMenu.add(jideBtnRegister);

        jideBtnCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/icon_course.png"))); // NOI18N
        jideBtnCourse.setToolTipText("Manager Course");
        jideBtnCourse.setEnabled(false);
        jideBtnCourse.setFocusable(false);
        jideBtnCourse.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jideBtnCourse.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jideBtnCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jideBtnCourseActionPerformed(evt);
            }
        });
        tbMenu.add(jideBtnCourse);

        jideBtnSubject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/subject_icon.png"))); // NOI18N
        jideBtnSubject.setToolTipText("Manager Subject");
        jideBtnSubject.setEnabled(false);
        jideBtnSubject.setFocusable(false);
        jideBtnSubject.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jideBtnSubject.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jideBtnSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jideBtnSubjectActionPerformed(evt);
            }
        });
        tbMenu.add(jideBtnSubject);

        jideBtnCertificate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Certificate_icon_32.png"))); // NOI18N
        jideBtnCertificate.setToolTipText("Manager Certificate");
        jideBtnCertificate.setEnabled(false);
        jideBtnCertificate.setFocusable(false);
        jideBtnCertificate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jideBtnCertificate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jideBtnCertificate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jideBtnCertificateActionPerformed(evt);
            }
        });
        tbMenu.add(jideBtnCertificate);

        jideBtnAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/account_icon -32.png"))); // NOI18N
        jideBtnAccount.setToolTipText("Manager Account");
        jideBtnAccount.setEnabled(false);
        jideBtnAccount.setFocusable(false);
        jideBtnAccount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jideBtnAccount.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jideBtnAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jideBtnAccountActionPerformed(evt);
            }
        });
        tbMenu.add(jideBtnAccount);

        jideBtnMark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/mark_icon_32.png"))); // NOI18N
        jideBtnMark.setToolTipText("Manager Mark");
        jideBtnMark.setEnabled(false);
        jideBtnMark.setFocusable(false);
        jideBtnMark.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jideBtnMark.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jideBtnMark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jideBtnMarkActionPerformed(evt);
            }
        });
        tbMenu.add(jideBtnMark);

        jideBtnPayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Dollar_32.png"))); // NOI18N
        jideBtnPayment.setToolTipText("Manager Payment");
        jideBtnPayment.setEnabled(false);
        jideBtnPayment.setFocusable(false);
        jideBtnPayment.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jideBtnPayment.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jideBtnPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jideBtnPaymentActionPerformed(evt);
            }
        });
        tbMenu.add(jideBtnPayment);

        jideBtnReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Statistic_bg.png"))); // NOI18N
        jideBtnReport.setToolTipText("Manager Report");
        jideBtnReport.setEnabled(false);
        jideBtnReport.setFocusable(false);
        jideBtnReport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jideBtnReport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jideBtnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jideBtnReportActionPerformed(evt);
            }
        });
        tbMenu.add(jideBtnReport);

        panelLogo.add(tbMenu, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelLogo, gridBagConstraints);

        panelLeft.setBackground(new java.awt.Color(255, 255, 255));
        panelLeft.setMinimumSize(new java.awt.Dimension(1024, 600));
        panelLeft.setPreferredSize(new java.awt.Dimension(1024, 600));
        panelLeft.setLayout(new java.awt.GridBagLayout());

        tpnBusiness.setBackground(new java.awt.Color(255, 255, 255));
        tpnBusiness.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tpnBusiness.setEnabled(false);
        tpnBusiness.setFont(new java.awt.Font("Tahoma", 1, 12));
        tpnBusiness.setMaximumSize(new java.awt.Dimension(1024, 600));
        tpnBusiness.setMinimumSize(new java.awt.Dimension(1024, 600));
        tpnBusiness.setPreferredSize(new java.awt.Dimension(1024, 600));
        tpnBusiness.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tpnBusinessStateChanged(evt);
            }
        });

        pnlHomeTab.setBackground(new java.awt.Color(255, 255, 255));
        pnlHomeTab.setEnabled(false);
        pnlHomeTab.setMaximumSize(new java.awt.Dimension(800, 600));
        pnlHomeTab.setMinimumSize(new java.awt.Dimension(800, 600));
        pnlHomeTab.setPreferredSize(new java.awt.Dimension(800, 600));
        pnlHomeTab.setRequestFocusEnabled(false);
        pnlHomeTab.setLayout(new java.awt.GridBagLayout());

        pnlHomeTab = homeAdmin;

        tpnBusiness.addTab("Home                  ", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlHomeTab); // NOI18N

        pnlEmployeeTab.setBackground(new java.awt.Color(255, 255, 255));
        pnlEmployeeTab.setEnabled(false);

        pnlEmployeeTab = emp;

        tpnBusiness.addTab("Employee            ", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlEmployeeTab); // NOI18N

        pnlStudentTab.setBackground(new java.awt.Color(255, 255, 255));
        pnlStudentTab.setEnabled(false);

        pnlStudentTab = student;

        tpnBusiness.addTab("Student", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlStudentTab); // NOI18N

        pnlRegisterTab.setBackground(new java.awt.Color(255, 255, 255));
        pnlRegisterTab.setEnabled(false);
        pnlRegisterTab = register;
        tpnBusiness.addTab("Register", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlRegisterTab); // NOI18N

        pnlCourseTab.setBackground(new java.awt.Color(255, 255, 255));
        pnlCourseTab.setEnabled(false);

        pnlCourseTab = course;

        tpnBusiness.addTab("Course", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlCourseTab); // NOI18N

        pnlPaymentTab.setBackground(new java.awt.Color(255, 255, 255));
        pnlPaymentTab.setEnabled(false);
        pnlPaymentTab = payment;
        tpnBusiness.addTab("Payment", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlPaymentTab); // NOI18N

        pnlSubjectTab.setBackground(new java.awt.Color(255, 255, 255));
        pnlSubjectTab.setEnabled(false);
        pnlSubjectTab = subject;
        tpnBusiness.addTab("Subject", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlSubjectTab); // NOI18N

        pnlMarkTab.setBackground(new java.awt.Color(255, 255, 255));
        pnlMarkTab.setEnabled(false);
        pnlMarkTab = mark;
        tpnBusiness.addTab("Mark", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlMarkTab); // NOI18N

        pnlCertificateTab.setBackground(new java.awt.Color(255, 255, 255));
        pnlCertificateTab.setEnabled(false);
        pnlCertificateTab = cer;
        tpnBusiness.addTab("Certificate", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlCertificateTab); // NOI18N

        pnlAccountTab.setBackground(new java.awt.Color(255, 255, 255));
        pnlAccountTab.setEnabled(false);
        pnlAccountTab = account;
        tpnBusiness.addTab("Account             ", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlAccountTab); // NOI18N

        pnlPermissionTab.setBackground(new java.awt.Color(255, 255, 255));
        pnlPermissionTab.setEnabled(false);
        pnlPermissionTab.setMinimumSize(new java.awt.Dimension(860, 600));
        pnlPermissionTab.setPreferredSize(new java.awt.Dimension(860, 600));
        pnlPermissionTab = per;
        tpnBusiness.addTab("Permission", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlPermissionTab); // NOI18N

        pnlViewMarkTab.setBackground(new java.awt.Color(255, 255, 255));
        pnlViewMarkTab.setEnabled(false);

        javax.swing.GroupLayout pnlViewMarkTabLayout = new javax.swing.GroupLayout(pnlViewMarkTab);
        pnlViewMarkTab.setLayout(pnlViewMarkTabLayout);
        pnlViewMarkTabLayout.setHorizontalGroup(
            pnlViewMarkTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
        );
        pnlViewMarkTabLayout.setVerticalGroup(
            pnlViewMarkTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );

        tpnBusiness.addTab("View Mark", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlViewMarkTab); // NOI18N

        pnlViewPaymentTab.setBackground(new java.awt.Color(255, 255, 255));
        pnlViewPaymentTab.setEnabled(false);

        javax.swing.GroupLayout pnlViewPaymentTabLayout = new javax.swing.GroupLayout(pnlViewPaymentTab);
        pnlViewPaymentTab.setLayout(pnlViewPaymentTabLayout);
        pnlViewPaymentTabLayout.setHorizontalGroup(
            pnlViewPaymentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
        );
        pnlViewPaymentTabLayout.setVerticalGroup(
            pnlViewPaymentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );

        tpnBusiness.addTab("View Payment", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlViewPaymentTab); // NOI18N

        pnlDevelopDegree.setBackground(new java.awt.Color(255, 255, 255));
        pnlDevelopDegree.setEnabled(false);

        javax.swing.GroupLayout pnlDevelopDegreeLayout = new javax.swing.GroupLayout(pnlDevelopDegree);
        pnlDevelopDegree.setLayout(pnlDevelopDegreeLayout);
        pnlDevelopDegreeLayout.setHorizontalGroup(
            pnlDevelopDegreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
        );
        pnlDevelopDegreeLayout.setVerticalGroup(
            pnlDevelopDegreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );

        pnlDevelopDegree =  developDegree;

        tpnBusiness.addTab("Develop Degree", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlDevelopDegree); // NOI18N

        pnlReport.setBackground(new java.awt.Color(255, 255, 255));
        pnlReport.setEnabled(false);

        javax.swing.GroupLayout pnlReportLayout = new javax.swing.GroupLayout(pnlReport);
        pnlReport.setLayout(pnlReportLayout);
        pnlReportLayout.setHorizontalGroup(
            pnlReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
        );
        pnlReportLayout.setVerticalGroup(
            pnlReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );

        tpnBusiness.addTab("Report", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlReport); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelLeft.add(tpnBusiness, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelLeft, gridBagConstraints);

        StatusPnl.setMinimumSize(new java.awt.Dimension(1024, 20));
        StatusPnl.setPreferredSize(new java.awt.Dimension(1024, 20));
        StatusPnl.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        getContentPane().add(StatusPnl, gridBagConstraints);

        mnuBSystem.setMaximumSize(new java.awt.Dimension(1024, 23));
        mnuBSystem.setMinimumSize(new java.awt.Dimension(1024, 23));
        mnuBSystem.setPreferredSize(new java.awt.Dimension(1024, 23));

        mnuSystem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/gear.png"))); // NOI18N
        mnuSystem.setText("System");

        mnuILoginSystem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK));
        mnuILoginSystem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/IconLogin.png"))); // NOI18N
        mnuILoginSystem.setText("Login System");
        mnuILoginSystem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuILoginSystemActionPerformed(evt);
            }
        });
        mnuSystem.add(mnuILoginSystem);

        mnuILogoutSystem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK));
        mnuILogoutSystem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/signout.png"))); // NOI18N
        mnuILogoutSystem.setText("Logout System");
        mnuILogoutSystem.setEnabled(false);
        mnuILogoutSystem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuILogoutSystemActionPerformed(evt);
            }
        });
        mnuSystem.add(mnuILogoutSystem);

        menuIChangePass.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        menuIChangePass.setText("Change Pass");
        menuIChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuIChangePassActionPerformed(evt);
            }
        });
        mnuSystem.add(menuIChangePass);

        mnuIConfiguration.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        mnuIConfiguration.setText("Configuration DB");
        mnuIConfiguration.setEnabled(false);
        mnuIConfiguration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuIConfigurationActionPerformed(evt);
            }
        });
        mnuSystem.add(mnuIConfiguration);

        mnuOptions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/gear.png"))); // NOI18N
        mnuOptions.setText("Options");
        mnuOptions.setEnabled(false);

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

        buttonGroupSkin.add(radioJgoodies);
        radioJgoodies.setText("Jgoodies");
        radioJgoodies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioJgoodiesActionPerformed(evt);
            }
        });
        mnuSkin.add(radioJgoodies);

        buttonGroupSkin.add(radioWindowsXP);
        radioWindowsXP.setText("Windows XP");
        radioWindowsXP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioWindowsXPActionPerformed(evt);
            }
        });
        mnuSkin.add(radioWindowsXP);

        mnuOptions.add(mnuSkin);

        mnuTheme.setText("Theme");

        buttonGroupTheme.add(radioDarkStar);
        radioDarkStar.setSelected(true);
        radioDarkStar.setText("Dark Star");
        radioDarkStar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDarkStarActionPerformed(evt);
            }
        });
        mnuTheme.add(radioDarkStar);

        buttonGroupTheme.add(radioDesertBlue);
        radioDesertBlue.setText("Deser Blue");
        radioDesertBlue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDesertBlueActionPerformed(evt);
            }
        });
        mnuTheme.add(radioDesertBlue);

        buttonGroupTheme.add(radioDesertGreen);
        radioDesertGreen.setText("Deser Green");
        radioDesertGreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDesertGreenActionPerformed(evt);
            }
        });
        mnuTheme.add(radioDesertGreen);

        buttonGroupTheme.add(radioDesertYellow);
        radioDesertYellow.setText("Deser Yellow");
        radioDesertYellow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDesertYellowActionPerformed(evt);
            }
        });
        mnuTheme.add(radioDesertYellow);

        buttonGroupTheme.add(radioExperienceBlue);
        radioExperienceBlue.setText("Experience Blue");
        radioExperienceBlue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioExperienceBlueActionPerformed(evt);
            }
        });
        mnuTheme.add(radioExperienceBlue);

        buttonGroupTheme.add(radioExperienceGreen);
        radioExperienceGreen.setText("Experience Green");
        radioExperienceGreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioExperienceGreenActionPerformed(evt);
            }
        });
        mnuTheme.add(radioExperienceGreen);

        buttonGroupTheme.add(radioExperenceRoyale);
        radioExperenceRoyale.setText("Experence Royale");
        radioExperenceRoyale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioExperenceRoyaleActionPerformed(evt);
            }
        });
        mnuTheme.add(radioExperenceRoyale);

        buttonGroupTheme.add(radioLightGray);
        radioLightGray.setText("Light Gray");
        radioLightGray.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioLightGrayActionPerformed(evt);
            }
        });
        mnuTheme.add(radioLightGray);

        buttonGroupTheme.add(radioSilver);
        radioSilver.setText("Silver");
        radioSilver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSilverActionPerformed(evt);
            }
        });
        mnuTheme.add(radioSilver);

        buttonGroupTheme.add(radioSkyBlue);
        radioSkyBlue.setText("Sky Blue");
        radioSkyBlue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSkyBlueActionPerformed(evt);
            }
        });
        mnuTheme.add(radioSkyBlue);

        buttonGroupTheme.add(radioSkyBluer);
        radioSkyBluer.setText("Sky Bluer");
        radioSkyBluer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSkyBluerActionPerformed(evt);
            }
        });
        mnuTheme.add(radioSkyBluer);

        buttonGroupTheme.add(radioSkyGreen);
        radioSkyGreen.setText("Sky Green");
        radioSkyGreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSkyGreenActionPerformed(evt);
            }
        });
        mnuTheme.add(radioSkyGreen);

        buttonGroupTheme.add(radioSkyPink);
        radioSkyPink.setText("Sky Pink");
        radioSkyPink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSkyPinkActionPerformed(evt);
            }
        });
        mnuTheme.add(radioSkyPink);

        buttonGroupTheme.add(radioSkyRed);
        radioSkyRed.setText("Sky Red");
        radioSkyRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSkyRedActionPerformed(evt);
            }
        });
        mnuTheme.add(radioSkyRed);

        buttonGroupTheme.add(radioSkyYellow);
        radioSkyYellow.setText("Sky Yellow");
        radioSkyYellow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSkyYellowActionPerformed(evt);
            }
        });
        mnuTheme.add(radioSkyYellow);

        mnuOptions.add(mnuTheme);

        mnuSystem.add(mnuOptions);
        mnuSystem.add(jSeparator1);

        mnuIExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
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

        mnuIHelpContent.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        mnuIHelpContent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/help (2).png"))); // NOI18N
        mnuIHelpContent.setText("Help Contents");
        mnuHelp.add(mnuIHelpContent);

        mnuIAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
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

        dlgLogin login = new dlgLogin(this, true);
        login.setVisible(true);
    }//GEN-LAST:event_mnuILoginSystemActionPerformed

    private void mnuIAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIAboutActionPerformed

        dlgAbout about = new dlgAbout(this, true);
        about.setVisible(true);
    }//GEN-LAST:event_mnuIAboutActionPerformed

    private void radioWindowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioWindowsActionPerformed

        if (radioWindows.isSelected()) {
            lookandfeel = guip.PLAF_WINDOWS;
            guidao.setGUI(lookandfeel, theme);
        }
    }//GEN-LAST:event_radioWindowsActionPerformed

    private void radioMetalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMetalActionPerformed

        if (radioMetal.isSelected()) {
            lookandfeel = guip.PLAF_METAL;
            guidao.setGUI(lookandfeel, theme);
        }
    }//GEN-LAST:event_radioMetalActionPerformed

    private void menuIChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIChangePassActionPerformed

        if (accCur != null) {
            dlgChangePass changePass = new dlgChangePass(this, true, this.accCur);
            changePass.setVisible(true);
        }
    }//GEN-LAST:event_menuIChangePassActionPerformed

    private void mnuIManagmentEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIManagmentEmpActionPerformed

    }//GEN-LAST:event_mnuIManagmentEmpActionPerformed

    private void mnuIHelpContentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIHelpContentActionPerformed

    }//GEN-LAST:event_mnuIHelpContentActionPerformed

    private void mnuIExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIExitActionPerformed

        System.exit(0);
    }//GEN-LAST:event_mnuIExitActionPerformed

    private void mnuISwitchUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuISwitchUserActionPerformed

        if (this.accCur != null) {
            accCur = null;
            this.setVisible(false);
            dlgLogin login = new dlgLogin(this);
            login.setVisible(true);
        }
    }//GEN-LAST:event_mnuISwitchUserActionPerformed

    private void mnuILogoutSystemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuILogoutSystemActionPerformed

        if (this.accCur != null) {
            accCur = null;
            initStatusBar();
            this.isLogout();
            dlgLogin login = new dlgLogin(this, true);
            login.setVisible(true);
        }
    }//GEN-LAST:event_mnuILogoutSystemActionPerformed

    private void radioJgoodiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioJgoodiesActionPerformed

        if (radioJgoodies.isSelected()) {
            lookandfeel = guip.PLAF_JGOODIES;
            guidao.setGUI(lookandfeel, theme);
        }
}//GEN-LAST:event_radioJgoodiesActionPerformed

    private void radioDarkStarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDarkStarActionPerformed

        if (radioDarkStar.isSelected()) {
            theme = "DarkStar";
            guidao.setGUI(lookandfeel, theme);
        }
    }//GEN-LAST:event_radioDarkStarActionPerformed

    private void radioDesertBlueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDesertBlueActionPerformed

        if (radioDesertBlue.isSelected()) {
            theme = "DesertBlue";
            guidao.setGUI(lookandfeel, theme);
        }
    }//GEN-LAST:event_radioDesertBlueActionPerformed

    private void radioDesertGreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDesertGreenActionPerformed

        if (radioDesertGreen.isSelected()) {
            theme = "DesertGreen";
            guidao.setGUI(lookandfeel, theme);
        }
    }//GEN-LAST:event_radioDesertGreenActionPerformed

    private void radioDesertYellowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDesertYellowActionPerformed

        if (radioDesertYellow.isSelected()) {
            theme = "DesertYellow";
            guidao.setGUI(lookandfeel, theme);
        }
    }//GEN-LAST:event_radioDesertYellowActionPerformed

    private void radioExperienceBlueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioExperienceBlueActionPerformed

        if (radioExperienceBlue.isSelected()) {
            theme = "ExperienceBlue";
            guidao.setGUI(lookandfeel, theme);
        }
    }//GEN-LAST:event_radioExperienceBlueActionPerformed

    private void radioExperienceGreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioExperienceGreenActionPerformed

        if (radioExperienceGreen.isSelected()) {
            theme = "ExperienceGreen";
            guidao.setGUI(lookandfeel, theme);
        }
    }//GEN-LAST:event_radioExperienceGreenActionPerformed

    private void radioExperenceRoyaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioExperenceRoyaleActionPerformed

        if (radioExperenceRoyale.isSelected()) {
            theme = "ExperienceRoyale";
            guidao.setGUI(lookandfeel, theme);
        }
    }//GEN-LAST:event_radioExperenceRoyaleActionPerformed

    private void radioLightGrayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioLightGrayActionPerformed

        if (radioLightGray.isSelected()) {
            theme = "LightGray";
            guidao.setGUI(lookandfeel, theme);
        }
    }//GEN-LAST:event_radioLightGrayActionPerformed

    private void radioSilverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSilverActionPerformed

        if (radioSilver.isSelected()) {
            theme = "Silver";
            guidao.setGUI(lookandfeel, theme);
        }
    }//GEN-LAST:event_radioSilverActionPerformed

    private void radioSkyBlueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSkyBlueActionPerformed

        if (radioSkyBlue.isSelected()) {
            theme = "SkyBlue";
            guidao.setGUI(lookandfeel, theme);
        }
    }//GEN-LAST:event_radioSkyBlueActionPerformed

    private void radioSkyBluerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSkyBluerActionPerformed

        if (radioSkyBluer.isSelected()) {
            theme = "SkyBluer";
            guidao.setGUI(lookandfeel, theme);
        }
    }//GEN-LAST:event_radioSkyBluerActionPerformed

    private void radioSkyGreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSkyGreenActionPerformed

        if (radioSkyGreen.isSelected()) {
            theme = "SkyGreen";
            guidao.setGUI(lookandfeel, theme);
        }
    }//GEN-LAST:event_radioSkyGreenActionPerformed

    private void radioSkyPinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSkyPinkActionPerformed

        if (radioSkyPink.isSelected()) {
            theme = "SkyPink";
            guidao.setGUI(lookandfeel, theme);
        }
    }//GEN-LAST:event_radioSkyPinkActionPerformed

    private void radioSkyRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSkyRedActionPerformed

        if (radioSkyRed.isSelected()) {
            theme = "SkyRed";
            guidao.setGUI(lookandfeel, theme);
        }
    }//GEN-LAST:event_radioSkyRedActionPerformed

    private void radioSkyYellowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSkyYellowActionPerformed

        if (radioSkyYellow.isSelected()) {
            theme = "SkyYellow";
            guidao.setGUI(lookandfeel, theme);
        }
    }//GEN-LAST:event_radioSkyYellowActionPerformed

    private void jideBtnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jideBtnHomeActionPerformed

        tpnBusiness.setSelectedComponent(pnlHomeTab);
    }//GEN-LAST:event_jideBtnHomeActionPerformed

    private void jideBtnEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jideBtnEmployeeActionPerformed

        tpnBusiness.setSelectedComponent(pnlEmployeeTab);
    }//GEN-LAST:event_jideBtnEmployeeActionPerformed

    private void jideBtnStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jideBtnStudentActionPerformed

        tpnBusiness.setSelectedComponent(pnlStudentTab);
    }//GEN-LAST:event_jideBtnStudentActionPerformed

    private void jideBtnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jideBtnRegisterActionPerformed

        tpnBusiness.setSelectedComponent(pnlRegisterTab);
    }//GEN-LAST:event_jideBtnRegisterActionPerformed

    private void jideBtnCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jideBtnCourseActionPerformed

        tpnBusiness.setSelectedComponent(pnlCourseTab);
    }//GEN-LAST:event_jideBtnCourseActionPerformed

    private void jideBtnSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jideBtnSubjectActionPerformed

        tpnBusiness.setSelectedComponent(pnlSubjectTab);
    }//GEN-LAST:event_jideBtnSubjectActionPerformed

    private void jideBtnCertificateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jideBtnCertificateActionPerformed

        tpnBusiness.setSelectedComponent(pnlCertificateTab);
    }//GEN-LAST:event_jideBtnCertificateActionPerformed

    private void jideBtnAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jideBtnAccountActionPerformed

        tpnBusiness.setSelectedComponent(pnlAccountTab);
    }//GEN-LAST:event_jideBtnAccountActionPerformed

    private void jideBtnMarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jideBtnMarkActionPerformed

        tpnBusiness.setSelectedComponent(pnlMarkTab);
    }//GEN-LAST:event_jideBtnMarkActionPerformed

    private void jideBtnPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jideBtnPaymentActionPerformed

        tpnBusiness.setSelectedComponent(pnlPaymentTab);
    }//GEN-LAST:event_jideBtnPaymentActionPerformed

    private void jideBtnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jideBtnReportActionPerformed

        tpnBusiness.setSelectedComponent(pnlReport);

    }//GEN-LAST:event_jideBtnReportActionPerformed

    private void mnuIConfigurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIConfigurationActionPerformed

        dlgConfigurationDB configurationDB = new dlgConfigurationDB(this, true);
        configurationDB.setVisible(true);
    }//GEN-LAST:event_mnuIConfigurationActionPerformed

    private void radioWindowsXPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioWindowsXPActionPerformed

        if (radioWindowsXP.isSelected()) {
            guidao.setGUI(guip.PLAF_WINDOWSXP, theme);
        }
    }//GEN-LAST:event_radioWindowsXPActionPerformed

    private void tpnBusinessStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tpnBusinessStateChanged

        int index = tpnBusiness.getSelectedIndex();
        if (index != -1) {
            String title = tpnBusiness.getTitleAt(index).trim();
            if (title.length() != 0) {
                //TODO: Xet du lieu chua duoc
                if (title.equals("Register")) {
                    register.getData();
                } else if (title.equals("Payment")) {
                    payment.getData();
                } else if (title.equals("Subject")) {
                    subject.getData();
                } else if (title.equals("Mark")) {
                    mark.getData();
                } else if (title.equals("Certificate")) {
                    cer.getData();
                } else if (title.equals("Account")) {
                    account.getData();
                } else if (title.equals("View Mark")) {
                    viewMark.getData();
                } else if (title.equals("View Payment")) {
                    viewPayment.getData();
                } else if (title.equals("Develop Degree")) {
                    developDegree.getData();
                }else if (title.equals("Employee")) {
                    emp.getData();
                }else if (title.equals("Student")) {
                    student.getData();
                }else if (title.equals("Permission")) {
                    per.getData();
                }else if (title.equals("Course")) {
                    course.getData();
                }
            }
        }
    }//GEN-LAST:event_tpnBusinessStateChanged

    public void isLogout() {

        tpnBusiness.removeAll();
        tpnBusiness.addTab("Home                  ", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlHomeTab);
        tpnBusiness.addTab("Employee            ", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlEmployeeTab);
        tpnBusiness.addTab("Student", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlStudentTab);
        tpnBusiness.addTab("Register", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlRegisterTab);
        tpnBusiness.addTab("Course", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlCourseTab);
        tpnBusiness.addTab("Payment", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlPaymentTab);
        tpnBusiness.addTab("Subject", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlSubjectTab);
        tpnBusiness.addTab("Mark", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlMarkTab);
        tpnBusiness.addTab("Certificate", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlCertificateTab);
        tpnBusiness.addTab("Account             ", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlAccountTab);
        tpnBusiness.addTab("Permission", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlPermissionTab);
        tpnBusiness.addTab("View Mark", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlViewMarkTab);
        tpnBusiness.addTab("View Payment", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlViewPaymentTab);
        tpnBusiness.addTab("Develop Degree", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlDevelopDegree);
        tpnBusiness.addTab("Report", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlReport);

        tpnBusiness.setEnabled(false);
        jideBtnHome.setEnabled(false);
        jideBtnEmployee.setEnabled(false);
        jideBtnStudent.setEnabled(false);
        jideBtnCourse.setEnabled(false);
        jideBtnSubject.setEnabled(false);
        jideBtnAccount.setEnabled(false);
        jideBtnCertificate.setEnabled(false);
        jideBtnAccount.setEnabled(false);
        jideBtnMark.setEnabled(false);
        jideBtnReport.setEnabled(false);
        jideBtnPayment.setEnabled(false);
        jideBtnRegister.setEnabled(false);

        mnuILogoutSystem.setVisible(false);
        tpnBusiness.setEnabled(false);
        menuIChangePass.setEnabled(false);
        mnuOptions.setEnabled(false);
        mnuILoginSystem.setVisible(true);
        mnuIConfiguration.setVisible(false);
    }

    public void isLogin() {
        tpnBusiness.setSelectedComponent(pnlHomeTab);

        pnlHomeTab.removeAll();
        pnlHomeTab.add(new pnlHome(this));
        jideBtnEmployee.setVisible(true);
        jideBtnStudent.setVisible(true);
        jideBtnCourse.setVisible(true);
        jideBtnSubject.setVisible(true);
        jideBtnAccount.setVisible(true);
        jideBtnCertificate.setVisible(true);
        jideBtnAccount.setVisible(true);
        jideBtnMark.setVisible(true);
        jideBtnRegister.setVisible(true);
        jideBtnPayment.setVisible(true);

        jideBtnHome.setEnabled(true);
        jideBtnEmployee.setEnabled(true);
        jideBtnStudent.setEnabled(true);
        jideBtnCourse.setEnabled(true);
        jideBtnSubject.setEnabled(true);
        jideBtnAccount.setEnabled(true);
        jideBtnCertificate.setEnabled(true);
        jideBtnAccount.setEnabled(true);
        jideBtnMark.setEnabled(true);
        jideBtnReport.setEnabled(true);
        jideBtnPayment.setEnabled(true);
        jideBtnRegister.setEnabled(true);

        if (this.accCur != null) {
            mnuILogoutSystem.setVisible(true);
            mnuILogoutSystem.setEnabled(true);
            tpnBusiness.setEnabled(true);
            menuIChangePass.setEnabled(true);
            mnuOptions.setEnabled(true);
            mnuILoginSystem.setVisible(false);
            mnuIConfiguration.setVisible(false);

            if (perDao.readByName("Admin").getId() == this.accCur.getPermission()) {
                mnuIConfiguration.setVisible(true);
                mnuIConfiguration.setEnabled(true);
            } else if (perDao.readByName("Employee").getId() == this.accCur.getPermission()) {

                tpnBusiness.removeAll();
                tpnBusiness.addTab("Home                  ", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlHomeTab);
                tpnBusiness.addTab("View Mark", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlViewMarkTab);
                tpnBusiness.addTab("View Payment", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlViewPaymentTab);
                tpnBusiness.addTab("Develop Degree", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlDevelopDegree);
                tpnBusiness.addTab("Report", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlReport);

                pnlHomeTab.removeAll();
                pnlHomeTab.add(new pnlHomeEmp(this));

                jideBtnEmployee.setVisible(false);
                jideBtnStudent.setVisible(false);
                jideBtnCourse.setVisible(false);
                jideBtnSubject.setVisible(false);
                jideBtnAccount.setVisible(false);
                jideBtnCertificate.setVisible(false);
                jideBtnAccount.setVisible(false);
                jideBtnMark.setVisible(false);
                jideBtnRegister.setVisible(false);
                jideBtnPayment.setVisible(false);

            } else {
                tpnBusiness.removeAll();
                tpnBusiness.addTab("Home                  ", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlHomeTab);
                tpnBusiness.addTab("View Mark", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlViewMarkTab);
                tpnBusiness.addTab("View Payment", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlViewPaymentTab);
                tpnBusiness.addTab("Report", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow.png")), pnlReport);


                pnlHomeTab.removeAll();
                pnlHomeTab.add(new pnlHomeStudent(this));


                jideBtnEmployee.setVisible(false);
                jideBtnStudent.setVisible(false);
                jideBtnCourse.setVisible(false);
                jideBtnSubject.setVisible(false);
                jideBtnAccount.setVisible(false);
                jideBtnCertificate.setVisible(false);
                jideBtnAccount.setVisible(false);
                jideBtnMark.setVisible(false);
                jideBtnPayment.setVisible(false);
                jideBtnRegister.setVisible(false);
            }
        } else {
            mnuILogoutSystem.setVisible(false);
            tpnBusiness.setEnabled(false);
            menuIChangePass.setEnabled(false);
            mnuOptions.setEnabled(false);
            mnuILoginSystem.setVisible(true);
            mnuIConfiguration.setVisible(false);
        }
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel StatusPnl;
    private javax.swing.ButtonGroup buttonGroupSkin;
    private javax.swing.ButtonGroup buttonGroupTheme;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private com.jidesoft.swing.JideButton jideBtnAccount;
    private com.jidesoft.swing.JideButton jideBtnCertificate;
    private com.jidesoft.swing.JideButton jideBtnCourse;
    private com.jidesoft.swing.JideButton jideBtnEmployee;
    private com.jidesoft.swing.JideButton jideBtnHome;
    private com.jidesoft.swing.JideButton jideBtnMark;
    private com.jidesoft.swing.JideButton jideBtnPayment;
    private com.jidesoft.swing.JideButton jideBtnRegister;
    private com.jidesoft.swing.JideButton jideBtnReport;
    private com.jidesoft.swing.JideButton jideBtnStudent;
    private com.jidesoft.swing.JideButton jideBtnSubject;
    private javax.swing.JMenuItem menuIChangePass;
    private javax.swing.JMenuBar mnuBSystem;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JMenuItem mnuIAbout;
    private javax.swing.JMenuItem mnuIConfiguration;
    private javax.swing.JMenuItem mnuIExit;
    private javax.swing.JMenuItem mnuIHelpContent;
    private javax.swing.JMenuItem mnuILoginSystem;
    private javax.swing.JMenuItem mnuILogoutSystem;
    private javax.swing.JMenu mnuOptions;
    private javax.swing.JMenu mnuSkin;
    private javax.swing.JMenu mnuSystem;
    private javax.swing.JMenu mnuTheme;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelLogo;
    public javax.swing.JPanel pnlAccountTab;
    public javax.swing.JPanel pnlCertificateTab;
    public javax.swing.JPanel pnlCourseTab;
    public javax.swing.JPanel pnlDevelopDegree;
    public javax.swing.JPanel pnlEmployeeTab;
    public javax.swing.JPanel pnlHomeTab;
    public javax.swing.JPanel pnlMarkTab;
    public javax.swing.JPanel pnlPaymentTab;
    public javax.swing.JPanel pnlPermissionTab;
    public javax.swing.JPanel pnlRegisterTab;
    public javax.swing.JPanel pnlReport;
    public javax.swing.JPanel pnlStudentTab;
    public javax.swing.JPanel pnlSubjectTab;
    public javax.swing.JPanel pnlViewMarkTab;
    public javax.swing.JPanel pnlViewPaymentTab;
    private javax.swing.JRadioButtonMenuItem radioDarkStar;
    private javax.swing.JRadioButtonMenuItem radioDesertBlue;
    private javax.swing.JRadioButtonMenuItem radioDesertGreen;
    private javax.swing.JRadioButtonMenuItem radioDesertYellow;
    private javax.swing.JRadioButtonMenuItem radioExperenceRoyale;
    private javax.swing.JRadioButtonMenuItem radioExperienceBlue;
    private javax.swing.JRadioButtonMenuItem radioExperienceGreen;
    private javax.swing.JRadioButtonMenuItem radioJgoodies;
    private javax.swing.JRadioButtonMenuItem radioLightGray;
    private javax.swing.JRadioButtonMenuItem radioMetal;
    private javax.swing.JRadioButtonMenuItem radioSilver;
    private javax.swing.JRadioButtonMenuItem radioSkyBlue;
    private javax.swing.JRadioButtonMenuItem radioSkyBluer;
    private javax.swing.JRadioButtonMenuItem radioSkyGreen;
    private javax.swing.JRadioButtonMenuItem radioSkyPink;
    private javax.swing.JRadioButtonMenuItem radioSkyRed;
    private javax.swing.JRadioButtonMenuItem radioSkyYellow;
    private javax.swing.JRadioButtonMenuItem radioWindows;
    private javax.swing.JRadioButtonMenuItem radioWindowsXP;
    private javax.swing.JToolBar tbMenu;
    public javax.swing.JTabbedPane tpnBusiness;
    // End of variables declaration//GEN-END:variables
}
