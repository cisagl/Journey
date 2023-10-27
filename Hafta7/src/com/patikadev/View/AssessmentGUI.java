package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Content;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AssessmentGUI extends JFrame {
    private JPanel wrapper;
    private JButton btn_answer;
    private JTextArea txt_answer;
    private JTextField fld_question;
    private JTable tbl_content_list;
    private JScrollPane scrl_content_list;

    private DefaultTableModel mdl_content_list;
    private Object[] row_content_list;

    public AssessmentGUI(int selected_id) {
        add(wrapper);
        setSize(500, 500);
        setLocation(Helper.screenCenter("x", getSize()), Helper.screenCenter("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
        setResizable(false);


        mdl_content_list = new DefaultTableModel();
        Object[] col_content_list = {"ID", "BAŞLIK", "AÇIKLAMA", "LİNK", "QUİZ SORULARI", "AİT OLDUĞU DERS"};
        mdl_content_list.setColumnIdentifiers(col_content_list);
        row_content_list = new Object[col_content_list.length];
        loadContentModel(selected_id);
        tbl_content_list.setModel(mdl_content_list);
        tbl_content_list.getTableHeader().setReorderingAllowed(false);
        tbl_content_list.getColumnModel().getColumn(0).setMaxWidth(75);

        tbl_content_list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    String select_content_quiz = tbl_content_list.getValueAt(tbl_content_list.getSelectedRow(), 4).toString();
                    fld_question.setText(select_content_quiz);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        btn_answer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String answer = txt_answer.getText();
                if (answer.isEmpty()) {
                    Helper.showMessage("fill");
                } else {
                    Helper.showMessage("Yanıtınız kaydedildi");
                    dispose();
                }
            }
        });
    }

    public void loadContentModel(int selected_id) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_content_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Content obj : Content.getContentForCourse(selected_id)) {
            i = 0;
            row_content_list[i++] = obj.getId();
            row_content_list[i++] = obj.getTitle();
            row_content_list[i++] = obj.getComment();
            row_content_list[i++] = obj.getLink();
            row_content_list[i++] = obj.getQuiz();
            if (obj.getCourse().getName() != null) {
                row_content_list[i++] = obj.getCourse().getName();
            } else {
                row_content_list[i++] = "HATALI SEÇİM";
            }

            mdl_content_list.addRow(row_content_list);
        }
    }
}
