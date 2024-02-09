package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Content;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateEducatorGUI extends JFrame{
    private JPanel wrapper;
    private JTextField fld_title_update;
    private JTextField fld_comment_update;
    private JTextField fld_link_update;
    private JTextField fld_quiz_update;
    private JButton btn_content_update;
    private Content content;

    public UpdateEducatorGUI(Content content){
        this.content = content;
        add(wrapper);
        setSize(350, 500);
        setLocation(Helper.screenCenter("x", getSize()), Helper.screenCenter("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);


        btn_content_update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.isFieldEmpty(fld_title_update) || Helper.isFieldEmpty(fld_comment_update) || Helper.isFieldEmpty(fld_link_update) || Helper.isFieldEmpty(fld_quiz_update)){
                    Helper.showMessage("fill");
                } else {
                    Content.update(fld_title_update.getText(), fld_comment_update.getText(), fld_link_update.getText(), fld_quiz_update.getText(), content.getId());
                    Helper.showMessage("Başarıyla güncellendi");
                }
                dispose();
            }
        });
    }
}
