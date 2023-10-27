package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommentOnContentGUI extends JFrame{
    private JPanel wrapper;
    private JButton btn_comment;
    private JTextArea txt_comment;

    public CommentOnContentGUI(){
        add(wrapper);
        setSize(500, 500);
        setLocation(Helper.screenCenter("x", getSize()), Helper.screenCenter("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
        setResizable(false);


        btn_comment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String answer = txt_comment.getText();
                if (answer.isEmpty()){
                    Helper.showMessage("fill");
                } else {
                    Helper.showMessage("Yorumunuz için teşekkür ederiz");
                    txt_comment.setText(null);
                    dispose();
                }
            }
        });
    }

}
