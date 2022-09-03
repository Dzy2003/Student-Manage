package com.duan.view;

import com.duan.handler.LoginHandle;

import javax.swing.*;
import java.awt.*;

public class LoginView  extends JFrame {
    //创建组件
    JLabel nameLabel=new JLabel("学生管理系统",JLabel.CENTER);
    SpringLayout springLayout=new SpringLayout();
    JPanel centerPanel=new JPanel(springLayout);
    JLabel usernameLabel=new JLabel("用户名:");
    JTextField userTxt=new JTextField();
    JLabel pwdLabel=new JLabel("密码:");
    JPasswordField pwdFiled=new JPasswordField();
    JButton loginBtn=new JButton("登录");
    JButton resetBtn=new JButton("清空");
    LoginHandle loginHandle=new LoginHandle(this);
    //给用户名框和密码框构造get方法在监听类中获取其中文本。
    public JTextField getUserTxt() {
        return userTxt;
    }
    public JPasswordField getPwdFiled() {
        return pwdFiled;
    }



    public LoginView(){
        super("学生管理系统");
        //初始化组件
        Container contentPane = getContentPane();
        Font centerFont = new Font("楷体", Font.PLAIN, 20);
        usernameLabel.setFont(centerFont);
        pwdLabel.setFont(centerFont);
        loginBtn.setFont(centerFont);
        resetBtn.setFont(centerFont);
        userTxt.setPreferredSize(new Dimension(200,30));
        pwdFiled.setPreferredSize(new Dimension(200,30));
        nameLabel.setFont(new Font("华文行楷",Font.PLAIN,40));
        nameLabel.setPreferredSize(new Dimension(0,80));
        //向面板添加组件
        centerPanel.add(usernameLabel);
        centerPanel.add(userTxt);
        centerPanel.add(pwdLabel);
        centerPanel.add(pwdFiled);
        centerPanel.add(loginBtn);
        centerPanel.add(resetBtn);
        resetBtn.addActionListener(loginHandle);
        loginBtn.addActionListener(loginHandle);
        //向窗口容器添加内容
        contentPane.add(nameLabel,BorderLayout.NORTH);
        contentPane.add(centerPanel,BorderLayout.CENTER);
        //弹簧布局
        Spring childWidth = Spring.sum(Spring.sum(Spring.width(usernameLabel), Spring.width(userTxt)), Spring.constant(20));
        int offsetX = childWidth.getValue() / 2;
        //
        springLayout.putConstraint(SpringLayout.WEST,usernameLabel,-offsetX,SpringLayout.HORIZONTAL_CENTER,centerPanel);
        springLayout.putConstraint(SpringLayout.NORTH,usernameLabel,20,SpringLayout.NORTH,centerPanel);

        springLayout.putConstraint(SpringLayout.WEST,userTxt,20,SpringLayout.EAST,usernameLabel);
        springLayout.putConstraint(SpringLayout.NORTH,userTxt,0,SpringLayout.NORTH,usernameLabel);

        springLayout.putConstraint(SpringLayout.EAST,pwdLabel,0,SpringLayout.EAST,usernameLabel);
        springLayout.putConstraint(SpringLayout.NORTH,pwdLabel,20,SpringLayout.SOUTH,usernameLabel);

        springLayout.putConstraint(SpringLayout.WEST,pwdFiled,20,SpringLayout.EAST,pwdLabel);
        springLayout.putConstraint(SpringLayout.NORTH,pwdFiled,0,SpringLayout.NORTH,pwdLabel);

        springLayout.putConstraint(SpringLayout.WEST,loginBtn,50,SpringLayout.WEST,pwdLabel);
        springLayout.putConstraint(SpringLayout.NORTH,loginBtn,20,SpringLayout.SOUTH,pwdLabel);

        springLayout.putConstraint(SpringLayout.WEST,resetBtn,80,SpringLayout.EAST,loginBtn);
        springLayout.putConstraint(SpringLayout.NORTH,resetBtn,-30,SpringLayout.SOUTH,loginBtn);



        //初始化窗口
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}
