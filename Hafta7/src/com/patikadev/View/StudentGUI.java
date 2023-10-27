package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Course;
import com.patikadev.Model.Patika;
import com.patikadev.Model.Student;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;


public class StudentGUI extends JFrame {
    private JPanel wrapper;
    private JTabbedPane tab_paths;
    private JTable tbl_paths;
    private JPanel pnl_student_transactions;
    private JPanel pnl_paths;
    private JScrollPane scrl_paths;
    private JLabel lbl_welcome;
    private JButton btn_logout;
    private JTable tbl_courses;
    private JScrollPane scrl_courses;
    private DefaultTableModel mdl_patika_list;
    private Object[] row_patika_list;

    private DefaultTableModel mdl_course_list;
    private Object[] row_course_list;
    private JPopupMenu pathsMenu;
    private JPopupMenu coursesMenu;
    private int selected_id;
    private static int cID;


    public StudentGUI(Student student) {
        add(wrapper);
        setSize(1000, 500);
        setLocation(Helper.screenCenter("x", getSize()), Helper.screenCenter("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        lbl_welcome.setText("Hoşgeldiniz " + student.getName());

        // PATİKALAR LİSTESİ
        mdl_patika_list = new DefaultTableModel();
        Object[] col_patika_list = {"ID", "Patika Adı"};
        mdl_patika_list.setColumnIdentifiers(col_patika_list);
        row_patika_list = new Object[col_patika_list.length];
        loadPatikaModel();
        tbl_paths.setModel(mdl_patika_list);
        tbl_paths.getTableHeader().setReorderingAllowed(false);
        tbl_paths.getColumnModel().getColumn(0).setMaxWidth(75);

        // PATİKA POPUP MENÜ
        pathsMenu = new JPopupMenu();
        tbl_paths.setComponentPopupMenu(pathsMenu);
        JMenuItem getCourses = new JMenuItem("Dersleri Getir");
        JMenuItem signUpToPath = new JMenuItem("Patikaya Kayıt Ol");
        pathsMenu.add(getCourses);
        pathsMenu.add(signUpToPath);

        tbl_paths.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int selected_row = tbl_paths.rowAtPoint(point);
                tbl_paths.setRowSelectionInterval(selected_row, selected_row);
            }
        });
        getCourses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selected_row = tbl_paths.getSelectedRow();
                if (selected_row != -1) {
                    Object value = tbl_paths.getValueAt(selected_row, 0);
                    if (value != null) {
                        selected_id = Integer.parseInt(value.toString());
                        loadCourseModel();
                    }
                }
            }
        });
        signUpToPath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Helper.showMessage("Patikaya başarıyla kayıt oldunuz");
            }
        });
        // ## PATİKA POPUP MENÜ
        // ## PATİKALAR LİSTESİ

        // DERSLER LİSTESİ
        mdl_course_list = new DefaultTableModel();
        Object[] col_course_list = {"ID", "Ders Adı", "Programlama Dili", "Patika", "Eğitmen"};
        mdl_course_list.setColumnIdentifiers(col_course_list);
        row_course_list = new Object[col_course_list.length];
        tbl_courses.setModel(mdl_course_list);
        tbl_courses.getTableHeader().setReorderingAllowed(false);
        tbl_courses.getColumnModel().getColumn(0).setMaxWidth(75);

        coursesMenu = new JPopupMenu();
        tbl_courses.setComponentPopupMenu(coursesMenu);
        JMenuItem getContents = new JMenuItem("İçerikleri Getir");
        JMenuItem commentOnContents = new JMenuItem("İçeriği Değerlendir");
        coursesMenu.add(getContents);
        coursesMenu.add(commentOnContents);

        tbl_courses.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int selected_row = tbl_paths.rowAtPoint(point);
                tbl_courses.setRowSelectionInterval(selected_row, selected_row);
            }
        });
        getContents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selected_row = tbl_courses.getSelectedRow();
                if (selected_row != -1) {
                    Object value = tbl_courses.getValueAt(selected_row, 0);
                    if (value != null) {
                        selected_id = Integer.parseInt(value.toString());
                        /*
                        SELECTED_ID DEĞERİ ASSESMENT'IN İÇERİSİNE AKTARILMALI Kİ
                        YALNIZCA SELECTED_ID'DEKİ CONTENTLER EKRANA YAZILSIN
                         */



                        AssessmentGUI as = new AssessmentGUI(selected_id);
                    }
                }
            }
        });
        commentOnContents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CommentOnContentGUI cocGUI = new CommentOnContentGUI();
            }
        });


        btn_logout.addActionListener(e -> {
            dispose();
            LoginGUI lgn = new LoginGUI();
        });
    }

    private void loadCourseModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_courses.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Course obj : Course.getListBySelectedId(selected_id)) {
            i = 0;
            row_course_list[i++] = obj.getId();
            row_course_list[i++] = obj.getName();
            row_course_list[i++] = obj.getLang();
            row_course_list[i++] = obj.getPatika().getName();
            row_course_list[i++] = obj.getEducator().getName();
            mdl_course_list.addRow(row_course_list);
        }
    }

    private void loadPatikaModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_paths.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Patika obj : Patika.getList()) {
            i = 0;
            row_patika_list[i++] = obj.getId();
            row_patika_list[i++] = obj.getName();
            mdl_patika_list.addRow(row_patika_list);
        }
    }

    public static void main(String[] args) {
        Student st = new Student();
        Helper.setLayout();
        StudentGUI edGUI = new StudentGUI(st);
    }
}
