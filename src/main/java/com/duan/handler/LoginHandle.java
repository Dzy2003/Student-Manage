package com.duan.handler;

import com.duan.service.AdminService;
import com.duan.service.impl.AdminServiceImpl;
import com.duan.view.LoginView;
import com.duan.view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LoginHandle implements ActionListener {
    //将窗口类加入成员变量来获取窗口中的按钮。
    private LoginView loginView;
    public LoginHandle(LoginView loginView){
        this.loginView=loginView;
    }
    //事件主要逻辑。
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton)e.getSource();
        String text = jButton.getText();
        if("清空".equals(text)){
            loginView.getUserTxt().setText("");
            loginView.getPwdFiled().setText("");
        }else if("登录".equals(text)){
            String username = loginView.getUserTxt().getText();
            char[] chars = loginView.getPwdFiled().getPassword();
            String password = new String(chars);
            AdminService service = new AdminServiceImpl();
            Boolean flag=service.Login(username,password);
            if(flag){
                //跳转主界面。
                new MainView();
                loginView.dispose();
            }else{
                JOptionPane.showMessageDialog(loginView,"用户名或密码错误");
            }
        }
    }
}
