package com.duan.view;

import com.duan.handler.AddViewHandle;
import com.duan.pojo.Student;

import javax.swing.*;
import java.awt.*;

public class AddStudentView extends JDialog {
    //声明组件
    JPanel jPanel=new JPanel(new FlowLayout(FlowLayout.CENTER,10,20));
    JLabel nameLabel=new JLabel("姓名：",JLabel.RIGHT);
    JTextField nameTxt=new JTextField();
    JLabel noLabel=new JLabel("学号：",JLabel.RIGHT);
    JTextField noTxt=new JTextField();
    JLabel homeLabel=new JLabel("家乡：",JLabel.RIGHT);
    JTextField homeTxt=new JTextField();
    JLabel cnLabel=new JLabel("语文成绩：",JLabel.RIGHT);
    JTextField cnTxt=new JTextField();
    JLabel enLabel=new JLabel("英语成绩：",JLabel.RIGHT);
    JTextField enTxt=new JTextField();
    JLabel mathLabel=new JLabel("数学成绩：",JLabel.RIGHT);
    JTextField mathTxt=new JTextField();
    JButton addBtn=new JButton("添加");
    AddViewHandle addViewHandle;


    public AddStudentView(MainView mainView){
        super(mainView,"添加学生",true);
        addViewHandle=new AddViewHandle(this,mainView);
        //添加组件
        nameLabel.setPreferredSize(new Dimension(80,30));
        jPanel.add(nameLabel);
        nameTxt.setPreferredSize(new Dimension(200,30));
        jPanel.add(nameTxt);

        noLabel.setPreferredSize(new Dimension(80,30));
        jPanel.add(noLabel);
        noTxt.setPreferredSize(new Dimension(200,30));
        jPanel.add(noTxt);

        homeLabel.setPreferredSize(new Dimension(80,30));
        jPanel.add(homeLabel);
        homeTxt.setPreferredSize(new Dimension(200,30));
        jPanel.add(homeTxt);

        cnLabel.setPreferredSize(new Dimension(80,30));
        jPanel.add(cnLabel);
        cnTxt.setPreferredSize(new Dimension(200,30));
        jPanel.add(cnTxt);

        enLabel.setPreferredSize(new Dimension(80,30));
        jPanel.add(enLabel);
        enTxt.setPreferredSize(new Dimension(200,30));
        jPanel.add(enTxt);

        mathLabel.setPreferredSize(new Dimension(80,30));
        jPanel.add(mathLabel);
        mathTxt.setPreferredSize(new Dimension(200,30));
        jPanel.add(mathTxt);
        addBtn.addActionListener(addViewHandle);
        jPanel.add(addBtn);

        Container contentPane = getContentPane();
        contentPane.add(jPanel);

        setSize(350,500);
        setLocationRelativeTo(null);
        //仅销毁当前窗口不销毁程序
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    public Student StudentBuilt(){
        Student student = new Student();
        student.setName(nameTxt.getText());
        student.setNo(noTxt.getText());
        student.setHomeTown(homeTxt.getText());
        student.setCnScore(Integer.parseInt(cnTxt.getText()));
        student.setEnScore(Integer.parseInt(enTxt.getText()));
        student.setMathScore(Integer.parseInt(mathTxt.getText()));
        return student;
    }
}
