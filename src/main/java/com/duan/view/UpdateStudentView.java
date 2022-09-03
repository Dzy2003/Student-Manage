package com.duan.view;

import com.duan.handler.UpdateViewHandle;
import com.duan.pojo.Student;
import com.duan.service.StudentService;
import com.duan.service.impl.StudentServiceImpl;

import javax.swing.*;
import java.awt.*;

public class UpdateStudentView extends JDialog {
    //声明组件
    JPanel jPanel=new JPanel(new FlowLayout(FlowLayout.CENTER,10,20));
    JLabel idLabel=new JLabel("学生编号：",JLabel.RIGHT);
    JTextField idTxt=new JTextField();
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
    JButton addBtn=new JButton("修改");



    public UpdateStudentView(MainView mainView, int id){
        super(mainView,"修改信息",true);
        UpdateViewHandle updateViewHandle=new UpdateViewHandle(this,mainView);
        //实现修改框的数据回显
        StudentService service=new StudentServiceImpl();
        Student student = service.selectById(id);
        idTxt.setText(String.valueOf(student.getId()));
        nameTxt.setText(student.getName());
        noTxt.setText(student.getNo());
        homeTxt.setText(student.getHomeTown());
        cnTxt.setText(String.valueOf(student.getCnScore()));
        enTxt.setText(String.valueOf(student.getEnScore()));
        mathTxt.setText(String.valueOf(student.getMathScore()));



        //添加组件
        idLabel.setPreferredSize(new Dimension(80,30));
        jPanel.add(idLabel);
        idTxt.setPreferredSize(new Dimension(200,30));
        jPanel.add(idTxt);
        idTxt.setEnabled(false);

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
        //为修改按钮添加事件
        addBtn.addActionListener(updateViewHandle);
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
    //获取输入框修改回显的数据之后的学生对象到数据库进行修改。
    public Student builtUpdatedStudent() {
        Student student = new Student();
        student.setId(Integer.parseInt(idTxt.getText()));
        student.setName(nameTxt.getText());
        student.setNo(noTxt.getText());
        student.setHomeTown(homeTxt.getText());
        student.setCnScore(Integer.parseInt(cnTxt.getText()));
        student.setEnScore(Integer.parseInt(enTxt.getText()));
        student.setMathScore(Integer.parseInt(mathTxt.getText()));
        return student;
    }
}
