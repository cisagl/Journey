package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.DBConnector;
import com.patikadev.Helper.Helper;
import com.patikadev.Helper.Item;
import com.patikadev.Model.Content;
import com.patikadev.Model.Course;
import com.patikadev.Model.Educator;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EducatorGUI extends JFrame {
    private JPanel wrapper;
    private JPanel pnl_top;
    private JPanel tab_educator;
    private JButton btn_logout;
    private JTable tbl_content_list;
    private JLabel lbl_welcome;
    private JTabbedPane tabbedPane1;
    private JPanel pnl_courses;
    private JPanel pnl_contents;
    private JScrollPane scrl_course_list;
    private JScrollPane scrl_content_list;
    private JTable tbl_course_list;
    private JTextField fld_title;
    private JTextField fld_comment;
    private JTextField fld_link;
    private JTextField fld_quiz;
    private JComboBox cmb_course_name;
    private JButton btn_add;
    private int userId;
    private JTextField fld_content_delete;
    private JButton btn_content_delete;
    private JTextField fld_sh_title;
    private JButton btn_sh_content;
    private JButton btn_allcontents;
    private DefaultTableModel mdl_content_list;
    private Object[] row_content_list;
    private DefaultTableModel mdl_course_list;
    private Object[] row_course_list;
    private JPopupMenu contentMenu;

    public EducatorGUI(Educator educator) {
        this.userId = educator.getId();
        add(wrapper);
        setSize(1000, 500);
        setLocation(Helper.screenCenter("x", getSize()), Helper.screenCenter("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        lbl_welcome.setText("Hoşgeldiniz " + educator.getName());

        mdl_course_list = new DefaultTableModel();
        Object[] col_courseList = {"ID", "Ders Adı", "Programlama Dili", "Patika", "Eğitmen"};
        mdl_course_list.setColumnIdentifiers(col_courseList);
        row_course_list = new Object[col_courseList.length];
        loadCourseModel();
        tbl_course_list.setModel(mdl_course_list);
        tbl_course_list.getTableHeader().setReorderingAllowed(false);
        tbl_course_list.getColumnModel().getColumn(0).setMaxWidth(75);
        tbl_course_list.setEnabled(false);


        mdl_content_list = new DefaultTableModel();
        Object[] col_content_list = {"ID", "BAŞLIK", "AÇIKLAMA", "LİNK", "QUİZ SORULARI", "AİT OLDUĞU DERS"};
        mdl_content_list.setColumnIdentifiers(col_content_list);
        row_content_list = new Object[col_content_list.length];
        loadContentModel();
        tbl_content_list.setModel(mdl_content_list);
        tbl_content_list.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            try {
                String select_content_id = tbl_content_list.getValueAt(tbl_content_list.getSelectedRow(), 0).toString();
                fld_content_delete.setText(select_content_id);
            } catch (Exception ex) {
            }
        });

        // CONTENT DÜZENLEME POPUP
        contentMenu = new JPopupMenu();
        tbl_content_list.setComponentPopupMenu(contentMenu);
        JMenuItem setContent = new JMenuItem("İçeriği düzenle");
        contentMenu.add(setContent);
        tbl_content_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int selected_row = tbl_content_list.rowAtPoint(point);
                tbl_content_list.setRowSelectionInterval(selected_row,selected_row);

            }
        });

        setContent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selected_row = tbl_content_list.getSelectedRow();
                if (selected_row != -1){
                    Object value = tbl_content_list.getValueAt(selected_row, 0);
                    Integer selected_row_id = (Integer) value;
                    if (value != null){
                        UpdateEducatorGUI ued = new UpdateEducatorGUI(Content.getFetch(selected_row_id));
                        ued.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                super.windowClosed(e);
                                loadContentModel();
                            }
                        });
                    }
                }
            }
        });

        tbl_content_list.getTableHeader().setReorderingAllowed(false);
        tbl_content_list.getColumnModel().getColumn(0).setMaxWidth(75);

        // Buttons
        btn_logout.addActionListener(e -> {
            dispose();
            LoginGUI login = new LoginGUI();
        });
        btn_add.addActionListener(e -> {
            String selectedCourseName = cmb_course_name.getSelectedItem().toString();
            int courseId = -1;
            for (Course course : Course.getList()) {
                if (course.getName().equals(selectedCourseName)) {
                    courseId = course.getId();
                    break;
                }
            }
            try {
                if (courseId != -1){
                    if (Helper.isFieldEmpty(fld_title) || Helper.isFieldEmpty(fld_comment) || Helper.isFieldEmpty(fld_link) || Helper.isFieldEmpty(fld_quiz) || cmb_course_name == null) {
                        Helper.showMessage("fill");
                    } else {
                        String title = fld_title.getText();
                        String comment = fld_comment.getText();
                        String link = fld_link.getText();
                        String quiz = fld_link.getText();

                        if (Content.add(title, comment, link, quiz, courseId)) {
                            Helper.showMessage("done");
                            loadContentModel();
                            fld_link.setText(null);
                            fld_title.setText(null);
                            fld_comment.setText(null);
                            fld_quiz.setText(null);
                        }
                    }
                }
            } catch (Exception exx){
                System.out.println(exx.getMessage());
            }
        });
        btn_content_delete.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_content_delete)) {
                Helper.showMessage("Lütfen silmek istediğiniz ID'yi giriniz");
            } else {
                if (Helper.confirm("sure")) {
                    int content_id = Integer.parseInt(fld_content_delete.getText());
                    if (Content.delete(content_id)) {
                        Helper.showMessage("İçerik sistemden kaldırıldı");
                        fld_content_delete.setText(null);
                        loadContentModel();
                    } else {
                        Helper.showMessage("error");
                    }
                }
            }
        });
        btn_sh_content.addActionListener(e -> {
            String title = fld_sh_title.getText();
            String query = Content.searchQuery(title);
            ArrayList<Content> searchingContent = Content.searchContentList(query);
            loadContentModel(searchingContent);
        });


        btn_allcontents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadContentModel();
            }
        });
    }

    public void loadContentModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_content_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Content obj : Content.getContentForUser(userId)) {
            i = 0;
            row_content_list[i++] = obj.getId();
            row_content_list[i++] = obj.getTitle();
            row_content_list[i++] = obj.getComment();
            row_content_list[i++] = obj.getLink();
            row_content_list[i++] = obj.getQuiz();
            if (obj.getCourse().getName() != null){
                row_content_list[i++] = obj.getCourse().getName();
            } else {
                row_content_list[i++] = "HATALI SEÇİM";
            }

            mdl_content_list.addRow(row_content_list);
        }
    }

    public void loadContentModel(ArrayList<Content> list) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_content_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Content obj : list) {
            i = 0;
            row_content_list[i++] = obj.getId();
            row_content_list[i++] = obj.getTitle();
            row_content_list[i++] = obj.getComment();
            row_content_list[i++] = obj.getLink();
            row_content_list[i++] = obj.getQuiz();
            row_content_list[i++] = "##########";
            mdl_content_list.addRow(row_content_list);
        }
    }

    private void loadCourseModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_course_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Course obj : getList()) {
            i = 0;
            row_course_list[i++] = obj.getId();
            row_course_list[i++] = obj.getName();
            row_course_list[i++] = obj.getLang();
            row_course_list[i++] = obj.getPatika().getName();
            row_course_list[i++] = obj.getEducator().getName();
            mdl_course_list.addRow(row_course_list);
            cmb_course_name.addItem(new Item(obj.getId(), obj.getName()));
        }
    }
    public ArrayList<Course> getList() {
        ArrayList<Course> courseList = new ArrayList<>();
        String query = "SELECT * FROM course WHERE user_id = ?";
        Course obj;
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, this.userId);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                int patika_id = rs.getInt("patika_id");
                String name = rs.getString("name");
                String lang = rs.getString("lang");
                obj = new Course(id, user_id, patika_id, name, lang);
                courseList.add(obj);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return courseList;
    }

    public static void main(String[] args) {
        Educator ed = new Educator();
        Helper.setLayout();
        EducatorGUI edGUI = new EducatorGUI(ed);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
