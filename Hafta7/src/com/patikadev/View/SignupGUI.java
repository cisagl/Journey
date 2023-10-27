package com.patikadev.View;
import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupGUI extends JFrame{
    private JTextField fld_signup_name;
    private JTextField fld_signup_uname;
    private JPasswordField fld_signup_pass;
    private JPanel wrapper;
    private JButton btn_add_student;
    private JButton btn_logout;

    public SignupGUI(){
        add(wrapper);
        setSize(400, 400);
        setLocation(Helper.screenCenter("x", getSize()), Helper.screenCenter("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);


        // BUTTONS
        btn_add_student.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_signup_name) || Helper.isFieldEmpty(fld_signup_uname) || Helper.isFieldEmpty(fld_signup_pass)){
                Helper.showMessage("fill");
            } else if(!(User.add(fld_signup_name.getText(), fld_signup_uname.getText(), fld_signup_pass.getText(), "student"))){
                dispose();
                SignupGUI sgn = new SignupGUI();
            } else {
                User.add(fld_signup_name.getText(), fld_signup_uname.getText(), fld_signup_pass.getText(), "student");
                Helper.showMessage("done");
                fld_signup_name.setText(null);
                fld_signup_uname.setText(null);
                fld_signup_pass.setText(null);
            }
        });
        btn_logout.addActionListener(e -> {
            dispose();
            LoginGUI log = new LoginGUI();
        });
    }
}
